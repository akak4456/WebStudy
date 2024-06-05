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
		if(name != null) {
			List<Student> searchList = new ArrayList<>();
			for(Student std : sList) {
				if(name.equals(std.getName())) {
					searchList.add(std);
				}
			}
			return searchList;
		}
		return null;
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

	@Override
	public Student searchModifyStudent(String name) {
		if(name != null) {
			for(Student student : sList) {
				if(name.equals(student.getName())) {
					return student;
				}
			}
		}
		return null;
	}

	@Override
	public int searchIndexByName(String name) {
		for(int i=0;i<sList.size();i++) {
			if(name.equals(sList.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}
	
	public List<Student> getFailStudent() {
		List<Student> ret = new ArrayList<>();
		for(Student student : sList) {
			if(student.getFirstScore() <= 40) {
				ret.add(student);
			} else if(student.getSecondScore() <= 40) {
				ret.add(student);
			} else if((student.getFirstScore() + student.getSecondScore()) / 2 < 60) {
				ret.add(student);
			}
		}
		return ret;
	}

}
