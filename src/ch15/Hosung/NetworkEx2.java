package ch15.Hosung;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL("http://www.javachobo.com:80/sample/"
				+"hello.html?refer=javachobo#index1");
		
		System.out.println("url.getAuthority():"+url.getAuthority());
//		System.out.println("url.getContent():"+url.getContent());
		System.out.println("url.getDefaultPort():"+url.getDefaultPort());
		System.out.println("url.getPort():"+url.getPort());
		System.out.println("url.getFile():"+url.getFile());
		System.out.println("url.getHost():"+url.getHost());
		System.out.println("url.getPath():"+url.getPath());
		System.out.println("url.getProtocol():"+url.getProtocol());
		System.out.println("url.getQuery():"+url.getQuery());
		System.out.println("url.getRef():"+url.getRef());
		System.out.println("url.getUserInfo():"+url.getUserInfo());
		System.out.println("url.toExternalForm():"+url.toExternalForm());
		System.out.println("url.toURI():"+url.toURI());
	}

}
