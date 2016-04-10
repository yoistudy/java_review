package ch06.hosung;

class Document{
	static int count=0;
	String name;
	
	public Document(){
		this("제목없음"+ ++count);
	}
	
	public Document(String name){
		this.name=name;
		System.out.println("문서 "+this.name+"가 생성되었습니다.");
	}
}

public class DocumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document d1 = new Document();
		Document d2 = new Document("자바.txt");
		Document d3 = new Document();
		Document d4 = new Document();
	}

}
