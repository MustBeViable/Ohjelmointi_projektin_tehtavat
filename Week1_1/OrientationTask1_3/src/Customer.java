public class Customer {
    private static int nextId = 1;
    private int id;
    private long startTime;
    private long endTime;


    public Customer () {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
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
