package ch06.hosung;

public class TvTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv t1=new Tv();
		Tv t2=new Tv();
		System.out.println("t1 채널은 "+t1.channel+"입니다.");
		System.out.println("t2 채널은 "+t2.channel+"입니다.");
		
		t2=t1;	//t1이 저장하고  있는 값(주소)을 t2에 저장한다.
		t1.channel=7;//channel 값을 7로 한다.
		System.out.println("t1의 channel");
		
		System.out.println("t1 채널은 "+t1.channel+"입니다.");
		System.out.println("t2 채널은 "+t2.channel+"입니다.");
	}

}
