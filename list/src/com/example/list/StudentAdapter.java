package com.example.list;

import java.util.ArrayList;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class StudentAdapter extends BaseAdapter {

	private ArrayList<Student> data;
	private Context context;

	public StudentAdapter(ArrayList<Student> data, Context context) {
		this.data = data;
		this.context = context;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {

			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_item, parent, false);
			
			
			TextView text = (TextView) convertView.findViewById(R.id.text_item);
			
			ImageView image = (ImageView) convertView.findViewById(R.id.image_item);
			
			ViewHolder vh = new ViewHolder(text, image);
			
			convertView.setTag(vh);
			
		}

		
		ViewHolder vh = (ViewHolder) convertView.getTag();
		
		vh.text.setText(data.get(position).toString());
		vh.image.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher));
		
		

		return convertView;
	}
	
	private class ViewHolder{
		public final TextView text;
		public final ImageView image;
		
		public ViewHolder (TextView text, ImageView image){
			this.text = text;
			this.image = image;
		}
		
		
	}
}
