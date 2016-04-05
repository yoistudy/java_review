package ch06.hosung;

class Data1{
	int value;
}

class Data2{
	int value;
	
	Data2(int x){
		value=x;
	}
}


public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data1 d1 = new Data1();
		//Data2 d2 = new Data2(); //compile error 발생
		//기본생성자가 추가되지 않았기때문에
	}

}
