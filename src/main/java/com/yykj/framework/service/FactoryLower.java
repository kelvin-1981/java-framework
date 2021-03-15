package com.yykj.framework.service;

import com.yykj.framework.bean.Message;
import com.yykj.framework.bean.Message2;
import com.yykj.framework.common.IMessage;

public class FactoryLower {

	/**
	 * 工厂方法
	 * @param className
	 * @return
	 */
	public static IMessage getInstance(String className){
		if(className.equals("Message")){
			return new Message();
		}
		else if(className.equals("Message2")){
			return new Message2();
		}
		else{
			return null;
		}
	}
}
