package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/28/2024
 * @project algorithms_practice
 * &
 */
public class QueraBord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numbersOfChance = scanner.nextInt();
        Integer numbersOfFruits = scanner.nextInt();
        Integer[] chancesArray = new Integer[numbersOfChance];
        for (int i = 0; i < numbersOfChance; i++) {
            chancesArray[i] = scanner.nextInt();
        }
        System.out.println(calculateMinOFFruits(chancesArray, numbersOfFruits));
    }

    private static Integer calculateMinOFFruits(Integer[] chancesArray, Integer numbersOfFruits) {
        Arrays.sort(chancesArray,(a,b)->b-a);

        for (int i = 0; i < chancesArray.length; i++) {
            int mines = chancesArray[i] - numbersOfFruits;
            if (mines > 0) {
                numbersOfFruits -= Math.min(numbersOfFruits, mines);
            }
        }

        return numbersOfFruits;
    }

}
