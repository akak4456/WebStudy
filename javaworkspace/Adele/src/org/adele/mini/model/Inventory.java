package org.adele.mini.model;

/*
 * 유저가 가지고 있는 아이템
 */
public class Inventory {
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
		if (gakseolitaryeongCount > 0) {
			gakseolitaryeongCount--;
			return true;
		}
		return false;
	}

	public boolean useBegFever() {
		if (begFeverCount > 0) {
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
