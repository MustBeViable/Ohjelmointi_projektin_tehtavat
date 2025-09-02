public class Clock {
    private static Clock clock;
    private long timeMs;

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

    public void setTimeMs(long newTime) {
        timeMs = newTime;
    }
}
