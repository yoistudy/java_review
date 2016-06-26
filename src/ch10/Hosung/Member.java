package ch10.Hosung;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
