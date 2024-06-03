package org.adele.day12.collection.list;

/*
 * A, B 에 동일한 메소드 시그니처가 있어도
 * override 하는데 문제가 없는듯...
 */
public class C implements A, B{

	@Override
	public boolean a() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean b() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean c() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		A a = new C();
		B b = new C();
		System.out.println("a.a() = "+a.a());
		System.out.println("b.b() = "+b.b());
	}

}
