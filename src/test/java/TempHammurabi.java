import java.util.Random;
import java.util.Scanner;

public class TempHammurabi {

    private  int totalDeaths = 0, percentDied = 0, year = 0, population = 95, storesOfGrain = 2800, immigrants = 5, deaths,
            harvest = 3000, yield = 3, acres = 1000, eaten = harvest - storesOfGrain, landPrice = 19, fullPeople;

    static boolean plague = false;

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TempHammurabi().playGame();
    }

    void playGame() {

        for (int i = 0; i < 10; i++) {
            int acresToBuy = askHowManyAcresToBuy( landPrice, storesOfGrain);
                if (acresToBuy == 0) {

            int acresToSell = askHowManyAcresToSell(acres);
                }

            int grainToFeed = askHowMuchGrainToFeedPeople(storesOfGrain);

            int acresToPlant = askHowManyAcresToPlant(acres, population, storesOfGrain);


        }
    }
    int askHowManyAcresToBuy( int price, int bushels) {
        int temp;
        do {
            System.out.print("HOW MANY ACRES DO YOU WISH TO BUY?  ");
            temp = scanner.nextInt();
            if (temp < 0)

            if (temp * price > bushels)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
        } while (temp * price > bushels);
        acres += temp;
        storesOfGrain -= temp * price;

        return temp;
    }
    int askHowManyAcresToSell(int acres) {
        int temp;
        do {
            System.out.print("HOW MANY ACRES DO YOU WISH TO SELL?  ");
            temp = scanner.nextInt();
            if (temp < 0)

            if (temp > acres)
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acres + " ACRES. NOW THEN,");
        } while (temp > acres);
        storesOfGrain += temp * landPrice;
        this.acres -= temp;
        return temp;
    }
    int askHowMuchGrainToFeedPeople(int bushels) {
        int temp;
        do {
            System.out.print("\nHOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
            temp = scanner.nextInt();
            if (temp < 0)

            if (temp > storesOfGrain)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        storesOfGrain + " BUSHELS OF GRAIN. NOW THEN,");
        } while (temp > storesOfGrain);
        fullPeople = temp / 20;
        storesOfGrain -= temp;
        return temp;
    }
    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        int temp;
//        do {
//            System.out.print("\nHOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
//            temp = scanner.nextInt();
//            if (temp < 0)
//
//            if (temp > bushels)
//                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
//                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
//        } while (temp > bushels);
//        fullPeople = temp / 20;
//        storesOfGrain -= temp;
//        return temp;
        do {
            System.out.print("\nHOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
            temp = scanner.nextInt();
            if (temp < 0)

            if (temp > acresOwned)
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acresOwned + " ACRES. NOW THEN,");
            if (temp / 2 > storesOfGrain)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        storesOfGrain + " BUSHELS OF GRAIN. NOW THEN,");
            if (temp > population * 10)
                System.out.println("BUT YOU HAVE ONLY" + population + "PEOPLE TO TEND THE FIELDS. NOW THEN,");
        } while (temp > acresOwned || temp / 2 > storesOfGrain || temp > population * 10);
        storesOfGrain -= temp / 2;
        return 0;
    }

}
