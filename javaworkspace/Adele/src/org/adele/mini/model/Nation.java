package org.adele.mini.model;

import org.adele.mini.Constants;

/*
 * 나라
 */
public class Nation extends AutoMoneyMachine {

	public Nation(Id id, String name, double mul, int buyPrice, int upgradePrice) {
		super(id, name, mul, buyPrice, upgradePrice);
	}
}