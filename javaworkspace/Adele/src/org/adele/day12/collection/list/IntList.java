package org.adele.day12.collection.list;

public class IntList {
	int [] nums;
	int size;
	
	public IntList() {
		nums = new int[3];
		size = 0;
	}
	
	public void add(int num) {
		nums[size] = num;
		size++;
		if(size >= nums.length) {
			int[] tmp = new int[size * 2];
			for(int i=0;i<nums.length;i++) {
				tmp[i] = nums[i];
			}
			nums = tmp;
		}
	}
	
	// 전체값을 가져올때는 매개변수 필요없음
	// 그런데 1개의 값을 가져올때는 그 위치가 필요하므로 매개변수 필요함.
	public int get(int index) {
		return nums[index];
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		nums = new int[3];
		size = 0;
	}
	
	public static void main(String[] args) {
		
	}
}
