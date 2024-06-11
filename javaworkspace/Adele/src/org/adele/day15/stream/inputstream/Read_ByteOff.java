package org.adele.day15.stream.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Read_ByteOff {
	public static void main(String[] args) {
		InputStream is = null;
		System.out.println(System.getProperty("java.class.path"));
		try {
			is = new FileInputStream("src/org/adele/day15/stream/inputstream/reading.txt");
			int readCount;
			byte [] readBytes = new byte[3];
			String result = "";
			while(true) {
				readCount = is.read(readBytes,0,3);
				if(readCount == -1) break;
				result += new String(readBytes, 0, readCount);
			}
			System.out.println(result);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
