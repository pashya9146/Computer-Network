package CN_Practical;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		Socket s;
		Scanner sc=new Scanner(System.in);
		String msg;
		ServerSocket ss=new ServerSocket(1124);
		System.out.println("Waiting for Client..");
		s=ss.accept();
		System.out.println("Connected..");
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		while(true)
		{
			String str=dis.readUTF();
			if(str.equalsIgnoreCase("stop"))
			{
				System.out.println(str);
				s.close();
				break;
			}
			System.out.println(str);
			msg=sc.nextLine();
			dos.writeUTF(msg);
			}
		}
		
	}
