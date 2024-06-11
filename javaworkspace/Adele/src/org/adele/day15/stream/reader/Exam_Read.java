package org.adele.day15.stream.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Exam_Read {
	public static void main(String[] args) {
		Reader reader = null;
		
		try {
			reader = new FileReader("src/org/adele/day15/stream/reader/reading.txt");
			int readData;
			while((readData = reader.read()) != -1) {
				System.out.println((char)readData);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
