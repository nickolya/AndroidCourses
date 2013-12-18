package com.example.lifecycle;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity1 extends Activity {
	
	public static final String LOG_TAG = MainActivity1.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(LOG_TAG, "onCreate");
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
		return new ArrayList<String>();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(LOG_TAG, "onStart");
	}
	
	@Override
	protected void onResume() {
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

	

}
