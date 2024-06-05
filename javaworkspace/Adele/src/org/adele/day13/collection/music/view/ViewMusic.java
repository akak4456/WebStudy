package org.adele.day13.collection.music.view;

import java.util.List;
import java.util.Scanner;

import org.adele.day13.collection.music.model.Music;

public class ViewMusic {
	public int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== ==== 메인 메뉴 === ===");
		System.out.println("1. 마지막 위치에 곡 추가");
		System.out.println("2. 첫 위치에 곡 추가");
		System.out.println("3. 전체 곡 목록 출력");
		System.out.println("4. 특정 곡 검색");
		System.out.println("5. 특정 곡 삭제");
		System.out.println("6. 특정 곡 정보수정");
		System.out.println("7. 곡명 오름차순 정렬");
		System.out.println("8. 곡명 내림차순 정렬");
		System.out.println("9. 가수명 오름차순 정렬");
		System.out.println("10. 가수명 내림차순 정렬");
		System.out.println("0. 종료");
		System.out.print("메뉴 선택 >> ");
		return sc.nextInt();
	}
	
	public void displayMsg(String msg) {
		System.out.println(msg);
	}

	public Music inputMusic() {
		Scanner sc = new Scanner(System.in);
		System.out.println("곡명 입력 >> ");
		String title = sc.next();
		System.out.println("가수명 입력 >> ");
		String singer = sc.next();
		return new Music(title, singer);
	}
	
	public void printMusics(List<Music> mList) {
		System.out.println("음악들");
		for(Music music : mList) {
			System.out.println(music.getTitle() + " (singer: " + music.getSinger() +")");
		}
	}
	
	public String inputTitle(String category) {
		Scanner sc = new Scanner(System.in);
		System.out.print(category + "할 곡명 입력 >> ");
		return sc.next();
	}
	
	public void printMusic(Music music) {
		System.out.println(music.getTitle() + " (singer: " + music.getSinger() +")");
	}
	
	public Music modifyMusic(Music music) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 가수명 입력 >> ");
		music.setSinger(sc.next());
		return music;
	}
}
