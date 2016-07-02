package Appendix.Hosung;

public class VarArgsEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(concatenate("-","100","200","300"));
	}//main end
	
	static String concatenate(String delim, String... args){
		String result = "";
		
		for(String str : args){
			result += str + delim;
		}//for end
		return result;
	}
	
//	static String concatenate(String... args){
//		return concatenate("",args);
//	}

}//class end
