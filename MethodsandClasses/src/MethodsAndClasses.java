import Store.Bookstore;
import Store.CoffeeShop;
import Store.ConvenienceStore;
import Store.SandwichShop;

public class MethodsAndClasses {
    public static void main(String[] args) {
        Bookstore barnesAndNobles = new Bookstore("Barnes & Nobles", "4020 Sharon Rd, Charlotte, NC 28211", "BNTitles.txt");
        barnesAndNobles.setHours(9,0,22,0);
        barnesAndNobles.setSize(26000);
        barnesAndNobles.setOpenOnSunday(true);

        //What is the address?
        System.out.println(barnesAndNobles.getAddress());

        //Is the store open today?
        System.out.println(barnesAndNobles.isOpen());

        //What time does it close?
        System.out.println(barnesAndNobles.getHours());

        //How big is the store?
        System.out.println(barnesAndNobles.getSquareFootage() + " square feet");

        //Does the store have used books?
        System.out.println(barnesAndNobles.hasUsedBooks());

        System.out.println(barnesAndNobles.doYouHave("The Real Barenziah, Book IV"));

        SandwichShop cloverJoes = new SandwichShop("Clover Joe's", "124 Brevard Court, Charlotte, NC 28202", "CloverJoeMenu.txt");
        cloverJoes.printMenu();

        CoffeeShop notJustCoffee = new CoffeeShop("Not Just Coffee", "222 S. Church St., Charlotte, NC 28202", "NJCMenu.txt");
        notJustCoffee.printMenu();

        ConvenienceStore sevenEleven = new ConvenienceStore("7Eleven", "255 W. E. Martin Luther King Dr., Charlotte, NC 28202","7elevenProducts.txt");
        sevenEleven.setHasAlcohol(true);

    }
}