import java.util.PriorityQueue;

public class TesterClass {
    public static void main(String[] args) {
        PriorityQueue<Event> queue = new PriorityQueue<>();
        int numOfArrivals = 10;
        ArrivalProcess arr = new ArrivalProcess(EventType.EVENT_TYPE_A);

        System.out.println("Current time is: " + Clock.getInstance().getTimeMs());

        for (int i = 0; i < numOfArrivals; i++) {
            arr.scheduleNext(queue);
        }
        System.out.println("Current time is: " + Clock.getInstance().getTimeMs());

        ServicePoint ser = new ServicePoint();

        CustomerGenerator cus = new CustomerGenerator(ser,numOfArrivals);
        cus.generateCustomers();

        System.out.println("Current time is: " + Clock.getInstance().getTimeMs());

        ser.serve();
    }
}
