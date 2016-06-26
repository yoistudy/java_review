package ch11.KC;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Daniel on 2016. 6. 26..
 */
public class HashMapEx1 {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("castello", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Id와 Password를 입력해주세요.");
            System.out.println("Id : ");
            String id = sc.nextLine().trim();

            System.out.println("Password : ");
            String password = sc.nextLine().trim();
            System.out.println();


            if (!map.containsKey(id)) {
                System.out.println("입력한 아이디는 존재하지 않습니다.");
            }
            else{
                if (!(map.get(id)).equals(password)) {
                    System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                }
                else{
                    System.out.println("ID/PASSWORD가 일치합니다.");
                    break;
                }
            }




        }

    }


}
