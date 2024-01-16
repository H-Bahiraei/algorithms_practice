package array;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/16/2024
 * @project algorithms_practice
 * &
 */
public class QueraArithmatic1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long k = scanner.nextLong();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        long val = 1000 * 1000 * 1000;

        for (int x = -100000; x < 100000; x++) {
            long t = 0;
            for (int i = 0; i < n; i++) {
                t += Math.abs((x + i * k) - a[i]);
            }
            val = Math.min(val, t);
        }

        System.out.println(val);
    }
}
