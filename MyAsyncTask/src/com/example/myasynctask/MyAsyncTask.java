package com.example.myasynctask;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {
	
	
	@Override
	protected void onPreExecute() {
		Log.i("MyAsyncTask", "#onPreExecute");
	}
	

	@Override
	protected Bitmap doInBackground(String... params) {
		Log.i("MyAsyncTask", "#doInBackground");
		
		try {
			Thread.sleep(20000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		Log.i("MyAsyncTask", "#onPostExecute");
	}

}
