import java.util.Random;

/**
 * Creates a Vending Machine objects that 
 * hold 6 different types of drinks , each
 * having their own costs
 *
 * @author (Tristan Santor)
 * @version (12/5/22)
 */
public class VendingMachine {
    //private vendingMachine array since we dont want it outside accessible
    //but Wallet should only be accessible here since i decided to separate
    //the inventory from the wallet
    private char[][] drinkVend = new char[6][5];
    public Wallet myWallet = new Wallet();

    /**
     * Most important part of the program
     * creates a 2d array of chars that represent
     * the six drinks explained in the driver
     * and is random everytime we run it again
     *
     */

    public void createVendingMachine() {
        String allDrinks = "SCMFP7";
        Random rnd = new Random();
        for(int i = 0; i < drinkVend.length; i++) { 
            for(int j = 0; j < drinkVend[0].length; j++) {
                drinkVend[i][j] = 
                      allDrinks.charAt(rnd.nextInt(allDrinks.length()));
            }
        }
    }
    
    /**
     * Prints a visual of the 2d array
     * with my best try of an ASCII Vending Machine
     *
     */
//34567891.........2.........3.........4.........5.........6.........7.........8
    public void presentVendingMachine() {
        System.out.println("_______________________");
        for(int i = 0; i < drinkVend.length; i++) {
            System.out.print("| ");
            for(int j = 0; j < drinkVend[0].length; j++) {
                System.out.print("[" + drinkVend[i][j] + "] " );
            }
        System.out.println("|");
        }
        System.out.println("|---------------------|");
        System.out.println("[  (     )        $$  ]");
        System.out.println("[_____________________] \n");


    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param input the position of the drink in the 
     *                  vending machine (A1 - F4)
     * @return   the drink itself represented as char
     */
    public char getDrink(String input) {
        //char will be switched to int so 2d array can access position index
        char tempRow = input.charAt(0);
        double drinkPrice = 0;
        int row;
        //the row is translate from letter to number
        //so the 2d array can get the row
        switch(tempRow) 
        {
              case 'A':
                  row = 0;
                  break;
              case 'B': 
                  row = 1;
                  break;
              case 'C': 
                  row = 2;
                  break;
              case 'D': 
                  row = 3;
                  break;    
              case 'E': 
                  row = 4;
                  break;       
              case 'F': 
                  row = 5;
                  break;
              default:
                  row = 0;
        }
        //column is a string still so we need to change is from string to int
        int column = Integer.parseInt(input.substring(1));
        if(drinkVend[row][column] == '_') 
        {
            System.out.println("This section is already empty");
            return '_';
        }
        //now we can get the position of the drink
        //from the "machine"
        char saveDrink = drinkVend[row][column];

        //this branching statement goes through to check
        //which drink was chosen and gets the price of the drink
        if(saveDrink == 'S') 
        { 
            drinkPrice = 1.00;
        }
        else if (saveDrink == 'C')
        {
            drinkPrice = 2.00;
        }
        else if (saveDrink == 'M')
        {
            drinkPrice = 1.00;
        }
        else if (saveDrink == 'F')
        {
            drinkPrice = 0.50;
        }
        else if (saveDrink == 'P')
        {
            drinkPrice = 0.99;
        }
        else if (saveDrink == '7')
        {
            drinkPrice = 3.00;
        }
        //updates wallet balance here in this method
        double finalPrice = myWallet.getMyBalance() - drinkPrice;
        if(finalPrice < 0 )
        {
            System.out.println("You dont have enough money");
            //empty slot
            return '_';
        }
        //turns section empty and updates balance
        drinkVend[row][column] = '_';
        myWallet.setBalance(finalPrice);
        return saveDrink;
    }

    /**
     * Prints the customers balance so far
     *
     */
    public void printUserBalance() {
        System.out.println("Customer's Balance: $" + myWallet.getMyBalance());
    }

    /**
     * When an item is sold, we go here since this is where
     * the wallet object was created the user can sell their drinks
     * for their money back half of its original cost
     *
     * @param addedPrice  sold price / 2
     */
    public void updateSoldItem(double addedPrice) {
        double finalPrice = myWallet.getMyBalance() + addedPrice;
        myWallet.setBalance(finalPrice);
    }



}