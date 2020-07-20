package by.duallab.ahremenko;

public class Task implements Comparable<Task>{
    private long startTime;
    private long finishTime;

    public Task(long startTime, long finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    @Override
    public int compareTo(Task another) {
        if (this.getStartTime()<another.getStartTime()){
            return -1;
        } else {
            return 1;
        }
    }
}