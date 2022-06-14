package Prashant_Hatekar;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		byte buf[] = new byte[1024];
		int cport =1791, sport = 1792;
		DatagramSocket clientsocket = new DatagramSocket(cport);
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		Scanner sc = new Scanner(System.in);
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println("Client is Running.... Type 'STOP' to quite");
		while(true){
			String str = sc.nextLine();
			buf = str.getBytes();
			if(str.equalsIgnoreCase("STOP")){
				System.out.println("Terminated...");
				clientsocket.send(new DatagramPacket(buf, str.length(), ip,sport));
				break;
			}
			clientsocket.send(new DatagramPacket(buf, str.length(), ip, sport));
			clientsocket.receive(dp);
			String str2 = new String(dp.getData(), 0, dp.getLength());
			System.out.println("MSG from Server: "+ str2);
	}
}}
