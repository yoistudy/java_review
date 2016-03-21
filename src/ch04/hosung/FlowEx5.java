package ch04.hosung;

public class FlowEx5 {

	public static void main(String[] args) {
			int score=82;
			String grade="";
			
			System.out.println("당신의 점수는 "+score+"입니다.");
			
			if(score >=90){
				grade="A";
				if(score>=98){
					grade+="+";
				}else if(score<94){
					grade+="-";
				}
			}else if(score >=80){
				grade="B";
				if(score>=88){
					grade+="+";
				}else if(score<84){
					grade+="-";
				}
			}else{
				grade="C";
			}
			
			System.out.println("당신의 학점은 " + grade + "입니다.") ;
		}
}
