package com.globalcoffinenterprise.beurs;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BankActivity extends BaseActivity
{
	/*
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("Het Werkt!!!");
		setContentView(tv);
    }
	
	*/
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.bank);

	    Spinner spinner = (Spinner) findViewById(R.id.spinner2);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this, R.array.lijstBedrage, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	}

}
