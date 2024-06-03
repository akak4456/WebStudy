package org.adele.day12.collection.student;

import java.util.List;

public class StudentRun {
	public static void main(String[] args) {
		ManageStudent mng = new ManageStudent();
		ViewStudent view = new ViewStudent();
		끝:
		while(true) {
			int input = view.printMenu();
			switch(input) {
			case 1 :
				Student std = view.inputStudent();
				mng.registerStudent(std);
				break;
			case 2 :
				String stdName = view.inputStudentName();
				view.displayStudents(mng.searchOneByName(stdName));
				break;
			case 3 :
				List<Student> stdList = mng.selectAllStudents();
				view.displayStudents(stdList);
				break;
			case 4 :
				break;
			case 5 :
				break;
			case 6 :
				break;
			case 0 :
				view.displayMsg("프로그램을 종료합니다.");
				break 끝;
			default : 
				view.displayMsg("0 ~ 6 사이의 수를 입력해주세요.");
			}
		}
	}
}
