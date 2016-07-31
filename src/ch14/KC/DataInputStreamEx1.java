package ch14.KC;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Daniel on 2016. 7. 31..
 */
public class DataInputStreamEx1 {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("sample.dat");
            DataInputStream dis = new DataInputStream(fis);

            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readBoolean());
            dis.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
