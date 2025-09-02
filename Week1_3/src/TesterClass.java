import java.lang.reflect.Array;
import java.util.PriorityQueue;

public class TesterClass {
    public static void main(String[] args) {
        int numOfArrivals = 10;
        ArrivalProcess arr = new ArrivalProcess(numOfArrivals);
        int iterationCycle = arr.queue.size();
        for (int i = 0; i < iterationCycle; i++) {
            Event evt = arr.queue.poll();
            System.out.println(evt.toString());
        }
    }
}
