package ch05.KC;

/**
 * Created by Daniel on 2016. 3. 27..
 */
public class ArrayEx15 {

    public static void main(String[] args) {
        if(args.length != 3){
            System.out.println("usage : java ArrayEx15 NUM1 OP NUM2");
            System.exit(0);
        }

        int num1 = Integer.parseInt(args[0]);
        char op = args[1].charAt(0);
        int num2 = Integer.parseInt(args[2]);

        int result = 0;

        switch (op){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            default:
                System.out.println("지원하지않음");
        }
        System.out.println("결과 : " + result);
    }

}
