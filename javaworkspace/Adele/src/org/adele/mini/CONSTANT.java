package org.adele.mini;
/*
 * 선택지 번호를 제외한 모든 상수를 저장한 것
 */
public class CONSTANT {
	public static final int INIT_BEG_MIN_MONEY = 50;
	public static final int INIT_BEG_MAX_MONEY = 100;
	public static final int INIT_BEG_UPGRADE_PRICE = 1000;
	public static final int UPGRADE_BEG_ADD_MIN_NUMBER = 5;
	public static final int UPGRADE_BEG_ADD_MAX_NUMBER = 5;
	public static final double UPGRADE_BEG_MIN_MUL = 1.2;
	public static final double UPGRADE_BEG_MAX_MUL = 1.2;
	public static final double UPGRADE_BEG_PRICE_MUL = 1.2;
	
	public static final int INIT_GAKSEOLITARYEONG_MIN_MONEY = 2000;
	public static final int INIT_GAKSEOLITARYEONG_MAX_MONEY = 4000;
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
