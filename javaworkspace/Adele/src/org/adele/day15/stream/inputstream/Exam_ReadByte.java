package org.adele.day15.stream.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exam_ReadByte {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("src/org/adele/day15/stream/inputstream/reading.txt");
			byte [] readBytes = new byte[3];
			int readCount;
			String result = "";
			while((readCount = is.read(readBytes)) != -1) {
				result += new String(readBytes, 0, readCount);
			}
			System.out.println(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
