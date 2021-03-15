package com.yykj.framework.service;

/**
 * 懒汉式单例模式（第一次使用时实例化）
 * @author YYKJ
 *
 */
public class Singleton {
	
	private static Singleton instance = null;

	private Singleton() {}
	
	/**
	 * 单例模式
	 * @return
	 */
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		
		return instance;
	}
	
	/**
	 * 输出
	 */
	public void show(){
		System.out.println("Singleton:show()");
	}
	

}
