package com.example.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	public static final String LOG_TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i(LOG_TAG, "onCreate");

		if (savedInstanceState != null) {
			String log = savedInstanceState.getString(LOG_TAG);
			Log.i(LOG_TAG, log);
		}

		Object obj = getLastNonConfigurationInstance();
		if (obj != null) {
			String text = (String) obj;
			Log.i(LOG_TAG, text);
		}
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);

		outState.putString(LOG_TAG, getString(R.string.app_name));
		Log.i(LOG_TAG, "onSaveInstanceState");
	}

	@Override
	@Deprecated
	public Object onRetainNonConfigurationInstance() {
		// TODO Auto-generated method stub
		Log.i(LOG_TAG, "onRetainNonConfigurationInstance");
		return "obj from onRetainNonConfigurationInstance";
	}

	@Override
	protected void onStart() {
		getLastNonConfigurationInstance();
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(LOG_TAG, "onStart");
	}

	@Override
	protected void onResume() {
		getLastNonConfigurationInstance();
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(LOG_TAG, "onResume");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(LOG_TAG, "onRestart");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(LOG_TAG, "onPause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(LOG_TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(LOG_TAG, "onDestroy");
	}

	public void onButtonClicked(View v) {
		
		Intent intent = new Intent(this, MainActivity1.class);
		//intent.setFlags(Intent.FLAG_*);

		startActivity(new Intent(this, MainActivity1.class));

	}

}
