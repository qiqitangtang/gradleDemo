package com.roobo.demo.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureUsage {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Callable<Object> task = new Callable<Object>() {
			public Object call() throws Exception {

				Thread.sleep(4000);

				Object result = "finished";
				return result;
			}
		};

		Future<Object> future = executor.submit(task);
		System.out.println("task submitted");

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}

		// Thread won't be destroyed.
	}
}
