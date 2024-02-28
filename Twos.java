/**
 * Implementation of ones class - returns sum of all die with value 2 in dice
 */
public class Twos extends Category{
    /**
     * evaluate overide sum of all die with value 2 in dice
     * @param d Dice to evaluate
     * @return count of dice with value 2 * 2
     */
    @Override
    public int evaluate(Dice d) {
        return d.count(2) * 2;
    }
}
