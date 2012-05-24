package com.beursSpel;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class CompaniesActivity extends BaseActivity
{
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
		super.onCreate(savedInstanceState);
		super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.companies);
    }
	
	
	public void newCompany(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), StartNewCompanieActivity.class);
		this.startActivity(intent);
	}
	
	public void buyStocks(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), BuyStocksActivity.class);
		this.startActivity(intent);
	}
	
	

}
