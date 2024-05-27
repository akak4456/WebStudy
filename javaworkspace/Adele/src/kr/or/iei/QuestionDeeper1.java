package kr.or.iei;

import java.util.Random;
import java.util.Scanner;

public class QuestionDeeper1 {
	public static void main(String[] args) {
		System.out.println("가위 바위 보 게임을 시작합니다.");
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		String[] rockSissorPaper = {"가위", "바위", "보"};
		while(true) {
			System.out.print("가위 바위 보 중 한개를 입력하세요 : ");
			String input = sc.next();
			System.out.println("당신은 "+input+"를 냈습니다.");
			int computerChoice = random.nextInt(3);
			int userChoice = -1;
			for(int i=0;i<3;i++) {
				if(rockSissorPaper[i].equals(input)) {
					userChoice = i;
					break;
				}
			}
			System.out.println("컴퓨터는 "+rockSissorPaper[computerChoice] +"를 냈습니다");
			if(userChoice == 0) {
				if(computerChoice == 0) {
					System.out.println("비겼습니다. 다시 시작합니다.");
				} else if(computerChoice == 1) {
					System.out.println("당신이 졌습니다!");
					break;
				} else if(computerChoice == 2) {
					System.out.println("당신이 이겼습니다!");
					break;
				}
			} else if(userChoice == 1) {
				if(computerChoice == 0) {
					System.out.println("당신이 이겼습니다!");
					break;
				} else if(computerChoice == 1) {
					System.out.println("비겼습니다. 다시 시작합니다.");
				} else if(computerChoice == 2) {
					System.out.println("당신이 졌습니다!");
					break;
				}
			} else if(userChoice == 2) {
				if(computerChoice == 0) {
					System.out.println("당신이 졌습니다!");
					break;
				} else if(computerChoice == 1) {
					System.out.println("당신이 이겼습니다!");
					break;
				} else if(computerChoice == 2) {
					System.out.println("비겼습니다. 다시 시작합니다.");
				}
			}
		}
	}
}
