package ch05.KC;

/**
 * Created by Daniel on 2016. 3. 27..
 */
public class CyclicRotation {
    public static void main(String[] args) {
        CyclicRotation cr = new CyclicRotation();
        int[] arr = {1,2,3,4,5};
        int[] result = cr.solution(arr, 3);


    }


    public int[] solution(int[] arr, int k){
        int[] result      = new int[arr.length];
        int[] shiftArr    = new int[k];
        int[] nonShiftArr = new int[arr.length - k];

        System.arraycopy(arr, k-1, shiftArr    , 0 , k);
        System.arraycopy(arr, 0  , nonShiftArr , 0 , arr.length - k);

        int tmp = 0;
        for(int i = shiftArr.length - 1 ; i < shiftArr.length ; i++){
            result[i] = shiftArr[tmp];
            tmp++;
        }

        return result;
    }

}
