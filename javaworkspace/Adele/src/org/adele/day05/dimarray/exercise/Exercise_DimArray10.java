package org.adele.day05.dimarray.exercise;

import java.util.Scanner;

//2차원 배열에 학년별로 1,2학기 성적으로 저장하고 4년간 전체 평점 평균을 출력하라.
//예시. 1학년 (3.3 3.4), 2학년 (3.5 3.6), 3학년 (3.7 4.0), 4학년 (4.1 4.2)
public class Exercise_DimArray10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] score = new double[4][2];
		for(int grade=1;grade<=4;grade++) {
			for(int section=1;section<=2;section++) {
				System.out.print(grade+"학년 "+ section+"학기 성적을 입력하세요 > ");
				score[grade-1][section-1] = sc.nextDouble();
			}
		}
		double sum = 0.0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<2;j++) {
				sum += score[i][j];
			}
		}
		System.out.println("4년간 전체 평점 평균 " + (sum / 8));
	}
}
