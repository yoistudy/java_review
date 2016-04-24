package ch07.Jaeyun;

public class BindingTest2 {

	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		System.out.println("p.x = " + p.x);
		System.out.println("p.y = " + p.y);
		p.methodA();
		p.methodB();
		
		System.out.println("c.x = " + c.x);
		System.out.println("c.y = " + c.y);
		c.methodA();
		c.methodB();

	}

}

class Parent {
	int x = 100;
	
	void methodA() {
		System.out.println("Parent Method A");
	}
}

class Child extends Parent {
	int y = 100;
	
	void methodB() {
		System.out.println("Parent Method B");
	}
}