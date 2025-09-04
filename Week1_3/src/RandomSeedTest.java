import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RandomSeedTest {
    public static void main(String[] args) {
        long seed = 123;
        Random random = new Random(seed);
        int randomAmount = 10;
        for (int i = 0; i < randomAmount; i++) {
            int x = i;
        }
        Scanner scanner = new Scanner(System.in);
        double xd = 23.9999;
        System.out.println("num as integer: " + (int) xd);
        System.out.println("num as rounded: " + Math.round(xd));
        final long gee = 9_223_372_036_854_775_807L;
        int gg = (int) gee;
        System.out.println(gg);

        String test = "kakka";
        String jeesus = "kakka";
        if (jeesus.equals(test)) {
            System.out.println("we got it");
        } else {
            System.out.println("nope");
        }

        String s1 = scanner.nextLine();
        String s2 = "Metropolia";

        if (s1 == s2) {
            System.out.println("1. They are the same");
        }

        if (s1.equals(s2)) {
            System.out.println("2. They are the same");
        }
    }
}
