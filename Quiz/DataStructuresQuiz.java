import java.util.ArrayList;
import java.util.Arrays;

public class DataStructuresQuiz {
    public static void main (String [] args) {
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++ )
            arr[i] = (int)Math.ceil(Math.random()*100);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Numbers with Duplicates: " + Arrays.toString(findDupes(arr)));
    }
    private static Object[] findDupes(int[] arr) { //Complexity O(n)
        Arrays.sort(arr);
        ArrayList<Integer> dupes = new ArrayList<>();
        int oldnum = arr[0];
        for (int num: arr) {
            if (dupes.contains(num)) continue;
            if (num == oldnum) { dupes.add(oldnum); } else { oldnum = num; }
        }
        return dupes.toArray();
    }
}