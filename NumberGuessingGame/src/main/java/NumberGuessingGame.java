import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1-100
            int attempts = 0;
            int maxAttempts = 10; // Limit attempts per round
            boolean guessedCorrectly = false;
            int roundScore = 100; // Initial score for the round

            System.out.println("\nI have chosen a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundScore -= (attempts - 1) * 10; // Deduct points for each incorrect attempt
                    totalScore += roundScore;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("🔼 Too low! Try again.");
                } else {
                    System.out.println("🔽 Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all " + maxAttempts + " attempts! The correct number was: " + numberToGuess);
                roundScore = 0; // No points if the user fails to guess
            }

            System.out.println("Your score this round: " + roundScore);
            System.out.println("Total Score: " + totalScore);

            // Ask for another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
