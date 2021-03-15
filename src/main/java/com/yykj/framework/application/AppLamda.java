package com.yykj.framework.application;

import com.yykj.framework.common.ILamda;
import com.yykj.framework.common.IMessage;

/**
 * Lamda表达式
 * @author YYKJ
 *
 */
public class AppLamda {

	public static void main(String[] args) {
		
		//1.无参数 方法 *IMessage 添加函数式接口标记
		IMessage instance = () -> {
			System.out.println("hello world !!!");
		};
		instance.send();
		
		//2.含参数
		ILamda instance_2 = (a, b) -> {
			return a + b;
		};
		System.out.println(instance_2.math(10, 20));
		
		ILamda instance_3 = (a,b) -> a + b;
		System.out.println(instance_3.math(10, 10));
	}
}
