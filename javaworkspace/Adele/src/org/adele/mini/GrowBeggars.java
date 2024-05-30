package org.adele.mini;
/*
 * MVC 아키텍처를 적용함
 * public class GrowBeggars: 게임을 실행하는 메인 클래스
 * class GrowBeggars...Controller: 게임의 입력과 출력을 중재하는 Controller
 * class Beggar: 게임 핵심 Model
 * class GrowBeggarsView: 게임의 입출력을 담당하는 View, 일단 System.out.println으로 구현함
 */

import java.util.Scanner;

import org.adele.mini.controller.GrowBeggarsIntroController;
import org.adele.mini.controller.GrowBeggarsMainController;

public class GrowBeggars {
	private static GrowBeggarsMainController mainController;
	private static GrowBeggarsIntroController introController;
	public static void main(String[] args) {
		GrowBeggarsView view = new GrowBeggarsView(new Scanner(System.in));
		ManageBeggar beggar = new ManageBeggar();
		mainController = new GrowBeggarsMainController(beggar, view);
		introController = new GrowBeggarsIntroController(beggar, view, mainController);
		introController.run();
	}

}
