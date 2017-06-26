package com.storkzhang.practice.threads;

/**
 * Created by storkzhang on 17-3-29.
 */
public class DeadLockRun {

    public static void main(String args[]) {
        DeadLockThread lr1 = new DeadLockThread();
        lr1.setUserName("a");
        Thread thread1 = new Thread(lr1);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DeadLockThread lr2 = new DeadLockThread();
        lr2.setUserName("b");
        Thread thread2 = new Thread(lr2);
        thread2.start();
    }
}
