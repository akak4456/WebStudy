package org.adele.mini.model;

import org.adele.mini.Constants;

/*
 * 건물
 */
public class Building extends AutoMoneyMachine {

	public Building(Id id, String name, double mul, int buyPrice, int upgradePrice) {
		super(id, name, mul, buyPrice, upgradePrice);
	}
}
