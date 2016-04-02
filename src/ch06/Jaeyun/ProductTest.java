package ch06.Jaeyun;

class Product {
	static int count = 0;
	int serialNo;
	
	{
		++count;
		serialNo = count;
	}
	
	public Product () { }
}

public class ProductTest {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();

		System.out.println("p1의 제품번호(serial No.)는 " + p1.serialNo + "입니다");
		System.out.println("p1의 제품번호(serial No.)는 " + p2.serialNo + "입니다");
		System.out.println("p1의 제품번호(serial No.)는 " + p3.serialNo + "입니다");
		System.out.println("생산된 제품의 수는 모두 " + Product.count + "개 입니다");
	}

}
