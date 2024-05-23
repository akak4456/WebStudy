package org.adele.day05.random.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Random1 {
	public static void main(String[] args) {
		System.out.println("=====가위 바위 보 게임=====");
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보):");
		int user = sc.nextInt();
		Random random = new Random();
		int computer = random.nextInt(3) + 1;
		System.out.println("==========결과==========");
		if(user == 1) {
			System.out.println("당신은 가위를 냈습니다.");
			if(computer == 1) {
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신과 컴퓨터는 비겼습니다.");
			} else if(computer == 2) {
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신이 졌습니다.");
			} else if(computer == 3) {
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신이 이겼습니다.");
			}
		} else if(user == 2) {
			System.out.println("당신은 바위를 냈습니다.");
			if(computer == 1) {
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신이 이겼습니다.");
			} else if(computer == 2) {
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신과 컴퓨터는 비겼습니다.");
			} else if(computer == 3) {
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신이 졌습니다.");
			}
		} else if(user == 3) {
			System.out.println("당신은 보를 냈습니다.");
			if(computer == 1) {
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신이 졌습니다.");
			} else if(computer == 2) {
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신이 이겼습니다.");
			} else if(computer == 3) {
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("======================");
				System.out.println("당신과 컴퓨터는 비겼습니다.");
			}
		}
	}
}
