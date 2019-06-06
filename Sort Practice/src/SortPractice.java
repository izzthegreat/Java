import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class SortPractice {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int count = 0;
        do {
            try {
                System.out.println("How many numbers would you like to merge sort? (max 100)");
                count = input.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter an integer between 1 and 100");
                input = new Scanner(System.in);
            }
        } while (count < 1 || count > 100);
        int[] nums = new int[count];
        for (int i = 0; i < nums.length; i++) nums[i] = (int) Math.ceil(Math.random() * 100);
        System.out.println("These are your numbers:");
        System.out.println(Arrays.toString(nums));
        Thread.sleep(2000);
        System.out.println("Now just watch. :)");
        Thread.sleep(1000);
        sort(nums);
    }
    
    private static void sort(@NotNull int[] input) throws InterruptedException {
        Thread.sleep(500);
        int halfPoint = input.length / 2;
        int[] left, right;
        if (input.length > 1) {
            left = Arrays.copyOfRange(input, 0, halfPoint);
            right = Arrays.copyOfRange(input, halfPoint, input.length);
            System.out.print(Arrays.toString(left));
            System.out.println(Arrays.toString(right));
            sort(left);
            sort(right);
            merge(left, right, input);
            System.out.println(Arrays.toString(input));
        }
    }

    private static void merge(int[] leftInput, int[] rightInput, int[] output) throws InterruptedException {
        Thread.sleep(50);
        int rightIndex = 0, leftI = 0;
        for (int i = 0; i < output.length; i++) {
            if (rightIndex == rightInput.length && leftI < leftInput.length) {
                output[i] = leftInput[leftI];
                leftI++;
            } else if (leftI == leftInput.length && rightIndex < rightInput.length) {
                output[i] = rightInput[rightIndex];
                rightIndex++;
            } else if (leftInput[leftI] <= rightInput[rightIndex] && leftI < leftInput.length) {
                output[i] = leftInput[leftI];
                leftI++;
            } else if (leftInput[leftI] > rightInput[rightIndex] && rightIndex < rightInput.length) {
                output[i] = rightInput[rightIndex];
                rightIndex++;
            }
        }
    }
}
