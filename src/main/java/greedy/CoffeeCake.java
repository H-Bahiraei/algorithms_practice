package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/19/2024
 * @project algorithms_practice
 * &
 */
public class CoffeeCake {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int k = scanner.nextInt();
        int[] inputArray = new int[length];
        for (int i = 0; i < length; i++) {
            inputArray[i] = scanner.nextInt();
        }

        if (k==1){
            Arrays.stream(inputArray).max().ifPresent(System.out::print);
        } else if (k==2) {
            System.out.println(Math.min(inputArray[0], inputArray[length-1]));
        }
        else {
            Arrays.stream(inputArray).min().ifPresent(System.out::print);
        }

    }


}
