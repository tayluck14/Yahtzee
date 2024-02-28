/**
 * Implementation of Small Straight category - returns score of 30 when there are 4 die in a row
 */
public class SmStraight extends Category {
    /**
     * evaluate override if 4 dice in a row return score of 30
     * @param d Dice arraylist to evaluate
     * @return sscore corresponding to small straight
     */
    @Override
    public int evaluate(Dice d) {
        for (int i = 1; i <= 3; i++) {
            if (d.count(i) > 0 && 
            d.count(i + 1) > 0 && 
            d.count(i + 2) > 0 && 
            d.count(i + 3) > 0) {
                return 30;
            }
        }

        return 0;
    }
}
