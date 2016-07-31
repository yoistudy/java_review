package ch14.Jaeyun;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class PipedReaderWriter {

	public static void main(String[] args) {
		InputThread inThread = new InputThread("InputThread");
		OutPutThread outThread = new OutPutThread("OutputThread");
		
		// PipedRead와 PipedWriter를 연결
		inThread.connect(outThread.getOutput());
		
		inThread.start();
		outThread.start();
	}
	

}

class InputThread extends Thread {
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();
	
	public InputThread(String name) {
		super(name);
	}
	
	public void run() {
		int data = 0;
		try {
			while ((data = input.read()) != -1) {
				sw.write(data);
			}
			System.err.println(getName() + " recieved : "  + sw.toString());
		} catch (IOException e) {}
	}
	
	public PipedReader getInput() {
		return input;
	}
	
	public void connect(PipedWriter output) {
		try {
			input.connect(output);
		} catch (IOException e) {}
	}
	
}

class OutPutThread extends Thread {
	PipedWriter output = new PipedWriter();
	
	public OutPutThread(String name) {
		super(name);
	}
	
	public void run() {
		try {
			String msg = "hello";
			System.out.println(getName() + " sent : " + msg);
			output.write(msg);
			output.close();
		} catch (IOException e) {}
	}
	
	public PipedWriter getOutput() {
		return output;
	}
	
	public void connect(PipedReader input) {
		try {
			output.connect(input);
		} catch (IOException e) {}
	}
}