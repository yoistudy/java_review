package ch07.Jaeyun;

import java.sql.Date;
import java.util.Date;

class Tv {
	boolean isPowerOn; // 전원 여부
	int channel;  // 채널
	
	void PowerOn () { isPowerOn = !isPowerOn; }
	void channelUp() { ++channel; }
	void channerDow() { --channel; }
}

class CaptionTv extends Tv {
	boolean isCaptionOn; // 캡션 여부
	void displayCaption (String text) {
		if (isCaptionOn) {
			System.out.println(text);
		}
	}
}

public class CaptionTvTest {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCaption("hello tv");
		ctv.isCaptionOn = true;
		ctv.displayCaption("hello tv");
		
	}
}