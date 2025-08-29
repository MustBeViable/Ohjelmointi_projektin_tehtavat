import java.util.Scanner;

public class CustomerTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many customers are you willing to generate? ");
        int answer = input.nextInt();

        ServicePoint servicePoint = new ServicePoint();
        CustomerGenerator generator = new CustomerGenerator(servicePoint, answer);
        generator.generateCustomers();
        servicePoint.serve();
    }
}
