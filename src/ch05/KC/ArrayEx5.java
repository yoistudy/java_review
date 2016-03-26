package ch05.KC;

/**
 * Created by Daniel on 2016. 3. 26..
 */
public class ArrayEx5 {

    public static void main(String[] args) {
        int[] num = new int[10];

        for(int i = 0 ; i < num.length ; i++){
            System.out.print(num[i] = (int)(Math.random() * 10));

        }
        System.out.println();

        for(int i = 0 ; i < num.length ; i++){
            boolean changed = false;

            for(int j = 0 ; j < num.length - 1 -i ; j++){
                if(num[j] > num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                    changed = true;
                }
            }

            if(!changed){
                break;
            }

            for(int k = 0 ; k < num.length ; k++){
                System.out.print(num[k]);
            }
            System.out.println();
        }
    }
}
