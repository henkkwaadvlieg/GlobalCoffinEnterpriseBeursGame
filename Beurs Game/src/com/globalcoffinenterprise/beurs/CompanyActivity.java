package com.globalcoffinenterprise.beurs;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class CompanyActivity extends BaseActivity
{
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	  super.onCreate(savedInstanceState);
    	  super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
	
	
	public void openResults(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
		this.startActivity(intent);
	}
	
	public void openBoD(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), BoDActivity.class);
		this.startActivity(intent);
	}
	
	public void openInvestments(View view)
	{
		this.finish();
		Intent intent = new Intent(getApplicationContext(), InvestmentsActivity.class);
		this.startActivity(intent);
	}
	
	public void backCompanies(View view)
	{
		setContentView(R.layout.companies);
	}

}
