package com.globalcoffinenterprise.beurs;
import java.net.URL;

import org.json.JSONObject;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class facebookActivity extends Activity implements DialogListener
{
	private Facebook facebook;
	private SharedPreferences mPrefs;
	private ImageView user_picture;
	private Handler handler;;
	private Bitmap bmpDownload;
	
	public facebookActivity()
	{
		this.facebook = new Facebook("367455903312223");
		this.handler = new Handler();
	}
	
	@Override
	public void onStart()
	{
		super.onStart();
		user_picture=(ImageView)findViewById(R.id.imgprofilepic);
		final TextView textView = (TextView) findViewById(R.id.txtstatus);
		if(textView != null)
		{
			if(facebook.isSessionValid())
			{
				 textView.setText("status : " + mPrefs.getString("email", "helaas"));
			}
			else
			{
				  textView.setText("status : y n good");
			}	  
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	  super.onCreate(savedInstanceState);
    	  
          setContentView(R.layout.facebook);
          /*
           * Get existing access_token if any
           */

          mPrefs = getPreferences(MODE_PRIVATE);
          String access_token = mPrefs.getString("access_token", null);
          long expires = mPrefs.getLong("access_expires", 0);
          if(access_token != null) {
              facebook.setAccessToken(access_token);
          }
          if(expires != 0) {
              facebook.setAccessExpires(expires);
          }
          
          /*
           * Only call authorize if the access_token has expired.
           */
          if(!facebook.isSessionValid() || mPrefs.getString("email", null) == null || mPrefs.getString("id", null) == null || bmpDownload == null)
          {
              facebook.authorize(this, new String[] { "read_stream", "email" }, this);
          } 
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
        super.onActivityResult(requestCode, resultCode, data);
        facebook.authorizeCallback(requestCode, resultCode, data);
    }

	public void onComplete(Bundle values) {
		  SharedPreferences.Editor editor = mPrefs.edit();
          editor.putString("access_token", facebook.getAccessToken());
          editor.putLong("access_expires", facebook.getAccessExpires());	
          editor.commit();  
          new Thread(new download()).start();
	}

	public void onFacebookError(FacebookError e) {
		// TODO Auto-generated method stub
		
	}

	public void onError(DialogError e) {
		// TODO Auto-generated method stub
		
	}

	public void onCancel() {
		// TODO Auto-generated method stub
		
	}
	
	public class download implements Runnable
	{
		
		public void run() 
		{
			SharedPreferences.Editor editor = mPrefs.edit();
	        try
	        {
				String response=facebook.request("me");
				JSONObject obj = Util.parseJson(response);
				editor.putString("email", obj.getString("email")); 
				editor.putString("id", obj.getString("id")); 
				URL img_value = null;
				img_value = new URL("http://graph.facebook.com/"+mPrefs.getString("id", "19292868552")+"/picture");
				bmpDownload = BitmapFactory.decodeStream(img_value.openConnection().getInputStream());
	        }
	        catch(Exception ex)
	        {
	      	  Log.d("json", ex.toString());
	          editor.putString("access_token", null);
	          editor.putLong("access_expires", 0);
	        }        
	        editor.commit();	
	        
	        handler.post(new Runnable() {
				public void run() {
					if(bmpDownload != null)
					{
						user_picture.setImageBitmap(bmpDownload);
					}
					else
					{
						new Thread(new download()).start();
					}
				}
			});
		}
		
	}

}
