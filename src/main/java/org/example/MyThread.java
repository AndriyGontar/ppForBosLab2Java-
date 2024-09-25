package org.example;

public class MyThread extends Thread {
    private final ThreadSum threadSum;
    private final int id;

    public MyThread(ThreadSum threadSum, int id) {
        this.threadSum = threadSum;
        this.id = id;
    }
    public void run(int i) {
        threadSum.add(i);
        threadSum.changeBool(id);
    }
}
