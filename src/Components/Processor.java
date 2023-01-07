package Components;

import java.util.PriorityQueue;

public class Processor extends Thread {
    private Task task;
    private int id;
    private final PriorityQueue<Task> queue;
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Processor(PriorityQueue<Task> queue, int id) {
        this.id=id;
    this.queue=queue;
    }
    public synchronized Task pollTask(){
        return task = queue.poll();
    }


    @Override
    public void run() {
        try {
            while (true){
            synchronized (this) {
                        this.wait();
                task = pollTask();
//                System.out.println(id );
//                System.out.println(queue);
                System.out.println( "processor id is "+ this.id + " ----- runs Task ID = " + task.id + " ---- " + "Creation Time is = " + task.creationTime);
                Thread.sleep((long) task.getExecutionTime().getNumberOfCycles() * 1000);
                System.out.println("Task " + task.id + " finished");
            }}
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
