package com.jancal.sebeser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程模型
 *
 * @author Jancal
 */
final class Executor {

    //业务组
    private Service service;
    private Service2 service2;
    //线程组
    private Lock lock = new ReentrantLock();
    private Runnable task = new Task("task-1");
    private Runnable task2 = new Task("task-2");
    private Runnable task3 = new Task("task-3");
    private Runnable task4 = new Task("task-4");

    Executor(Service service, Service2 service2) {
        this.service = service;
        this.service2 = service2;
    }

    void start() {
        System.out.println("start");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(task);
        pool.execute(task2);
        pool.execute(task3);
        pool.execute(task4);
        pool.shutdown();
        System.out.println("end");
    }


    private class Task extends Thread {

        Task(String name) {
            super(name);
        }

        public void run() {

            try {
                lock.lock();
                System.out.println(this.getName() + " doTask...");
                service.doService();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
