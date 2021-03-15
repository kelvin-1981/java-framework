package com.yykj.framework.application;

import com.yykj.framework.service.Singleton;
import com.yykj.framework.service.Singleton2;

/**
 * 单例模式
 * @author YYKJ
 *
 */
public class AppSingleton {

	public static void main(String[] args) {
		
		// 1.懒汉式单例模式
		Singleton instance = Singleton.getInstance();
		instance.show();
		
		//2.饿汉式单例模式
		Singleton2 instance2 = Singleton2.getInstance();
		instance2.show();
	}

}
