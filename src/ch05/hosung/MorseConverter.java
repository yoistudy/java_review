package ch05.hosung;

public class MorseConverter {
	public static void main(String[] args) {
		if(args.length!=1){
			System.out.println("usage: java MorseConverter WORD");
			System.out.println(0);//프로그램 종료
		}
		
		System.out.println("source:"+args[0]);
		String source=args[0].toUpperCase();//대문자로 변환한다.
		
		String[] morse={
				".-","-...","-.-.","-..","."
				,"..-.","--.","....","..",".---"
				,"-.-",".-..","--","-.","---"
				,".--.","--.-",".-.","...","-"
				,"..-","...-",".--","-..-","-.--"
				,"--.."
		};
		String result="";
		
		for(int i=0; i<source.length(); i++){
			result+=morse[source.charAt(i)-'A'];
			System.out.print(source.charAt(i)-'A'+" ");
		}
		System.out.println("morse:"+result);
	}//main end
}//class end
