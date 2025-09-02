public class ClockTester {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        clock.setTimeMs(200);

        System.out.println("Clock time is: " + clock.getTimeMs());

    }
}
