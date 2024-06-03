package org.adele.day12.collection.list;

public class GenericList<T> {
	Object [] objects;
	int size;
	
	public GenericList() {
		objects = new Object[3];
		size = 0;
	}
	
	public void add(T object) {
		objects[size] = object;
		size++;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T)objects[index];
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		objects = new Object[3];
		size = 0;
	}
}
