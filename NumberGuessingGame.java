import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int playAgain = 1;

        System.out.println("===== NUMBER GUESSING GAME =====");

        while (playAgain == 1) {

            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nI have selected a number between 1 to 100.");
            System.out.println("You have only " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    guessed = true;

                    System.out.println("Correct! You guessed the number.");

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Score in this round: " + score);

                    break;
                }

                else if (guess > number) {
                    System.out.println("Too high! Try smaller number.");
                }

                else {
                    System.out.println("Too low! Try bigger number.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nYou lost this round.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.println("\nPress 1 to play again.");
            System.out.println("Press 0 to exit.");

            playAgain = sc.nextInt();
        }

        System.out.println("\nThanks for playing!");
        sc.close();
    }
}