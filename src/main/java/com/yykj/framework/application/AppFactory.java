package com.yykj.framework.application;

import com.yykj.framework.bean.Message;
import com.yykj.framework.bean.Message2;
import com.yykj.framework.common.IMessage;
import com.yykj.framework.service.FactoryInvoke;
import com.yykj.framework.service.FactoryLower;
import com.yykj.framework.service.FactoryMiddle;
import com.yykj.framework.service.HouseService;

public class AppFactory {

	public static void main(String[] args) {
		
		//原始工厂模式
		//lowerFactory();
		
		//泛型工厂模式
		//middleFactory();
		
		//反射工厂
		invocationFactory();
	}

	/**
	 * 反射工厂
	 */
	private static void invocationFactory() {
		// TODO Auto-generated method stub
		IMessage message = FactoryInvoke.getInstance("com.yykj.framework.bean.Message");
		message.send();
	}

	/**
	 * 泛型工厂模式
	 */
	private static void middleFactory() {
		// TODO Auto-generated method stub
		Message instance = FactoryMiddle.GetInstance("message", Message.class);
		instance.send();
		
		HouseService instance2 = FactoryMiddle.GetInstance("service", HouseService.class);
		instance2.service();
	}

	/**
	 * 原始工厂模式
	 */
	public static void lowerFactory() {
		
		Message msg_1 = (Message) FactoryLower.getInstance("Message");
		msg_1.send();
		
		Message2 msg_2 = (Message2) FactoryLower.getInstance("Message2");
		msg_2.send();
	}
}
