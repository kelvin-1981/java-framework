package com.yykj.framework.bean;

import com.yykj.framework.common.IChannel;
import com.yykj.framework.common.IMessage;
import com.yykj.framework.service.AbstractBase;

public class Person extends AbstractBase implements IMessage,IChannel {
	
	private String name = "";
	
	private int age = 0;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean connection() {
		return true;
	}

	@Override
	public void send() {
		if(this.connection()){
			System.out.println("Person:send()");
		}
	}

//	public String getSchool(String name,int level){
//		return "Person：getSchool()   学校：" + name + " 年级:" + level;
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.age;
	}
}
