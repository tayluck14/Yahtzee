/**
 * Implementation of Fullhouse category - returns score of 25 when 3 of a kind and two of a kind are present
 */
public class FullHouse extends Category{
    /**
     * evaluate override returns score of 25 regardless of die values as long as full house is achieved
     * @param d Dice arraylist to evaluate
     * @return int score for full house
     */
    @Override
    public int evaluate(Dice d) {
        boolean full = false;
        boolean of = false;

        for (int i = 1; i <= 6; i++) {
            if (d.count(i) == 3) {
                full = true;
            } else if (d.count(i) == 2) {
                of = true;
            }
        }

        if (full && of) {
            return 25;
        }

        return 0;
    }
}
