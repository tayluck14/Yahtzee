/**
 * Implementation for Four of a Kind Category -  returns value of all die when 4 are of equal value
 */
public class FourOfAKind extends Category{
    /**
     * evaluate override, sums the value of all dice when 4 of the same value exist
     * @param d Dice arraylist to evaluate
     * @return sum int value of sum of die in dice
     */
    @Override
    public int evaluate(Dice d) {
        int sum = 0; // initialize sum
        for (int i = 1; i <= 6; i++) {
            if (d.count(i) >= 4) {
                for (Die die : d.getDice()) {
                    sum += die.getValue();
                }
                return sum;
            }
        }

        return 0;
    }
}
