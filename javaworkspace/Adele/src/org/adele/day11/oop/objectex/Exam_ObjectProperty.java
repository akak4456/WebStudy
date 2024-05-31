package org.adele.day11.oop.objectex;
class Member {
	String name;
	int age;
	String email;
	String phone;
	String address;
	
	public Member() {
		
	}
	
	public Member(String name, int age, String email, String phone, String address) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name +", 나이 : "+ age + ", 이메일 : "+ email + ", 전화번호 : " + phone + ", 주소 : " + address;
	}
}
public class Exam_ObjectProperty {
	public static void print(Object obj) {
		System.out.println("클래스 이름 : " + obj.getClass().getName());
		System.out.println("해시 코드값 : " + obj.hashCode());
		System.out.println("객체를 문자열로 만들어 출력 : " + obj.toString());
		System.out.println("객체 출력 : " + obj);
	}
	public static void main(String [] args) {
//		print(new Member("일용자", 50, "akak1234@naver.com", "010-1234-1234", "address"));
//		print(new Member());
		
		String javaStr = "Java";
		String javaStr2 = new String("Java");
		String javaStr3 = "Java";
		
		System.out.println(javaStr == javaStr3); // true
		System.out.println(javaStr3 == javaStr2); // false
		System.out.println(javaStr3 == "Java"); // true
		System.out.println(javaStr == "JavA"); // false
		System.out.println(javaStr2 == "Java"); // false
		System.out.println(javaStr2.equals("Java")); // true
		
		if("Java".equals(javaStr2)) {
			System.out.println("똑같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
	}
}
