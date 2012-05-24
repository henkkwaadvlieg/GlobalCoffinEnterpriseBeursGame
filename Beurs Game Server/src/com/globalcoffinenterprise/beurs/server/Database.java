package com.globalcoffinenterprise.beurs.server;

import java.util.LinkedList;

public class Database
{
	public LinkedList<String> lijst;
	
	public Database()
	{
		lijst = new LinkedList<String>();
	}
	
	public void add(String s)
	{
		System.out.println(s);
		lijst.add(s);
	}
}
