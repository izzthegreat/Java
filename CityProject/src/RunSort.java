import java.util.ArrayList;

class RunSort {
    static ArrayList<Integer> run () {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            listOfNumbers.add((int) Math.ceil(Math.random() * 100));
        } // end for-loop
        System.out.println(listOfNumbers);
        return listOfNumbers;
    }
}
