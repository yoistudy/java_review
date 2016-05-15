package OOPExercise.KC;

/**
 * Created by Daniel on 2016. 5. 15..
 */
public class IPhone5 extends AppleDevice implements Callable{

    public static final int  DISPLAY_HORIZONTAL_SIZE = 20;
    public static final int  DISPLAY_VERTICAL_SIZE   = 40;

    MobileDevice mobileDevice; // 기기 식별 정보(번호, 통신사)

    public IPhone5(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
        //mobileDevice = new MobileDevice();
        //mobileDevice.setDeviceNumber(phoneNumber);
        //mobileDevice.setNetworkProvider(networkProvider);
    }

    @Override
    public void callSend(Callable callableDevice) {
        callableDevice.callReceive(this.mobileDevice.getDeviceNumber());
    }

    @Override
    public void callReceive(String senderPhoneNumber) {
        System.out.println(senderPhoneNumber + "님에게서 전화가 왔습니다.");
    }

    @Override
    public String toString() {
        return "[IPhone Obj] mobileDevice.deviceNumber = " + mobileDevice.getDeviceNumber() + ", mobileDevice.networkProvider = " + mobileDevice.getNetworkProvider();
    }
}
