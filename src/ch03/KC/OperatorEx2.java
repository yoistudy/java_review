package ch03.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class OperatorEx2 {
    public static void main(String args[]){
        int i=5;
        int j=0;
        j = i++;
        System.out.println("j=i++; 실행 후, i=" + i + ", j=" + j);

        i=5;
        j=0;
        j = ++i;
        System.out.println("j=++i; 실행 후, i=" + i + ", j="+j);
    }


}
