package org.adele.day12.collection.student;

import java.util.ArrayList;
import java.util.List;

public class ManageStudent implements ManageInterface {

	private List<Student> sList;
	
	public ManageStudent() {
		sList = new ArrayList<>();
	}
	
	@Override
	public void registerStudent(Student student) {
		sList.add(student);
	}

	@Override
	public List<Student> searchOneByName(String name) {
		List<Student> ret = new ArrayList<>();
		for(Student s : sList) {
			if(s.getName().equals(name)) {
				ret.add(s);
			}
		}
		return ret;
	}

	@Override
	public List<Student> selectAllStudents() {
		return sList;
	}

	@Override
	public void modifyStudent(int index, Student student) {
		sList.set(index, student);
	}

	@Override
	public void deleteStudent(int index) {
		sList.remove(index);
	}

}
