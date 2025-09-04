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

    public void scheduleNext(PriorityQueue<Event> eventList) {
        long randomizedEventTime = (long) (neg.sample() + (1000 * (Math.random() + 1)));
        long delta = Math.max(200, randomizedEventTime);
        //välillä Math.max jätti 0 tulokseski ja alla oleva if koittaa selvittää milloin. Ei olennainen tehtävää
        if (delta <= 0) {
            System.out.println("Random number: " + randomizedEventTime);
        }
        Clock.getInstance().advanceTimeMs(delta);
        long arrTime = Clock.getInstance().getTimeMs();
        evt = new Event("Arrival"+index, arrTime, this.eventType);
        eventList.add(evt);
        index++;
        }

}