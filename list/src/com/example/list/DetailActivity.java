package com.example.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		TextView firstNameView = (TextView) findViewById(R.id.detail_first_name);
		TextView lastNameView = (TextView) findViewById(R.id.detail_last_name);
		TextView dobView = (TextView) findViewById(R.id.detail_dob);
		
		Intent startIntent = getIntent();
		
		String first = startIntent.getExtras().getString(MainActivity.EXTRA_FIRST_NAME);
		String last = startIntent.getExtras().getString(MainActivity.EXTRA_LAST_NAME);
		int dob = startIntent.getIntExtra(MainActivity.EXTRA_DOB, -1);
		
		firstNameView.setText(first);
		lastNameView.setText(last);
		
		if (dob != -1){
			dobView.setText(dob+"");
		}else{
			
			Toast.makeText(getApplicationContext(), "Student has no DOB!!!", Toast.LENGTH_LONG).show();
			
			finish();
			
		}
		
		
	}

	

}
