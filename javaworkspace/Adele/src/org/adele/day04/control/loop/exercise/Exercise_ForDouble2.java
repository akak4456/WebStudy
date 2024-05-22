package org.adele.day04.control.loop.exercise;

public class Exercise_ForDouble2 {
	public static void main(String[] args) {
		for(int hour=0;hour<24;hour++) {
			for(int minute=0;minute<60;minute++) {
				System.out.println(hour+"시 "+minute+"분");
			}
		}
	}
}
