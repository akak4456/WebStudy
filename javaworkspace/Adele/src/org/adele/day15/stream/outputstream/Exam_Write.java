package org.adele.day15.stream.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Exam_Write {
	public static void main(String[] args) {
		
		try(OutputStream os = new FileOutputStream("src/org/adele/day15/stream/outputstream/writing.txt")) {
			byte [] input = "헬로우 입출력입니다".getBytes();
			for(int i=0;i<input.length;i++) {
				os.write(input[i]);
			}
			os.flush();
		
			System.out.println("파일 출력 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
