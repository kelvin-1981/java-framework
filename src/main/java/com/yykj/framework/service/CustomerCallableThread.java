package com.yykj.framework.service;

import java.util.concurrent.Callable;

public class CustomerCallableThread implements Callable<String> {

	private String title;
	
	public CustomerCallableThread(String title) {
		super();
		this.title = title;
	}

	@Override
	public String call() throws Exception {
		for(int i = 0; i < 10; i++){
			System.out.println(title + ":" + i);
		}
		return title + " finsish !!!";
	}

	
}
