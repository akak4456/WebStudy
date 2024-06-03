package org.adele.day12.collection.list;

import java.util.ArrayList;
import java.util.List;

public class Exam_ListCollection {
	public static void main(String[] args) {
		// List 인터페이스 존재
		// List 인터페이스를 구현하여 만든 클래스가 존재
		// ArrayList 클래스라고 하면 이것을 사용한다.
		List<String> list = new ArrayList<>();
		list.add("김만규");
		list.add("김지혁");
		list.add("양희준");
		list.add("오정민");
		list.add("김태우");
		list.add("이용재");
		list.add("조홍빈");
		list.add("오준석");
		list.add(2, "adele");
		
		System.out.println(list.get(0));
//		System.out.println(list.get(5));
		System.out.println("크기 : " + list.size());
		System.out.println("마지막 값 : " + list.get(list.size() - 1));
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(list.size() - 1);
		list.remove(2);
		list.clear();
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println("isEmpty() : " + list.isEmpty() + ", size() : " + list.size());
	}
	
	public static void genericSample() {
		GenericList<String> strList = new GenericList<>();
		strList.add("개강");
		strList.add("프로젝트");
		strList.add("종강");
		
		String start = strList.get(0);
		String project = strList.get(1);
		String end = strList.get(2);
		System.out.println(start);
		System.out.println(project);
		System.out.println(end);
	}
	
	public static void objListSample() {
		ObjectList objList = new ObjectList();
		objList.add(5.7);
		objList.add(1023);
		objList.add("종강");
		
		double start = (double)objList.get(0);
		int end = (int)objList.get(1);
		String msg = (String)objList.get(2);
		System.out.println(start);
		System.out.println(end);
		System.out.println(msg);
	}
	
	public static void intListSample() {
		IntList nums = new IntList();
		nums.add(5);
		nums.add(7);
		nums.add(1023);
		System.out.println(nums.get(0));
		System.out.println(nums.get(1));
		System.out.println(nums.get(2));
		System.out.println("크기 : " + nums.size);
		nums.clear();
		System.out.println("크기 : " + nums.size);
	}
}
