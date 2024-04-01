package recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/1/2024
 * @project algorithms_practice
 * &
 */
public class QueraWaysToMakeNumber {

    static Map<Integer, Integer> myResults = new HashMap<>();

    public static void main(String[] args) {
//        System.out.println("Ways to make 1: " + waysToMakeNumber(1));
//        System.out.println("Ways to make 2: " + waysToMakeNumber(2));
//        System.out.println("Ways to make 3: " + waysToMakeNumber(3));
//        System.out.println("Ways to make 4: " + waysToMakeNumber(4));
//        System.out.println("Ways to make 5: " + waysToMakeNumber(5));
//        System.out.println("Ways to make 6: " + waysToMakeNumber(6));
//        System.out.println("Ways to make 7: " + waysToMakeNumber(7));
//        System.out.println("Ways to make 8: " + waysToMakeNumber(8));

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(waysToMakeNumber(input));

    }

    public static int waysToMakeNumber(int n) {

        if (myResults.containsKey(n)) {
            return myResults.get(n);
        }
        if (n == 0 || n == 1) {
            myResults.put(n, 1);
            return 1;
        } else if (n < 0) {
            return 0;
        }
        int ways = 0;
        ways += waysToMakeNumber(n - 1); // Using 1
        ways += waysToMakeNumber(n - 2); // Using 2
        if (n - 5 >= 0)
            ways += waysToMakeNumber(n - 5); // Using 5
        myResults.put(n, ways);
        return ways;

    }


}
