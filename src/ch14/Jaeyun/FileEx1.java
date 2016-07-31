package ch14.Jaeyun;

import java.io.File;

public class FileEx1 {

	public static void main(String[] args) {
		File f = new File("~/abc/.config.cson");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("경로를 제외한 파일 이름 - " + fileName);
		System.out.println("확장자를 제외한 파일 이름 - " + fileName.substring(0, pos));
		System.out.println("확장자 - " + fileName.substring(pos + 1));
		
		System.out.println("경로를 포함한 파일이름 - " + f.getPath());
		System.out.println("파일의 절대경로 - " + f.getAbsolutePath());
		System.out.println("파일이 속해있는 디렉토리 - " + f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator - " + File.pathSeparator);
		System.out.println("File.separator - " + File.separator);
		System.out.println();
		System.out.println("user.dir - " + System.getProperty("user.dir")); // user.dir 속성은 현재 프로그램이 실행중인 디렉토리
		System.out.println("sun.boot.class.path - " + System.getProperty("sun.boot.class.path")); // 시스템의 기본적인 classpath 속성
		
	}

}
