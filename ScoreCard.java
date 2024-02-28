/**
 * The ScoreCard class represents the scorecard for a Yahtzee game. It includes methods to
 * choose a category and add the appropriate score based on the dice, check the evaluation
 * of a category with a given set of dice, determine if a category has been scored or not,
 * get the existing score of a category, score the top and bottom sections of the scorecard,
 * score all categories, and provides a custom toString method.
 */
import java.util.ArrayList;

public class ScoreCard {
    private ArrayList<Category> scorecard;
    private int yahtzeeBonus;
    private static final int NUM_CATS = 13;

    /**
     * Main constructor, initializes the scorecard with each category and sets yahtzeeBonus to 0.
     */
    public ScoreCard() {
        scorecard = new ArrayList<>(NUM_CATS);
        yahtzeeBonus = 0;

        scorecard.add(new Ones());
        scorecard.add(new Twos());
        scorecard.add(new Threes());
        scorecard.add(new Fours());
        scorecard.add(new Fives());
        scorecard.add(new Sixes());
        scorecard.add(new ThreeOfAKind());
        scorecard.add(new FourOfAKind());
        scorecard.add(new FullHouse());
        scorecard.add(new SmStraight());
        scorecard.add(new LgStraight());
        scorecard.add(new Yahtzee());
        scorecard.add(new Chance());
    }

    /**
     * Chooses a category and adds the appropriate score based on the dice.
     *
     * @param cv The CategoryValue representing the chosen category.
     * @param d The Dice object representing the current dice configuration.
     */
    public void choose(CategoryValue cv, Dice d) {
        // Check for Yahtzee bonus
        if (cv == CategoryValue.YAHTZEE && scorecard.get(cv.getValue()).getScore() == 50) {
            yahtzeeBonus++;
        } else {
            scorecard.get(cv.getValue()).addValue(d);
        }
    }

    /**
     * Gets the evaluation score of a category with a given set of dice.
     *
     * @param cv The CategoryValue representing the category to evaluate.
     * @param d The Dice object representing the current dice configuration.
     * @return The evaluation score of the specified category.
     */
    public int getEvaluation(CategoryValue cv, Dice d) {
        return scorecard.get(cv.getValue()).evaluate(d);
    }

    /**
     * Checks if a category has been scored.
     *
     * @param cv The CategoryValue representing the category to check.
     * @return True if the category has been scored; false otherwise.
     */
    public boolean checkScored(CategoryValue cv) {
        return scorecard.get(cv.getValue()).getUsed();
    }

    /**
     * Gets the existing score of a category.
     *
     * @param cv The CategoryValue representing the category to get the score for.
     * @return The existing score of the specified category.
     */
    public int getCategoryScore(CategoryValue cv) {
        return scorecard.get(cv.getValue()).getScore();
    }

    /**
     * Scores the top section of the scorecard.
     *
     * @return The total score of the top section, including any bonus.
     */
    public int scoreTop() {
        int topScore = 0;
        for (CategoryValue value : CategoryValue.values()) {
            if (value.getValue() <= 6) {
                topScore += getCategoryScore(value);
            }
        }
        // Check for top score bonus
        if (topScore >= 63) {
            topScore += 35;
        }
        return topScore;
    }

    /**
     * Scores the bottom section of the scorecard.
     *
     * @return The total score of the bottom section.
     */
    public int scoreBottom() {
        int bottomScore = 0;
        for (CategoryValue value : CategoryValue.values()) {
            if (value.getValue() > 6) {
                bottomScore += getCategoryScore(value);
            }
        }
        return bottomScore;
    }

    /**
     * Scores all categories on the scorecard.
     *
     * @return The total score of the scorecard, including any bonuses.
     */
    public int score() {
        return scoreTop() + scoreBottom() + (yahtzeeBonus * 100);
    }

    /**
     * Overrides the default toString method to provide a custom string representation
     * of the ScoreCard.
     *
     * @return A string representation of the ScoreCard.
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < NUM_CATS; i++) {
            CategoryValue cv = CategoryValue.values()[i];
            s += String.format("%s: %d\n", cv, getCategoryScore(cv));
        }
        s += "Yahtzee Bonus: " + yahtzeeBonus * 100 + "\n";
        s += "Upper Total: " + scoreTop() + "\n";
        s += "Lower Total: " + scoreBottom() + "\n";
        s += "Total: " + score() + "\n";
        return s;
    }
}
