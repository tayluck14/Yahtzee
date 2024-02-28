/**
 * Implementation of ones class - returns sum of all die with value 3 in dice
 */
public class Threes extends Category{
    /**
     * evaluate overide sum of all die with value 3 in dice
     * @param d Dice arraylist to evaluate
     * @return num dice with value 3 * 3
     */
    @Override
    public int evaluate(Dice d) {
        return d.count(3) * 3;
    }
}
