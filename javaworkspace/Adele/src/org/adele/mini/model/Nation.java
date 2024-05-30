package org.adele.mini.model;

import org.adele.mini.CONSTANT;

/*
 * 나라
 */
public class Nation extends AutoMoneyMachine {
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