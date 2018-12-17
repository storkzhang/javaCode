package com.storkzhang.practice.threads;
/**
 * Created by storkzhang on 17-7-5.
 */
public class ObjectLock {

    private static class ObjectThread extends Thread {
        private Object lock = new Object();
        private int count;

        public ObjectThread(int count) {
            this.count = count;
        }

        @Override public void run() {
            synchronized (lock) {
                test();
            }
        }

        private void test() {
            System.out.println("test" + count);
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) {
            ObjectThread thread = new ObjectThread(i);
            thread.start();
        }
    }
}
