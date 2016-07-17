package ch14.Hosung;

import java.io.*;
import java.util.Arrays;

public class IOEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] inSrc={0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc=null;
		
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input =  new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		input.read(temp,0,temp.length);
		output.write(temp,5,5);
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source :"+Arrays.toString(inSrc));
		System.out.println("temp :"+Arrays.toString(temp));
		System.out.println("Output Source :"+Arrays.toString(outSrc));
	}

}
