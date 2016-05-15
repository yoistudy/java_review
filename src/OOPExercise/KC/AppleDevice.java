package OOPExercise.KC;

import java.util.*;

/**
 * Created by Daniel on 2016. 5. 15..
 */
public abstract class AppleDevice{

    private String appleId;

    private Set<String>               installApp;
    private Map<String, List<String>> iMessage;

    public String getAppleId() {
        return appleId;
    }

    public void setAppleId(String appleId) {
        this.appleId = appleId;
    }

    AppleDevice(){
        installApp = new HashSet<String>();
        iMessage   = new HashMap<String, List<String>>();
    }

    public void installApp(String appName){
        installApp.add(appName);
        System.out.println(appleId + "님 단말기에 " + appName + "앱이 설치되었습니다.");
    }

    public void runApp(String appName) {
        if (installApp.contains(appName)){
            System.out.println(appName + "앱이 실행됩니다.");
        }else{
            System.out.println("설치된 앱이 없습니다.");
        }
    }

    public void sendIMessage(AppleDevice appDevice, String msg) {
        System.out.println(appDevice.getAppleId() + "님에게 메세지를 전송합니다.");
        appDevice.receiveIMessage(this.appleId, msg);
    }

    public void receiveIMessage(String id, String msg) {
        if(!(iMessage.containsKey(id))){
            iMessage.put(id, new ArrayList<String>());
        }
        System.out.println(this.appleId + "님께서 메세지를 전송받으셨습니다.");
        System.out.println("[메세지 내용] : " + msg);
        iMessage.get(id).add(msg + " [수신 시각] : " + new Date().toString());
    }

    public void printIMessage(){
        Iterator<String> keys = iMessage.keySet().iterator();
        System.out.println("######## [메세지 내용 확인] ######## ");
        if (keys.hasNext()){

        }
        else{
            System.out.println("[메세지함 내용이 없습니다.]");
        }
        while (keys.hasNext()){
            String key = keys.next();
            List<String> msgList = iMessage.get(key);
            System.out.println(key + "님에게 받은 메시지");
            for (String msg: msgList) {
                System.out.println(msg);
            }
        }

    }

    public void printInstalledApp(){
        System.out.println("##### 설치된 앱 리스트 #####");
        for (String appName : installApp) {
            System.out.println("  - "+appName);
        }
    }

}
