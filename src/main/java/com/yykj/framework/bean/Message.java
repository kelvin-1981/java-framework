package com.yykj.framework.bean;

import com.yykj.framework.common.IMessage;

public class Message implements IMessage {

	private String info;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Message() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send() {
		System.out.println("Message:send()");
	}
	
	public void show(){
		System.out.println("Message:show()" + " " + info);
	}

	public void hello(String name){
		System.out.println("Hello " + name + " !");
	}
}
