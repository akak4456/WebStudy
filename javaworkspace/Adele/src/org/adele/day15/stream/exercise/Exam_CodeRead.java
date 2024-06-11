package org.adele.day15.stream.exercise;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class Exam_CodeRead {
	public static void main(String[] args) {
		// Exam_ImageCopy.java 파일을 읽어서 콘솔로 출력해보세요!
		
		try (Reader reader = new FileReader("src/org/adele/day15/stream/exercise/Exam_ImageCopy.java")) {
			char [] cBuf = new char[1024];
			int readCount = 0;
			StringBuilder result = new StringBuilder();
			while((readCount = reader.read(cBuf)) != -1) {
				result.append(Arrays.copyOf(cBuf, readCount));
			}
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
