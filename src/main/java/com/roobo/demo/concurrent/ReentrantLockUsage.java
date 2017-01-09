package com.roobo.demo.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockUsage implements Runnable {

	private static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		lock.lock();

		try {
			System.out.println("do something 1");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		} finally {
			lock.unlock(); // Why put it in finally block?
		}

		System.out.println("finish 1");
	}

	public static void main(String[] args) {
		new Thread(new ReentrantLockUsage()).start();
		lock.lock();

		try {
			System.out.println("do something 2");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
		}

		System.out.println("finish 2");
	}
}
