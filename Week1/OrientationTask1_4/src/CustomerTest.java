import java.util.LinkedList;
import java.util.ArrayList;

public class CustomerTest {

    public static void main(String[] args) {
        LinkedList<Customer> customerList = new LinkedList<>();
        ArrayList<Customer> dequedCustomers = new ArrayList<>();
        int testCustomerCount = 100;
        for (int i=0; i<testCustomerCount; i++) {
            Customer customer = new Customer();
            customer.setStartTime(System.nanoTime());
            customerList.addFirst(customer);
        }
        while (!customerList.isEmpty()) {
            Customer customer = customerList.removeLast();
            customer.setEndTime(System.nanoTime());
            dequedCustomers.add(customer);
        }

        for (Customer customer : dequedCustomers) {
            System.out.printf("%d. Customer came at %d and left %d. Waiting time was %d\n",
                    customer.getId(), customer.getStartTime(), customer.getEndTime(), customer.spentTime());
        }
    }
}
