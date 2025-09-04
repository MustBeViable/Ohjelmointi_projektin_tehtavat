public class Customer {
    private static int nextId = 1;
    final private int id;
    private long startTime;
    private long endTime;

    public Customer (Event e) {
        this.startTime = e.getEventTime();
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return this.id;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long spentTime () {
        return this.endTime - this.startTime;
    }
}
