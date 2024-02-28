/**
 * Implementation of ones class - returns sum of all ones in dice
 */
public class Ones extends Category{
    /**
     * evaluate override sum of all die with value 1 in dice
     * @param d Dice to evaluate
     * @return count of ones in Dice
     */
    @Override
    public int evaluate(Dice d) {
        return d.count(1);
    }
}
