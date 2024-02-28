/**
 * Implementation of Four of a kind category - returns sum of all die when 4 die of same value exist in Dice
 */
public class ThreeOfAKind extends Category{
    /**
     * evaluate override sum of all die when  4 die with the same value exist in dice
     * @param d Dice arraylist to evaluate
     * @return sum int value of sum of die in dice
     */
    @Override
    public int evaluate(Dice d) {
        int sum = 0; // initialize sum
        for (int i = 1; i <= 6; i++) {
            if (d.count(i) >= 3) {
                for (Die die : d.getDice()) {
                    sum += die.getValue();
                }
                return sum;
            }
        }

        return 0;
    }
}

