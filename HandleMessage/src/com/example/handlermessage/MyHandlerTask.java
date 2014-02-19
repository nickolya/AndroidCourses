package com.example.handlermessage;

import android.os.Handler;
import android.os.Message;

public class MyHandlerTask implements HandlerTask {
	
	public static final int BACKGROUND_TASK_DONE = Integer.MAX_VALUE;
	public static final int PUBLISH_PROGRESS = Integer.MIN_VALUE;
	
	
	private OnHandlerTaskListener mListener;

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case BACKGROUND_TASK_DONE:

				mListener.onBackgroundTaskCompleted(msg.obj);
				break;

			case PUBLISH_PROGRESS:
				
				mListener.onPublishProgress(msg.arg1);
				break;

			default:
				super.handleMessage(msg);
				break;
			}

		}

	};

	@Override
	public void start() {
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// do something and store results in obj
				Object obj = new Object();
		
				
				mHandler.obtainMessage(BACKGROUND_TASK_DONE, obj).sendToTarget();
				
				pubProgress(100);
				
				
			}
			
		}).start();
		

	}

	@Override
	public void setLestener(OnHandlerTaskListener l) {
		mListener = l;
		
	}
	
	public void pubProgress(int progress){
		
		mHandler.removeMessages(PUBLISH_PROGRESS);
		mHandler.obtainMessage(PUBLISH_PROGRESS, progress, 0).sendToTarget();
		
	}

}
