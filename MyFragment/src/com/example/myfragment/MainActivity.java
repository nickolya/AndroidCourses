package com.example.myfragment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;

public class MainActivity extends SherlockFragmentActivity {

	private static final String SECONT_FRAMENT = "secont_frament";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				getSupportFragmentManager().beginTransaction().replace(R.id.container, new MySecondFragment(), SECONT_FRAMENT).commit();
				
			}
		});
	}

	
	
	
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	
	getSupportMenuInflater().inflate(R.menu.main, menu);
	
	return false;
}

@Override
public Object onRetainCustomNonConfigurationInstance() {
	// TODO Auto-generated method stub
	return super.onRetainCustomNonConfigurationInstance();
}	

}
