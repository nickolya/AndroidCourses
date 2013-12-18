package com.example.optionmenu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{
	
	private MenuItem item ;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(true);
		
		
		findViewById(R.id.btn).setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		
		item = menu.findItem(R.id.action4);
		
	//	item.setActionView(R.layout.menu_layout);
		
		
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		
		case android.R.id.home:

			Log.i("Menu", "HOME item was clicked");

			return false;

		
		
		case R.id.action1:

			Log.i("Menu", "Action 1 item was clicked");

			return false;

		case R.id.action2:
			Log.i("Menu", "Action 2 item was clicked");
			return true;
		case R.id.action3:
			Log.i("Menu", "Action 3 item was clicked");
			return true;
		case R.id.action4:
			Log.i("Menu", "Action 4 item was clicked");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	@Override
	public void onClick(View v) {
		item.setActionView(null);
		
	}

}
