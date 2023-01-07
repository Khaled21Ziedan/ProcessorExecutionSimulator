package Components;

import Utility.ReadInputFile;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Scheduler implements Runnable {
    private PriorityQueue<Task> queue;
    private Thread thread1, thread2, thread3, thread4;
    private final Processor P1;
    private final Processor P2;
    private final Processor P3;
    private final Processor P4;
    private ReadInputFile readInputFile;


    public Scheduler() throws FileNotFoundException {
        queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getPriority().getPriority() > o2.getPriority().getPriority()) {
                    return -1;
                } else if (o1.getPriority().getPriority() < o2.getPriority().getPriority()) {
                    return -1;
                } else
                    return 0;
            }
        });
//        for (int i = 0; i < 5; i++) {
//            Processor p = new Processor(queue,i);
//            p.start();
//        }
        P1 = new Processor(queue, 1);
        P2 = new Processor(queue, 2);
        P3 = new Processor(queue, 3);
        P4 = new Processor(queue, 4);
        thread1 = new Thread(P1);
        thread2 = new Thread(P2);
        thread3 = new Thread(P3);
        thread4 = new Thread(P4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    public void setQueue(PriorityQueue<Task> queue) {
        this.queue.addAll(queue);
    }

    public PriorityQueue<Task> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (P1) {
                if (!isQueueEmpty()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    P1.notify();
                }
            }
            synchronized (P2) {
                if (!isQueueEmpty()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    P2.notify();
                }
            }
            synchronized (P3) {
                if (!isQueueEmpty()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    P3.notify();
                }
            }
            synchronized (P4) {
                if (!isQueueEmpty()) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    P4.notify();
                }
            }
        }
    }
    public synchronized boolean isQueueEmpty(){
        return queue.isEmpty();
    }


}


