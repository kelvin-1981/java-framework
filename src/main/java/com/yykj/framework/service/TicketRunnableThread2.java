package com.yykj.framework.service;

public class TicketRunnableThread2 implements Runnable{
	
	private int ticket = 1000;

	/**
	 * 同步方法
	 */
	public synchronized void sale(){
		if (this.ticket > 0) {
			System.out.println("销售1张车票，购票人:" + Thread.currentThread().getName() + ",剩余车票：" + this.ticket);
			this.ticket -= 1;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("车票已售完！购票人:" + Thread.currentThread().getName());
		}
	}
	
	@Override
	public void run() {
		while (true) {
			this.sale();	
			
			if(this.ticket <= 0){
				break;
			}
		}
	}
}
