package ch05.KC;

/**
 * Created by Daniel on 2016. 3. 26..
 */
public class ArrayEx10 {

    public static void main(String[] args) {
        int [][] score = {
                {100,100,100},
                {20,20,20},
                {30,30,30},
                {40,40,40},
                {50,50,50}
        };

        int koreanTotal = 0;
        int englishTotal = 0;
        int mathTotal = 0;

        System.out.println("번호 국어 영어 수학 총점 평균");
        System.out.println("==========================");

        for(int i = 0 ; i < score.length ; i++){
            int sum = 0;
            koreanTotal += score[i][0];
            englishTotal += score[i][1];
            mathTotal += score[i][2];
            System.out.print((i+1) + " ");
            for(int j = 0 ; j < score[i].length ; j++){
                sum += score[i][j];
                System.out.print(score[i][j] + " ");
            }
            System.out.println(sum + " " + sum/(float)score[i].length);
        }

        System.out.println("==========================");
        System.out.println("총점:" + koreanTotal + " " + englishTotal + " " + mathTotal);
    }
}
