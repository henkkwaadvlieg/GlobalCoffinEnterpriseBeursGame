package com.globalcoffinenterprise.beurs;

import android.os.Bundle;
import android.view.View;

public class TutorialActivity extends BaseActivity 
{
	
	public void onCreate(Bundle savedInstanceState) 
    {
    	  super.onCreate(savedInstanceState);
          setContentView(R.layout.tutorial); 
    }
	
	public void uitleg1(View view)
	{
		setContentView(R.layout.tutorial); 
		
	}
	

	public void uitleg2(View view)
	{
		setContentView(R.layout.tutorial2); 
	}
	
	public void uitleg3(View view)
	{
		setContentView(R.layout.tutorial3); 
	}

}
