package com.storkzhang.practice.threads;

/**
 * Created by storkzhang on 17-3-29.
 */
public class SynchronizedTask {
    private static class TestTask {
        public void doLongTimeTask() {
            for (int i = 0; i < 100; i++) {
                System.out.println("not synchronized threadName=" + Thread.currentThread().getName() + " i=" + i);
            }
            synchronized (this) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " i=" + i);
                }
            }
        }
    }

    private static class TestThread1 extends Thread {
        private TestTask mTask;

        public TestThread1(TestTask task) {
            mTask = task;
        }

        @Override
        public void run() {
            if (mTask != null) {
                //do sth only in thread1
                // xxx

                mTask.doLongTimeTask();
            }
        }
    }
    private static class TestThread2 extends Thread {
        private TestTask mTask;

        public TestThread2(TestTask task) {
            mTask = task;
        }

        @Override
        public void run() {
            if (mTask != null) {
                //do sth only in thread2
                // xxx

                mTask.doLongTimeTask();
            }
        }
    }

    public static void main(String args[]) {
        TestTask testTask = new TestTask();
        TestThread1 testThread1 = new TestThread1(testTask);
        testThread1.start();
        TestThread2 testThread2 = new TestThread2(testTask);
        testThread2.start();
    }
}
