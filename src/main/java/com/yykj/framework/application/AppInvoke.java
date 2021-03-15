package com.yykj.framework.application;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppInvoke {

	public static void main(String[] args) throws Exception {
		//1.反射操作
		invokeClass();
	}

	/**
	 *1.反射操作
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchFieldException 
	 */
	private static void invokeClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		//反射类信息
		Class<?> cls = Class.forName("com.yykj.framework.bean.Message");
		
		//反射父接口
		Class<?>[] interfaces = cls.getInterfaces();
		for (Class<?> info : interfaces) {
			System.out.println("父接口" + info.getName());
		}
		
		//反射父类
		Class<?> superclass = cls.getSuperclass();
		System.out.println("父类" + superclass.getName());
		
		//反射构造方法
		Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			System.out.println("构造参数：" + constructor.getParameterCount());
		}
		
		//反射方法
		Method[] methods = cls.getMethods();
		for (Method method : methods) {
			System.out.println("方法:" + method.getName());
		}

		//反射构造对象 调用指定方法
		Object instance = cls.getDeclaredConstructor().newInstance();

		Field field = cls.getDeclaredField("info");
		field.setAccessible(true);
		field.set(instance, "invoke value");
		
		//反射调用方法
		Method method = cls.getDeclaredMethod("show", null);
		method.invoke(instance, null);

		Method hello = cls.getMethod("hello", String.class);
		hello.invoke(instance,"kelvin");
	}
}
