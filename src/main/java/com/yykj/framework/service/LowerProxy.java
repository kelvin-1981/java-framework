package com.yykj.framework.service;


import com.yykj.framework.common.IMessage;

/**
 * 
 * @author YYKJ
 *
 */
public class LowerProxy implements IMessage {

	private IMessage message = null;

	/**
	 * 
	 * @param message
	 */
	public LowerProxy(IMessage message) {
		super();
		this.message = message;
	}

	@Override
	public void send() {
		
		connection();
		
		this.message.send();
		
		close();
	}

	private void close() {
		// TODO Auto-generated method stub
		System.out.println("LowerProxy:close()");
	}



	private void connection() {
		// TODO Auto-generated method stub
		System.out.println("LowerProxy:connection()");
	}
}
