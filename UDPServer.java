package Prashant_Hatekar;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class UDPServer {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		byte buf[] = new byte[1024];
		 //RIP=172.20.149.131, SIP=172.20.149.130 ;
		int cport =1791, sport = 1792;
		DatagramSocket serversocket = new DatagramSocket(cport);
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		Scanner sc = new Scanner(System.in);
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println("Server is Running.... Type 'STOP' to quite");
		while(true){
			serversocket.receive(dp);
			String str = new String(dp.getData(), 0, dp.getLength());
			
			if(str.equals("STOP")){
				System.out.println("Terminated...");
				break;
			}
			System.out.println("Client: " + str);
			String str1 = sc.nextLine();
			buf = str1.getBytes();
			serversocket.send(new DatagramPacket(buf, str1.length(), ip, sport));

	}
}
}
