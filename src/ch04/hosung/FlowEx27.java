package ch04.hosung;

import java.io.IOException;

public class FlowEx27 {
	public static void main(String[] args) throws IOException {
		loop1 : for(int i=2; i<=9; i++){
			for(int j=1; j<=9; j++){
				if(j==5)
					break loop1;
//					break;
//					continue loop1;
//					continue;
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}
}
