package Utility;

public class ExecutionTime {
    private final int numberOfCycles;

    public int getNumberOfCycles() {
        return numberOfCycles;
    }

    public ExecutionTime(int numberOfCycles) {
        this.numberOfCycles = numberOfCycles;
    }

    @Override
    public String toString() {
        return "ExecutionTime{" +
                "" + numberOfCycles +
                '}';
    }
}
