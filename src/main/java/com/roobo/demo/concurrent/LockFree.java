package com.roobo.demo.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFree {
	private AtomicInteger max = new AtomicInteger();

	// type A
	public void setA(int value) {
		while (true) { // 1.circulation
			int currentValue = max.get();
			if (value > currentValue) {
				if (max.compareAndSet(currentValue, value)) // 2.CAS
					break; // 3.exit
			} else
				break;
		}
	}

	// type B
	public void setB(int value) {
		int currentValue;
		do { // 1.circulation
			currentValue = max.get();
			if (value <= currentValue)
				break; // 3.exit
		} while (!max.compareAndSet(currentValue, value)); // 2.CAS
	}
}
