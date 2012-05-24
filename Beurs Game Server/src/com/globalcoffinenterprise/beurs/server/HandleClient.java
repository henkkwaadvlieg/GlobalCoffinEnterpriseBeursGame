package com.globalcoffinenterprise.beurs.server;

import java.io.ObjectInputStream;
import java.net.Socket;

import com.globalcoffinenterprise.beurs.objects.Transfer;

public class HandleClient implements Runnable
{
	private Socket clientSocket;
	private Database database;
	
	public HandleClient(Socket clientSocket,Database database)
	{
		this.clientSocket = clientSocket;
		this.database = database;
	}

	@Override
	public void run() 
	{
		try
		{
			ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
			
			Object o = ois.readObject();
			Transfer transfer;
			if(o != null)
			{
				transfer = (Transfer)o;
				if(transfer != null)
				{
					database.add(transfer.getData());
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}	
	}

}
