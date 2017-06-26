package com.storkzhang.practice.threads;

/**
 * Created by storkzhang on 17-3-29.
 */
public class YieldThread extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("duration:" + (endTime - beginTime) + "ms");
    }

    public static void main(String args[]) {
        YieldThread thread = new YieldThread();
        thread.start();
    }
}
