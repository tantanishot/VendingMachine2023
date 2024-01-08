
import java.util.Scanner;
/**
 * The main driver method that mainly 
 * interacts with the user and is where
 * the objects are being created 
 *
 * @author (Tristan Santor)
 * @version (12/5/22)
 */
public class VendingMachineDriver {

      /**
     * Main method to which is the first method called to 
     * create the main objects: Scanner, Vending Machine and Inventory
     *
     */
//34567891.........2.........3.........4.........5.........6.........7.........8
    public static void main(String[] args) {

        //Objects are named similar to class name
        VendingMachine sodaMachine = new VendingMachine();
        Inventory myBackpack = new Inventory();
        //creates a new inventory, vending machine
        //of the same dimension and presents it to console
        myBackpack.createInventory();
        sodaMachine.createVendingMachine();
        sodaMachine.presentVendingMachine();
      //scanner for user input
        Scanner sc = new Scanner(System.in);

        System.out.println("-------This is a vending machine------");

        System.out.println
        ("You are only holding $10 and able to carry 5 drinks");
        System.out.print
        (" S = Sprite \n C = Coke \n");
        System.out.print
        (" M = Mountain Dew \n F = Fanta \n P = Pepsi \n 7 = 7UP \n");
        System.out.println
        ("Enter position ex. A3 is Row 1, Column 4 (A0 - F4)");
        //String will always be in all caps 
        String positionInput = sc.nextLine().toUpperCase();

      //chooseDrink represents a position in the users
      //inventory to get a drink based on index - 1
        int chooseDrink = 0;
        //currentDrink gets the character representing
        //the beverage to store into user backpack
        char currentDrink = sodaMachine.getDrink(positionInput);
        myBackpack.addDrinkToBackpack(currentDrink);
        sodaMachine.presentVendingMachine();
        sodaMachine.printUserBalance();
        myBackpack.printInventory();

        System.out.println();
        System.out.println("Type these commands to interact with inventory");
        System.out.print(" DRINK = drink any drink in inventory \n");
        System.out.print(" SELL = sell drink for half of the price \n");
        System.out.print(" TRASH = delete drink \n");
        System.out.print(" HELP = call directions again \n");
        System.out.print(" BUY = purchase another drink \n");
        System.out.print(" QUIT = exit system \n");

        
        boolean isRunning = true;
      
      //one of the crucial parts of the program where
      //it keeps running until user says quit
      while(isRunning)
      {
        System.out.print("What do you want to do: ");
        String userResponse = sc.nextLine().toUpperCase();

        if(userResponse.equals("DRINK"))
        {
          //Drink object in backpack and then trash it 
            myBackpack.printInventory();
            System.out.print
            ("What do you want to drink? (Backpack size is 1-5): ");
            chooseDrink = sc.nextInt() - 1;
            sc.nextLine();
            myBackpack.drinkItem(chooseDrink);
            myBackpack.trashItem(chooseDrink); 
        }
        else if(userResponse.equals("SELL"))
        {
          //Sell item in backpack then trash it
          myBackpack.printInventory();
          System.out.print
          ("What do you want to sell? (Backpack size is 1-5): ");
          chooseDrink = sc.nextInt() - 1;
          sc.nextLine();
          //updateSold item requires a double which sellItem returns cost
          sodaMachine.updateSoldItem(myBackpack.sellItem(chooseDrink));
          myBackpack.trashItem(chooseDrink); 
        }
        else if(userResponse.equals("TRASH"))
        {
           //Trash item gain nothing in return
          System.out.print
          ("What do you want to trash? (Backpack size is 1-5): ");
          chooseDrink = sc.nextInt() - 1;
          sc.nextLine();
          myBackpack.trashItem(chooseDrink); 
        }
        else if(userResponse.equals("HELP"))
        { 
          //show how to interact with user again
           printHelp();
        }
        else if(userResponse.equals("BUY"))
        {
          //buys a drink then puts it in inventory
          sodaMachine.presentVendingMachine();
          System.out.println
          ("Enter position ex. A3 is Row 1, Column 4 (A0 - F4)");
          positionInput = sc.nextLine().toUpperCase();
          currentDrink = sodaMachine.getDrink(positionInput);
          myBackpack.addDrinkToBackpack(currentDrink);
          
        }
        else if(userResponse.equals("QUIT"))
        {
          //let user know you are done, exit system
          System.out.println("Thanks for using the vending machine");
          isRunning = false;
          sc.close();
          System.exit(0);

        }
        else 
        {
          System.out.println("Invalid Input");
        }
        //This part of the loop executes after the user 
        //does any of these commands other than QUIT
        //which shows their current possessions
        
        System.out.println
        ("**************************************************");

        sodaMachine.printUserBalance();
        myBackpack.printInventory(); 
      }
    }
    
    /**
     * Print method to show the rules of interaction
     * method is called when user in loop says HELP
     *
     */
    public static void printHelp()  {
//34567891.........2.........3.........4.........5.........6.........7.........8

        System.out.println
        ("------------------------------------------------------");

        System.out.println("Vending Machine Legend:");

        System.out.print(" S = Sprite \n  7 = 7UP \n");
        System.out.print(" C = Coke \n");
        System.out.print(" M = Mountain Dew \n");
        System.out.print(" F = Fanta \n");
        System.out.print(" P = Pepsi \n");
        System.out.print(" 7 = 7UP \n");

        System.out.println("When interacting in inventory: ");
        
        System.out.print(" DRINK = drink any drink in inventory \n");
        System.out.print(" SELL = sell drink for half of the price \n");
        System.out.print(" TRASH = delete drink \n");
        System.out.print(" HELP = call directions again \n");
        System.out.print(" BUY = purchase another drink \n");
        System.out.print(" QUIT = exit system \n");

        System.out.println
        ("------------------------------------------------------");
    }
}   

