package com.example.list;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.library.Generator;
import com.example.library.Student;

public class MainActivity extends SherlockActivity {

	public static final String EXTRA_FIRST_NAME = "first_name";
	public static final String EXTRA_LAST_NAME = "last_name";
	public static final String EXTRA_DOB = "dob";

	//private AbsListView list;
	private BaseAdapter adapter;

	private Spinner spinner;

	private ArrayList<Student> students;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		students = Generator.generate();
		adapter = new StudentAdapter(students, getApplicationContext());
		
		OnItemClickListener listener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(MainActivity.this,
						DetailActivity.class);

				Student student = (Student) adapter.getItem(position);

				intent.putExtra(EXTRA_FIRST_NAME, student.firstName);
				intent.putExtra(EXTRA_LAST_NAME, student.lastName);
				intent.putExtra(EXTRA_DOB, student.dob);

				startActivity(intent);
				
				startActivityForResult(intent, 111);

			}
		};
		
		
		
		//list = (AbsListView) findViewById(R.id.list);
		
		View list = findViewById(R.id.list);
		
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
			
			if (list instanceof ListView){
				ListView l1 = (ListView) list; 
				l1.setAdapter(adapter);
				l1.setOnItemClickListener(listener);
			}else if (list instanceof GridView){
				
				GridView g1 = (GridView) list;
				g1.setAdapter(adapter);
				g1.setOnItemClickListener(listener);
			}

		} else {

			AbsListView al1 = (AbsListView)list;

			al1.setAdapter(adapter);
			al1.setOnItemClickListener(listener);
		}
		
		
		

		//list.setOnItemClickListener();

		String[] titles = getResources().getStringArray(R.array.titles);

		spinner = (Spinner) findViewById(R.id.sort);

		SpinnerAdapter spinnerAdapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				titles);

		spinner.setAdapter(spinnerAdapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(),
						"Sort by " + ((position == 0) ? "name" : "age"),
						Toast.LENGTH_LONG).show();

				adapter.notifyDataSetChanged();

				adapter.notifyDataSetInvalidated();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		//super.onRestoreInstanceState(savedInstanceState);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		
		//getMenuInflater()
		
		getSupportMenuInflater().inflate(R.menu.main, menu);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		return true;
	}
}
