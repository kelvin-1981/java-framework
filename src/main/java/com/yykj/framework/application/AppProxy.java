package com.yykj.framework.application;

import com.yykj.framework.bean.Message;
import com.yykj.framework.common.IMessage;
import com.yykj.framework.service.LowerProxy;
import com.yykj.framework.service.ProxyDynamic;

public class AppProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.原始代理方式
		//lowerProxy();
		
		//2.动态代理方式
		DynamicProxy();
	}

	/**
	 * 动态代理方式
	 */
	private static void DynamicProxy() {
		// TODO Auto-generated method stub
		ProxyDynamic proxyDynamic = new ProxyDynamic();
		IMessage message = (IMessage) proxyDynamic.bind(new Message());
		message.send();
	}

	/**
	 * 原始代理
	 */
	private static void lowerProxy() {
		IMessage proxy = new LowerProxy(new Message());
		proxy.send();
	}
}
