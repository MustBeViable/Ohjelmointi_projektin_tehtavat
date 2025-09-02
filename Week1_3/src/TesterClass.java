import java.util.PriorityQueue;

public class TesterClass {
    public static void main(String[] args) {
        PriorityQueue<Event> queue = new PriorityQueue<>();
        int numOfArrivals = 10;
        ArrivalProcess arr = new ArrivalProcess(EventType.EVENT_TYPE_A);
        for (int i = 0; i < numOfArrivals; i++) {
            arr.scheduleNext(queue);
        }

        int iterationCycle = queue.size();
        for (int i = 0; i < iterationCycle; i++) {
            Event evt = queue.poll();
            System.out.println(evt.toString());
        }
    }
}
