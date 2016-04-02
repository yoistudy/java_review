package ch06.Jaeyun;

public class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
//	static int cv2 = iv; // 클래스 변수는 인스턴스 변수를 사용할 수 없음
	static int cv2 = new MemberCall().iv; // 객체를 생성한 후에 인스턴스 변수 참조 가능
	
	static void staticMethod1() {
		System.out.println(cv);
//		System.out.println(iv); // 클래스 메서드에서 바로 인스턴스 변수 사용 불가
		MemberCall c = new MemberCall();
		System.out.println(c.iv); // 객체를 생성한 후에 인스턴스 변수 참조 가능
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv); // 인스턴스 메서드에서 바로 인스턴스 변수 사용 가능
	}
	
	static void staticMethod2() {
		staticMethod1();
//		instanceMethod1(); //  클래스 메서드에서 바로 인스턴스 메서드 호출 불가
		MemberCall c = new MemberCall();
		c.instanceMethod1();; // 객체를 생성한 후에 인스턴스 메서드 호출 가능
	}
	
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1(); //  인스턴스 메서드에서 바로 인스턴스 메서드 호출 가능
	}
	
}
