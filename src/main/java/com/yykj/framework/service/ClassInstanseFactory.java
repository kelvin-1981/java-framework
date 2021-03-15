package com.yykj.framework.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassInstanseFactory {
	
	private ClassInstanseFactory(){
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T create(Class<?> cls,String context){
		if(cls == null || context == null || context.equalsIgnoreCase("")){
			return null;
		}
		
		T obj;
		try {
			obj = (T) cls.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		String[] atts = context.split("\\|");
		for(String info : atts){
			String[] list = info.split("\\:");
			String attName = list[0];
			String attValue = list[1];
			
			Field field;
			try {
				field = cls.getDeclaredField(attName);
				field.setAccessible(true);
				field.set(obj, ClassInstanseFactory.convertAttributeValue(field.getType().getName(), attValue));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return (T) obj;
	}
	
	public static Object convertAttributeValue(String type,String value){
		if(type == null || type.equalsIgnoreCase("")){
			return null;
		}
		if(value == null || value.equalsIgnoreCase("")){
			return null;
		}
		
		if(type.equals("int")){
			return Integer.parseInt(value);
		}
		else if(type.equals("long")){
			return Long.parseLong(value);
		}
		else{
			return value;
		}
	}
}
