/**
 * Wallet class to create an object that 
 * keeps track of money spent and gained
 *
 * @author (Tristan Santor)
 * @version (12/5/22)
 */
//34567891.........2.........3.........4.........5.........6.........7.........8
public class Wallet {
    private double myBalance = 10.00;
        
    
    /**
     * Constructor for objects of class Wallet
     */
    public Wallet() {
        myBalance = 10.00;
    }

    /**
     * Accessor to get the current balance
     * of object Wallet
     *
     * @return  myBalance 
     */
    public double getMyBalance() {
        return myBalance;
    }

    /**
     * Mutator to update balance to when is prompted
     *
     * @param  newBalance the new balance to be used
     */
    public void setBalance(double newBalance) {
        myBalance = newBalance;
    }
}