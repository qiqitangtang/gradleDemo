package com.roobo.demo.concurrent;

public class Lock {
	private static Object o = new Object();
	static Lock lock = new Lock();

	// lock on dynamic method
	public synchronized void dynamicMethod() {
		System.out.println("dynamic method");
		sleepSilently(2000);
	}

	// lock on static method
	public static synchronized void staticMethod() {
		System.out.println("static method");
		sleepSilently(2000);
	}

	// lock on this
	public void thisBlock() {
		synchronized (this) {
			System.out.println("this block");
			sleepSilently(2000);
		}
	}

	// lock on an object
	public void objectBlock() {
		synchronized (o) {
			System.out.println("dynamic block");
			sleepSilently(2000);
		}
	}

	// lock on the class
	public static void classBlock() {
		synchronized (Lock.class) {
			System.out.println("static block");
			sleepSilently(2000);
		}
	}

	private static void sleepSilently(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// object lock test
		new Thread() {
			@Override
			public void run() {
				lock.dynamicMethod();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				lock.thisBlock();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				lock.objectBlock();
			}
		}.start();

		sleepSilently(3000);
		System.out.println();

		// class lock test
		new Thread() {
			@Override
			public void run() {
				lock.staticMethod();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				lock.classBlock();
			}
		}.start();

	}
}
