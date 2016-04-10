package ch06.hosung;

class MemberCall {
	int iv=10;
	static int cv=20;
	
	int iv2=cv;
	//static int cv2=iv; //클래스 변수는 인스턴스 변수 사용 할 수 없음.
	static int cv2=new MemberCall().iv; //객체생성 후 사용 가능

	static void staticMethod1(){
		System.out.println(cv);
		//System.out.println(iv);
		MemberCall c = new MemberCall();
		System.out.println(c.iv);
	}
	
	void instanceMethod1(){
		System.out.println(cv);
		System.out.println(iv);//인스턴스 메서드에서는 인스턴스 변수를 바로 사용 가능
	}
	
	static void staticMethod2(){
		staticMethod1();
		//instanceMethod1();//에러 클래스메서드에서는 인스턴스메서드를 호출할 수 없음
		MemberCall c = new MemberCall();
		c.instanceMethod1();//인스턴스 생성후에야 호출 가능
	}
	
	void instanceMethod2(){//인스턴스 메서드에서는 인스턴스 메서드와 클래스 메서드
		staticMethod1();//모두 인스턴스 생성없이 바로 호출 가능
		instanceMethod1();
	}
}
