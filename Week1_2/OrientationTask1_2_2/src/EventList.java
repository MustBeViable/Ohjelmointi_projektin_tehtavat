import java.util.Collections;
import java.util.PriorityQueue;

public class EventList{
    private final PriorityQueue<Event> priorityQueue = new PriorityQueue<>();

    private void addPriotityQueue(Event evt) {
        priorityQueue.add(evt);
    }

    public PriorityQueue<Event> getPriorityQueue () {
        return this.priorityQueue;
    }

    public static void main(String[] args) {
        int testEvents = 1000;
        EventList evtList = new EventList();

        for (int i=0; i<testEvents; i++) {
            String evtName = "testEvent"+(i+1);
            Event evt = new Event(evtName);
            evtList.addPriotityQueue(evt);
        }


        System.out.println("First in queue (which is going to be deleted) : " + evtList.priorityQueue.peek().getName()
                + " with event time: " + evtList.priorityQueue.peek().getEventTime());
        System.out.println(" ");
        //Poistaa ekan eli a) kohta
        evtList.priorityQueue.poll();

        //Tää poll() tuhoaa listan, jos esim haluaa, nii tekee kopion ja tuhoo kopion tällä poll() metodilla.
        System.out.println("Events sorted by event time: ");
        System.out.println(" ");
        while (!evtList.priorityQueue.isEmpty()) {
            Event evt = evtList.priorityQueue.poll();
            System.out.printf("Name: %s event time: %d\n", evt.getName(), evt.getEventTime());
        }
    }

}
