/**
 * Implementation of Large Straight category - returns score of 40 when there are 5 die in a row
 */
public class LgStraight extends Category {
    /**
     * evaluate override if 5 dice in a row return score of 40
     * @param d Dice arraylist to evaluate
     * @return sscore corresponding to large straight
     */
    @Override
    public int evaluate(Dice d) {
        for (int i = 1; i <= 2; i++) {
            if (d.count(i) > 0 && 
            d.count(i + 1) > 0 && 
            d.count(i + 2) > 0 && 
            d.count(i + 3) > 0 && 
            d.count(i+ 4) > 0) {
                return 40;
            }
        }
        return 0;
    }
}
