package com.globalcoffinenterprise.beurs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class beursActivity extends Activity 
{
    /** Called when the activity is first created. */
	
	@Override
	public void onStart()
	{
		super.onStart();
		 this.startActivity( new Intent(this, facebookActivity.class) );
		 this.finish();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}