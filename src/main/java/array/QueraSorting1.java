package array;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/25/2024
 * @project algorithms_practice
 * &
 */
public class QueraSorting1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        long[] myArray = new long[length];
        for (int i = 0; i < length; i++) {
            myArray[i] = scanner.nextLong();
        }


        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                if (myArray[j] < myArray[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = myArray[i];
            myArray[i] = myArray[minIndex];
            myArray[minIndex] = temp;

        }

        for (long v :
                myArray) {
            System.out.print(v +" ");
        }

    }

}
