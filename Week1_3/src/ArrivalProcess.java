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
        long delta = Math.max(0L,(long)neg.sample());
        Clock clock = Clock.getInstance();
        clock.advanceTimeMs(delta);
        evt = new Event("Arrival"+index, clock.getTimeMs(), this.eventType);
        eventList.add(evt);
        index++;
        return evt;
        }

}