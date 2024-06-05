package org.adele.effectivejava;

import java.util.ArrayList;
import java.util.List;

public class UnsafeAddTest {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		unsafeAdd(strings, "ABC");
		String s = strings.get(0);
	}
	
	private static void unsafeAdd(List<String> list, String o) {
		list.add(o);
	}
}	
