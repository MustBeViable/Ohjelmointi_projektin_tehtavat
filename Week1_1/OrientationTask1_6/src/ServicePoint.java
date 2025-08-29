import java.util.LinkedList;
import java.util.ArrayList;

public class ServicePoint {
    LinkedList<Customer> customerList = new LinkedList<>();
    private final ArrayList<Double> allServiceTimes = new ArrayList<>();
    private double serviceTimeSum;
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
        customer.setEndTime(System.nanoTime());
        return customer;
    }

    public void serve() {
        while (!customerList.isEmpty()) {
            double serviceTime = (Math.random() * 1000 * ((int)(Math.random() * 5))) + 1000;
            allServiceTimes.add(serviceTime);
            if (serviceTime > this.maxServiceTIme || serviceTime < this.minServiceTime) {
                this.maxServiceTIme = Math.max(this.maxServiceTIme, serviceTime);
                this.minServiceTime = Math.min(this.minServiceTime, serviceTime);
            }

            try {
                Thread.sleep((long)serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Customer customer = removeFromQueue();

            double currCustomerResponseTime = (((double) customer.spentTime()/1000000000) + serviceTime/1000);

            this.customerCount++;
            System.out.printf("%d. Customer response time was %.2f s and service time was %.2f s\n",
                    customer.getId(), currCustomerResponseTime, (serviceTime)/1000);
        }
        System.out.printf("Average service time was: %.2fs\n", (averageServiceTime()/1000));
        System.out.printf("Fastest service: %.2fs\n", (this.minServiceTime/1000));
        System.out.printf("Slowest service: %.2fs", (this.maxServiceTIme/1000));
    }

    public double averageServiceTime() {
        for (Double time : allServiceTimes) {
            this.serviceTimeSum += time;
        } return (this.serviceTimeSum /this.customerCount);
    }


}
