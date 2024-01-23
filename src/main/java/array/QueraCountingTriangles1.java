package array;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/23/2024
 * @project algorithms_practice
 * &
 */
public class QueraCountingTriangles1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        int n = scanner.nextInt();

        // Counting triangles
        int count = 0;
        for (int e1 = 1; e1 <= n; e1++) {
            for (int e2 = e1; e2 <= n; e2++) {
                int e3 = n - e1 - e2;
                if (e3 >= e2 && e1 + e2 > e3) {
                    // Valid triangle
                    count++;
                }
            }
        }

        // Output
        System.out.println(count);

        // Close the scanner
        scanner.close();
    }


}
