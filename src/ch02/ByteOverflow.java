package ch02;

/**
 * Created by Daniel on 2016. 3. 6..
 */
public class ByteOverflow {

    public static void main(String args[]){
        byte b = 0;
        int i = 0;


        // 정수형 변수는 자신이 저장할 수 있는 범위를 넘어서면, 마치 자동차의 주행표시기와 같이
        // 최소값부터 다시 반복된다.
        for(int x=0 ; i <= 270 ; x++){
            System.out.print(b++);
            System.out.print('\t');
            System.out.println(i++);
        }
    }
}
