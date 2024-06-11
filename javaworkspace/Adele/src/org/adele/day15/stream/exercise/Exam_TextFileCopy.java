package org.adele.day15.stream.exercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Exam_TextFileCopy {
	public static void main(String[] args) {
		try (Reader reader = new FileReader("C:\\Windows\\system.ini");
				Writer writer = new FileWriter("C:\\Temp\\system.txt")) {
			char [] cBuf = new char[1024];
			int readCount;
			while((readCount = reader.read(cBuf)) != -1) {
				writer.write(cBuf, 0, readCount);
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
