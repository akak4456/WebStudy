package org.adele.mini;

import java.util.ArrayList;
import java.util.Random;

import org.adele.mini.model.AutoMoneyMachine;
import org.adele.mini.model.Beggar;
import org.adele.mini.model.EmployBeggar;

/*
 * 유저가 키우게 되는 거지 모델을 관리하는 것
 */
public class ManageBeggar {

	/*
	 * 고용된 거지, 건물, 나라 등에서 자동으로 벌어들이는 돈에 의해서 money 가 자동으로 늘어나야 할 때 기준이 되는 시간. 원래는
	 * 1초마다 자동으로 늘어나는 것이 제일 좋은 방법 이겠으나 복잡하고 실시간 동시성이 중요하지 않으니 (현재 시간) -
	 * lastCalcMillis 를 사용해 돈을 늘려가는 방법을 채택
	 */
	private long lastCalcMillis;
	
	private Beggar beggar;
	
	public ManageBeggar() {
		beggar = new Beggar();
		lastCalcMillis = 0;
		beggar.init();
	}

	public boolean isFirst() {
		return beggar.getName() == null && beggar.getAge() == 0;
	}

	public void setNameAndAge(String name, int age) {
		beggar.setName(name);
		beggar.setAge(age);
	}
	
	public void reset() {
		beggar.init();
	}
	
	public String getName() {
		return beggar.getName();
	}
	
	public int getAge() {
		return beggar.getAge();
	}
	
	public int getEarnBegMoney() {
		return (new Random()).nextInt(beggar.getBegMaxMoney() - beggar.getBegMinMoney() + 1) + beggar.getBegMinMoney();
	}
	
	public boolean useBegFever() {
		return beggar.getInventory().useBegFever();
	}
	
	public boolean useGakseolitaryeong() {
		return beggar.getInventory().useGakseolitaryeong();
	}
	
	public long getMoney() {
		calcAutoMoney();
		return beggar.getMoney();
	}
	
	public void addMoney(int earnMoney) {
		calcAutoMoney();
		beggar.setMoney(beggar.getMoney() + earnMoney);
	}
	
	public int getEarnGakseolitaryeongMoney() {
		return (new Random()).nextInt(beggar.getGakseolitaryeongMaxMoney() - beggar.getGakseolitaryeongMinMoney() + 1)
				+ beggar.getGakseolitaryeongMinMoney();
	}
	
	public int getFeverCount() {
		return beggar.getInventory().getBegFeverCount();
	}
	
	public int getGakseolitaryeongCount() {
		return beggar.getInventory().getGakseolitaryeongCount();
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
			for (int i = 0; i < beggar.getMachines().size(); i++) {
				AutoMoneyMachine machine = beggar.getMachines().get(i);
				if (machine != null) {
					sum += durationSeconds * machine.getMul();
				}
			}
			beggar.setMoney((long) (beggar.getMoney() + sum));
		}
	}
	
	public boolean hireBeggar(EmployBeggar employ) {
		if (beggar.getMoney() >= employ.getBuyPrice()) {
			beggar.getMachines().add(employ);
			beggar.setMoney(beggar.getMoney() - employ.getBuyPrice());
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<AutoMoneyMachine> getMachines() {
		return beggar.getMachines();
	}
	
	public int getBegMinMoney() {
		return beggar.getBegMinMoney();
	}
	
	public int getBegMaxMoney() {
		return beggar.getBegMaxMoney();
	}
	
	public int getBegUpgradePrice() {
		return beggar.getBegUpgradePrice();
	}
	
	public boolean upgradeBegMoney() {
		if (beggar.getMoney() >= beggar.getBegUpgradePrice()) {
			beggar.setMoney(beggar.getMoney() - beggar.getBegUpgradePrice());
			beggar.setBegMinMoney((int) ((beggar.getBegMinMoney() + CONSTANT.UPGRADE_BEG_ADD_MIN_NUMBER) * CONSTANT.UPGRADE_BEG_MIN_MUL));
			beggar.setBegMaxMoney((int) ((beggar.getBegMaxMoney() + CONSTANT.UPGRADE_BEG_ADD_MAX_NUMBER) * CONSTANT.UPGRADE_BEG_MAX_MUL));
			beggar.setBegUpgradePrice((int) (beggar.getBegUpgradePrice() * CONSTANT.UPGRADE_BEG_PRICE_MUL));
			return true;
		} else {
			return false;
		}
	}
	
	public int getGakseolitaryeongMinMoney() {
		return beggar.getGakseolitaryeongMinMoney();
	}
	
	public int getGakseolitaryeongMaxMoney() {
		return beggar.getGakseolitaryeongMaxMoney();
	}
	
	public int getGakseolitaryeongUpgradePrice() {
		return beggar.getGakseolitaryeongUpgradePrice();
	}
	
	public boolean upgradeGakseolitaryeong() {
		if (beggar.getMoney() >= beggar.getGakseolitaryeongUpgradePrice()) {
			beggar.setMoney(beggar.getMoney() - beggar.getGakseolitaryeongUpgradePrice());
			beggar.setGakseolitaryeongMinMoney((int) ((beggar.getGakseolitaryeongMinMoney() + CONSTANT.UPGRADE_GAKSEOLITARYEONG_ADD_MIN_NUMBER) * CONSTANT.UPGRADE_GAKSEOLITARYEONG_MIN_MUL));
			beggar.setGakseolitaryeongMaxMoney((int) ((beggar.getGakseolitaryeongMaxMoney() + CONSTANT.UPGRADE_GAKSEOLITARYEONG_ADD_MAX_NUMBER) * CONSTANT.UPGRADE_GAKSEOLITARYEONG_MAX_MUL));
			beggar.setGakseolitaryeongUpgradePrice((int) (beggar.getGakseolitaryeongUpgradePrice() * CONSTANT.UPGRADE_GAKSEOLITARYEONG_PRICE_MUL));
			return true;
		} else {
			return false;
		}
	}
	
	public boolean upgradeMachine(AutoMoneyMachine machine) {
		if (beggar.getMoney() >= machine.getUpgradePrice()) {
			beggar.setMoney(beggar.getMoney() - machine.getUpgradePrice());
			machine.setMul((machine.getMul() + CONSTANT.UPGRADE_MACHINE_MUL_ADD_NUMBER) * CONSTANT.UPGRADE_MACHINE_MUL_MUL);
			machine.setUpgradePrice((int) (machine.getUpgradePrice() * CONSTANT.UPGRADE_MACHINE_PRICE_MUL));
			return true;
		} else {
			return false;
		}
	}
	
	public boolean buyBegFever() {
		if (beggar.getMoney() >= CONSTANT.BEG_FEVER_PRICE) {
			beggar.setMoney(beggar.getMoney() - CONSTANT.BEG_FEVER_PRICE);
			beggar.getInventory().addBegFever(CONSTANT.BEG_FEVER_ITEM_BUNDLE_SIZE);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean buyGakseolitaryeong() {
		if (beggar.getMoney() >= CONSTANT.GAKSEOLITARYEONG_PRICE) {
			beggar.setMoney(beggar.getMoney() - CONSTANT.GAKSEOLITARYEONG_PRICE);
			beggar.getInventory().addGakseolitaryeong(CONSTANT.GAKSEOLITARYEONG_ITEM_BUNDLE_SIZE);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containMachine(AutoMoneyMachine machine) {
		for (AutoMoneyMachine m : beggar.getMachines()) {
			if (m.getName().equals(machine.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean buyMachine(AutoMoneyMachine machine) {
		if (beggar.getMoney() >= machine.getBuyPrice()) {
			beggar.setMoney(beggar.getMoney() - machine.getBuyPrice());
			beggar.getMachines().add(machine);
			return true;
		} else {
			return false;
		}
	}
	
}
