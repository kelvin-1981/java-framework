package com.yykj.framework.service;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射工厂
 * @author YYKJ
 *
 */
public class FactoryInvoke {

	private FactoryInvoke() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param className
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className){
		
		T instance = null;
		
		try {
			instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return instance;
	}
	
}
