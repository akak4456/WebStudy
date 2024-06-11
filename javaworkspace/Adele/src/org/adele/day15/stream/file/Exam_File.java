package org.adele.day15.stream.file;

import java.io.File;
import java.io.IOException;

public class Exam_File {
	public static void main(String[] args) throws IOException {
		File fileMake = new File("src/org/adele/day15/stream/file/sample.txt");
		if(!fileMake.exists()) {
			fileMake.createNewFile();
			System.out.println("파일이 만들어졌습니다.");
		} else {
			System.out.println("이미 파일이 존재합니다.");
		}
	}
	public void fileBasic() {
		File file = new File("C:\\Users\\user1\\Desktop\\SeungHyo-old\\img\\logo.png");
		String fileName = file.getName();
		String path = file.getPath();
		String parent = file.getParent();
		System.out.println("파일 이름 : " + fileName);
		System.out.println("파일 경로 : " + path);
		System.out.println("부모 폴더 : " + parent);
		System.out.println("파일이 존재하는가? : " + file.exists());
		System.out.println("파일이 맞는가? : " + file.isFile());
		System.out.println("폴더가 맞는가? : " + file.isDirectory());
	}
}
