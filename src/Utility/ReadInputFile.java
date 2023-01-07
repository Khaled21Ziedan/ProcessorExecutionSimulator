package Utility;

import Components.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ReadInputFile {
    private File file;

    private PriorityQueue<Task> queue;

    public PriorityQueue<Task> getQueue() {
        return queue;
    }

    public ReadInputFile(String filePath) throws FileNotFoundException {
        this.file=new File(filePath);
        this.createTasksFromFile();
    }

    private void createTasksFromFile() throws FileNotFoundException {
        queue = new PriorityQueue<Task>(new Task());
        int i = 0;
        Scanner scan = new Scanner(file);
        scan.nextLine();
        while (scan.hasNext()) {
            i++;
            if (i == 1) {
            }
            Task task = new Task(i, scan.nextInt(), new ExecutionTime(scan.nextInt()), new Priority(scan.nextInt()));
            this.queue.add(task);
        }

        scan.close();
    }

    public PriorityQueue<Task> getCurrentCycleTasks(int currentCycle) {
        PriorityQueue<Task> sendQueue = new PriorityQueue<>(new Task());
        for (int i = 0; i < queue.size(); i++) {
            if (queue.peek().getCreationTime() == currentCycle) {
                sendQueue.add(queue.poll());
            }
            else  break;
        }
//        System.out.println(sendQueue + " ---------- first task ");
        return sendQueue;

    }


    public static void main(String[] args) throws FileNotFoundException {
        ReadInputFile readInputFile=new ReadInputFile("C:\\Users\\omar_\\Desktop\\Atypon Tasks.txt");
        PriorityQueue q=new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.getPriority().getPriority() == o2.getPriority().getPriority()){
                    return 0;
                }
                else if (o1.getPriority().getPriority() < o2.getPriority().getPriority()){
                    return 1;
                }
                else
                    return -1;
            }
        });
        q.addAll(readInputFile.getQueue());
        System.out.println(q);
    }
}

