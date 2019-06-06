package Store;

import java.io.IOException;
import java.util.ArrayList;

public class Bookstore extends Store {
    private boolean hasUsedBooks=false;
    private ArrayList<String> titles;

    private void loadTitles(String titleList){
        try {
            Utils.loadStringsToArray(titleList, this.titles);
        }
        catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initialize the titles");
            // make sure it is empty
            this.titles = new ArrayList<String>();
        }
    }

    public Bookstore(){
        super();
    }

    public Bookstore(String name, String address, String titleList){
        super(name,address);

        // all other members set here

        // init the array and then load it.
        titles = new ArrayList<String>();
        loadTitles(titleList);
    }

    public void setTitles(String titleList) {
        titles = new ArrayList<String>();
        loadTitles(titleList);
    }

    public ArrayList getTitles(){
        return titles;
    }

    public boolean doYouHave(String bookTitle) { return titles.contains(bookTitle); }

    public boolean hasUsedBooks() {
        return hasUsedBooks;
    }

    public void setHasUsedBooks( boolean hasUsedBooks ) {
        this.hasUsedBooks = hasUsedBooks;
    }

}
