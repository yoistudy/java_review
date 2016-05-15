package OOPExercise.KC;

/**
 * Created by Daniel on 2016. 5. 15..
 */
public class MobileDevice {
    /**
     * 모바일 기기 일반 특성
     */

    private String deviceNumber;    // 핸드폰 번호
    private String networkProvider; // 통신사

    public MobileDevice(String deviceNumber, String networkProvider) {
        this.deviceNumber = deviceNumber;
        this.networkProvider = networkProvider;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getNetworkProvider() {
        return networkProvider;
    }

    public void setNetworkProvider(String networkProvider) {
        this.networkProvider = networkProvider;
    }
}
