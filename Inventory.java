
/**
 * Creates an inventory that holds the
 * things bought from the vending machine 
 * and is stored here.
 *
 * @author (Tristan Santor)
 * @version (12/5/22)
 */
public class Inventory {
    private char[] inventory;


    /**
     * Constructor for objects of class Inventory
     * to make a backpack size of 5
     */
    public Inventory() {
        inventory = new char[5];
    }

    /**
     * Creates an empty inventory
     * in this simulation, the character
     * '_' represents an empty slot
     * this applies for inventory and 
     * the vending machine
     *
     */
    public void createInventory() {
        char empty = '_';
        for(int i = 0; i < inventory.length; i++) {
            inventory[i] = empty;
        }
    }

    /**
     * APrints the elements of the inventory
     * which is an array
     *
     */
    public void printInventory() {
         for(int i = 0; i < inventory.length; i++) {
            System.out.print(inventory[i]+ " ");
        }
        System.out.println();
    }

    /**
     * Adds a drink to you inventory
     *
     * @param  drink the character representing the drink
     */
    public void addDrinkToBackpack(char drink) {
        //if the current element in the char array
        //is not empty, iterate empty count 
        //if emptyCount == 5 that means all slots
        //are full so let user know
        //the variable emptyCount doesnt literally
        //mean its empty
        int emptyCount = 0;
        for(int i = 0; i < inventory.length; i++) {
            if(inventory[i] == '_')
            {
                inventory[i] = drink;
                break;
            }
            else 
            {
                emptyCount++;
            }
        }
        if(emptyCount == 5) 
        {
            System.out.println("Your inventory is full");
        }
    }

    /**
     * Drink the item in chosen position of inventory
     *
     * @param drinkPosition the position of what
     *                   the user requested (index + 1)
     */
//34567891.........2.........3.........4.........5.........6.........7.........8
    public void drinkItem(int drinkPosition) {
        if(inventory[drinkPosition] == '_') 
        {
            System.out.println
            ("There is no drink in this part of your inventory");

            return;
        }
        else
        {
            //switch case which prints 
            //to user what drink they consumed
            //based on the representing character
            char curDrink = inventory[drinkPosition];
            switch(curDrink) 
            {
                case 'S':
                 System.out.println("You Drank a Sprite!");
                 break;
                case 'C':
                 System.out.println("You Drank a Coke!");
                 break;
                case 'M':
                 System.out.println("You Drank a Mountain Dew!");
                 break;
                case 'F':
                 System.out.println("You Drank a Fanta!");
                 break;
                case 'P':
                 System.out.println("You Drank a Pepsi!");
                 break;
                 case '7':
                 System.out.println("You Drank a 7UP!");
                 break;
                 default:
                 System.out.println("You drank nothing");
            }
        }
    }

    /**
     * Deletes item by making it empty ('_')
     *
     * @param drinkPosition the position of what
     *                   the user requested (index + 1)
     */
    public void trashItem(int drinkPosition) {
        inventory[drinkPosition] = '_';
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param drinkPosition the position of what
     *                  the user requested (index + 1)
     * @return    the cost of the drink / 2 (no profit!!)
     */
    public double sellItem(int drinkPosition) {
        double drinkCost = 0;
        char currentDrink = inventory[drinkPosition];
        if(currentDrink == '_')
        {
            System.out.println
            ("There is no drink in this part of your inventory");
        }
        if(currentDrink == 'S') 
        { 
            drinkCost = 1.00 / 2.00;
        }
        else if (currentDrink == 'C')
        {
            drinkCost = 2.00 / 2.00;
        }
        else if (currentDrink == 'M')
        {
            drinkCost = 1.00 / 2.00;
        }
        else if (currentDrink == 'F')
        {
            drinkCost = 0.50 / 2.00;
        }
        else if (currentDrink == 'P')
        {
            drinkCost = 0.99 / 2.00;
        }
        else if (currentDrink == '7')
        {
            drinkCost = 3.00 / 2.00;
        }
        else 
        {
            drinkCost = 0;
        }

        return drinkCost;
    }
}
