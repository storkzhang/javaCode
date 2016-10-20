package com.storkzhang.threads;

import java.lang.InterruptedException;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;

public class TestVolatile {
	private static volatile int sCount = 0;
	private static final int MAX_COUNT = 100;


	public static void inc(CountDownLatch latch) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread());
		sCount++;
		latch.countDown();
	}

	public static void main(String args[]) throws InterruptedException {
	    final CountDownLatch latch = new CountDownLatch(MAX_COUNT);
		for (int i = 0;i < MAX_COUNT; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					inc(latch);
				}
			}).start();
		}
		latch.await();
		System.out.println(sCount);
	}

}
