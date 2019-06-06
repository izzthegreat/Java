package Stores;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bookstore extends Store {
    boolean hasUsedBooks;
    private ArrayList<String> titles;

    public Bookstore(String name, String address, String input) {
        super(name, address);
        titles = new ArrayList<>();
        loadTitles(input);
    }

    public Bookstore(String name, String address, int sqrFeet, LocalTime openAt, LocalTime closedAt, boolean openOnSaturday, boolean openOnSunday, String input) {
        super(name, address, sqrFeet, openAt, closedAt, openOnSaturday, openOnSunday);
        titles = new ArrayList<>();
        loadTitles(input);
    }

    public int numBooks() {
        return titles.size();
    }

    public boolean hasBook(String nameOfBook){
        return titles.contains(nameOfBook);
    }

    public boolean hasUsedBooks() {
        return hasUsedBooks;
    }

    public void setHasUsedBooks(boolean hasUsedBooks) {
        this.hasUsedBooks = hasUsedBooks;
    }

    public boolean titleHasWord(String word){
        for (String item: titles){
            if (item.contains(word)) return true;
        }
        return false;
    }

    private void loadTitles(String input) {
        try {
            Utils.loadStringsToArray(input,this.titles);
        }
        catch (IOException e) {
            // for now simply init the array to zero
            System.out.println("Could not initilize the titles");
            // make sure it is empty
            this.titles = new ArrayList<>();

        }
    }
}
