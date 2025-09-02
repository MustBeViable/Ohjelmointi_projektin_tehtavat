import java.util.Random;

public class RandomSeedTest {
    public static void main(String[] args) {
        long seed = 123;
        Random random = new Random(seed);
        int randomAmount = 10;
        for (int i = 0; i < randomAmount; i++) {
            System.out.println(random.nextInt(100));;
        }
    }
}
