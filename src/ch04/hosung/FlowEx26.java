package ch04.hosung;

import java.io.IOException;

public class FlowEx26 {
	public static void main(String[] args) throws IOException {
		for(int i=0; i<=10; i++){
			if(i%3==0)
				continue;
			System.out.println(i);
		}
	}
}
