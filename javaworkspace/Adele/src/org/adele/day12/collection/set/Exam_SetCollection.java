package org.adele.day12.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.adele.day12.collection.student.Student;

public class Exam_SetCollection {
	public static void main(String[] args) {
		// Collection의 List, Set, Map -> 저장소
		// 자료구조의 특성에 따라서 선택하여 사용함.
		Set<Student> stdSet = new HashSet<Student>();
		stdSet.add(new Student("이세훈", 90, 80));
		stdSet.add(new Student("허태성", 88, 44));
		stdSet.add(new Student("남궁성", 78, 67));
		stdSet.add(new Student("이세훈", 90, 80));
		
		System.out.println("크기 : " + stdSet.size());
		
		Iterator<Student> it = stdSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void setSample() {
		Set<String> strSet = new HashSet<String>();
		strSet.add("체리");
		strSet.add("딸기");
		strSet.add("사과");
		strSet.add("수박");
		strSet.add("포도");
		strSet.add("딸기");
		System.out.println("크기 : " + strSet.size());
		
		Iterator<String> it = strSet.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
