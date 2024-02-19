package recursive;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/19/2024
 * @project algorithms_practice
 * &
 */
public class EmployyLife {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputArray = new int[n];

        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }

        System.out.println(calculateTheTasksCount(inputArray));
    }

    private static long calculateTheTasksCount(int[] inputArray) {
        long count = 0;
        int length = inputArray.length;

//        Arrays.stream(inputArray).sorted().filter(x -> )

        Arrays.sort(inputArray);

        for (int minute = 1; minute <= length; minute++) {

            for (int i = minute; i <= 100000; i++) {
                int index = Arrays.binarySearch(inputArray, i);
                if (index >= 0) {
                    count += 1;
                    inputArray[index] = minute;
                    Arrays.sort(inputArray);
                    int delIndex = Arrays.binarySearch(inputArray, minute);
                    inputArray = Arrays.copyOfRange(inputArray, delIndex + 1, inputArray.length);
//                    Arrays.sort(inputArray);
                    break;
                }

            }

            if (inputArray.length == 0 || inputArray[inputArray.length - 1] <= minute)
                break;
        }

        return count;
    }

}
