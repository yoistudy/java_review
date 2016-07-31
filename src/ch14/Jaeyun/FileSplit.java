package ch14.Jaeyun;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSplit {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("USAGE : java FileSplit file SIZE_KB");
			System.exit(0);
		}
		
		final int VOLUME = Integer.parseInt(args[1]) * 1000;
		
		try {
			String file = args[0];
			int pos = file.lastIndexOf(".");
			String fileName = file.substring(0, pos);
			String ext = file.substring(pos + 1);
			
			
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			
			int data = 0;
			int i = 0;
			int number = 0;
			while ((data = bis.read()) != -1) {
				if (i % VOLUME == 0) {
					if (i != 0) {
						bos.close();
					}
					String splitFileName = fileName + "_" + (number++) + ("".equals(ext) ? "" : "." + ext);
					fos = new FileOutputStream(splitFileName);
					bos = new BufferedOutputStream(fos);
					System.out.println(splitFileName + "로 분할");
				}
				bos.write(data);
				i++;
			}
			
			bis.close();
			bos.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
