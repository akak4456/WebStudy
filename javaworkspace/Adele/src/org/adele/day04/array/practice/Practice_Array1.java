package org.adele.day04.array.practice;

import java.util.Random;
import java.util.Scanner;

public class Practice_Array1 {
	public static void main(String[] args) {
		practice12();
	}
	
	public static void practice1() {
		int[] nums = new int[10];
		for(int i=0;i<10;i++) {
			nums[i] = i+1;
		}
		for(int i=0;i<10;i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void practice2() {
		int[] nums = new int[10];
		for(int i=0;i<10;i++) {
			nums[i] = 10 - i;
		}
		for(int i=0;i<10;i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		int[] nums = new int[num];
		for(int i=0;i<num;i++) {
			nums[i] = i+1;
		}
		for(int i=0;i<num;i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void practice4() {
		String[] strs = {"사과", "귤","포도","복숭아","참외"};
		System.out.println(strs[1]);
	}
	
	public static void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		char[] strArray = new char[str.length()];
		for(int i=0;i<str.length();i++) {
			strArray[i] = str.charAt(i);
		}
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		int cnt = 0;
		System.out.print(str+"에 "+ch+"가 존재하는 위치(인덱스) : ");
		for(int i=0;i<strArray.length;i++) {
			if(strArray[i] == ch) {
				cnt++;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println(ch + " 개수 : "+cnt);
	}
	
	public static void practice6() {
		String[] days = {"월", "화", "수", "목", "금", "토", "일"};
		Scanner sc = new Scanner(System.in);
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		if(num < 0 || num > 6) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			System.out.println(days[num]+"요일");
		}
	}
	
	public static void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int cnt = sc.nextInt();
		int[] nums = new int[cnt];
		int sum = 0;
		for(int i=0; i < cnt;i++) {
			System.out.print("배열 "+i+"번째 인덱스에 넣을 값 : ");
			nums[i] = sc.nextInt();
			sum += nums[i];
		}
		for(int i=0;i<cnt;i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println("총 합 : "+sum);
	}
	
	public static void practice8() {
		Scanner sc = new Scanner(System.in);
		int cnt = -1;
		while(cnt == -1) {
			System.out.print("정수 : ");
			cnt = sc.nextInt();
			if(cnt % 2 == 0 || cnt <= 0) {
				System.out.println("다시 입력하세요.");
				cnt = -1;
			}
		}
		int[] nums = new int[cnt];
		for(int i=0;i<cnt;i++) {
			if(i <= cnt/2) {
				nums[i] = i + 1; 
			} else {
				nums[i] = cnt - i;
			}
		}
		for(int i=0;i<cnt;i++) {
			System.out.print(nums[i]);
			if(i < cnt - 1) {
				System.out.print(", ");
			}
		}
	}
	
	public static void practice9() {
		String[] menu = {"양념","후라이드", "마늘간장", "순한맛"};
		Scanner sc = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요 : ");
		String target = sc.next();
		System.out.print(target);
		boolean isFound = false;
		for(int i=0;i<menu.length;i++) {
			if(menu[i].equals(target)) {
				isFound = true;
				break;
			}
		}
		if(isFound) {
			System.out.print("치킨 배달 가능");
		} else {
			System.out.print("치킨은 없는 메뉴입니다.");
		}
	}
	public static void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String number = sc.next();
		char[] convertedNumber = new char[number.length()];
		for(int i=0;i<convertedNumber.length;i++) {
			if(i >= 8) {
				convertedNumber[i] = '*';
			} else {
				convertedNumber[i] = number.charAt(i);
			}
		}
		for(int i=0;i<convertedNumber.length;i++) {
			System.out.print(convertedNumber[i]);
		}
	}
	public static void practice11() {
		int[] number = new int[6];
		Random random = new Random();
		for(int i=0;i<number.length;i++) {
			number[i] = random.nextInt(45) + 1;
		}
		for(int i=0;i<number.length;i++) {
			System.out.print(number[i] + " ");
		}
	}
	public static void practice12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		int[] chCntList = new int[26];
		for(int i=0;i<str.length();i++) {
			chCntList[str.charAt(i) - 'a']++;
		}
		System.out.print("문자열에 있는 문자 : ");
		int chCnt = 0;
		boolean isFirst = true;
		for(int i=0;i<chCntList.length;i++) {
			if(chCntList[i] > 0) {
				if(!isFirst) {
					System.out.print(", ");
				}
				System.out.print((char)(i + 'a'));
				chCnt++;
				isFirst = false;
			}
		}
		System.out.println();
		System.out.println("문자 개수 : "+chCnt);
	}
	
}
