package ch06.hosung;

class Product{
	static int count=0;
	int serialNo;
	
	{
		++count;
		serialNo=count;
	}
	
	public Product(){ }
}

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1= new Product();
		Product p2= new Product();
		Product p3= new Product();
		
		System.out.println("p1의 제품 번호 (serial no)는 "+p1.serialNo);
		System.out.println("p2의 제품 번호 (serial no)는 "+p2.serialNo);
		System.out.println("p3의 제품 번호 (serial no)는 "+p3.serialNo);
		System.out.println("생산된 제품의 수는 모두 "+Product.count+"개 입니다.");
	}

}
