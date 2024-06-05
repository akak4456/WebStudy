package org.adele.day12.collection.student;

import java.util.List;

public interface ManageInterface {
	void registerStudent(Student student);
	
	List<Student> searchOneByName(String name);
	
	List<Student> selectAllStudents();
	
	void modifyStudent(int index, Student student);
	
	void deleteStudent(int index);
	
	Student searchModifyStudent(String name);
	
	int searchIndexByName(String name);
	
}
