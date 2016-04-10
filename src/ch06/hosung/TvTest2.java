package ch06.hosung;

public class TvTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv t1=new Tv();
		Tv t2=new Tv();
		System.out.println("t1 채널은 "+t1.channel+"입니다.");
		System.out.println("t2 채널은 "+t2.channel+"입니다.");
		
		t1.channel=7;
		System.out.println("t1의 channel");
		
		System.out.println("t1 채널은 "+t1.channel+"입니다.");
		System.out.println("t2 채널은 "+t2.channel+"입니다.");
	}

}
