package net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import util.Utility;

public class Server extends Thread
{

	ServerSocket server = null;
	Socket sk = null;
	BufferedReader rdr = null;
	PrintWriter wtr = null;

	public Server()
	{
		try
		{
			server = new ServerSocket(1987);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void run()
	{

		while (true)
		{
			System.out.println("Listenning...");
			try
			{
				// 每个请求交给一个线程去处理
				sk = server.accept();
				ServerThread th = new ServerThread(sk);
				th.start();
				sleep(1000);
			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args)
	{
		new Server().start();
	}

	class ServerThread extends Thread
	{

		Socket sk = null;

		public ServerThread(Socket sk)
		{
			this.sk = sk;
		}

		public void run()
		{

			try
			{
				wtr = new PrintWriter(sk.getOutputStream());
				rdr = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				while (true)
				{
					System.out.println("##");
					String line = Utility.readFromIns(sk.getInputStream());
					System.out.println("从客户端来的信息：" + line);
					// 特别，下面这句得加上 “\n”,
					wtr.println("你好，服务器已经收到您的信息！'" + line);
					wtr.flush();
					System.out.println("已经返回给客户端！");
				}
			} catch (IOException e)
			{
				e.printStackTrace();
				
			}
		}

	}

}
