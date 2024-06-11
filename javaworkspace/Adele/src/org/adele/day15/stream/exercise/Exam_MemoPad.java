package org.adele.day15.stream.exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Exam_MemoPad {
	public static void main(String[] args) {
		// 저장할 파일 입력(확장자 제외) : snow
		// 종료는 exit
		// 1 : 오늘은
		// 2 : 눈이
		// 3 : 옵니다.
		// 4 : 펑펑
		// 5 : 옵니다.
		// 6 : exit
		// 파일 저장이 완료되었습니다. F5를 눌러 확인해보세요~
		// snow.txt -> 오늘은\n눈이\n옵니다\n펑펑\n옵니다.
		Scanner sc = new Scanner(System.in);
		System.out.print("저장할 파일 입력(확장자 제외) : ");
		String fileName = sc.nextLine();
		try (Writer writer = new FileWriter("src/org/adele/day15/stream/exercise/" + fileName+".txt")){
			String line = "";
			int lineCnt = 1;
			while(!line.equals("exit")) {
				System.out.print(lineCnt + " : ");
				line = sc.nextLine();
				if(line.equals("exit")) {
					break;
				}
				lineCnt++;
				writer.write(line);
				writer.write("\n");
				writer.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
