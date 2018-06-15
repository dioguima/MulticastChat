import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;


public class ThreadEnvio extends Thread {

	private String nome;
	private Scanner in;
	
	public ThreadEnvio(String nome, Scanner in){
		this.nome = nome;
		this.in = in;
	}
	
	public void run(){
		try {
			InetAddress group = InetAddress.getByName("228.5.6.7");
			MulticastSocket socket = new MulticastSocket(3333);
			socket.joinGroup(group);
			while (true) {
				String msg = in.nextLine();
				msg = nome + " - " + msg;
				DatagramPacket pckt = new DatagramPacket(msg.getBytes(), msg.length(), group, 3333);
				socket.send(pckt);
			}
		} catch (Exception e) {
			System.out.println("Acabou");
		}
		
	}
	
}
