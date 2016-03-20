package ch04.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class FlowEx27 {

    public static void main(String[] args) {

        // 이름 붙은 반복문!
        loop1 : for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if(j==5){
                    //break loop1;
                    break;
                }
                //break;
                //continue loop1;
                //continue;
                System.out.println(i + "*" + j + "=" + i*j);

            }
            System.out.println();
        }

    }
}
