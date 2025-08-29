public class Event  implements Comparable<Event> {
    private String name;
    private final int eventTime;
    private static int eventTimeIndex = 1;
    private final EventType eventType;

    public Event (String name) {
        this.name = name;
        this.eventTime = eventTimeIndex;
        if (eventTimeIndex%3==0) {
            this.eventType = EventType.EVENT_TYPE_B;
        } else {
            this.eventType = EventType.EVENT_TYPE_A;
        }
        eventTimeIndex++;

    }

    //Varmistaa että poll metodissa tulee oikea kronologinen järjestys
    @Override
    public int compareTo(Event o) {
        return eventTime-o.eventTime;
    }

    public int getEventTime() {
        return this.eventTime;
    }

    public String getName() {
        return this.name;
    }

    public EventType getEventType() {
        return this.eventType;
    }
}
