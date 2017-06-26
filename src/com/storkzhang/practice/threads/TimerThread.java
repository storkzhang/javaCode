package com.storkzhang.practice.threads;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by storkzhang on 17-6-26.
 */
public class TimerThread {
    private static final int MAX_COUNT = 10;
    private static final int PROCESS_COST = 1;
    private static final int DELAY_TIMER = 1;
    private static Timer mTimer;
    private static HandleTask mTimerTask;

    public static class HandleTask extends TimerTask {
        public boolean isNotified;

        @Override public void run() {

            synchronized (this) {
                //System.out.println("handleTask running :" + isNotified);
                if (!isNotified) {
                    isNotified = true;
                    //System.out.println("modified by handleTask:" + isNotified);
                    handleResult();
                }
            }
        }
    }

    private static void handleResult() {
        System.out.println("handleResult called by " + Thread.currentThread());
    }

    public static void main(String args[]) {
        for (int i = 0; i < MAX_COUNT; i++) {
            if (mTimer != null) {
                mTimer.cancel();
            }
            mTimer = new Timer();
            mTimerTask = new HandleTask();
            mTimer.schedule(mTimerTask, DELAY_TIMER);
            // DO SOMETHING
            try {
                Thread.sleep(PROCESS_COST);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            synchronized (mTimerTask) {
                if (mTimerTask.isNotified) {
                    //System.out.println("added to record:" + mTimerTask.isNotified);
                } else {
                    mTimerTask.isNotified = true;
                    mTimer.cancel();
                    //System.out.println("timer cancelled");
                    handleResult();
                }
            }
            System.out.println("");
        }
    }

}
