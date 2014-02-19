package com.example.handlermessage;

public interface OnHandlerTaskListener {
	
	public void onBackgroundTaskCompleted(Object obj);
	public void onPublishProgress(int progress);

}
