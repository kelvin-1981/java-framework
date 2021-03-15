package com.yykj.framework.service;

import com.yykj.framework.bean.Message;

public class FactoryMiddle <T> {

	@SuppressWarnings("unchecked")
	public static <T> T GetInstance(String className,Class<T> clazz){
		
		if(className.equalsIgnoreCase("message")){
			return (T) new Message();
		}
		else if(className.equalsIgnoreCase("service")){
			return (T) new HouseService();
		}
		else{
			return null;
		}
	}
}
