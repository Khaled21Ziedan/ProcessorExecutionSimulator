package Components;

import Utility.Priority;
import Utility.ExecutionTime;

import java.util.Comparator;

public class Task implements Comparator<Task> {
    int id;
    int creationTime;
    ExecutionTime executionTime;
    Priority priority;
    public Task(){}
    public Task(int id, int creationTime, ExecutionTime executionTime, Priority priority) {
        this.id = id;
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(int creationTime) {
        this.creationTime = creationTime;
    }

    public ExecutionTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(ExecutionTime executionTime) {
        this.executionTime = executionTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", creationTime = "+ creationTime +
                ", "+ executionTime +
                ", " + priority +
                "} \n";
    }

    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getCreationTime() == o2.getCreationTime()){
            return 0;
        }
        else if (o1.getCreationTime() > o2.getCreationTime()){
            return 1;
        }
        else
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
