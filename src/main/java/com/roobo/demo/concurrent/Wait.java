package com.roobo.demo.concurrent;

public class Wait extends Thread {
	@Override
	public void run() {
		System.out.println("start");
		synchronized (this) { // wait/notify/notifyAll use the same
								// synchronization resource
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace(); // notify won't throw exception
			}
		}
	}

	public static void main(String[] args) {
		Thread thread = new Wait();
		thread.start();
		try {
			sleep(2000);
		} catch (InterruptedException e) {
		}
		synchronized (thread) {
			System.out.println("Wait() will release the lock!");
			thread.notify();
		}
	}
}
