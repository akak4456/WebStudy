package org.adele.mini.model;

import java.util.ArrayList;

import org.adele.mini.CONSTANT;

/*
 * 유저 정보를 담는 거지 POJO
 */
public class Beggar {
	private String name;
	private int age;

	private long money;
	private ArrayList<AutoMoneyMachine> machines;

	private Inventory inventory;

	private int begMinMoney; // 구걸을 통해 벌 수 있는 최소한의 돈
	private int begMaxMoney; // 구걸을 통해 벌 수 있는 최대한의 돈
	private int begUpgradePrice; // 구걸 업그레이드 비용

	private int gakseolitaryeongMinMoney; // 각설이타령을 통해 벌 수 있는 최소한의 돈
	private int gakseolitaryeongMaxMoney; // 각설이타령을 통해 벌 수 있는 최대한의 돈
	private int gakseolitaryeongUpgradePrice; // 각설이타령 업그레이드 비용
	
	public void init() {
		this.name = null;
		this.age = 0;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public ArrayList<AutoMoneyMachine> getMachines() {
		return machines;
	}

	public void setMachines(ArrayList<AutoMoneyMachine> machines) {
		this.machines = machines;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getBegMinMoney() {
		return begMinMoney;
	}

	public void setBegMinMoney(int begMinMoney) {
		this.begMinMoney = begMinMoney;
	}

	public int getBegMaxMoney() {
		return begMaxMoney;
	}

	public void setBegMaxMoney(int begMaxMoney) {
		this.begMaxMoney = begMaxMoney;
	}

	public int getBegUpgradePrice() {
		return begUpgradePrice;
	}

	public void setBegUpgradePrice(int begUpgradePrice) {
		this.begUpgradePrice = begUpgradePrice;
	}

	public int getGakseolitaryeongMinMoney() {
		return gakseolitaryeongMinMoney;
	}

	public void setGakseolitaryeongMinMoney(int gakseolitaryeongMinMoney) {
		this.gakseolitaryeongMinMoney = gakseolitaryeongMinMoney;
	}

	public int getGakseolitaryeongMaxMoney() {
		return gakseolitaryeongMaxMoney;
	}

	public void setGakseolitaryeongMaxMoney(int gakseolitaryeongMaxMoney) {
		this.gakseolitaryeongMaxMoney = gakseolitaryeongMaxMoney;
	}

	public int getGakseolitaryeongUpgradePrice() {
		return gakseolitaryeongUpgradePrice;
	}

	public void setGakseolitaryeongUpgradePrice(int gakseolitaryeongUpgradePrice) {
		this.gakseolitaryeongUpgradePrice = gakseolitaryeongUpgradePrice;
	}

}
