package ch04.hosung;

import java.io.IOException;

public class FlowEx25 {
	public static void main(String[] args) throws IOException {
		int sum=0;
		int i=0;
		
		while(true){
			if(sum>100)
				break;
			++i;
			sum+=i;
		}
		
		System.out.println("i="+i);
		System.out.println("sum="+sum);
	}
}
