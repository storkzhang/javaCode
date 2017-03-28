package com.storkzhang.practice.threads;

/**
 * Created by storkzhang on 17-3-28.
 */
public class InterruptedThread {
    private static class ThreadRunnable implements Runnable {
        private Thread mThread;

        public void setThread (Thread thread) {
            mThread = thread;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 500000; i++) {
                    if (mThread != null && mThread.isInterrupted()) {
                        System.out.println("begin to exit current thread:" + mThread.getName());
                        throw new InterruptedException();
                    } else {
                        System.out.println(i);
                    }
                }
                System.out.println("all have been printed");
            } catch (InterruptedException e) {
                System.out.println("into interrupted Exception");
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        ThreadRunnable mRunnable = new ThreadRunnable();
        Thread testThread = new Thread(mRunnable);
        mRunnable.setThread(testThread);
        testThread.start();
        try {
            Thread.sleep(100);
            testThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
