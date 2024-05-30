package org.adele.mini.model;

import org.adele.mini.CONSTANT;

/*
 * 고용된 거지
 */
public class EmployBeggar extends AutoMoneyMachine {
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