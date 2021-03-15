package com.yykj.framework.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDynamic implements InvocationHandler{
	
	private Object target = null;
	
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
	}
	
	private void connect(){
		System.out.println("connect...");
	}
	
	private void close(){
		System.out.println("close...");
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	
		if(method.getName() != "send")
			return null;
		
		Object result = null;
		
		this.connect();
		result = method.invoke(this.target, args);
		this.close();
		
		return result;
	}
}
