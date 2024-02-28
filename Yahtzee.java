/**
 * Implementation of the Yahtzee Class - returns a score of 50 when player rolls 5 of a kind
 */
public class Yahtzee extends Category {
    /**
     * evaluate overide denote score of 50
     * @param d Dice arraylist to evaluate
     * @return sum int value of sum of die in dice
     */
    @Override
    public int evaluate(Dice d) {
        for (int i = 1; i <= 6; i++) {
            if (d.count(i) == 5) {
                return 50;
            }
        }
        return 0;
    }
}