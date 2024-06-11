package org.adele.day15.stream.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Exam_FileCopy {
	public static void main(String[] args) {
		try(InputStream is = new FileInputStream("C:/Temp/fetlity.png");
		OutputStream os = new FileOutputStream("D:/Copy/copied.png")) {
			byte[] buf = new byte[1024];
			int readCount;
			while((readCount = is.read(buf)) != -1) {
				os.write(buf,0,readCount);
			}
			os.flush();
			System.out.println("복사가 완료되었습니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
