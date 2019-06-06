import java.util.Arrays;

public class MergeSort {
    public static void main (String [] args) {
        Comparable[] arr = new Comparable[100];
        for (int i=0; i<arr.length; i++) arr[i] = (int) Math.ceil(Math.random()*100);
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @SuppressWarnings("rawtypes")
    private static void mergeSort(Comparable[] list)
    {
        //If list is empty; no need to do anything
        if (list.length <= 1) {
            return;
        }

        //Split the array in half in two parts
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        //Sort each half recursively
        mergeSort(first);
        mergeSort(second);

        //Merge both halves together, overwriting to original array
        merge(first, second, list);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result)
    {
        //Index Position in first array - starting with first element
        int iFirst = 0;

        //Index Position in second array - starting with first element
        int iSecond = 0;

        //Index Position in merged array - starting with first position
        int iMerged = 0;

        //Compare elements at iFirst and iSecond,
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length)
        {
            if (first[iFirst].compareTo(second[iSecond]) < 0)
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            }
            else
            {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
/*
    A Merge Sort Retro by Bryant Allen
    As I understand (not to be trusted...) a merge sort works like this:
    1. Split the array in two.
    2. Slit each new array in two.
    3.to n. continue to split until each value is in its own array.
    n+1. once you have individual values compare them in pairs to create arrays of two ordered values.
    n+2. - n+n. compare left most values within each pair of arrays and push the lowest value into a new array.
        Repeat as necessary until all values have been sorted in each pair.
    n+n+1. Repeat steps n+2-n+n until you only have one sorted array remaining.
*/

/*
    A Merge Sort in Action by Bryant Allen
    [9,2,4,7,1,6,3,8,5,10]
    [9,2,4,7,1]             [6,3,8,5,10]
    [9,2,4]     [7,1]       [6,3,8]     [5,10]
    [9,2][4]    [7][1]      [6,3][8]    [5][10]
    [9][2][4]   [7][1]      [6][3][8]   [5][10]
    [2,9][4]    [7,1]       [6,3][8]    [5,10]
    [2,4,9]     [7,1]       [3,6,8]     [5,10]
    [1,2,4,7,9]             [3,5,6,8,10]
    [1,2,3,4,5,6,7,8,9,10]
*/