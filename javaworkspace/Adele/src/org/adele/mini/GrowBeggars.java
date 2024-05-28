package org.adele.mini;
/*
 * MVC 아키텍처를 적용함
 * public class GrowBeggars: 게임을 실행하는 메인 클래스
 * class GrowBeggars...Controller: 게임의 입력과 출력을 중재하는 Controller
 * class Beggar: 게임 핵심 Model
 * class GrowBeggarsView: 게임의 입출력을 담당하는 View, 일단 System.out.println으로 구현함
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
 * 선택지 번호를 제외한 모든 상수를 저장한 것
 */
class CONSTANT {
	public static final double AUTO_MONEY_MUL = 50.0; 
	public static final int INIT_BEG_MIN_MONEY = 50;
	public static final int INIT_BEG_MAX_MONEY = 100;
	public static final int INIT_BEG_UPGRADE_PRICE = 1000;
	public static final int UPGRADE_BEG_ADD_MIN_NUMBER = 5;
	public static final int UPGRADE_BEG_ADD_MAX_NUMBER = 5;
	public static final double UPGRADE_BEG_MIN_MUL = 1.2;
	public static final double UPGRADE_BEG_MAX_MUL = 1.2;
	public static final double UPGRADE_BEG_PRICE_MUL = 1.2;
	
	public static final int INIT_GAKSEOLITARYEONG_MIN_MONEY = 500;
	public static final int INIT_GAKSEOLITARYEONG_MAX_MONEY = 1000;
	public static final int INIT_GAKSEOLITARYEONG_UPGRADE_PRICE = 1000;
	public static final int UPGRADE_GAKSEOLITARYEONG_ADD_MIN_NUMBER = 5;
	public static final int UPGRADE_GAKSEOLITARYEONG_ADD_MAX_NUMBER = 5;
	public static final double UPGRADE_GAKSEOLITARYEONG_MIN_MUL = 1.2;
	public static final double UPGRADE_GAKSEOLITARYEONG_MAX_MUL = 1.2;
	public static final double UPGRADE_GAKSEOLITARYEONG_PRICE_MUL = 1.2;
	
	public static final int GAKSEOLITARYEONG_PRICE = 1000;
	public static final int BEG_FEVER_PRICE = 500;
	
	public static final int BEG_FEVER_ADD = 50;
	public static final double BEG_FEVER_MUL = 2;
	
	public static final int UPGRADE_MACHINE_MUL_ADD_NUMBER = 5;
	public static final double UPGRADE_MACHINE_MUL_MUL = 1.2;
	public static final double UPGRADE_MACHINE_PRICE_MUL = 1.2;
	
	public static final int BEG_FEVER_ITEM_BUNDLE_SIZE = 5;
	public static final int GAKSEOLITARYEONG_ITEM_BUNDLE_SIZE = 1;
	
	public static final String[] EMPLOY_BEGGAR_NAMES = {"초급 거지", "초급 불의 호흡 거지", "초급 바람의 호흡 거지", "초급 물의 호흡 거지", "중급 거지", "고급 거지", "특급 거지"};
	public static final double[] EMPLOY_BEGGAR_MULS = {1.0, 1.2, 1.4, 1.7, 2.0, 3.0, 4.0};
	public static final int[] EMPLOY_BEGGAR_BUY_PRICES = {1000,1200,1400,1700,2000,3000,4000};
	public static final int[] EMPLOY_BEGGAR_INIT_UPGRADE_PRICES = {1000,1000,1000,1000,1000,1000,1000};
	
	public static final String[] BUILDING_NAMES = {"단독주택", "연립주택", "아파트", "궁궐", "초호화 주택"};
	public static final double[] BUILDING_MULS = {10.0, 15.0, 20.0, 30.0, 50.0};
	public static final int[] BUILDING_BUY_PRICES = {10000, 15000, 20000, 30000, 50000};
	public static final int[] BUILDING_INIT_UPGRADE_PRICES = {1000,1000,1000,1000, 1000};
	
	public static final String[] NATION_NAMES = {"미국", "중국", "일본", "대만", "한국"};
	public static final double[] NATION_MULS = {100.0, 120.0, 150.0, 200.0, 300.0};
	public static final int[] NATION_BUY_PRICES = {100000,120000,150000,200000,300000};
	public static final int[] NATION_INIT_UPGRADE_PRICES = {1000,1000,1000,1000,1000};
	private CONSTANT() {
		
	}
}

/*
 * 유저가 키우게 되는 거지
 */
class Beggar {

	private String name;
	private int age;
	/*
	 * 고용된 거지, 건물, 나라 등에서 자동으로 벌어들이는 돈에 의해서 money 가 자동으로 늘어나야 할 때 기준이 되는 시간. 원래는
	 * 1초마다 자동으로 늘어나는 것이 제일 좋은 방법 이겠으나 복잡하고 실시간 동시성이 중요하지 않으니 (현재 시간) -
	 * lastCalcMillis 를 사용해 돈을 늘려가는 방법을 채택
	 */
	private long lastCalcMillis;
	private long money;
	private ArrayList<AutoMoneyMachine> machines;

	private Inventory inventory;

	private int begMinMoney; // 구걸을 통해 벌 수 있는 최소한의 돈
	private int begMaxMoney; // 구걸을 통해 벌 수 있는 최대한의 돈
	private int begUpgradePrice; // 구걸 업그레이드 비용

	private int gakseolitaryeongMinMoney; // 각설이타령을 통해 벌 수 있는 최소한의 돈
	private int gakseolitaryeongMaxMoney; // 각설이타령을 통해 벌 수 있는 최대한의 돈
	private int gakseolitaryeongUpgradePrice; // 각설이타령 업그레이드 비용

	public Beggar() {
		init();
	}

	public boolean isFirst() {
		return name == null && age == 0;
	}

	public void setNameAndAge(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	private void init() {
		this.name = null;
		this.age = 0;
		this.lastCalcMillis = 0;
		this.money = 0;
		this.begMinMoney = CONSTANT.INIT_BEG_MIN_MONEY;
		this.begMaxMoney = CONSTANT.INIT_BEG_MAX_MONEY;
		this.begUpgradePrice = CONSTANT.INIT_BEG_UPGRADE_PRICE;
		this.gakseolitaryeongMinMoney = CONSTANT.INIT_GAKSEOLITARYEONG_MIN_MONEY;
		this.gakseolitaryeongMaxMoney = CONSTANT.INIT_GAKSEOLITARYEONG_MAX_MONEY;
		this.gakseolitaryeongUpgradePrice = CONSTANT.INIT_GAKSEOLITARYEONG_UPGRADE_PRICE;
		machines = new ArrayList<>();
		inventory = new Inventory();
	}
	
	public void reset() {
		init();
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getEarnBegMoney() {
		return (new Random()).nextInt(begMaxMoney - begMinMoney + 1) + begMinMoney;
	}
	
	public boolean useBegFever() {
		return inventory.useBegFever();
	}
	
	public boolean useGakseolitaryeong() {
		return inventory.useGakseolitaryeong();
	}
	
	public long getMoney() {
		calcAutoMoney();
		return money;
	}
	
	public void addMoney(int earnMoney) {
		calcAutoMoney();
		money += earnMoney;
	}
	
	public int getEarnGakseolitaryeongMoney() {
		return (new Random()).nextInt(gakseolitaryeongMaxMoney - gakseolitaryeongMinMoney + 1)
				+ gakseolitaryeongMinMoney;
	}
	
	public int getFeverCount() {
		return inventory.getBegFeverCount();
	}
	
	public int getGakseolitaryeongCount() {
		return inventory.getGakseolitaryeongCount();
	}
	
	private void calcAutoMoney() {
		if (!isFirst()) {
			if (lastCalcMillis == 0) {
				lastCalcMillis = System.currentTimeMillis();
			}
			long curTime = System.currentTimeMillis();
			long durationSeconds = (curTime - lastCalcMillis) / 1000;
			lastCalcMillis = System.currentTimeMillis();
			double sum = 0.0;
			for (int i = 0; i < machines.size(); i++) {
				AutoMoneyMachine machine = machines.get(i);
				if (machine != null) {
					sum += durationSeconds * machine.mul * CONSTANT.AUTO_MONEY_MUL;
				}
			}
			money += sum;
		}
	}
	
	public boolean hireBeggar(EmployBeggar employ) {
		if (money >= employ.buyPrice) {
			machines.add(employ);
			money -= employ.buyPrice;
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<AutoMoneyMachine> getMachines() {
		return machines;
	}
	
	public int getBegMinMoney() {
		return begMinMoney;
	}
	
	public int getBegMaxMoney() {
		return begMaxMoney;
	}
	
	public int getBegUpgradePrice() {
		return begUpgradePrice;
	}
	
	public boolean upgradeBegMoney() {
		if (money >= begUpgradePrice) {
			money -= begUpgradePrice;
			begMinMoney = (int) ((begMinMoney + CONSTANT.UPGRADE_BEG_ADD_MIN_NUMBER) * CONSTANT.UPGRADE_BEG_MIN_MUL);
			begMaxMoney = (int) ((begMaxMoney + CONSTANT.UPGRADE_BEG_ADD_MAX_NUMBER) * CONSTANT.UPGRADE_BEG_MAX_MUL);
			begUpgradePrice = (int) (begUpgradePrice * CONSTANT.UPGRADE_BEG_PRICE_MUL);
			return true;
		} else {
			return false;
		}
	}
	
	public int getGakseolitaryeongMinMoney() {
		return gakseolitaryeongMinMoney;
	}
	
	public int getGakseolitaryeongMaxMoney() {
		return gakseolitaryeongMaxMoney;
	}
	
	public int getGakseolitaryeongUpgradePrice() {
		return gakseolitaryeongUpgradePrice;
	}
	
	public boolean upgradeGakseolitaryeong() {
		if (money >= gakseolitaryeongUpgradePrice) {
			money -= gakseolitaryeongUpgradePrice;
			gakseolitaryeongMinMoney = (int) ((gakseolitaryeongMinMoney + CONSTANT.UPGRADE_GAKSEOLITARYEONG_ADD_MIN_NUMBER) * CONSTANT.UPGRADE_GAKSEOLITARYEONG_MIN_MUL);
			gakseolitaryeongMaxMoney = (int) ((gakseolitaryeongMaxMoney + CONSTANT.UPGRADE_GAKSEOLITARYEONG_ADD_MAX_NUMBER) * CONSTANT.UPGRADE_GAKSEOLITARYEONG_MAX_MUL);
			gakseolitaryeongUpgradePrice = (int) (gakseolitaryeongUpgradePrice * CONSTANT.UPGRADE_GAKSEOLITARYEONG_PRICE_MUL);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean upgradeMachine(AutoMoneyMachine machine) {
		if (money >= machine.upgradePrice) {
			money -= machine.upgradePrice;
			machine.mul = (machine.mul + CONSTANT.UPGRADE_MACHINE_MUL_ADD_NUMBER) * CONSTANT.UPGRADE_MACHINE_MUL_MUL;
			machine.upgradePrice = (int) (machine.upgradePrice * CONSTANT.UPGRADE_MACHINE_PRICE_MUL);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean buyBegFever() {
		if (money >= CONSTANT.BEG_FEVER_PRICE) {
			money -= CONSTANT.BEG_FEVER_PRICE;
			inventory.addBegFever(CONSTANT.BEG_FEVER_ITEM_BUNDLE_SIZE);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean buyGakseolitaryeong() {
		if (money >= CONSTANT.GAKSEOLITARYEONG_PRICE) {
			money -= CONSTANT.GAKSEOLITARYEONG_PRICE;
			inventory.addGakseolitaryeong(CONSTANT.GAKSEOLITARYEONG_ITEM_BUNDLE_SIZE);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containMachine(AutoMoneyMachine machine) {
		for (AutoMoneyMachine m : machines) {
			if (m.name.equals(machine.name)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean buyMachine(AutoMoneyMachine machine) {
		if (money >= machine.buyPrice) {
			money -= machine.buyPrice;
			machines.add(machine);
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * 나라
	 */
	static class Nation extends AutoMoneyMachine {
		public static final Nation[] WHOLE_NATION;
		
		static {
			WHOLE_NATION = new Nation[CONSTANT.NATION_NAMES.length];
			for(int i=0;i<CONSTANT.NATION_NAMES.length;i++) {
				WHOLE_NATION[i] = new Nation(
						CONSTANT.NATION_NAMES[i],
						CONSTANT.NATION_MULS[i],
						CONSTANT.NATION_BUY_PRICES[i],
						CONSTANT.NATION_INIT_UPGRADE_PRICES[i]
						);
			}
		}

		Nation(String name, double mul, int buyPrice, int upgradePrice) {
			super(name, mul, buyPrice, upgradePrice);
		}
	}

	/*
	 * 건물
	 */
	static class Building extends AutoMoneyMachine {
		public static final Building[] WHOLE_BUILDING;
		
		static {
			WHOLE_BUILDING = new Building[CONSTANT.BUILDING_NAMES.length];
			for(int i=0;i<CONSTANT.BUILDING_NAMES.length;i++) {
				WHOLE_BUILDING[i] = new Building(
						CONSTANT.BUILDING_NAMES[i],
						CONSTANT.BUILDING_MULS[i],
						CONSTANT.BUILDING_BUY_PRICES[i],
						CONSTANT.BUILDING_INIT_UPGRADE_PRICES[i]
						);
			}
		}

		Building(String name, double mul, int buyPrice, int upgradePrice) {
			super(name, mul, buyPrice, upgradePrice);
		}
	}

	/*
	 * 고용된 거지
	 */
	static class EmployBeggar extends AutoMoneyMachine {
		public static final EmployBeggar[] WHOLE_EMPLOY_BEGGAR;
		
		static {
			WHOLE_EMPLOY_BEGGAR = new EmployBeggar[CONSTANT.EMPLOY_BEGGAR_NAMES.length];
			for(int i=0;i<CONSTANT.EMPLOY_BEGGAR_NAMES.length;i++) {
				WHOLE_EMPLOY_BEGGAR[i] = new EmployBeggar(
						CONSTANT.EMPLOY_BEGGAR_NAMES[i],
						CONSTANT.EMPLOY_BEGGAR_MULS[i],
						CONSTANT.EMPLOY_BEGGAR_BUY_PRICES[i],
						CONSTANT.EMPLOY_BEGGAR_INIT_UPGRADE_PRICES[i]
						);
			}
		}

		EmployBeggar(String name, double mul, int buyPrice, int upgradePrice) {
			super(name, mul, buyPrice, upgradePrice);
		}
	}

	static abstract class AutoMoneyMachine {
		protected String name;
		protected double mul;
		protected int buyPrice;
		protected int upgradePrice;

		AutoMoneyMachine(String name, double mul, int buyPrice, int upgradePrice) {
			this.name = name;
			this.mul = mul;
			this.buyPrice = buyPrice;
			this.upgradePrice = upgradePrice;
		}

	}

	/*
	 * 유저가 가지고 있는 아이템
	 */
	static class Inventory {
		private int gakseolitaryeongCount; // 각설이타령 갯수
		private int begFeverCount;// 구걸 피버 갯수

		public Inventory() {
			gakseolitaryeongCount = 0;
			begFeverCount = 0;
		}

		public int getGakseolitaryeongCount() {
			return gakseolitaryeongCount;
		}

		public int getBegFeverCount() {
			return begFeverCount;
		}

		public boolean useGakseolitaryeong() {
			if (gakseolitaryeongCount > 0) {
				gakseolitaryeongCount--;
				return true;
			}
			return false;
		}

		public boolean useBegFever() {
			if (begFeverCount > 0) {
				begFeverCount--;
				return true;
			}
			return false;
		}

		public void addGakseolitaryeong(int count) {
			gakseolitaryeongCount += count;
		}

		public void addBegFever(int count) {
			begFeverCount += count;
		}
	}
}

class GrowBeggarsView {
	private Scanner sc;
	public GrowBeggarsView(Scanner sc) {
		this.sc = sc;
	}
	public void hello() {
		System.out.println("거지키우기 게임에 오신 여러분 환영합니다!");
		System.out.println("거지를 키워 최대한 부자로 만드세요!");
		System.out.println();
	}

	public int choiceMenu() {
		System.out.println("메인 메뉴");
		System.out.println("1. 게임시작");
		System.out.println("2. 게임 초기화");
		System.out.println("3. 게임종료");
		System.out.print("당신의 선택 > ");
		return getNumberInput(1, 3);
	}
	
	public String inputName() {
		System.out.println("당신은 게임을 처음 했군요!");
		System.out.println("거지에 대한 정보가 필요합니다.");
		System.out.print("거지의 이름을 입력해주세요 > ");
		return getStringInput();
	}
	
	public int inputAge() {
		System.out.print("거지의 나이를 입력해주세요 > ");
		return getNumberInput();
	}
	
	public int choiceGameMenu() {
		printDivider();
		System.out.println("당신은 이제 거지를 키우고자 합니다.");
		System.out.println("어떤 행위를 하시겠습니까?");
		System.out.println("1. 구걸하기");
		System.out.println("2. 각설이타령하기");
		System.out.println("3. 거지 고용하기");
		System.out.println("4. 업그레이드 하기");
		System.out.println("5. 아이템 사기");
		System.out.println("6. 건물 사기");
		System.out.println("7. 나라 사기");
		System.out.println("8. 현재 상태 보기");
		System.out.println("9. 게임종료");
		System.out.print("당신의 선택은? > ");
		return getNumberInput(1, 9);
	}
	
	public void showBegResult(boolean useFever, int earnMoney) {
		System.out.println("당신은 구걸을 하였습니다.");
		if(useFever) {
			System.out.println("구걸 피버가 적용되었습니다.");
		}
		System.out.println("당신은 " + formatMoney(earnMoney) + "원 만큼 벌었습니다.");
	}
	
	public void showCurrentMoney(long money) {
		System.out.println("당신은 현재 " + formatMoney(money) + "원 있습니다.");
	}
	
	public void showGakseolitaryeongResult(int earnMoney) {
		System.out.println("당신은 각설이 타령을 하였습니다.");
		System.out.println("당신은 " + formatMoney(earnMoney) + "원 만큼 벌었습니다.");
	}
	
	public void showNotUseGakseolitaryeong() {
		System.out.println("당신은 각설이 타령을 할 수 없습니다.");
		System.out.println("각설이 타령을 보유하고 있는지 확인해주세요.");
	}
	
	public int hireBeggar() {
		System.out.println("당신은 거지를 고용할 수 있습니다.");
		System.out.println("어떤 거지를 고용하시겠습니까?");
		for(int i=0;i<Beggar.EmployBeggar.WHOLE_EMPLOY_BEGGAR.length;i++) {
			Beggar.EmployBeggar employ = Beggar.EmployBeggar.WHOLE_EMPLOY_BEGGAR[i];
			int price = employ.buyPrice;
			System.out.println((i+1)+". "+employ.name + " 배율: "+employ.mul + " 가격: " + formatMoney(price));
		}
		System.out.println((Beggar.EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1) + ". 그만 고용하기");
		System.out.print("당신의 선택은? > ");
		return getNumberInput(1, Beggar.EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1);
	}
	
	public void showHireBeggarResult(boolean isHired) {
		if(isHired) {
			System.out.println("거지를 고용하였습니다.");
		} else {
			System.out.println("이 거지를 고용하기에는 돈이 부족합니다.");
		}
	}
	
	public int upgradeBeggar(ArrayList<String> names) {
		System.out.println("당신은 거지와 관련해서 업그레이드를 할 수 있습니다.");
		System.out.println("어떤 것을 업그레이드 하시겠습니까?");
		System.out.println("1. 구걸로 벌어들이는 돈 업그레이드");
		System.out.println("2. 각설이타령으로 벌어들이는 돈 업그레이드");
		for(int i=0;i<names.size();i++) {
			System.out.println((i+3) + ". "+names.get(i) + "업그레이드");
		}
		System.out.println((names.size()+3) +". 업그레이드 종료하기");
		System.out.print("당신의 선택은? > ");
		return getNumberInput(1, names.size() + 3);
	}
	
	public boolean begUpgradeYN(int minMoney, int maxMoney, int price) {
		System.out.println("당신은 현재 구걸하기를 통해");
		System.out.println("최소 " + formatMoney(minMoney) + "원");
		System.out.println("최대 " + formatMoney(maxMoney) + "원");
		System.out.println("만큼 벌고 있으며 업그레이드 비용은 " + formatMoney(price) + "원 입니다.");
		System.out.print("업그레이드 하시겠습니까?(Y/N) > ");
		return getStringInput().charAt(0) == 'Y';
	}
	
	public void showBegUpgradeResult(boolean result) {
		if(result) {
			System.out.println("구걸하기를 업그레이드 하였습니다.");
		} else {
			System.out.println("업그레이드를 진행할 돈이 부족합니다.");
		}
	}
	
	public void showNotContinueBegUpgrade() {
		System.out.println("구걸하기 업그레이드를 진행하지 않았습니다.");
	}
	
	public boolean gakseolitaryeongUpgradeYN(int minMoney, int maxMoney, int price) {
		System.out.println("당신은 현재 각설이타령을 통해");
		System.out.println("최소 " + formatMoney(minMoney) + "원");
		System.out.println("최대 " + formatMoney(maxMoney) + "원");
		System.out.println("만큼 벌고 있으며 업그레이드 비용은 " + formatMoney(price) + "원 입니다.");
		System.out.print("업그레이드 하시겠습니까?(Y/N) > ");
		return getStringInput().charAt(0) == 'Y';
	}
	
	public void showGakseolitaryeongUpgradeResult(boolean result) {
		if(result) {
			System.out.println("각설이타령을 업그레이드 하였습니다.");
		} else {
			System.out.println("업그레이드를 진행할 돈이 부족합니다.");
		}
	}
	
	public void showNotContinueGakseolitaryeongUpgrade() {
		System.out.println("각설이타령 업그레이드를 진행하지 않았습니다.");
	}
	
	public boolean machineUpgradeYN(String name, double mul, int upgradePrice) {
		System.out.println("당신은 현재 "+ name +"을 통해");
		System.out.println("1초마다 " + (mul * CONSTANT.AUTO_MONEY_MUL) +"원을 자동으로 벌고 있습니다.");
		System.out.println("업그레이드 비용은 " + formatMoney(upgradePrice) + "원입니다.");
		System.out.print("업그레이드 하시겠습니까?(Y/N) > ");
		return getStringInput().charAt(0) == 'Y';
	}
	
	public void showMachineUpgradeResult(boolean result, String name) {
		if(result) {
			System.out.println(name + "을(를) 업그레이드 하였습니다.");
		} else {
			System.out.println("업그레이드를 진행할 돈이 부족합니다.");
		}
	}
	
	public void showNotContinueMachineUpgrade(String name) {
		System.out.println(name + " 업그레이드를 진행하지 않았습니다.");
	}
	
	public int buyItem(int curBegFeverCount, int curGakseolitaryeongCount) {
		System.out.println("1. 구걸 피버 "+CONSTANT.BEG_FEVER_ITEM_BUNDLE_SIZE+"개 구입(현재 " + curBegFeverCount +"개 보유) 가격: "+ formatMoney(CONSTANT.BEG_FEVER_PRICE)+"원");
		System.out.println("2. 각설이타령 "+CONSTANT.GAKSEOLITARYEONG_ITEM_BUNDLE_SIZE+"개 구입(현재 " + curGakseolitaryeongCount +"개 보유) 가격: "+formatMoney(CONSTANT.GAKSEOLITARYEONG_PRICE)+"원");
		System.out.println("3. 아이템 구입 종료");
		System.out.print("당신의 선택은? > ");
		return getNumberInput(1, 3);
	}
	
	public void showBuyBegFeverResult(boolean result) {
		if(result) {
			System.out.println("구걸 피버를 "+CONSTANT.BEG_FEVER_ITEM_BUNDLE_SIZE+"개 샀습니다.");
		} else {
			System.out.println("구걸 피버를 살 돈이 없습니다.");
		}
	}
	
	public void showBuyGakseolitaryeongResult(boolean result) {
		if(result) {
			System.out.println("각설이 타령을 "+CONSTANT.GAKSEOLITARYEONG_ITEM_BUNDLE_SIZE+"개 샀습니다.");
		} else {
			System.out.println("각설이 타령을 살 돈이 없습니다.");
		}
	}
	
	public int buyBuilding(ArrayList<String> names, ArrayList<Integer> prices) {
		System.out.println("당신은 빌딩을 살 수 있습니다.");
		System.out.println("어떤 빌딩을 사시겠습니까?");
		for(int i=0;i<names.size();i++) {
			System.out.println((i+1)+". " + names.get(i) + " 가격: " + formatMoney(prices.get(i)) + "원");
		}
		System.out.println((names.size() + 1)+". 빌딩 사기 종료하기");
		System.out.print("당신의 선택은? > ");
		return getNumberInput(1, names.size() + 1);
	}
	
	public void showBuyMachineResult(boolean result, String name) {
		if(result) {
			System.out.println(name + "을(를) 구입하였습니다.");
		} else {
			System.out.println(name + "을(를) 구입하는 데 드는 돈이 없습니다.");
		}
	}
	
	public int buyNation(ArrayList<String> names, ArrayList<Integer> prices) {
		System.out.println("당신은 나라를 살 수 있습니다.");
		System.out.println("어떤 나라를 사시겠습니까?");
		for(int i=0;i<names.size();i++) {
			System.out.println((i+1)+". " + names.get(i) + " 가격: " + formatMoney(prices.get(i)) + "원");
		}
		System.out.println((names.size() + 1)+". 나라 사기 종료하기");
		System.out.print("당신의 선택은? > ");
		return getNumberInput(1, names.size() + 1);
	}
	
	public void showBegInfo(
			String beggarName,
			int beggarAge,
			int begMinMoney,
			int begMaxMoney,
			int begUpgradePrice,
			int gakseolitaryeongMinMoney,
			int gakseolitaryeongMaxMoney,
			int gakseolitaryeongUpgradePrice,
			int begFeverCount,
			int gakseolitaryeongCount,
			ArrayList<String> employBeggarNames,
			ArrayList<Double> employBeggarMuls,
			ArrayList<Integer> employBeggarUpgradePrices,
			ArrayList<String> buildingNames,
			ArrayList<Double> buildingMuls,
			ArrayList<Integer> buildingUpgradePrices,
			ArrayList<String> nationNames,
			ArrayList<Double> nationMuls,
			ArrayList<Integer> nationUpgradePrices
			) {
		System.out.println("당신의 이름은 "+beggarName+"이며 나이는 "+beggarAge+"살 입니다.");
		System.out.println("당신은 구걸을 통해 최소 " + formatMoney(begMinMoney) +"원 최대 " + formatMoney(begMaxMoney)+"원 벌고 있습니다.");
		System.out.println("현재 구걸 업그레이드 비용은 "+formatMoney(begUpgradePrice)+"원 입니다.");
		System.out.println("당신은 각설이타령을 통해 최소 "+formatMoney(gakseolitaryeongMinMoney) +"원 최대 "+formatMoney(gakseolitaryeongMaxMoney)+"원 벌고 있습니다.");
		System.out.println("현재 각설이타령 업그레이드 비용은 "+formatMoney(gakseolitaryeongUpgradePrice)+"원 입니다.");
		System.out.println("당신이 가지고 있는 아이템은 다음과 같습니다.");
		System.out.println("구걸 피버: " + begFeverCount + "개");
		System.out.println("각설이타령: " + gakseolitaryeongCount + "개");

		System.out.println("당신이 고용한 거지는 다음과 같습니다.");
		if(employBeggarNames.isEmpty()) {
			System.out.println("고용한 거지가 없습니다.");
		} else {
			for(int i=0;i<employBeggarNames.size();i++) {
				System.out.println(employBeggarNames.get(i));
				System.out.println("--- 1초마다 벌어들이는 돈: " + employBeggarMuls.get(i) * CONSTANT.AUTO_MONEY_MUL);
				System.out.println("--- 현재 업그레이드 비용: " + formatMoney(employBeggarUpgradePrices.get(i)));
			}
		}

		System.out.println("당신이 구입한 빌딩은 다음과 같습니다.");
		if(buildingNames.isEmpty()) {
			System.out.println("구입한 빌딩이 없습니다.");
		} else {
			for(int i=0;i<buildingNames.size();i++) {
				System.out.println(buildingNames.get(i));
				System.out.println("--- 1초마다 벌어들이는 돈: " + buildingMuls.get(i) * CONSTANT.AUTO_MONEY_MUL);
				System.out.println("--- 현재 업그레이드 비용: " + formatMoney(buildingUpgradePrices.get(i)));
			}
		}

		System.out.println("당신이 구입한 나라는 다음과 같습니다.");
		if(nationNames.isEmpty()) {
			System.out.println("구입한 나라가 없습니다.");
		} else {
			for(int i=0;i<nationNames.size();i++) {
				System.out.println(nationNames.get(i));
				System.out.println("--- 1초마다 벌어들이는 돈: " + nationMuls.get(i) * CONSTANT.AUTO_MONEY_MUL);
				System.out.println("--- 현재 업그레이드 비용: " + formatMoney(nationUpgradePrices.get(i)));
			}
		}
	}
	
	public void showReset() {
		System.out.println("게임을 초기화 합니다.");
	}
	
	public void sayGoodbye() {
		printDivider();
		System.out.println("게임을 즐겨주셔서 감사합니다!");
	}
	
	private void printDivider() {
		System.out.println("==================================================");
	}
	
	private String formatMoney(long m) {
		String mString = m + "";
		ArrayList<String> tokens = new ArrayList<>();
		int endIdx = mString.length();
		int startIdx = endIdx - 3;
		while (startIdx >= 0) {
			tokens.add(mString.substring(startIdx, endIdx));
			endIdx = startIdx;
			startIdx -= 3;
		}
		tokens.add(mString.substring(0, endIdx));
		StringBuilder sb = new StringBuilder();
		for (int i = tokens.size() - 1; i >= 0; i--) {
			sb.append(tokens.get(i));
			if (i > 0 && !tokens.get(i).isBlank()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	private int getNumberInput() {
		Integer ret = null;
		while (ret == null) {
			try {
				ret = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				showWrongInput();
				ret = null;
			}
		}
		return ret;
	}

	private int getNumberInput(int minInput, int maxInput) {
		Integer ret = null;
		while (ret == null) {
			try {
				ret = Integer.parseInt(sc.nextLine());
				if (ret < minInput || ret > maxInput) {
					showNotRangeInput(minInput, maxInput);
					ret = null;
				}
			} catch (NumberFormatException e) {
				showWrongInput();
				ret = null;
			}
		}
		return ret;
	}
	
	private String getStringInput() {
		String ret = null;
		while(ret == null) {
			ret = sc.nextLine();
			if(ret != null && ret.isBlank()) {
				showWrongInput();
				ret = null;
			}
		}
		return ret;
	}
	
	private void showWrongInput() {
		System.out.print("잘못된 입력입니다. 다시 입력해주세요 > ");
	}

	private void showNotRangeInput(int minInput, int maxInput) {
		System.out.print(minInput + " ~ " + maxInput + " 사이의 수를 입력해야 합니다. 다시 입력해주세요 > ");
	}
}

class GrowBeggarsMainController extends GrowBeggarsController {

	public GrowBeggarsMainController(Beggar beggar, GrowBeggarsView view) {
		super(beggar, view);
	}

	@Override
	void run() {
		while(true) {
			int choice = view.choiceGameMenu();
			if(choice == 1) {
				int earnMoney = beggar.getEarnBegMoney();
				boolean useFever = beggar.useBegFever(); // 구걸 피버는 자동으로 사용한다.
				if(useFever) {
					earnMoney = (int)((earnMoney + CONSTANT.BEG_FEVER_ADD) * CONSTANT.BEG_FEVER_MUL);
				}
				view.showBegResult(useFever, earnMoney);
				beggar.addMoney(earnMoney);
				view.showCurrentMoney(beggar.getMoney());
			} else if(choice == 2) {
				if(beggar.useGakseolitaryeong()) {
					int earnMoney = beggar.getEarnGakseolitaryeongMoney();
					beggar.addMoney(earnMoney);
					view.showGakseolitaryeongResult(earnMoney);
				} else {
					view.showNotUseGakseolitaryeong();
				}
			} else if(choice == 3) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					int hireChoice = view.hireBeggar();
					if(hireChoice == Beggar.EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1) {
						break;
					} else {
						view.showHireBeggarResult(beggar.hireBeggar(Beggar.EmployBeggar.WHOLE_EMPLOY_BEGGAR[hireChoice - 1]));
					}
				}
			} else if(choice == 4) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					ArrayList<Beggar.AutoMoneyMachine> machines = beggar.getMachines();
					ArrayList<String> lines = new ArrayList<>();
					for(int i=0;i<machines.size();i++) {
						lines.add(machines.get(i).name);
					}
					int buyChoice = view.upgradeBeggar(lines);
					if(buyChoice == 1) {
						if(view.begUpgradeYN(beggar.getBegMinMoney(), beggar.getBegMaxMoney(), beggar.getBegUpgradePrice())) {
							view.showBegUpgradeResult(beggar.upgradeBegMoney());
						} else {
							view.showNotContinueBegUpgrade();
						}
					} else if(buyChoice == 2) {
						if(view.gakseolitaryeongUpgradeYN(beggar.getGakseolitaryeongMinMoney(), beggar.getGakseolitaryeongMaxMoney(), beggar.getGakseolitaryeongUpgradePrice())) {
							view.showGakseolitaryeongUpgradeResult(beggar.upgradeGakseolitaryeong());
						} else {
							view.showNotContinueGakseolitaryeongUpgrade();
						}
					} else if(buyChoice == machines.size() + 3) {
						break;
					} else {
						Beggar.AutoMoneyMachine machine = machines.get(buyChoice - 3);
						if(view.machineUpgradeYN(machine.name, machine.mul, machine.upgradePrice)) {
							view.showMachineUpgradeResult(beggar.upgradeMachine(machine), machine.name);
						} else {
							view.showNotContinueMachineUpgrade(machine.name);
						}
					}
				}
			} else if (choice == 5) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					int buyItemChoice = view.buyItem(beggar.getFeverCount(), beggar.getGakseolitaryeongCount());
					if(buyItemChoice == 1) {
						view.showBuyBegFeverResult(beggar.buyBegFever());
					} else if(buyItemChoice == 2) {
						view.showBuyGakseolitaryeongResult(beggar.buyGakseolitaryeong());
					} else if(buyItemChoice == 3) {
						break;
					}
				}
			} else if(choice == 6) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					ArrayList<Beggar.AutoMoneyMachine> validMachines = new ArrayList<>();
					ArrayList<String> names = new ArrayList<>();
					ArrayList<Integer> prices = new ArrayList<>();
					for(int i=0;i<Beggar.Building.WHOLE_BUILDING.length;i++) {
						if(beggar.containMachine(Beggar.Building.WHOLE_BUILDING[i])) {
							continue;
						}
						validMachines.add(Beggar.Building.WHOLE_BUILDING[i]);
						names.add(Beggar.Building.WHOLE_BUILDING[i].name);
						prices.add(Beggar.Building.WHOLE_BUILDING[i].buyPrice);
					}
					int buyBuildingChoice = view.buyBuilding(names, prices);
					if(buyBuildingChoice == validMachines.size() + 1) {
						break;
					} else {
						Beggar.AutoMoneyMachine machine = validMachines.get(buyBuildingChoice-1);
						view.showBuyMachineResult(beggar.buyMachine(machine), machine.name);
					}
				}
			} else if(choice == 7) {
				while(true) {
					long curMoney = beggar.getMoney();
					view.showCurrentMoney(curMoney);
					ArrayList<Beggar.AutoMoneyMachine> validMachines = new ArrayList<>();
					ArrayList<String> names = new ArrayList<>();
					ArrayList<Integer> prices = new ArrayList<>();
					for(int i=0;i<Beggar.Nation.WHOLE_NATION.length;i++) {
						if(beggar.containMachine(Beggar.Nation.WHOLE_NATION[i])) {
							continue;
						}
						validMachines.add(Beggar.Nation.WHOLE_NATION[i]);
						names.add(Beggar.Nation.WHOLE_NATION[i].name);
						prices.add(Beggar.Nation.WHOLE_NATION[i].buyPrice);
					}
					int buyNationChoice = view.buyNation(names, prices);
					if(buyNationChoice == validMachines.size() + 1) {
						break;
					} else {
						Beggar.AutoMoneyMachine machine = validMachines.get(buyNationChoice-1);
						view.showBuyMachineResult(beggar.buyMachine(machine), machine.name);
					}
				}
			} else if(choice == 8) {
				long curMoney = beggar.getMoney();
				view.showCurrentMoney(curMoney);
				ArrayList<String> employBeggarNames = new ArrayList<>();
				ArrayList<Double> employBeggarMuls = new ArrayList<>();
				ArrayList<Integer> employBeggarUpgradePrices = new ArrayList<>();
				ArrayList<String> buildingNames = new ArrayList<>();
				ArrayList<Double> buildingMuls = new ArrayList<>();
				ArrayList<Integer> buildingUpgradePrices = new ArrayList<>();
				ArrayList<String> nationNames = new ArrayList<>();
				ArrayList<Double> nationMuls = new ArrayList<>();
				ArrayList<Integer> nationUpgradePrices = new ArrayList<>();
				for(Beggar.AutoMoneyMachine machine : beggar.getMachines()) {
					if(machine instanceof Beggar.EmployBeggar) {
						employBeggarNames.add(machine.name);
						employBeggarMuls.add(machine.mul);
						employBeggarUpgradePrices.add(machine.upgradePrice);
					} else if(machine instanceof Beggar.Building) {
						buildingNames.add(machine.name);
						buildingMuls.add(machine.mul);
						buildingUpgradePrices.add(machine.upgradePrice);
					} else if(machine instanceof Beggar.Nation) {
						nationNames.add(machine.name);
						nationMuls.add(machine.mul);
						nationUpgradePrices.add(machine.upgradePrice);
					}
				}
				view.showBegInfo(
						beggar.getName(),
						beggar.getAge(),
						beggar.getBegMinMoney(),
						beggar.getBegMaxMoney(),
						beggar.getBegUpgradePrice(),
						beggar.getGakseolitaryeongMinMoney(),
						beggar.getGakseolitaryeongMaxMoney(),
						beggar.getGakseolitaryeongUpgradePrice(),
						beggar.getFeverCount(),
						beggar.getGakseolitaryeongCount(),
						employBeggarNames,
						employBeggarMuls,
						employBeggarUpgradePrices,
						buildingNames,
						buildingMuls,
						buildingUpgradePrices,
						nationNames,
						nationMuls,
						nationUpgradePrices
						);
			} else {
				break;
			}
		}
	}
	
}

class GrowBeggarsIntroController extends GrowBeggarsController {
	private GrowBeggarsMainController mainController;
	public GrowBeggarsIntroController(Beggar beggar, GrowBeggarsView view, GrowBeggarsMainController mainController) {
		super(beggar, view);
		this.mainController = mainController;
	}

	@Override
	void run() {
		view.hello();
		while (true) {
			int choice = view.choiceMenu();
			if(choice == 1) {
				if(beggar.isFirst()) {
					String name = view.inputName();
					int age = view.inputAge();
					beggar.setNameAndAge(name, age);
				}
				mainController.run();
			} else if(choice == 2) {
				beggar.reset();
				view.showReset();
			} else if(choice == 3) {
				view.sayGoodbye();
				break;
			}
		}
	}
}

abstract class GrowBeggarsController {
	protected Beggar beggar;
	protected GrowBeggarsView view;
	public GrowBeggarsController(Beggar beggar, GrowBeggarsView view) {
		this.beggar = beggar;
		this.view = view;
	}
	
	abstract void run();

}

public class GrowBeggars {
	private static GrowBeggarsMainController mainController;
	private static GrowBeggarsIntroController introController;
	public static void main(String[] args) {
		GrowBeggarsView view = new GrowBeggarsView(new Scanner(System.in));
		Beggar beggar = new Beggar();
		mainController = new GrowBeggarsMainController(beggar, view);
		introController = new GrowBeggarsIntroController(beggar, view, mainController);
		introController.run();
	}

}
