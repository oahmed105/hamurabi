import java.util.Random;
import java.util.Scanner;

public class TempHammurabi {

    private  int totalDeaths = 0, percentDied = 0, year = 0, population = 95, bushels = 2800, immigrants = 5, deaths,
            harvest = 3000, yield = 3, acres = 1000, eaten = harvest - bushels, landPrice = 19, fullPeople;

    static boolean plague = false;

    final static String FINK = "DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY\n" +
            "BEEN IMPEACHED AND THROWN OUT OF OFFICE BUT YOU HAVE\n" +
            "ALSO BEEN DECLARED PERSONA NON GRATA!!\n";

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TempHammurabi().playGame();
    }

    void playGame() {

        for (int i = 0; i < 10; i++) {
            int acresToBuy = askHowManyAcresToBuy( landPrice, bushels);
                if (acresToBuy == 0) {

            int acresToSell = askHowManyAcresToSell(acres);
                }

            int grainToFeed = askHowMuchGrainToFeedPeople(bushels);

            int acresToPlant = askHowManyAcresToPlant(acres, population, bushels);


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
        bushels -= temp * price;

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
        bushels += temp * landPrice;
        this.acres -= temp;
        return temp;
    }
    int askHowMuchGrainToFeedPeople(int bushels) {
        int temp;
        do {
            System.out.print("\nHOW MANY BUSHELS DO YOU WISH TO FEED YOUR PEOPLE?  ");
            temp = scanner.nextInt();
            if (temp < 0)

            if (temp > bushels)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
        } while (temp > bushels);
        fullPeople = temp / 20;
        bushels -= temp;
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
//        bushels -= temp;
//        return temp;
        do {
            System.out.print("\nHOW MANY ACRES DO YOU WISH TO PLANT WITH SEED?  ");
            temp = scanner.nextInt();
            if (temp < 0)

            if (temp > acresOwned)
                System.out.println("HAMURABI:  THINK AGAIN. YOU OWN ONLY " + acresOwned + " ACRES. NOW THEN,");
            if (temp / 2 > bushels)
                System.out.println("HAMURABI:  THINK AGAIN. YOU HAVE ONLY\n" +
                        bushels + " BUSHELS OF GRAIN. NOW THEN,");
            if (temp > population * 10)
                System.out.println("BUT YOU HAVE ONLY" + population + "PEOPLE TO TEND THE FIELDS. NOW THEN,");
        } while (temp > acresOwned || temp / 2 > bushels || temp > population * 10);
        bushels -= temp / 2;
        return temp;
    }

    int plagueDeaths(int population) {
        if (random.nextInt(100) < 15) {
           population = population / 2;
        }
        return population;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        bushelsFedToPeople = bushels / 20;
        return deaths;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        return false;
    }

    public int immigrants(int population, int acresOwned, int grainInStorage) {
        immigrants = (20 * acresOwned + grainInStorage) / (100 * population) + 1;
        return immigrants;
    }

//    public int harvest(int acres, int bushelsUsedAsSeed) {
//        int number = random.nextInt(6 - 1 + 1) + 1;
//        bushels = number * acres;
//
//        return bushels;
//    }

    public int harvest(int acres, int bushels) {
        int number = random.nextInt(6 - 1 + 1) + 1;
        bushels = number * acres;

        return bushels;
    }

    public int grainEatenByRats(int bushels) {
        int percentage = random.nextInt(100);
        if (percentage < 40) {
            if (percentage < random.nextInt(30 - 10 + 1) + 10) {
                bushels = eaten;

            }

        }
        return bushels;
    }

    public int newCostOfLand() {
        int landPrice = random.nextInt(23 - 17 + 1) + 17;

        return landPrice;
    }

//    private static void epicFail(int x) {
//        String reason = "";
//        switch (x) {
//            case 0: reason = "HAMURABI:  I CANNOT DO WHAT YOU WISH.\n" +
//                    "GET YOURSELF ANOTHER STEWARD!!!!!"; break;
//            case 1: reason = "YOU STARVED " + deaths + " PEOPLE IN ONE YEAR!!!\n" +
//                    FINK; break;
//        }
//        System.out.println(reason);
//        System.exit(0);
//    }


}
