import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RaffleWinner {
    public static void main(String[] args) {
        RaffleWinner test = new RaffleWinner();
        test.raffleWinner();
    }

    public void raffleWinner() {
        int min, max;
        String raffleName;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome to the Raffle Winner Program!");

            System.out.println("What is the name of the raffle?");
            raffleName = scanner.nextLine();
            String formattedName = formatRaffleName(raffleName);

            do {
                System.out.println("What is the smallest raffle ticket number?");
                min = Integer.parseInt(scanner.nextLine());

                System.out.println("What is the largest raffle ticket number?");
                max = Integer.parseInt(scanner.nextLine());

                if (min <= 0 || max <= 0) {
                    System.out.println("Ticket numbers must be positive.");
                    continue;
                }

                if (max - min < 2) {
                    System.out.println("There must be at least 3 tickets sold.");
                    continue;
                }

                break;
            } while (true);


            System.out.println("The winning raffle ticket numbers in the " + formattedName + " raffle are: ");

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < 4; i++) {
                int randomNumber = generateRandomNumber(min, max);
                while (!set.add(randomNumber)) {
                    randomNumber = generateRandomNumber(min, max);
                }
                System.out.println("Winner " + i + ": " + randomNumber);
            }

            System.out.println("Do you want to run another raffle? y or n");

            if (!scanner.nextLine().equals("y")) {
                break;
            }
        } while (true);
    }

    private String formatRaffleName(String raffleName) {
        return raffleName.toUpperCase().replace(' ', '_');
    }

    private int generateRandomNumber(int minimumValue, int maximumValue) {
        Random generator = new Random();
        int randomNumber = generator.nextInt(maximumValue - minimumValue + 1)
                + minimumValue;
        return randomNumber;
    }
}
