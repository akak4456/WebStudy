package org.adele.mini;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
class EmployBeggarPair {
	public EmployBeggar beggar;
	public int price;
	public EmployBeggarPair(EmployBeggar beggar, int price) {
		this.beggar = beggar;
		this.price = price;
	}
}
/*
 * 나라
 */
class Nation extends AutoMoneyMachine {
	Nation(String name, double mul, int level) {
		super(name, mul, level);
	}
}
/*
 * 건물
 */
class Building extends AutoMoneyMachine {
	Building(String name, double mul, int level) {
		super(name, mul, level);
	}
}
/*
 * 고용된 거지
 */
class EmployBeggar extends AutoMoneyMachine {
	public static final EmployBeggarPair[] WHOLE_EMPLOY_BEGGAR = {
			new EmployBeggarPair(new EmployBeggar("초급 거지", 1.0, 1), 1000),
			new EmployBeggarPair(new EmployBeggar("초급 불의 호흡 거지", 1.2, 1), 1200),
			new EmployBeggarPair(new EmployBeggar("초급 바람의 호흡 거지", 1.4, 1), 1400),
			new EmployBeggarPair(new EmployBeggar("초급 물의 호흡 거지", 1.7, 1), 1700),
			new EmployBeggarPair(new EmployBeggar("중급 거지", 2.0, 1), 2000),
			new EmployBeggarPair(new EmployBeggar("고급 거지", 3.0, 1), 3000),
			new EmployBeggarPair(new EmployBeggar("특급 거지", 4.0, 1), 4000)
	};
	EmployBeggar(String name, double mul, int level) {
		super(name, mul, level);
	}
}
abstract class AutoMoneyMachine {
	protected String name;
	protected double mul;
	protected int level;
	
	AutoMoneyMachine(String name, double mul, int level) {
		this.name = name;
		this.mul = mul;
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	
	public double getMul() {
		return mul;
	}
}
/*
 * 유저가 가지고 있는 아이템
 */
class Inventory {
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
		if(gakseolitaryeongCount > 0) {
			gakseolitaryeongCount--;
			return true;
		}
		return false;
	}
	public boolean useBegFever() {
		if(begFeverCount > 0) {
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
/*
 * 유저가 키우게 되는 거지
 */
class Beggar {
	private String name;
	private int age;
	/*
	 * 고용된 거지, 건물, 나라 등에서 자동으로 벌어들이는
	 * 돈에 의해서 money 가 자동으로 늘어나야 할 때 기준이 되는
	 * 시간. 원래는 1초마다 자동으로 늘어나는 것이 제일 좋은 방법
	 * 이겠으나 복잡하고 실시간 동시성이 중요하지 않으니
	 * (현재 시간) - lastCalcMillis 를 사용해 돈을 늘려가는
	 * 방법을 채택
	 */
	private long lastCalcMillis;
	private long money;
	private ArrayList<AutoMoneyMachine> machines;
	
	private Inventory inventory;
	
	private int begMinMoney; // 구걸을 통해 벌 수 있는 최소한의 돈
	private int begMaxMoney; // 구걸을 통해 벌 수 있는 최대한의 돈
	private int begLevel; // 구걸 레벨
	
	private int gakseolitaryeongMinMoney; // 각설이타령을 통해 벌 수 있는 최소한의 돈
	private int gakseolitaryeongMaxMoney; // 각설이타령을 통해 벌 수 있는 최대한의 돈
	private int gakseolitaryeongLevel; // 각설이타령 레벨
	
	public Beggar() {
		this.name = null;
		this.age = 0;
		this.lastCalcMillis = 0;
		this.money = 0;
		this.begMinMoney = 5;
		this.begMaxMoney = 10;
		this.begLevel = 1;
		this.gakseolitaryeongMinMoney = 50;
		this.gakseolitaryeongMaxMoney = 100;
		this.gakseolitaryeongLevel = 1;
		machines = new ArrayList<>();
		inventory = new Inventory();
	}
	
	public boolean isFirst() {
		return name == null && age == 0;
	}
	
	public void setNameAndAge(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void calcAutoMoney() {
		if(!isFirst()) {
			if(lastCalcMillis == 0) {
				lastCalcMillis = System.currentTimeMillis();
			}
			long curTime = System.currentTimeMillis();
			long durationSeconds = (curTime - lastCalcMillis) / 1000;
			lastCalcMillis = System.currentTimeMillis();
			double sum = 0.0;
			for(int i=0;i<machines.size();i++) {
				AutoMoneyMachine machine = machines.get(i);
				if(machine != null) {
					sum += durationSeconds * machine.getMul();
				}
			}
			money += sum;
		}
	}
	
	public void begMoney() {
		int earnMoney = (new Random()).nextInt(begMaxMoney - begMinMoney + 1) + begMinMoney;
		if(inventory.useBegFever()) {
			earnMoney = earnMoney * 3;
			System.out.println("구걸 피버가 적용되었습니다.");
		}
		System.out.println("당신은 " + formatMoney(earnMoney) +"원 만큼 벌었습니다.");
		money += earnMoney;
	}
	
	public void showMoney() {
		calcAutoMoney();
		System.out.println("당신은 현재 "+formatMoney(money)+"원 있습니다.");
	}
	
	public static String formatMoney(long m) {
		String mString = m + "";
		ArrayList<String> tokens = new ArrayList<>();
		int endIdx = mString.length();
		int startIdx = endIdx - 3;
		while(startIdx >= 0) {
			tokens.add(mString.substring(startIdx, endIdx));
			endIdx = startIdx;
			startIdx -= 3;
		}
		tokens.add(mString.substring(0, endIdx));
		StringBuilder sb = new StringBuilder();
		for(int i=tokens.size() - 1; i>=0; i--) {
			sb.append(tokens.get(i));
			if(i > 0 && !tokens.get(i).isBlank()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	public void gakseolitaryeong() {
		if(inventory.useGakseolitaryeong()) {
			System.out.println("당신은 각설이 타령을 하였습니다.");
			int earnMoney = (new Random()).nextInt(gakseolitaryeongMaxMoney - gakseolitaryeongMinMoney + 1) + gakseolitaryeongMinMoney;
			System.out.println("당신은 " + formatMoney(earnMoney) +"원 만큼 벌었습니다.");
			money += earnMoney;
		} else {
			System.out.println("당신은 각설이 타령을 할 수 없습니다.");
			System.out.println("각설이 타령을 보유하고 있는지 확인해주세요.");
		}
	}
	
	public void hireBeggarIfPossible(EmployBeggar employ, int price) {
		if(money >= price) {
			machines.add(employ);
			money -= price;
			System.out.println("거지를 고용하였습니다.");
		} else {
			System.out.println("이 거지를 고용하기에는 돈이 부족합니다.");
		}
	}
}
public class GrowBeggars {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Beggar beggar = new Beggar();
		System.out.println("거지키우기 게임에 오신 여러분 환영합니다!");
		System.out.println("거지를 키워 최대한 부자로 만드세요!");
		System.out.println();
		while(true) {
			beggar.calcAutoMoney();
			System.out.println("메인 메뉴");
			System.out.println("1. 게임시작");
			System.out.println("2. 게임 초기화");
			System.out.println("3. 게임종료");
			System.out.print("당신의 선택 > ");
			int number = getNumberInput();
			if(number == 1) {
				if(beggar.isFirst()) {
					enterNameAndAge(beggar);
				}
				gameStart(beggar);
			}
			// TODO 2, 3 번 구현하기
		}
	}
	
	private static void enterNameAndAge(Beggar beggar) {
		System.out.println("당신은 게임을 처음 했군요!");
		System.out.println("거지에 대한 정보가 필요합니다.");
		System.out.print("거지의 이름을 입력해주세요 > ");
		String input = sc.nextLine();
		while(input.isBlank()) {
			System.out.print("잘못된 입력입니다. 다시 입력해주세요 > ");
			input = sc.nextLine();
		}
		System.out.print("거지의 나이를 입력해주세요 > ");
		int age = getNumberInput();
		beggar.setNameAndAge(input, age);
	}
	
	private static int getNumberInput() {
		Integer ret = null;
		while(ret == null) {
			try {
				ret = Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {
				System.out.print("잘못된 문자를 입력했습니다. 숫자만 입력해야 합니다. 다시 입력해주세요 > ");
				ret = null;
			}
		}
		return ret;
	}
	
	private static void gameStart(Beggar beggar) {
		while(true) {
			beggar.calcAutoMoney();
			System.out.println("당신은 이제 거지를 키우고자 합니다.");
			System.out.println("어떤 행위를 하시겠습니까?");
			System.out.println("1. 구걸하기");
			System.out.println("2. 각설이타령하기");
			System.out.println("3. 거지 고용하기");
			System.out.println("4. 업그레이드 하기");
			System.out.println("5. 아이템 사기");
			System.out.println("6. 건물 사기");
			System.out.println("7. 나라 사기");
			System.out.println("8. 랜덤박스 열기");
			System.out.println("9. 인벤토리 열기");
			System.out.println("10. 현재 상태 보기");
			System.out.println("11. 게임종료");
			int number = getNumberInput();
			if(number == 1) {
				System.out.println("당신은 구걸을 하였습니다.");
				beggar.begMoney();
				beggar.showMoney();
			} else if(number == 2) {
				beggar.gakseolitaryeong();
				beggar.showMoney();
			} else if(number == 3) {
				hireBeggar(beggar);
			}
		}
	}
	
	private static void hireBeggar(Beggar beggar) {
		while(true) {
			beggar.showMoney();
			System.out.println("당신은 거지를 고용할 수 있습니다.");
			System.out.println("어떤 거지를 고용하시겠습니까?");
			for(int i=0;i<EmployBeggar.WHOLE_EMPLOY_BEGGAR.length;i++) {
				EmployBeggar employ = EmployBeggar.WHOLE_EMPLOY_BEGGAR[i].beggar;
				int price = EmployBeggar.WHOLE_EMPLOY_BEGGAR[i].price;
				System.out.println((i+1)+". "+employ.name + " 배율: "+employ.mul + " 가격: " + Beggar.formatMoney(price));
			}
			System.out.println((EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1) + ". 그만 고용하기");
			System.out.print("당신의 선택은? > ");
			int number = getNumberInput();
			if(number == EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1) {
				break;
			} else if(number >= 1 && number < EmployBeggar.WHOLE_EMPLOY_BEGGAR.length + 1){
				beggar.hireBeggarIfPossible(EmployBeggar.WHOLE_EMPLOY_BEGGAR[number - 1].beggar, EmployBeggar.WHOLE_EMPLOY_BEGGAR[number - 1].price);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
}
