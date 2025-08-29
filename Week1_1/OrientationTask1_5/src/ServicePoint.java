import java.util.LinkedList;

public class ServicePoint {
    LinkedList<Customer> customerList = new LinkedList<>();

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
            double sleeptime = (Math.random() * 1000 * ((int)(Math.random() * 5))) + 1000;

            try {
                Thread.sleep((long)sleeptime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Customer customer = removeFromQueue();
            System.out.printf("%d. Customer waiting time was %.2f s and service time was %.2f s\n",
                    customer.getId(), ((((double)customer.spentTime()/1000) + sleeptime)/1000), (sleeptime)/1000);
        }
    }


}
