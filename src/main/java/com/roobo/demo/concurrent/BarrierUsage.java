package com.roobo.demo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierUsage extends Thread {
	private static CyclicBarrier barrier = new CyclicBarrier(2, new Thread() {
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println("finish");
		};
	});

	private final int sleepMilSecs;

	public BarrierUsage(int sleepMilSecs) {
		this.sleepMilSecs = sleepMilSecs;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(sleepMilSecs);
			System.out.println(sleepMilSecs + " secs slept");
			barrier.await();
		} catch (InterruptedException e) {
		} catch (BrokenBarrierException e) {
		}
	}

	public static void main(String[] args) {
		new BarrierUsage(2000).start();
		new BarrierUsage(4000).start();
	}
}
