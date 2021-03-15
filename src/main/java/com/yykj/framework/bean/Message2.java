package com.yykj.framework.bean;

import com.yykj.framework.common.IMessage;

public class Message2 implements IMessage {
	
	public Message2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send() {
		System.out.println("Message2:send()");
	}
}
