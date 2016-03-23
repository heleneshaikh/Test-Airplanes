package com.realdolmen.course.domain.threading;

/**
 * Created by heleneshaikh on 22/03/16.
 */
public class ThreadingExample {
    //Code that is safe to call by multiple threads simultaneously is called thread safe

    /*

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello world");
        }
    }

    */

    static class MyRunnable implements Runnable {
        //runnable: how a thread runs

        @Override
        public void run() {
            System.out.println("Hello world");
            //obtain a reference to the currently executing thread:
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName());
        }
    }

    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable(), "myThread");
        System.out.println(myThread.getName());
        myThread.start();
    }


}
