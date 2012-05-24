package com.globalcoffinenterprise.beurs.server;

import java.net.ServerSocket;
import java.net.Socket;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ServerSocket serverSocket;
		try
		{
			serverSocket = new ServerSocket(5432);
			Database database = new Database();
			
			while(true)
			{
				final Socket clientSocket = serverSocket.accept();
				System.out.println("New Connection: " + clientSocket.getRemoteSocketAddress());
				new Thread(new HandleClient(clientSocket,database)).start();
			}			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
