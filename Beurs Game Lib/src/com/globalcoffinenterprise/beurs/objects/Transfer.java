package com.globalcoffinenterprise.beurs.objects;

import java.io.Serializable;

public class Transfer implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum Type{Registration}
	
	private Type type;
	private String data;
	
	public Transfer(Type type, String data)
	{
		this.type = type;
		this.data = data;
	}

	public Type getType() {
		return type;
	}

	public String getData() {
		return data;
	}
}
