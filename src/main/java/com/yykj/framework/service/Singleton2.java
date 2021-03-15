package com.yykj.framework.service;

/**
 * 饿汉式单例模式
 * @author YYKJ
 *
 */
public class Singleton2 {

	final private static Singleton2 instanse = new Singleton2();
	
	public Singleton2() {}
	
	public static Singleton2 getInstance(){
		return instanse;
	}
	
	public void show() {
		System.out.println("Singleton2:show()");
	}

}
