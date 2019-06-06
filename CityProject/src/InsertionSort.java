import java.util.ArrayList;

public class InsertionSort {
    public static void main (String [] args) {
        ArrayList<Integer> listOfNumbers = RunSort.run();
        sort(listOfNumbers);
        System.out.println(listOfNumbers);
    }
    private static void sort(ArrayList<Integer> input) {
        for (int i = 1; i < input.size(); ++i){
            Integer key = input.get(i);
            int jumpIndex = i-1;
            while (jumpIndex >= 0 && input.get(jumpIndex) > key) {
                input.set(jumpIndex + 1, input.get(jumpIndex));
                jumpIndex = jumpIndex - 1;
                System.out.println(input);
            }
            input.set(jumpIndex+1, key);
            System.out.println(input);
        }
    }
}
