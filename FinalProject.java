/*
 We have abided by the UNCG Academic Honor Code on this assignment.
 This will be an intricate game turned in for our final project grade.
 Anthony Garcia and Storm West
 12/08/2014
 */

// Imported to allow user input.
import java.util.Scanner;
// Imported to assign random integers when needed.
import java.util.Random;
// Imported to allow the usage of an ArrayList.
import java.util.ArrayList;

public class FinalProject {

    // Used to pass the values needed to calculate the score.
    private static int UserGuessScore;
    private static int ComputerGuessScore;
    
    public static void main(String[] args) {
        // Used to print out information for the user from methods within the program.
        System.out.println("Welcome to Anthony Garcia's and Storm West's Java game!"
                + " Please enjoy your stay! \nWelcome to The"
                + " Mystery Number Game!");
        userMethod();
        computerMethod();
        scoreMethod();
    }
    // This method is used to organize and hold the user's guesses.
    public static void userMethod() {
        // Establish variables that will be used within the userMethod.
        Scanner userScanner = new Scanner(System.in);
        Random userRandom = new Random();
        int randomNumber = userRandom.nextInt(1000) + 1;
        int user, uScore = 0;
        // Create an ArrayList to hold previous guesses.
        ArrayList<Integer> array = new ArrayList<>();
        // Inform the user about this portion of the game.
        System.out.println("This part of the game will be based on YOUR calculated"
                + " guessing!");
        do {
            // Tell the user the main purpose of the game.
            System.out.println("Guess the Artificial Intelligence's number!"
                    + " The A.I. will limit the "
                    + "range between the integers 1 - 1000. ");
            // Used to allow the user to input their guesses.
            user = userScanner.nextInt();
            if (user < 1 || user > 1000) {
                System.out.println("The user entered an integer outside of the"
                        + " range.");
            } else // Set conditions to help the user reach the number.
            if (user > randomNumber) {
                System.out.println("Your guess is too HIGH! Your guess was: "
                        + user);
                array.add(user);
                System.out.print("Your preceding calculated guesses were: ");
                for (Integer PreviousGuesses : array) {
                    System.out.print("(" + PreviousGuesses + ")" + " ");
                }
                System.out.print("\n");
                uScore++;
            } else if (user < randomNumber) {
                System.out.println("Your guess is too LOW! Your guess was: "
                        + user);
                array.add(user);
                System.out.print("Your preceding calculated guesses were: ");
                for (Integer PreviousGuesses : array) {
                    System.out.print("(" + PreviousGuesses + ")" + " ");
                }
                System.out.print("\n");
                uScore++;
            }
        } while (user != randomNumber);
        System.out.println("The user has guessed the correct number. Proceed"
                + " forward into the game.");
        System.out.println("The user has guessed " + uScore + " times.");
        UserGuessScore = uScore;
    }
    // This method is used to organize and hold the computer's guesses.
    public static void computerMethod() {
        // Establish variables that will be used within the computerMethod
        int user, computer, cScore = 0;
        // Computer's guessing range.
        int lowestGuessNumber = 1, highestGuessNumber = 1000;
        // Used to allow the user to input their integer.
        Scanner input = new Scanner(System.in);
        // Create an ArrayList for the computer's guesses.
        ArrayList<Integer> array = new ArrayList<>();
        // Used to collect the user's integer.
        System.out.println("Welcome to the second part of the game! "
                + "Enter an integer user. Between 1 - 1000:");
        user = input.nextInt();
        // Creates a condition for the user.
        if (user < 1 || user > 1000) {
            System.out.println("The user entered an integer outside of the"
                    + "range.");
        } else {
            System.out.println("The integer you have chosen has been encrypted."
                    + "\nThe integer you have chosen is: " + user + ". \nThe "
                    + "Artificial Intelligence will proceed to guess for: " + user);
        }
        // Logic behind the computer's intelligence.
        computer = (highestGuessNumber + lowestGuessNumber) / 2;
        System.out.print("The computer's calculated guesses were:");
        do {
            if (computer < user) {
                lowestGuessNumber = computer;
                computer = (highestGuessNumber + lowestGuessNumber) / 2;
                array.add(computer);
                cScore++;
            } else {
                highestGuessNumber = computer;
                computer = (highestGuessNumber + lowestGuessNumber) / 2;
                array.add(computer);
                cScore++;
            }
        } while (user != computer);
        for (Integer PreviousGuesses : array) {
            System.out.print("(" + PreviousGuesses + ")" + " ");
        }
        System.out.println("\nThe computer has guessed: " + cScore + " times.");
        ComputerGuessScore = cScore;
    }
    public static void scoreMethod() {
        // Calculates the score.
        int finalScore;
        if (ComputerGuessScore > UserGuessScore) {
            finalScore = ComputerGuessScore - UserGuessScore;
            System.out.println("The user beat the computer by this many guesses: " + finalScore);
        } else {
            finalScore = UserGuessScore - ComputerGuessScore;
            System.out.println("The computer beat the user by this many guesses: " + finalScore);
        }
    }
}
