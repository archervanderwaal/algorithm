package me.stormma.others;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    ReentrantLock lock = new ReentrantLock();

    private static final TestReentrantLock testReentrantLock = new TestReentrantLock();

    public void test() {
        lock.lock();
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        lock.lock();
        lock.unlock();
        lock.unlock();
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                testReentrantLock.test();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testReentrantLock.test();
            }
        }).start();
    }
}
