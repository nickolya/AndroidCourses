package com.example.handlermessage;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity implements OnHandlerTaskListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		((HandlerTask) new MyHandlerTask()).start();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackgroundTaskCompleted(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPublishProgress(int progress) {
		// TODO Auto-generated method stub
		
	}

}
