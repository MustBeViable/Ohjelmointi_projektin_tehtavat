public class CustomerGenerator {
    private final ServicePoint servicePoint;

    public CustomerGenerator (ServicePoint servicePoint) {
        this.servicePoint = servicePoint;
    }

    public void generateCustomers (Event e) {
            Customer customer = new Customer(e);
            servicePoint.addToQueue(customer);

    }
}
