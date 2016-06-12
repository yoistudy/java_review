package ch11.Jaeyun;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class RandomEx {

	public static void main(String[] args) {
		Random random1 = new Random(1234);
		Random random2 = new Random(1234);
		
		// nextInt 메서드는 int 타입 난수를 반환한다
		// true
		System.out.println("random1 == random2" + 
			(random1.nextInt() == random2.nextInt())
		);
		// setSeed 메서드는 seed를 인자로 변경한다
		random1.setSeed(4321);
		// false
		System.out.println("random1 == random2" + 
			(random1.nextInt() == random2.nextInt())
		);
	}
	
}
