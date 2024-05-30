package org.adele.mini.model;

import org.adele.mini.CONSTANT;

/*
 * 건물
 */
public class Building extends AutoMoneyMachine {
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
