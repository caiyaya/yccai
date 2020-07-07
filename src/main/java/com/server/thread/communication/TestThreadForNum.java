package com.server.thread.communication;

/**
 * 线程间通信：等待唤醒机制
 *
 * wait();让当前线程释放锁
 * wait(longtimeout);让当前线程释放锁，并等待xx毫秒
 * notify();唤醒持有同一锁的某个线程
 * notifyAll();唤醒持有同一锁的所有线程
 */
public class TestThreadForNum {
    public static void main(String[] args){
        new ThreadForNum1().start();
        new ThreadForNum2().start();
    }

    public static class MyLock {
        public static Object o=new Object();
    }

    //定义一个线程类  输出1
    public static class ThreadForNum1 extends Thread {

        public void run(){
            for(int j=0;j<10;j++){
                synchronized (MyLock.o) {
                    System.out.println(1);
                    MyLock.o.notify();
                    try {
                        MyLock.o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    //自定义一个线程类   输出2
    public static class ThreadForNum2 extends Thread {

        public void run(){
            for(int j=0;j<10;j++){
                synchronized (MyLock.o) {
                    System.out.println(2);
                    MyLock.o.notify();
                    try {
                        MyLock.o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

