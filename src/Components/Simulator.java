package Components;

import Utility.ReadInputFile;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Simulator implements Runnable {
    int numberOfProcessors;
    int fullCycles;
    private String filePath;
    private Scheduler scheduler;
    private ReadInputFile readInputFile;
    private Thread clockThread, schedulerThread;
    private Clock clock;

    public Simulator(int numberOfProcessors, int fullCycles, String filePath) throws FileNotFoundException {
        this.numberOfProcessors = numberOfProcessors;
        this.fullCycles = fullCycles;
        this.filePath = filePath;
        readInputFile = new ReadInputFile(filePath);
        scheduler = new Scheduler();
        scheduler.setQueue(readInputFile.getCurrentCycleTasks(Clock.getClockInstance().getCycleNumber()));
        clockThread = new Thread(Clock.getClockInstance());
        schedulerThread = new Thread(scheduler);
        clock = Clock.getClockInstance();
        clockThread.start();
        schedulerThread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                synchronized (Clock.getClockInstance()) {
                    Clock.getClockInstance().notify();
                    scheduler.setQueue(readInputFile.getCurrentCycleTasks(Clock.getClockInstance().getCycleNumber()));
                    System.out.println(clock);
                }
            }
        } catch (Exception e) {
        }
    }

}
