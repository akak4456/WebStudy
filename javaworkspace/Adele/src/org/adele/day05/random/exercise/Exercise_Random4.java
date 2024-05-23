package org.adele.day05.random.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise_Random4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 10000;
		int winCnt = 0;
		int loseCnt = 0;
		int drawCnt = 0;
		while(true) {
			if(money <= 0) {
				System.out.println("더이상 걸 돈이 없습니다. 게임을 종료합니다.");
				break;
			}
			System.out.println("== Dice Game ==");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print(">");
			int num = sc.nextInt();
			if(num == 1) {
				System.out.println("<< Game Start >>");
				Random random = new Random();
				int userDice1 = random.nextInt(6) + 1;
				int userDice2 = random.nextInt(6) + 1;
				int userDice3 = random.nextInt(6) + 1;
				int userDiceSum = userDice1 + userDice2 + userDice3;
				System.out.println("당신의 주사위의 합 : "+userDiceSum);
				System.out.print("베팅을 하시겠습니까?(y/n) ");
				String input = sc.next();
				if(input.charAt(0) == 'y') {
					System.out.print("걸 돈을 지정해주세요");
					int bet = sc.nextInt();
					int computerDice1 = random.nextInt(6) + 1;
					int computerDice2 = random.nextInt(6) + 1;
					int computerDice3 = random.nextInt(6) + 1;
					int computerDiceSum = computerDice1 + computerDice2 + computerDice3;
					if(userDiceSum > computerDiceSum) {
						money += bet;
						System.out.println("당신이 이겼습니다.");
						winCnt++;
					} else if(userDiceSum == computerDiceSum) {
						System.out.println("비겼습니다.");
						drawCnt++;
					} else {
						money -= bet;
						System.out.println("당신이 졌습니다.");
						loseCnt++;
					}
				}
			} else if(num == 2) {
				System.out.println("WIN : "+winCnt);
				System.out.println("DRAW : "+drawCnt);
				System.out.println("LOSE : "+loseCnt);
			} else if(num == 3) {
				break;
			}
		}
	}
}
