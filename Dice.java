import java.util.ArrayList;
/**
 * Dice is an arraylist of die, and contains a limit to the number of die - in this case 5
 * contains two sconstructors,
 * a method to add die to the arraylist
 * a method to get the size of the arraylist
 * a method to remove a die from the arraylist
 * a method to get a die from the arraylist
 * a method to count how many die of the same value exist in the arraylist
 * a method to find the summed value of the die in the arraylist
 * a method to determine wether the array list contains a die of a specified value
 * a method to return the arraylist of dice
 * and a to string method listing each die's index and corresponding value
 */
public class Dice {
    //declare variables
    private final int DEF_CAP = 5;
    private ArrayList<Die> dice;
    
    /**
     * Primary constuctor for Dice object
     * creates new arraylist with capacity of 5
     */
    public Dice(){
        dice = new ArrayList<>(DEF_CAP);
    }

    /**
     * Secondary constructor of Dice object
     * creates new arraylist with specified capacity
     * @param num int capacity of arraylist
     */
    public Dice(int num){
        dice = new ArrayList<>(num);
    }

    /**
     * Method to add a die to the end of the arraylist
     * @param d Die to be added
     */
    public void addDie(Die d){
        dice.add(d);
    }

    /**
     * method to return the size of the arraylist
     * @return int size of the arraylist
     */
    public int getNumDice(){
        return dice.size();
    }

    /**
     * Method to roll all dice in arraylist
     */
    public void roll() {
        for (Die die : dice) {
            die.roll();
        }
    }
    /**
     * A method to get the arraylist of die
     * @return Arraylist dice containing die
     */
    public ArrayList<Die> getDice() {
        return dice;
    }

    /**
     * Method to return a die at a specified index
     * @param i int index of die to return
     * @return die at specified index
     */
    public Die getDie(int i){
        if (i >= 0 && i < dice.size()) {
            return dice.get(i);
        } else {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
        }
    }

    /**
     * Method to remove a die at a specified index and return it
     * @param i int index of die to be removed and returned
     * @return die that was removed
     */
    public Die removeDie(int i){
        if (i >= 0 && i < dice.size()) {
            return dice.remove(i);
        } else {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
        }
    }


    /**
     * Method to count the number of a die with a specified value
     * @param val int value of die to be counted
     * @return int number of die with specified value
     */
    public int count(int val){
        int count = 0;
        for (Die die : dice) {
            if (die.getValue() == val) {
                count++;
            }
        }
        return count;
    }

    /**
     * method to calculate the sum of all die in arraylist
     * @return int the value of the sum of all die in the arraylist
     */
    public int sum() {
        int sum = 0;
        for (Die die : dice) {
            sum += die.getValue();
        }
        return sum;
    }

    /**
     * Method to determine if Dice contains die of specified value
     * @param val the value of the die to search for
     * @return boolean status of if die exists in Dice
     */
    public boolean contains(int val) {
        for (Die die : dice) {
            if (die.getValue() == val) {
                return true;
            }
        }
        return false;
    }

    /**
     * Override of tostring method
     * Returns the index and corresponding value of each die
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < dice.size(); i++) {
            s += String.format("%d: value %d\n", i, dice.get(i).getValue());
        }
        return s;
    }
}
