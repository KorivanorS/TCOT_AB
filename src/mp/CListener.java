package mp;

import java.io.IOException;
import java.net.*;

public class CListener implements Runnable{
	Client c;
	DatagramPacket inp;
	DatagramPacket outp;
	byte inpd[];
	byte outpd[];
	public CListener(Client c){
		this.c=c;
		inpd=new byte[1024];
		inp=new DatagramPacket(inpd, inpd.length);
		outpd=new byte[1024];
		outp=new DatagramPacket(outpd, outpd.length);
	}
	public void run(){
		while(true){
			try {
				c.ds.receive(inp);
				byte data[] = inp.getData();
				c.phs[c.phsp++]=data[1]*256+data[2];
				if(data[0]==1){
					outpd[0]=1;
					NetF.rhs(outp);
					c.ds.send(outp);
				}
			} catch (IOException e) {e.printStackTrace();}
		}
	}
}
