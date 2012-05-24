package com.beursSpel;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class BuyStocksActivity extends BaseActivity
{
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("Hier start je een nieuw bedrijf!!!");
		setContentView(tv);
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if (keyCode == KeyEvent.KEYCODE_BACK) 
	    {
	        moveTaskToBack(true);
	        this.finish();
	         Intent intent = new Intent(getApplicationContext(), CompaniesActivity.class);
	         this.startActivity(intent);
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}

}
