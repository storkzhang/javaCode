package com.storkzhang.practice.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPractice implements Runnable {

	@Override
	public void run() {
		testSyncMethod();
	}

	private synchronized void testSyncMethod() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getId() + "testSyncMethod:" + i);
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		ThreadPractice rt = new ThreadPractice();
		ThreadPractice rt1 = new ThreadPractice();
		exec.execute(rt);
		exec.execute(rt1);
		exec.shutdown();
	}
}