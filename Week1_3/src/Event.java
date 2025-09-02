public class Event  implements Comparable<Event> {
    private String name;
    private final int eventTime;
    private static int eventTimeIndex = 1;
    private final EventType eventType;

    public Event (String name, int eventTime, EventType type) {
        this.name = name;
        this.eventTime = eventTime;
        this.eventType = type;
        eventTimeIndex++;

    }

    //Varmistaa että poll metodissa tulee oikea kronologinen järjestys
    @Override
    public int compareTo(Event o) {
        return eventTime-o.eventTime;
    }

    public double getEventTime() {
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
        return "number of event: " + this.eventTime + " name: " + this.name + " event type: " + this.eventType;
    }
}
