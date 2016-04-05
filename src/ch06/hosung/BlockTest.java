package ch06.hosung;

public class BlockTest {
	static{
		System.out.println("static { }");
	}
	
	{
		System.out.println("{ }");
	}
	
	public BlockTest(){
		System.out.println("생성자");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("BlcokTest bt = new BlcokTest();");
		BlockTest bt = new BlockTest();
		
		System.out.println("BlcokTest bt2 = new BlcokTest();");
		BlockTest bt2 = new BlockTest();
		
	}

}
