import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;


public class ThreadRecebimento extends Thread{

	public void run(){
		try {
			InetAddress group = InetAddress.getByName("228.5.6.7");
			MulticastSocket socket = new MulticastSocket(3333);
			socket.joinGroup(group);
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket pckt = new DatagramPacket(buf, buf.length, group, 3333);
				socket.receive(pckt);
				String str = new String(pckt.getData(), 0, pckt.getLength());
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println("Acabou");
		}
		
	}
	
}
