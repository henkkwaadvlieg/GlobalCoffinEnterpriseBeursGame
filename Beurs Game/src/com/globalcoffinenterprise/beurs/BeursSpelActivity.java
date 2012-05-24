package com.beursSpel;

import android.os.Bundle;
import android.view.KeyEvent;

public class BeursSpelActivity extends BaseActivity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    
    @Override
   	public boolean onKeyDown(int keyCode, KeyEvent event) 
   	{
       	if (keyCode == KeyEvent.KEYCODE_BACK) 
     	    {
       		this.finish();
       		destroy();
     	    }
       	return super.onKeyDown(keyCode, event);
   	}
    
    
    /**
     * Kills app
     */
    public static void destroy()
    {
    	//android.os.Process.killProcess(android.os.Process.myPid());
    	System.runFinalizersOnExit(true);
    	System.exit(0);
    }
}