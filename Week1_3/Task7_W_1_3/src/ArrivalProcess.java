import eduni.distributions.Negexp;

import java.util.PriorityQueue;
import java.util.Random;

public class ArrivalProcess {
    private Random random = new Random();
    private Negexp neg = new Negexp(10, random.nextInt());
    private EventType eventType;
    Event evt;
    static int index = 1;

    public ArrivalProcess(EventType eventType) {
        this.eventType = eventType;
    }

    public Event scheduleNext(PriorityQueue<Event> eventList) {
        long delta = (long) Math.max(200, (neg.sample() + (1000 * (Math.random() + 1))));
        System.out.println("Delta: " + delta);
        Clock.getInstance().advanceTimeMs(delta);
        long arrTime = Clock.getInstance().getTimeMs();
        evt = new Event("Arrival"+index, arrTime, this.eventType);
        eventList.add(evt);
        index++;
        return evt;
        }

}