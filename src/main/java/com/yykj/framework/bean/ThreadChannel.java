package com.yykj.framework.bean;

public class ThreadChannel {

	final private static ThreadLocal<Message>  threadLocal = new ThreadLocal<Message>();
	
	private ThreadChannel(){
		
	}
	
	public static void setMessage(Message m){
		threadLocal.set(m);
	}
	
	public static void show(){
		System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get().getInfo());
	}
}
