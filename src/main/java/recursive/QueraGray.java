package recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/29/2024
 * @project algorithms_practice
 * &
 */
public class QueraGray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input=scanner.nextInt();
        List<Integer> result = grayCode(input);
        result.forEach(x-> System.out.println(toBinaryStringWithPadding(x, input)));
    }
    private static String toBinaryStringWithPadding(int num, int padding) {
        String binary = Integer.toBinaryString(num);
        return String.format("%" + padding + "s", binary).replace(' ', '0');
    }
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        int curr = 1;
        for (int i = 2; i <= n; i++) {
            curr *= 2;
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(curr + list.get(j));
            }
        }
        return list;
    }
}
