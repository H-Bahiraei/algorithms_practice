package recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/26/2024
 * @project algorithms_practice
 * &
 */
public class QueraRecursiveSequence {

    static Map<Integer, Integer> myMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.print(f(number));
    }

    public static int f(int n) {
        int result;
//        if (myMap.containsKey(n))
//            return myMap.get(n);
//        else {
        if (n == 0)
            result = 5;
        else if (n % 2 == 0)
            result = f(n - 1) - 21;
        else {
            int temp = f(n - 1);
            result = temp * temp;
        }
//            myMap.put(n, result);
//        }
        return result;
    }

}
