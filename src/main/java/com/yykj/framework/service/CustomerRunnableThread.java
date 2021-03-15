package com.yykj.framework.service;

public class CustomerRunnableThread implements Runnable {

	private String title = null;

	public CustomerRunnableThread(String title) {
		super();
		this.title = title;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.title + ":" + i);
		}
	}
}
