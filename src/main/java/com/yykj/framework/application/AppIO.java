package com.yykj.framework.application;

import java.io.*;

public class AppIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//字符流使用缓冲区，字节流没有
		
		//1.字节输出流
		//outputStream();
		
		//2.字节输入流
		//inputStream();
		
		//3.字符输出流
		//writeStream();
		
		//4.字输入流
		readStream();
	}

	/**
	 * 字符输入流
	 * @throws IOException 
	 */
	@SuppressWarnings({ "resource", "unused" })
	private static void readStream() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("e:/111.txt");
		if(!file.exists()){
			System.out.println("文件不存在！");
			return;
		}
		
		Reader reader = new FileReader(file);
		
		char[] buf = new char[1024];  
		int length = 0;
	
		while((length = reader.read(buf)) != -1){   
			System.out.println(new String(buf, 0, length));
		}
		
		reader.close();
	}

	/**
	 * 字符输出流
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private static void writeStream() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("e:/111.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		
		Writer writer = new FileWriter(file);
		writer.write("hello word 111");
		writer.append("hello world 222");
		writer.close();
		
		System.out.println("Success");
	}



	/**
	 * 字节输入流
	 * @throws IOException 
	 */
	private static void inputStream() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("e:/111.txt");
		if(!file.exists()){
			System.out.println("文件不存在！");
			return;
		}
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buf = new byte[1024];  
		int length = 0;
	
		while((length = fis.read(buf)) != -1){   
			System.out.println(new String(buf, 0, length));
		}
	}

	/**
	 * 字节输出流
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private static void outputStream() throws IOException {
		File file = new File("e:/111.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write("hello world".getBytes());
		fos.close();
		
		System.out.println("success!");
	}

}
