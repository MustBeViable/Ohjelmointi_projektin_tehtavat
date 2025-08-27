import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CustomerTest {
    static LinkedList<Customer> customerList = new LinkedList<>();
    static ArrayList<Customer> dequeuedCustomers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer;
        System.out.println("Do you want to add customer to the queue (anything for yes and x to end)?");
        answer = input.next().toLowerCase();
        while (!Objects.equals(answer, "x")) {
            System.out.println("Do you want to add new customer to queue (q), dequeue a customer (d) " +
                    "or stop the program (x)?");
            answer = input.next().toLowerCase();
            while (!Objects.equals(answer,"q") && !Objects.equals(answer, "d")
                    && !Objects.equals(answer, "x"))
            {
                System.out.println("Please enter valid answer (y/n)");
                answer = input.next().toLowerCase();
            }
            if (Objects.equals(answer,"q")) {
                createCustomer();
            }
            else if (Objects.equals(answer, "d")) {
                dequeue();
            }
            System.out.println("Currently on queue: " + customerList.toArray().length);
            }

        for (Customer customer : dequeuedCustomers) {
            System.out.printf("%d. Customer came at %d and left %d. Waiting time was %d\n",
                    customer.getId(), customer.getStartTime(), customer.getEndTime(), customer.spentTime());
        }
    }

    private static void createCustomer () {
        Customer customer = new Customer();
        System.out.println("Adding customer with id " + customer.getId() + " to the queue");
        customer.setStartTime(System.nanoTime());
        customerList.addFirst(customer);
    }

    private static void dequeue() {
        if (customerList.toArray().length > 0) {
            Customer customer = customerList.removeLast();
            customer.setEndTime(System.nanoTime());
            dequeuedCustomers.add(customer);
            System.out.printf("%d. Customer came at %d and left %d. Waiting time was %d\n",
                    customer.getId(), customer.getStartTime(), customer.getEndTime(), customer.spentTime());
        } else {
            System.out.println("No customers in queue");
        }
    }
}
