package ch14.Jaeyun;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SuperCustomerInfo {
	String name;
	String password;
	public SuperCustomerInfo() {
		this("Unknown", "1111");
	}
	public SuperCustomerInfo(String name, String pasword) {
		this.name = name;
		this.password = pasword;
	}
	
}

public class CustomerInfo extends SuperCustomerInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3755225272344392560L;
	int age;

	public CustomerInfo() {
		this("Unknown", "1111", 0);
	}

	public CustomerInfo(String name, String pasword, int age) {
		super(name, pasword);
		this.age = age;
	}

	@Override
	public String toString() {
		return "CustomerInfo [age=" + age + ", name=" + name + ", pasword=" + password + "]";
	}
	
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeUTF(password);
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		this.name = in.readUTF();
		this.password = in.readUTF();
		in.defaultReadObject();
	}
	
	
}
