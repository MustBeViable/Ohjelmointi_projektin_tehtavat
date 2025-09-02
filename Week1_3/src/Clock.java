public class Clock {
    private static Clock clock;
    private long timeMs = 0;

    private Clock() {}


    public static Clock getInstance() {
        if (clock == null) {
            clock = new Clock();
        }
        return clock;
    }

    //varmaa joku metodi joka antaa jonkun eventin timerin
    public Long getTimeMs() {
        return timeMs;
    }

    //Increments time of
    public void setTimeMs(long newTime) {
        timeMs += newTime;
    }
}
