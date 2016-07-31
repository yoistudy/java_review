package ch14.Jaeyun;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMerge {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java FileMerge file");
			System.exit(0);
		} 
		
		
		try {
			String file = args[0];
			String newFileName = "merged_" + file;
			int pos = file.lastIndexOf(".");
			String fileName = file.substring(0, pos);
			String ext = file.substring(pos + 1);
			
			// 머지 임시파일 
			File tempFile = File.createTempFile("~mergeTemp", ".tmp");
			tempFile.deleteOnExit();
			
			FileOutputStream fos = new FileOutputStream(tempFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			
			int number = 0;
			
			// 분할된 파일
			File f = new File(fileName + "_"  + number + ("".equals(ext) ? "" : "." + ext)); 
			
			while (f.exists()) { // 분할된 파일이 있으면
				f.setReadOnly();
				bis = new BufferedInputStream(new FileInputStream(f));
				
				int data = 0;
				while ((data = bis.read()) != -1) {
					bos.write(data); // 임시파일에 분할된 파일 데이터 쓰기
				}
				System.out.println(f.getName() + " 병합");
				bis.close();
				number++;
				// 다음 순번의 분할된 파일
				f = new File(fileName + "_"  + number + ("".equals(ext) ? "" : "." + ext));
			}
			bos.close();
			
			File newFile = new File(newFileName);
//			File oldFile = new File(file);
//			if (oldFile.exists()) {  // 머지할 파일이 존재하면 삭제
//				oldFile.delete();
//			}
			tempFile.renameTo(newFile); // 머지된 임시파일을 머지할 파일명으로 리네임
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		

	}

}
