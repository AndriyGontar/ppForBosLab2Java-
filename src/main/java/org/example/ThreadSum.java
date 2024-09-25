package org.example;

import java.util.Arrays;

public class ThreadSum {

    private int[] array;
    private MyThread[] threads;
    private boolean[] isFree;

    public ThreadSum(int lenArray, int colThreads) {
        array = new int[lenArray];
        Arrays.fill(array, 1);
        isFree = new boolean[colThreads];
        Arrays.fill(isFree, true);
        threads = new MyThread[colThreads];
        for (int i = 0; i < colThreads; i++) {
            threads[i] = new MyThread(this, i);
        }
    }

    public void changeBool(int id) {
        isFree[id] = true;
    }

    public void add(int i) {
        if (i != array.length - i - 1) {
            array[i] += array[array.length - i - 1];
        }
    }

    public void wave() {
        int stop = array.length % 2 == 1 ? array.length / 2 + 1 : array.length / 2;
        sum(stop);
        array = Arrays.copyOf(array, stop);
        if (array.length > 1) {
            wave();
        }
    }

    private void sum(int stop) {
        int i = 0;
        boolean isDoSum = true;
        while (isDoSum) {
            for (int j = 0; j < isFree.length; j++) {
                if (isFree[j]) {
                    isFree[j] = false;
                    threads[j].run(i);
                    i++;
                    if (i == stop) {
                        isDoSum = false;
                        break;
                    }
                }
            }
        }
        boolean isAllStoped = false;
        while (!isAllStoped) {
            isAllStoped = isFree[0];
            for (int j = 0; j < isFree.length; j++) {
                isAllStoped = isAllStoped && isFree[j];
            }
        }

    }

    public int[] getArray() {
        return array;
    }

}

