package array;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/26/2024
 * @project algorithms_practice
 * &
 */
public class QueraSumOfDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;
        int i = number;
        while (i > 0) {
            if (i < 10)
                sum += i;
            else
                sum += i % 10;
            i = i / 10;
        }
        System.out.println(sum);
    }

}
