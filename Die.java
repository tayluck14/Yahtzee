import java.util.Random;
/**
 * Implementation of the Die class
 * One die has 6 sides and generates a random number between 1 and 6 when rolled, has a get value and tostring method
 */
public class Die {
    //declare variables
    private static  final int SIDES = 6;
    private int value;
    private static Random r = new Random();

    /**
     * Sole constructor for die class - rolls die
     */
    public Die(){
        roll();
    }

    /**
     * roll method sets the die value to a random number between 1 and 6
     */
    public void roll(){
        value = r.nextInt(SIDES) + 1;
    }

    /**
     * returs the dies value
     * @return int value of die
     */
    public int getValue(){
        return value;
    }
    /**
     * Override of tostring
     * returns the value of the die as a string
     */
    @Override
    public String toString(){
        return String.format("%d", value);
    }
}
