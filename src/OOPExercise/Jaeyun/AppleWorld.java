package OOPExercise.Jaeyun;

public class AppleWorld {

	public static void main(String[] args) {
		
		Mac jaeyunMacBookPro = new MacBookPro("SN-MCB001");
		jaeyunMacBookPro.login("jaeyun");
		
		IPhone jaeyunIPhone6 = new IPhone6("SN-IPHN001"); 
		jaeyunIPhone6.login("Jaeyun");
		jaeyunIPhone6.setCelluarInfo(new CelluarInfo("SKT", "01011111111"));
		jaeyunIPhone6.makeCall("01022222222");
		jaeyunIPhone6.sendText("01022222222", "Hey, How have you been?");
		jaeyunMacBookPro.makeFacetimeCall("yoiyoy");

		IPhone yoiyoyIPhone6 = new IPhone6("SN-IPHN002");
		yoiyoyIPhone6.login("yoiyoy");
		yoiyoyIPhone6.setCelluarInfo(new CelluarInfo("SKT", "01022222222"));
		yoiyoyIPhone6.setCelluarInfo(null);
		yoiyoyIPhone6.setCelluarInfo(new CelluarInfo("KT", "01022222222"));
		yoiyoyIPhone6.sendText("01011111111", "yo, I've been doing alight, I'll call you back after the meeting is over");
		yoiyoyIPhone6.makeCall("01011111111");
		yoiyoyIPhone6.makeFacetimeCall("yoiyoy");
		
		
		
		
	}

}
