package core.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UpdClient
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",34532);
		InetSocketAddress des = new InetSocketAddress("127.0.0.1",12345);
		DatagramSocket socket = new DatagramSocket(address);
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine();
			if(line.equals("exit"))
				break;
			byte[] buffer = line.getBytes("utf-8");
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length,des);
			socket.send(packet);
		}
		
		socket.close();

	}
	

}
