package greedy;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/1/2024
 * @project algorithms_practice
 * &
 */
public class QueraStartUp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        scanner.nextInt();
        int num2 = scanner.nextInt();

        calculate(num1, num2);
    }

    private static void calculate(int num1, int num2) {
        int x = (num1 <= num2) ? ((Integer.min(num1, num2) * 2) - 1) : Integer.min(num1, num2) * 2;
        int a = x / 4;
        int b = x % 4;

        for (int i = 1; i <= 4; i++) {
            if (b > 0) {
                System.out.print(a + 1 + " ");
                b-=1;
            } else
                System.out.print(a + " ");
        }
    }

}
