public class Event  implements Comparable<Event> {
    private String name;
    private final int eventTime;
    private static int eventTimeIndex = 1;

    public Event (String name) {
        this.name = name;
        this.eventTime = eventTimeIndex;
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

}
