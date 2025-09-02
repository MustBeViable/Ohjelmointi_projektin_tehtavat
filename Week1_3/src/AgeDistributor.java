public class AgeDistributor {
    public static void main(String[] args) {
        final long REITERATIONS = 2000000000L;
        final int MAX_AGE = 35;
        final int MIN_AGE = 20;
        final int nanoConvertor = 1000000000;

        int agedistribution[][] = {
                {16, MIN_AGE},
                {34, 21},
                {52, 22},
                {68, 23},
                {82, 24},
                {89, 25},
                {94, 26},
                {96, 28},
                {98, 30},
                {100,MAX_AGE},
        };

        int generatedAges[] = new int[MAX_AGE+1];

        long startTime = System.nanoTime();

        for (long i = 1; i <= REITERATIONS; i++){
            int x = (int)(Math.random()*100)+1;
            int j = 0;
            while (x > agedistribution[j][0]) j++;
            generatedAges[agedistribution[j][1]]++;
        }

        long endTime = System.nanoTime();


        System.out.println("Age  count     %-share");
        for (int age = 0; age <= MAX_AGE; age++) {
            if (generatedAges[age] != 0) {
                String str = "%-4d %-8d %-8.2f\n";
                System.out.printf(str, age, generatedAges[age], ((double)generatedAges[age])/REITERATIONS*100 );
            }
        }
        System.out.println("Operation lasted: " + ((endTime - startTime)/nanoConvertor) + " seconds");
    }
}