package com.yykj.framework.application;

import com.yykj.framework.bean.Message;
import com.yykj.framework.bean.ThreadChannel;
import com.yykj.framework.service.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程
 * 
 * @author YYKJ
 *
 */
public class AppThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// 1.Thread实现
		// 备注：多个线程按顺序执行，没有异步执行
		// runThread();

		// 2.Runnable接口实现（标准实现方式）
		// 注1：实现多线程异步执行
		// 注2：缺点：此方法无返回值
		// runRunnableThread();

		// 3.Callable实现多线程
		// 注1：此方法有返回值
		// callableThread();

		// 4.线程休眠、中断、礼让、强制运行、优先级
		// threadSleep();

		// 5.线程同步案例:使用同步块实现
		// threadTicketSale();

		// 6.线程同步案例:使用同步方法实现
		//threadTicketSale2();
		
		//7.守护线程
		//daemonThread();
		
		//
		threadLocal();
	}
	
	

	/**
	 * ThreadLocal:解决线程安全，线程内部存储类
	 */
	private static void threadLocal() {
		// TODO Auto-generated method stub
		new Thread(() -> {
			Message msg = new Message();
			msg.setInfo("第一个线程消息");
			ThreadChannel.setMessage(msg);
			ThreadChannel.show();
		}, "用户线程1").start();
		
		new Thread(() -> {
			Message msg = new Message();
			msg.setInfo("第二个线程消息");
			ThreadChannel.setMessage(msg);
			ThreadChannel.show();
		}, "用户线程2").start();
		
		new Thread(() -> {
			Message msg = new Message();
			msg.setInfo("第三个线程消息");
			ThreadChannel.setMessage(msg);
			ThreadChannel.show();
		}, "用户线程3").start();
	}



	/**
	 * 守护线程：主线程执行完毕，自动完成.
	 * 例：垃圾回收线程
	 */
	private static void daemonThread() {
		// TODO Auto-generated method stub
		Thread userThread = new Thread(() ->{
			for(int i = 0; i < 10; i++){
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"用户线程"); 
		
		Thread daemonThread = new Thread(() ->{
			for(int i = 0; i < Integer.MAX_VALUE; i++){
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "守护线程");
		
		userThread.start();
		
		daemonThread.setDaemon(true);
		daemonThread.start();
	}

	/**
	 * 
	 */
	private static void threadTicketSale2() {
		// TODO Auto-generated method stub
		TicketRunnableThread2 run = new TicketRunnableThread2();

		new Thread(run, "票贩子A").start();
		new Thread(run, "票贩子B").start();
		new Thread(run, "票贩子C").start();
	}

	/**
	 * 线程同步:同步块方式实现
	 */
	private static void threadTicketSale() {

		TicketRunnableThread run = new TicketRunnableThread();

		new Thread(run, "票贩子A").start();
		new Thread(run, "票贩子B").start();
		new Thread(run, "票贩子C").start();
	}

	/**
	 * 线程休眠、中断、礼让、强制运行、优先级
	 */
	@SuppressWarnings("unused")
	private static void threadSleep() {
		Runnable run = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					// 线程休眠
					Thread.sleep(3000);

					// 线程中断
					// Thread.interrupted();

					// 线程礼让
					// Thread.yield();

					// 线程强制运行
					// thread_1.join()

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread thread_1 = new Thread(run, "Thread-A");
		thread_1.setPriority(Thread.MIN_PRIORITY);

		Thread thread_2 = new Thread(run, "Thread-B");
		thread_2.setPriority(Thread.NORM_PRIORITY);

		Thread thread_3 = new Thread(run, "Thread-C");
		thread_3.setPriority(Thread.MAX_PRIORITY);

		thread_1.start();
		thread_2.start();
		thread_3.start();
	}

	/**
	 * Callable实现多线程
	 * 
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unused")
	private static void callableThread() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		FutureTask<String> futureTask = new FutureTask<String>(new CustomerCallableThread("Thread1"));
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}

	/**
	 * Runnable接口实现
	 */
	@SuppressWarnings("unused")
	private static void runRunnableThread() {
		// TODO Auto-generated method stub
		Thread thread_1 = new Thread(new CustomerRunnableThread("Thread1"));
		Thread thread_2 = new Thread(new CustomerRunnableThread("Thread2"));
		Thread thread_3 = new Thread(new CustomerRunnableThread("Thread3"));

		thread_1.start();
		thread_2.start();
		thread_3.start();
	}

	/**
	 * Thread实现
	 */
	private static void runThread() {
		// TODO Auto-generated method stub
		CustomerThread thread_1 = new CustomerThread("Thread1");
		CustomerThread thread_2 = new CustomerThread("Thread2");
		CustomerThread thread_3 = new CustomerThread("Thread3");

		thread_1.run();
		thread_2.run();
		thread_3.run();
	}

}
