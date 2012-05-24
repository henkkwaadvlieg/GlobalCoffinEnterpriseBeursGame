package com.globalcoffinenterprise.beurs;

import java.io.ObjectOutputStream;
import java.net.Socket;

import com.globalcoffinenterprise.beurs.objects.Transfer;
public class Register implements Runnable 
{
	public void run() 
	{
		try
		{
			Socket s = new Socket("bakkerstad.dyndns.biz",5432);
			Transfer t = new Transfer(Transfer.Type.Registration,"Testing");
			ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
			os.writeObject(t);
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		
	}
}
