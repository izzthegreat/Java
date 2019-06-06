import java.util.ArrayList;

public class BubbleSort {
    public static void main (String [] args){
        ArrayList<Integer> listOfNumbers = RunSort.run();
        sort(listOfNumbers);
        System.out.println(listOfNumbers);
    } // end main method

    private static void sort(ArrayList<Integer> input){
        boolean sorted = false; // Initially assume list is unsorted.
        while (!sorted) { // As long as the list is unsorted, sort it. :)
            sorted = true; //Give it a chance to be sorted at first.
            for (int i = 0; i < input.size()-1; i++) { //Then try to sort
                    if (input.get(i) > input.get(i + 1)) { // Check each pair to se if the larger number is on the left
                    Integer temp = input.get(i);   // If not, set the left number to a temporary variable...
                    input.set(i, input.get(i + 1)); // ...set the right number to the left spot...
                    input.set(i + 1, temp); // ..and set the temporary variable to the right spot. Voila, switched!
                    sorted = false; // Only get to stop when it didn't need to do a sort this round.
                } // end if statement
            } // end for-loop
        } // end while-loop
    } // end sort method
} // end BubbleSort class
