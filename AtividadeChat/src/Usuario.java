import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Usuario {

	public static void main(String[] args) throws Exception {
		ThreadRecebimento recebimento;
		ThreadEnvio envio;
		Scanner in;
		
		in = new Scanner(System.in);
		System.out.print("Seu nome: ");
		String nome = in.nextLine();
		
		envio = new ThreadEnvio(nome, in);
		recebimento = new ThreadRecebimento();
		
		envio.start();
		recebimento.start();
		
		System.out.println("Bem vindo ao chat !!!");
		recebimento.join();
		envio.join();
	}
	

}
