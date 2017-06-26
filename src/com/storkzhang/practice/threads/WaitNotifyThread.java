package com.storkzhang.practice.threads;
/**
 * Created by storkzhang on 17-3-30.
 */
public class WaitNotifyThread {
    private Object mLock = new Object();

    private static class WaitThread extends Thread {
        protected Object mLock;
        public WaitThread(Object lock) {
            mLock = lock;
        }
        @Override public void run() {
            try {
                synchronized (mLock) {
                    System.out.println("WaitThread begin to wait.");
                    mLock.wait();
                    System.out.println("WaitThread has been notified.");
                }
            } catch (InterruptedException e) {
                // need to be logged
                e.printStackTrace();
            }
        }
    }

    private static class NotifyThread extends WaitThread {
        public NotifyThread(Object lock) {
            super(lock);
        }

        @Override public void run() {
            synchronized (mLock) {
                System.out.println("NotifyThread begin to notify WaitThread.");
                mLock.notify();
                System.out.println("NotifyThread has sent the signal.");
            }
        }
    }

    public static void main(String args[]) {
        Object lock = new Object();
        WaitThread waitThread = new WaitThread(lock);
        NotifyThread notifyThread = new NotifyThread(lock);
        waitThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread.start();
    }
}