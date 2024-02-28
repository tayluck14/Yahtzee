/**
 * Implementation of Fours categor - returns sum of all fours
 */
public class Fours extends Category{
    /**
     * evaluate override sum of all die with value 4 in dice
     * @param d Dice arraylist to evaluate
     * @return num dice with value 4 * 4
     */
    @Override
    public int evaluate(Dice d) {
        return d.count(4) * 4;
    }
}
