package com.yykj.framework.application;

public class AppGenericsMethod {

	/**
	 * 泛型
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer[] list_1 = show(1,2,3);
		System.out.println(list_1.toString());
		
		String[] list_2 = show("A","B","C");
		System.out.println(list_2.toString());
	}
	
	/**
	 * 泛型方法
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] show(T ... args){
		return args;
	}
}
