package org.adele.day15.stream.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exam_Read {
	public static void main(String[] args) {
		InputStream is = null;
		
		try {
			is = new FileInputStream("src/org/adele/day15/stream/inputstream/reading.txt");
			int readByte = -1;
			while((readByte = is.read()) != -1) {
				// 1바이트를 읽어 들이므로
				// 한국어 등 2바이트 짜리를 쓸 때 오류가 남
				System.out.println((char)readByte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
