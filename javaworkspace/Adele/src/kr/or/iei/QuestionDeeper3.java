package kr.or.iei;

import java.util.Random;
import java.util.Scanner;

public class QuestionDeeper3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기 입력 : ");
		int sz = sc.nextInt();
		if(sz < 0) {
			System.out.println("배열의 크기는 양수로 입력해야 합니다!");
		} else {
			int[] num = new int[sz];
			Random random = new Random(); 
			for(int i=0;i<sz;i++) {
				num[i] = random.nextInt(100) + 1;
				boolean isDuplicate = false;
				do {
					isDuplicate = false;
					for(int j=0;j<i;j++) {
						if(num[j] == num[i]) {
							isDuplicate = true;
							break;
						}
					}
					if(isDuplicate) {
						num[i] = random.nextInt(100) + 1;
					}
				} while(isDuplicate);
			}
			int sum = 0;
			for(int i=0;i<sz;i++) {
				sum += num[i];
			}
			System.out.println("sum = " + sum);
		}
	}
}
