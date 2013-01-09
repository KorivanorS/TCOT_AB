package mp;

import java.net.*;
import java.util.Random;

public class NetF {
	static Random r = new Random();
	public static void rhs(DatagramPacket dp){
		byte data[]=dp.getData();
		data[1]=(byte) r.nextInt();
		data[2]=(byte) r.nextInt();
		dp.setData(data);
	}
}
