import java.util.Scanner;
import java.util.Random;
public class GuessTheNumberGame {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String[] args) {
        int totalScore = 0;
        int rounds = 3;
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("You have to guess a number between 1 and 100.");
        System.out.println("You get 10 attempts per round.");
        System.out.println("Fewer attempts = higher score!");
        System.out.println("------------------------------------------");
        for (int r = 1; r <= rounds; r++) {
            System.out.println("\n ROUND " + r + " STARTS!");
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1 to 100): ");
                int userGuess = sc.nextInt();
                attempts++;
                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }
            int roundScore = 0;
            if (guessedCorrectly) {
                roundScore = 100 - (attempts - 1) * 10; // 100 for 1st try, 90 for 2nd...
                roundScore = Math.max(roundScore, 10); // Minimum score 10 if guessed within attempts
            } else {
                System.out.println(" Out of attempts! The correct number was: " + numberToGuess);
            }
            System.out.println("Round " + r + " Score: " + roundScore);
            totalScore += roundScore;
        }
        System.out.println("\nGame Over! Your total score: " + totalScore + " out of " + (rounds * 100));
        System.out.println("Thanks for playing!");
    }
}
