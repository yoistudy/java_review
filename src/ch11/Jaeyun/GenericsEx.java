package ch11.Jaeyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Product
// 구현 클래스를 작성하여 사용하는 방법
// implements Comparable<Product>
{
	Product() {
		this.name = "없음";
	}
	
	protected String name;
	
	protected int  price = 0;
	
	protected int  quantity = 0;
	
	protected int  toalPrice = 0;
	
	String getName() {
		return this.name;
	}
	int getQuantity () {
		return this.quantity;
	}
	int getPrice () {
		return this.price;
	}
//	@Override
//	public int compareTo(Product o) {
//		return o.getPrice() - this.getPrice();
//	}
}

class Tv extends Product {
	Tv() {
		this(1);
	}
	Tv(int quantity) {
		this.name = "TV";
		this.price = 10000;
		this.quantity = quantity;
	}
}

class Audio extends Product {
	Audio() {
		this(2); // 기본 두개 묶음 이야
	}
	
	Audio(int quantity) {
		this.name = "AUDIO";
		this.price = 200;
		this.quantity = quantity; 
	}
}

class ExtArrayList<T extends E, E> extends ArrayList<E> {
	public ExtArrayList() {
		super();
	}
}

public class GenericsEx {

	public static void main(String[] args) {
		ExtArrayList<? extends Product, Product> productList = new ExtArrayList();
		productList.add(new Tv());
		productList.add(new Audio(4));
		productList.add(new Tv(2));
		
		// 상품의 price순으로 상품리스트 정렬
		// 익명 구현 객체를 작성하여 사용하는 방법
		Collections.sort(productList, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o2.getPrice() - o1.getPrice();
			}
		});
		// 구현 클래스를 작성하여 사용하는 방법
		// Collections.sort(productList); 
		
		System.out.println( productList.get(0) instanceof Tv);
		System.out.println( productList.get(0));
		System.out.println( "--  iterating product list --");
		
		Iterator<Product> it = productList.iterator();
		while (it.hasNext()) {
			Product product = it.next();
			System.out.println("상품:" + product.getName() + " - "+product.getPrice()+"("+product.getQuantity()+"개)");
		}
		
		System.out.println("총 상품 가격:" + getTotalProductPrice(productList));
	}
	
	public static int getTotalProductPrice (ArrayList<Product> productList) {
		return 0;
	}
	
	public static <T extends Product> void printTotalProductPrice(ArrayList<T> productList) {
		for (T product: productList) {
			System.out.println(product.getName());
		}
	}

}
