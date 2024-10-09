import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    // Function to play one round of the game
    public static int playRound(int min, int max, int maxAttempts) {
        Random random = new Random();
        int numberToGuess = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        int points = 0;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess a number between " + min + " and " + max + ". You have " + maxAttempts + " attempts.");
        
        while (attempts < maxAttempts) {
            attempts++;
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            
            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the number.");
                points = 100 - (attempts - 1) * 10; // Decrease points with more attempts
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("The number is higher than " + userGuess);
            } else {
                System.out.println("The number is lower than " + userGuess);
            }
        }
        
        if (attempts == maxAttempts) {
            System.out.println("Sorry! You've used all your attempts. The number was: " + numberToGuess);
            points = 0; // No points if user runs out of attempts
        }
        
        return points;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int totalRounds, maxAttempts = 10, min = 1, max = 100;
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number game!");

        // Setting number of rounds
        System.out.print("Enter the number of rounds you want to play: ");
        totalRounds = scanner.nextInt();

        // Game loop for multiple rounds
        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\n--- Round " + round + " ---");
            int points = playRound(min, max, maxAttempts);
            totalScore += points;
            System.out.println("Round " + round + " score: " + points);
        }

        // Displaying final score
        System.out.println("\nGame over! Your total score is: " + totalScore);
    }
}
