package Utility;

public class Priority {
    private int priority;

    public Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }



    @Override
    public String toString() {
        return " { Priority=" + priority +
                '}';
    }

}
