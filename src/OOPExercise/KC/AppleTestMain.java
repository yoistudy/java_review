package OOPExercise.KC;

/**
 * Created by Daniel on 2016. 5. 15..
 */
public class AppleTestMain {

    public static void main(String[] args) {
        AppleDevice ipadMini1 = new IPadMini();
        AppleDevice ipadMini2 = new IPadMini();


        ipadMini1.setAppleId("thefeeling");
        ipadMini1.installApp("KaKao Talk");
        ipadMini1.runApp("KaKao Talk");

        ipadMini2.setAppleId("ssingame");
        ipadMini2.installApp("Naver");
        ipadMini2.runApp("Naver");
        ipadMini2.runApp("Daum");

        System.out.println();

        ipadMini1.sendIMessage(ipadMini2, "Hello Man");
        ipadMini1.sendIMessage(ipadMini2, "Hello Girl");
        ipadMini1.sendIMessage(ipadMini2, "Hello Choi");
        ipadMini1.sendIMessage(ipadMini2, "Hey Where are you?");

        System.out.println();

        ipadMini1.printIMessage();
        ipadMini1.printInstalledApp();

        System.out.println();

        ipadMini2.printIMessage();
        ipadMini2.printInstalledApp();


        IPhone5 iphone1 = new IPhone5(new MobileDevice("01099553758", "SK"));
        IPhone5 iphone2 = new IPhone5(new MobileDevice("01037583758", "KT"));
        iphone1.setAppleId("dokki");
        iphone2.setAppleId("simon");

        iphone1.callSend(iphone2);
        iphone2.callSend(iphone1);

        iphone1.sendIMessage(iphone2, "Hello simon");

        iphone2.printIMessage();
    }
}