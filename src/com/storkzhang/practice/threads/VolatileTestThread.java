package com.storkzhang.practice.threads;

/**
 * Created by storkzhang on 17-3-29.
 */
public class VolatileTestThread extends Thread {
    private static int count;
    private static Object lock = new Object();

    private void addCount() {
        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                //System.out.println("Count= ,Current Thread:" + getId());
                count++;
            }
            System.out.println("Count=" + count + " ,Current Thread:" + getId());
        }
    }

    @Override public void run() {
        addCount();
    }

    public static void main(String args[]) {
        VolatileTestThread[] threadArr = new VolatileTestThread[100];
        for (int i = 0; i < 100; i++) {
            threadArr[i] = new VolatileTestThread();
        }
        for (int i = 0; i < 100; i++) {
            threadArr[i].start();
        }
    }
}