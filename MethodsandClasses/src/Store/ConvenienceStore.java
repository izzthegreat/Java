package Store;

import java.io.IOException;
import java.util.ArrayList;

public class ConvenienceStore extends Store{
    private boolean hasAlcohol=false, sellsGas=false;
    private ArrayList<String> products;

    public boolean hasAlcohol() {
        return hasAlcohol;
    }

    public void setHasAlcohol(boolean hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }

    private void loadProducts(String productList){
        try {
            Utils.loadStringsToArray(productList, this.products);
        }
        catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initialize the stock");
            // make sure it is empty
            this.products = new ArrayList<String>();
        }
    }

    public boolean sellsGas() {
        return sellsGas;
    }

    public void setSellsGas(boolean sellsGas) {
        this.sellsGas = sellsGas;
    }

    public ConvenienceStore(){
        super();
    }

    public ConvenienceStore(String name, String address, String productList){
        super(name,address);

        // all other members set here

        // init the array and then load it.
        products = new ArrayList<String>();
        loadProducts(productList);
    }

    public void setProducts(String productList) {
        products = new ArrayList<String>();
        loadProducts(productList);
    }

    public ArrayList<String> getStock(){
        return products;
    }
}
