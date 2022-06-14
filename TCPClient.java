package CN_Practical;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		Socket s=new Socket(InetAddress.getLocalHost(),1124);
		String msg;
		Scanner sc=new Scanner(System.in);
		System.out.println("Connetcted........");
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		while(true)
		{
			msg=sc.nextLine();
			dos.writeUTF(msg);
			System.out.println(dis.readUTF());
			if(msg.equalsIgnoreCase("stop"))
			{
				s.close();
				break;
			}
		}

	}

}
