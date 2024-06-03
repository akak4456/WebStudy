package org.adele.effectivejava;

import java.util.WeakHashMap;
class Fruit {
	private String name;
	public Fruit(String name) {
		this.name = name;
	}
}
public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap<Fruit, String> map = new WeakHashMap<>();
		// HashMap<Fruit, String> map = new HashMap<>();
        Fruit apple = new Fruit("apple");
        Fruit orange = new Fruit("orange");
        map.put(apple, "test a");
        map.put(orange, "test b");
        apple = null;
        System.gc();
        map.entrySet().forEach(System.out::println);
	}
}
