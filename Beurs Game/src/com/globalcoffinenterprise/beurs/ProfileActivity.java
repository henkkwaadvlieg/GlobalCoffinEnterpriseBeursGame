package com.globalcoffinenterprise.beurs;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends BaseActivity
{
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("Het Werkt!!!");
		setContentView(tv);
    }

}
