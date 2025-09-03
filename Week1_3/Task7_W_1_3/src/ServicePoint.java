import java.util.ArrayList;
import java.util.LinkedList;

public class ServicePoint {
    LinkedList<Customer> customerList = new LinkedList<>();
    private final ArrayList<Long> allServiceTimes = new ArrayList<>();
    private long serviceTimeSum;
    private int customerCount = 0;
    private double minServiceTime = Integer.MAX_VALUE;
    private double maxServiceTIme = Integer.MIN_VALUE;

    public void addToQueue(Customer a) {
        System.out.println("Adding customer with id " + a.getId() + " to the queue");
        customerList.addFirst(a);
        a.setStartTime();
    }

    public Customer removeFromQueue() {
        Customer customer = customerList.removeLast();
        customer.setEndTime(Clock.getInstance().getTimeMs());
        return customer;
    }

    public void serve() {
        while (!customerList.isEmpty()) {
            Clock.getInstance().advanceTimeMs(500);
            long serviceTime = Clock.getInstance().getTimeMs();
            allServiceTimes.add(serviceTime);
            if (serviceTime > this.maxServiceTIme || serviceTime < this.minServiceTime) {
                this.maxServiceTIme = Math.max(this.maxServiceTIme, serviceTime);
                this.minServiceTime = Math.min(this.minServiceTime, serviceTime);
            }
            Customer customer = removeFromQueue();


            this.customerCount++;
            System.out.printf("%d. Customer  service time was %s s\n",
                    customer.getId(), serviceTime);
        }
        System.out.printf("Average service time was: %s\n", averageServiceTime());
        System.out.printf("Fastest service: %.2fs\n", this.minServiceTime);
        System.out.printf("Slowest service: %.2fs", this.maxServiceTIme);
    }

    public long averageServiceTime() {
        for (Long time : allServiceTimes) {
            this.serviceTimeSum += time;
        } return (this.serviceTimeSum /this.customerCount);
    }


}
