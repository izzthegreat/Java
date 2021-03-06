package Store;

import java.io.IOException;
import java.util.ArrayList;

public class CoffeeShop extends Store {
    private ArrayList<String> menu;

    private void loadMenu(String menuSource){
        try {
            Utils.loadStringsToArray(menuSource, this.menu);
        }
        catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initialize the menu");
            // make sure it is empty
            this.menu = new ArrayList<String>();
        }
    }

    public CoffeeShop() {
        super();
    }

    public CoffeeShop(String name, String address, String menuSource) {
        super(name, address);
        this.setOpenOnSunday(true);

        menu = new ArrayList<>();
        loadMenu(menuSource);
    }

    public void setMenu(String menuSource) {
        menu = new ArrayList<String>();
        loadMenu(menuSource);
    }

    public void printMenu(){
        for(String menuItem: menu) System.out.println(menuItem);
    }
}
