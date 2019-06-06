import Stores.Bookstore;

public class MainStreet {
    public static void main(String[] args) {
        Bookstore that = new Bookstore("Bruice's Books", "1234 Main St","BookTitles.txt");
        that.setOpenAt(10, 0);
        that.setClosedAt(22,30);
        that.setHasUsedBooks(true);
        that.hasUsedBooks();
        that.isOpen();
        System.out.println("The store has "+that.numBooks()+" books.");
    }
}
