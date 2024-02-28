/**
 * Implementation of Catergory abstract class
 * This is the base to all categories
 * has two instance variables score and used
 * contains an abstract evaluate method
 * a method to find the value to add the score card
 */
public abstract class Category {
    // decalre variables
    private int score;
    private boolean used;

    /**
     * default construct intitializes variables to 0 and false
     */
    public Category(){
        score = 0;
        used = false;
    }

    /**
     * Abstract evaluate method to be expanded in implemented categories
     * @param d Dice to evaluate
     * @return int score to return to be added
     */
    public abstract int evaluate(Dice d);

    /**
     * Determines if catergory has been used, if not finds and sets score to evaluation of Dice
     * @param d Dice to a evaluate
     */
    public void addValue(Dice d){
        score += evaluate(d);
        used = true;
        
    }

    /**
     * retunrs the score
     * @return int score of category
     */
    public int getScore(){
        return score;
    }

    /**
     * returns used status
     * @return boolean if category has been used
     */
    public boolean getUsed(){
        return used;
    }
}
