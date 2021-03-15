package com.yykj.framework.service;

public class CustomerThread extends Thread{

	private String title = null;
	
	public CustomerThread(String title) {
		super();
		this.title = title;
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(this.title + ":" + i);
		}
	}
}
