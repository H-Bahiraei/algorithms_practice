package array;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/22/2024
 * @project algorithms_practice
 * &
 */
public class QueraLargestSubrange {
    // #24

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] inputArray = new long[n];

        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextLong();
        }

        long maxEndingHere = inputArray[0];
        long maxSoFar = inputArray[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(inputArray[i], maxEndingHere + inputArray[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        System.out.println(maxSoFar);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] inputArray = new long[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextLong();
        }

        long sum= -Long.MAX_VALUE;

        for (int i=0; i< n; i++ ){
            long tempSum= inputArray[i];
            sum= Math.max(sum, tempSum);
            for(int j= i+1; j< n; j++){
                tempSum+=inputArray[j];
                sum= Math.max(sum, tempSum);
            }
        }
        System.out.println(sum);
    }
}
