/**
 * DiceRoll is a dice,
 * rolls a Dice and denotes each die a value
 */
public class DiceRoll extends Dice{
    private final int NUM_DIE = 5;
    /**
     * Sole constructor for DiceRoll
     * populates dice with 5 die
     */
    public DiceRoll(){
        for (int i = 0; i < NUM_DIE; i++) {
            addDie(new Die());
        }
    }

    /**
     * method to roll dice in arraylist
     */
    public void toss(){
        for (Die die : getDice()) {
            die.roll();
        }
    }
}
