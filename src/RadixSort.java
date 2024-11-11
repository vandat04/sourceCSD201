package PE;

import java.util.Arrays;

/*How Radix Sort Works (LSD Approach):
Find the maximum number to know the number of digits.
Starting from the least significant digit (units place), sort the array based on the current digit using a stable sorting algorithm (like Counting Sort).
Move to the next significant digit and repeat the sorting process.
Continue until all digits have been processed.*/
public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        // Separate negative and positive numbers
        int[] positives = Arrays.stream(arr).filter(x -> x >= 0).toArray();
        int[] negatives = Arrays.stream(arr).filter(x -> x < 0).map(Math::abs).toArray();

        // Sort positive numbers
        if (positives.length > 0) {
            radixSortPositive(positives);
        }

        // Sort negative numbers
        if (negatives.length > 0) {
            radixSortPositive(negatives);
            // Reverse and negate the negatives
            for (int i = 0; i < negatives.length / 2; i++) {
                int temp = negatives[i];
                negatives[i] = negatives[negatives.length - i - 1];
                negatives[negatives.length - i - 1] = temp;
            }
            // Convert back to negative numbers
            for (int i = 0; i < negatives.length; i++) {
                negatives[i] = -negatives[i];
            }
        }

        // Merge negatives and positives back into arr
        System.arraycopy(negatives, 0, arr, 0, negatives.length);
        System.arraycopy(positives, 0, arr, negatives.length, positives.length);
    }

    private static void radixSortPositive(int[] arr) {
        int max = getMax(arr);

        // Apply counting sort to sort elements based on place value.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Function to get the maximum value in arr[]
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }

    // A function to do counting sort of arr[] according to the digit represented by exp.
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array
        int[] count = new int[10]; // Count array for digits (0-9)

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / exp) % 10;
            count[index]++;
        }

        // Change count[i] so that count[i] contains the position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array to maintain stability
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[--count[index]] = arr[i];
        }

        // Copy the output array to arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {170, -45, 75, -90, 802, 24, 2, 66};
        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
