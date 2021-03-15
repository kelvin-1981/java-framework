package com.yykj.framework.service;

import java.io.File;

public class DemoClassLoader extends ClassLoader {
	
	@SuppressWarnings("unused")
	private static final String MESSAGE_CLASS_PATH = "d" + File.separator + "Message.class";
	/**
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public Class<?> loadData(String className) throws Exception {
		return null;
	}
}
