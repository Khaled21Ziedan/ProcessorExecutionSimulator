package Components;

 class Clock implements Runnable {
    private static Clock clock=new Clock(1);

    private Clock(int cycleNumber) {
        this.cycleNumber = 0;
    }

    public static Clock getClockInstance(){
        return clock;
    }
    private int cycleNumber;

    public int getCycleNumber() {
        return cycleNumber;
    }

    @Override
    public void run() {
        try {
            synchronized (Clock.getClockInstance()) {
                while (true){
                    Clock.getClockInstance().wait();
                    increaseClock();
                }}
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void increaseClock (){
        this.cycleNumber++;
    }

     @Override
     public String toString() {
         return "Clock{" +
                 "cycleNumber=" + cycleNumber +
                 '}';
     }
 }
