package mp;

import java.net.*;
import java.io.IOException;

public class Client implements Runnable{
	DatagramSocket ds;
	int phs[];
	int phsp;
	public Client(String ip,int port) throws IOException{
		ds = new DatagramSocket(port);
		Thread t = new Thread(new CListener(this));
		t.start();
		phs = new int[32];
		phsp=0;
	}
	public void run(){
		
	}
}
