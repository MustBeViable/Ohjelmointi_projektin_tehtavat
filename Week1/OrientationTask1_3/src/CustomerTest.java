import java.util.ArrayList;

public class CustomerTest {

    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();
        int testCustomerCount = 1000000;
        for (int i=0; i<testCustomerCount; i++) {
            customerList.add(new Customer());
        }
        int index = 1;
        for (Customer customer : customerList) {
            customer.setId(index);
            customer.setStartTime(System.currentTimeMillis());
            index++;
        }
        for (Customer customer : customerList) {
            customer.setEndTime(System.currentTimeMillis());
        }

        for (Customer customer : customerList) {
            System.out.printf("%d. Customer came at %d and left %d. Waiting time was %d\n",
                    customer.getId(), customer.getStartTime(), customer.getEndTime(), customer.spentTime());
        }
    }
}
