package PLCMC;

import java.util.ArrayList;

abstract class Book extends LibraryItem{
    private ArrayList<String> authorList;
    private String seriesTitle;

    public Book(long itemNumber, String title, String Author) {
        super(itemNumber, title);
        authorList.add(Author);
    }
}
