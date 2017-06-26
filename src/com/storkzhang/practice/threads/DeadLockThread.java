package com.storkzhang.practice.threads;

/**
 * Created by storkzhang on 17-3-29.
 */
public class DeadLockThread implements Runnable{

    public String userName;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        if (userName.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("userName = " + userName);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("lock1->lock2");
                }
            }
        }
        if (userName.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("userName = " + userName);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("lock2->lock1");
                }
            }
        }

    }
}
