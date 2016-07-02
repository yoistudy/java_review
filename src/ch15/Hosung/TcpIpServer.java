package ch15.Hosung;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		
		try {
			//서버소켓을 생성하여 7777번 포트와 결합시킨다. 
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		while(true){
			try {
				System.out.println(getTime()+"연결요청을 기다립니다.");
				//서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
				//클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				serverSocket.setSoTimeout(5*1000);//요청 대기시간을 5초로설정 접속요청이 없으면 SocketTimeoutException발
				Socket socket = serverSocket.accept();
				System.out.println(getTime()+socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
				
				System.out.println("getPort():"+socket.getPort());//상대편이 사용하는 포트 
				System.out.println("geLocalPort():"+socket.getLocalPort());//자신이 사용하는 포트 
				
				//소켓의 출력스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//원격 소켓(remote socket)에 데이터를 보낸다.
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime()+"데이터를 전송했습니다.");
				
				dos.close();
				socket.close();
			}catch(SocketTimeoutException e){
				System.out.println("지정된 시간동안 접속요청이 없어서 서버를 종료합니다.");
				System.exit(0);
			}catch (IOException e) {
				e.printStackTrace();// TODO: handle exception
			}
		}
		
	}
	
	//현재시간을 문자열로 반환하는 함수.
	static String getTime(){
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
		}

}
