package ch11.Jaeyun;

import java.util.ArrayList;

class Product {
	protected String name;
	Product() {
		this.name = "없음";
	}
	String getName() {
		return this.name;
	}
}

class Tv extends Product {
	private String price;
	Tv() {
		this.name = "TV";
		this.price = "$1000";
	}
}

class Audio extends Product {
	private String price;
	Audio() {
		this.name = "AUDIO";
		this.price = "$200";
	}
}

public class GenericsEx {

	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> tvList = new ArrayList<Tv>();
		ArrayList<Audio> audioList = new ArrayList<Audio>();
		
		productList.add(new Product());
		printAll(productList);
		tvList.add(new Tv());
		printAll(tvList);
		audioList.add(new Audio());
		printAll(audioList);
	}
	
	public static <T extends Product> void printAll(ArrayList<T> productList) {
		for (T product: productList) {
			System.out.println(product.getName());
		}
	}

}
