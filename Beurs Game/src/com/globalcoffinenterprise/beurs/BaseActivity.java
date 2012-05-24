package com.beursSpel;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;

public class BaseActivity extends Activity implements OnClickListener, OnKeyListener
{
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	  super.onCreate(savedInstanceState);
    	  super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    
	/**
	 * Opent het profiel van het speler
	 * @param view
	 */
	public void openProfile(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
		this.startActivity(intent);
	}
	/**
	 * opent menu Companies
	 * @param view
	 */
	
	public void openCompanies(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), CompaniesActivity.class);
		this.startActivity(intent);
	}
	/**
	 * opent de bank
	 * @param view
	 */
	public void openBank(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), BankActivity.class);
		this.startActivity(intent);
	}
	/**
	 * Opent het tutoriol
	 * @param view
	 */
	public void openTutoriol(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
		this.startActivity(intent);
	}
	/**
	 * Stopt het spel. app word afgesloten.
	 * @param view
	 */
	public void quit(View view)
	{
		BeursSpelActivity.destroy();
	}
	
	/**
	 * Gaat terug naar het hoofdmenu
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if (keyCode == KeyEvent.KEYCODE_BACK) 
	    {
	        moveTaskToBack(true);
	        this.finish();
	         Intent intent = new Intent(getApplicationContext(), BeursSpelActivity.class);
	         this.startActivity(intent);
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}

	public boolean onKey(View v, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
