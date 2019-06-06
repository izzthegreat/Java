package PLCMC;

abstract class LibraryItem {
    long itemNumber;
    String Title;

    public LibraryItem(long itemNumber, String title) {
        this.itemNumber = itemNumber;
        Title = title;
    }
}
