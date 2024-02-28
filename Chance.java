/**
 * Chance category implementation
 * Sums die in dice and returns sum
 */
public class Chance extends Category {
    /**
     * evaluate overide sum of all die in dice
     * @param d Dice arraylist to evaluate
     * @return sum int value of sum of die in dice
     */
    @Override
    public int evaluate(Dice d) {
        int sum = 0;
        for (Die die : d.getDice()) {
            sum += die.getValue();
        }
        return sum;
    }
}
