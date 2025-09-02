import eduni.distributions.Negexp;

import java.util.PriorityQueue;
import java.util.Random;

public class ArrivalProcess {
    Random random = new Random(1121211);
    Negexp neg = new Negexp(10, random.nextInt());
    Event evt;
    PriorityQueue<Event> queue;


    public ArrivalProcess(int events) {
        queue = new PriorityQueue<>();
        for (int i = 0; i < events; i++) {
            evt = new Event("Jee" + i, (int) neg.sample() , EventType.EVENT_TYPE_A);
            queue.add(evt);
        }
    }
}