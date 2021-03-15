package com.yykj.framework.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MessageProxy implements InvocationHandler {
	
	private Object target = null;
	
	public Object bind(Object obj){
		this.target = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	public MessageProxy() {
	
	}
	
	private boolean connection(){
		System.out.println("MessageProxy.connection()");
		return true;
	}
	
	private boolean close(){
		System.out.println("MessageProxy.close()");
		return true;
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("MessageProxy:invoke()");
		
		Object result = null;
		if(this.connection()){
			result = method.invoke(this.target,args);
			this.close();
		}
		
		return result;
	}
}
