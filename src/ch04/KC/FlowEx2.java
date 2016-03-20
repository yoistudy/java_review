package ch04.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class FlowEx2 {
    public static void main(String args[]) {
        int visitCount = 5;
        if(visitCount < 1){
            System.out.println("처음 오셨군요. 방문해 주셔서 감사합니다.");
        }
        else{
            System.out.printf("다시 방문해 주셔서 감사합니다.");
        }
        System.out.println("방문횟수는 " + ++visitCount + "번 입니다.");
    }
}
