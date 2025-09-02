public class CustomerGenerator {
    private final ServicePoint servicePoint;
    private final int customerCount;

    public CustomerGenerator (ServicePoint servicePoint ,int customerCount) {
        this.customerCount = customerCount;
        this.servicePoint = servicePoint;
    }

    public void generateCustomers () {
        for (int i = 0; i < this.customerCount; i++) {
            Customer customer = new Customer();
            Clock.getInstance().advanceTimeMs(500);
            servicePoint.addToQueue(customer);
        }
    }
}
