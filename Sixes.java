/**
 * Implementation of Sixes - sums all die with value 6 in dice
 */
public class Sixes extends Category{
    /**
     * evaluate overide sum of all die with value 6 in dice
     * @param d Dice arraylist to evaluate
     * @return scount of dice with value 6 * 6
     */
    @Override
    public int evaluate(Dice d) {
        return d.count(6) * 6;
    }
}