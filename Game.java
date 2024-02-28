/**
 * The Game class represents a Yahtzee game with two players. It includes methods to
 * play the game, take turns for each player, and handle the scoring of categories based on
 * user input.
 */
import java.util.Scanner;

public class Game {
    private ScoreCard p1, p2;
    private final int NUM_ROUNDS = 13;
    private DiceRoll dice;

    /**
     * Main constructor for the Game class. Initializes player scorecards, dice, and
     * prints a welcome message.
     */
    public Game() {
        p1 = new ScoreCard();
        p2 = new ScoreCard();
        dice = new DiceRoll();
        System.out.println("*******************************************************\n" +
                           "                   WELCOME TO YAHTZEE\n" +
                           "*******************************************************");
    }

    /**
     * Initiates the Yahtzee game, allowing each player to take turns for a fixed number of rounds.
     * Prints the winner or a tie message at the end of the game.
     */
    public void playGame() {
        for (int round = 1; round <= NUM_ROUNDS; round++) {
            System.out.println("*** Player 1: ***");
            takeTurn(p1);

            System.out.println("*** Player 2: ***");
            takeTurn(p2);
        }

        if (p1.score() > p2.score()) {
            System.out.println("Player 1 Wins!!");
        } else if (p2.score() > p1.score()) {
            System.out.println("Player 2 Wins!!");
        } else {
            System.out.println("The game was a tie");
        }
    }

    /**
     * Handles the turn for a player, allowing them to roll the dice, choose which dice to save,
     * and score a category based on user input.
     *
     * @param sc The ScoreCard for the current player.
     */
    private void takeTurn(ScoreCard sc) {
        // Initialization of variables
        int rolls = 1;
        boolean scored = false;
        boolean[] saved = new boolean[5];

        // Toss the dice
        dice.toss();

        // Get user input
        Scanner input = new Scanner(System.in);
        String choice = "";

        // While not scored or rolls <= 3
        while (rolls <= 2 && !choice.equals("score")) {
            // Display scorecard and dice status
            System.out.println("Current Scorecard:\n" + sc);
            System.out.println("******************************");

            for (int i = 0; i < dice.getNumDice(); i++) {
                if (saved[i]) {
                    System.out.println(String.format("%d: value %d %6s", (i + 1), dice.getDie(i).getValue(), "SAVE"));
                } else {
                    System.out.println(String.format("%d: value %d", (i + 1), dice.getDie(i).getValue()));
                }
            }

            // Prompt user for input
            System.out.println("Please select a die # to toggle it between save and unsave, \"roll\" or \"score\":");
            // Get user input
            choice = input.nextLine();

            if (choice.equals("roll")) {
                // Roll unsaved dice
                for (int i = 0; i < dice.getNumDice(); i++) {
                    if (!saved[i]) {
                        dice.getDie(i).roll();
                    }
                }
                rolls++;
            } else if (choice.equals("score")) {
                score(sc);
                scored = true;
            } else {
                try {
                    int index = Integer.parseInt(choice);

                    if (index >= 0 && index <= saved.length) {
                        saved[index - 1] = !saved[index - 1];
                    } else {
                        System.out.println(choice + " is not a valid die value\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(choice + " is not a valid die value\n");
                }
            }
        }

        if (!scored) {
            System.out.print(dice);
            System.out.print("You have reached your maximum number of rolls. Now choose a category to score.");
            score(sc);
        }
    }

    /**
     * Handles the scoring of a category for a player based on user input.
     *
     * @param sc The ScoreCard for the current player.
     */
    private void score(ScoreCard sc) {
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        String choice = null;
        CategoryValue category = null;

        // While input is valid
        while (!valid) {
            // Display available scoring options
            for (CategoryValue cv : CategoryValue.values()) {
                // Determining available categories
                if ((cv == CategoryValue.YAHTZEE && sc.getCategoryScore(cv) == 50) || (!sc.checkScored(cv))) {
                    System.out.println(String.format("%d: %s, %d points", cv.getValue() + 1, cv.toString(), sc.getEvaluation(cv, dice)));
                }
            }

            // Prompt user for input
            System.out.println("Select a category that you have not scored in yet:\n");
            choice = input.nextLine();

            // Parse user input
            if (choice.equals("1")) {
                category = CategoryValue.ONES;
            } else if (choice.equals("2")) {
                category = CategoryValue.TWOS;
            } else if (choice.equals("3")) {
                category = CategoryValue.THREES;
            } else if (choice.equals("4")) {
                category = CategoryValue.FOURS;
            } else if (choice.equals("5")) {
                category = CategoryValue.FIVES;
            } else if (choice.equals("6")) {
                category = CategoryValue.SIXES;
            } else if (choice.equals("7")) {
                category = CategoryValue.THREE_OF_A_KIND;
            } else if (choice.equals("8")) {
                category = CategoryValue.FOUR_OF_A_KIND;
            } else if (choice.equals("9")) {
                category = CategoryValue.FULL_HOUSE;
            } else if (choice.equals("10")) {
                category = CategoryValue.SM_STRAIGHT;
            } else if (choice.equals("11")) {
                category = CategoryValue.LG_STRAIGHT;
            } else if (choice.equals("12")) {
                category = CategoryValue.YAHTZEE;
            } else if (choice.equals("13")) {
                category = CategoryValue.CHANCE;
            }

            if (category != null && !sc.checkScored(category)) {
                valid = true;
            } else if (category != null && sc.checkScored(category)) {
                System.out.println("That category has already been scored, choose another...");
            } else {
                System.out.println(choice + " is invalid, choose one of the available categories.");
            }
        }

        sc.choose(category, dice);
        System.out.printf("You scored %d in %s\n", sc.getCategoryScore(category), category);
    }
}
