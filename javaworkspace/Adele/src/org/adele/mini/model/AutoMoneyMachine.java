package org.adele.mini.model;

public abstract class AutoMoneyMachine {
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
	
	public String getName() {
		return name;
	}
	
	public double getMul() {
		return mul;
	}
	
	public int getBuyPrice() {
		return buyPrice;
	}
	
	public int getUpgradePrice() {
		return upgradePrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMul(double mul) {
		this.mul = mul;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public void setUpgradePrice(int upgradePrice) {
		this.upgradePrice = upgradePrice;
	}
	
	

}
