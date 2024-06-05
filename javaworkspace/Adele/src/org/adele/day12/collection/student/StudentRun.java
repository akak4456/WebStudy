package org.adele.day12.collection.student;

import java.util.List;

public class StudentRun {
	public static void main(String[] args) {
		ManageStudent mng = new ManageStudent();
		ViewStudent view = new ViewStudent();
		끝:
		while(true) {
			int input = view.printMenu();
			String name;
			switch(input) {
			case 1 :
				Student std = view.inputStudent();
				mng.registerStudent(std);
				break;
			case 2 :
				name = view.inputName("검색");
				List<Student> sList = mng.searchOneByName(name);
				view.displayStudents(sList);
				break;
			case 3 :
				List<Student> stdList = mng.selectAllStudents();
				view.displayStudents(stdList);
				break;
			case 4 :
				name = view.inputName("수정");
				Student student = mng.searchModifyStudent(name);
				int index = mng.searchIndexByName(name);
				student = view.modifyStudent(student);
				mng.modifyStudent(index, student);
				break;
			case 5 :
				name = view.inputName("삭제");
				index = mng.searchIndexByName(name);
				mng.deleteStudent(index);
				break;
			case 6 :
				view.showFailStudent(mng.getFailStudent());
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
