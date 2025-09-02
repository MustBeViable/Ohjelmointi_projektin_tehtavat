public class Event  implements Comparable<Event> {
    private String name;
    private final long eventTime;
    private static int eventTimeIndex = 1;
    private final EventType eventType;

    public Event (String name, long eventTime, EventType type) {
        this.name = name;
        this.eventTime = eventTime;
        this.eventType = type;
        eventTimeIndex++;

    }

    //Varmistaa että poll metodissa tulee oikea kronologinen järjestys
    @Override
    public int compareTo(Event o) {
        return Long.compare(eventTime, o.eventTime);
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public String getName() {
        return this.name;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    @Override
    public String toString() {
        return "Arrival time: " + this.eventTime + " name: " + this.name + " event type: " + this.eventType;
    }
}
