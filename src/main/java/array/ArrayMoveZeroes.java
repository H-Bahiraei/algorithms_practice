package array;

import java.util.Arrays;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 10/21/2023
 * @project algorithms_practice
 * &
 */
public class ArrayMoveZeroes {
    public int[] move(int[] arr) {
        int length = arr.length;
        System.out.println("arr = " + Arrays.toString(arr));
        int lastIndexOfForBeingZero = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                int i1 = arr[lastIndexOfForBeingZero];
                arr[lastIndexOfForBeingZero] = arr[i];
                arr[i] = i1;
                lastIndexOfForBeingZero--;
            }
        }
        System.out.println("Rar = " + Arrays.toString(arr));
        return arr;
    }
}
