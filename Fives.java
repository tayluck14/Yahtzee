/**
 * Implementation of Fives Category
 * Returns number of 5s in Dice * 5
 */
public class Fives extends Category{
    /**
     * evaluate overide sum of all die with value 5 in dice
     * @param d Dice arraylist to evaluate
     * @return scount of dice with value 5 * 5
     */
    @Override
    public int evaluate(Dice d) {
        return d.count(5) * 5;
    }
}