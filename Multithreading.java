package com.ebiz;

public class ThreadTest {
	public static void main(String[] args) {
		
		Runnable target=new MyThread();
		Thread th1=new Thread(target);
		th1.start();
		
		Runnable r=new Runnable(){
			@Override
			public void run() {
				System.out.println("in anonymous run");
			}
		};
		
		Thread th2=new Thread(r);
		th2.start();
		
		Thread th3=new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("in anonymous again...");
			}
		});
		th3.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("super code by IDE");
			}
		}).start();
		
		//by lambda expression
		new Thread(()->System.out.println("this is fun")).start();
		
	}
}

class MyThread implements Runnable{
	public void run() {
		System.out.println("in run");
	};
}




