package array;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/15/2024
 * @project algorithms_practice
 * &
 */
public class QueraSearchInSequence {

    static int[] inputArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read inputs
        int arraySize = scanner.nextInt();
        int numberOfQuestions = scanner.nextInt();
        inputArray = new int[arraySize];

        // check inputs : done
        if (1 <= numberOfQuestions && numberOfQuestions <= 100000
                && 1 <= arraySize && arraySize <= 100000) {
//            scanner.nextLine();
            for (int i = 0; i < arraySize; i++) {
                int value = scanner.nextInt();
                if (1 <= value && value <= 1000000)
                    inputArray[i] = value;
            }

            quickSort(inputArray, 0, arraySize - 1);// O N (log n)

            for (int i = 0; i < numberOfQuestions; i++) { // O(n)
                int xi = scanner.nextInt();
                int count = binarySearch(xi); // O (log n)
                System.out.println(count);
            } // O (N log N)
        }
    }

    private static int binarySearch(int target) {
        int left = 0;
        int right = inputArray.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (inputArray[mid] < target) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
