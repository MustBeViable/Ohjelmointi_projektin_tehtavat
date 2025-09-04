import java.util.ArrayList;
import java.util.PriorityQueue;

public class TesterClass {
    public static void main(String[] args) {
        //tän vois esim pitää EventList classissa, mutta tein sen nyt näin itse. Event luokassa määrittelen
        // priority queuen järjestyksen aikajärjestykseen pienimmästä suurimpaan.
        PriorityQueue<Event> queue = new PriorityQueue<>();
        int numOfArrivals = 10;
        ArrivalProcess arr = new ArrivalProcess(EventType.EVENT_TYPE_A);

        System.out.println("Current time before creating 10 events: " + Clock.getInstance().getTimeMs());

        for (int i = 0; i < numOfArrivals; i++) {
            arr.scheduleNext(queue);
        }


        System.out.println("Current time after creating 10 events: " + Clock.getInstance().getTimeMs());

        ServicePoint ser = new ServicePoint();

        CustomerGenerator cus = new CustomerGenerator(ser);
        while (!queue.isEmpty()) {
            Event evt = queue.poll();
            cus.generateCustomers(evt);
        }

        System.out.println("Current time is after adding customers to the queue: " + Clock.getInstance().getTimeMs());

        //liikutetaan kelloo vähän eteenpäi niiku tehtävä määrittää (?)
        Clock.getInstance().advanceTimeMs(500);

        ser.serve();
    }
}
