package array;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 11/16/2023
 * @project algorithms_practice
 * &
 */
public class SearchOne {


    public static void main(String[] args) {
        // check inputs : done

        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int numberOfQuestions = scanner.nextInt();
        int[] inputArray = new int[arraySize];
        int[] questionArray = new int[numberOfQuestions];
        int[] answerArray = new int[numberOfQuestions];

//        System.out.println("arraySize = " + arraySize);
//        System.out.println("numberOfQuestions = " + numberOfQuestions);

        if (1 <= numberOfQuestions && numberOfQuestions <= 1000 && 1 <= arraySize && arraySize <= 1000) {

            scanner.nextLine();
            for (int i = 0; i < arraySize; i++) {
                int value = scanner.nextInt();
                if (1 <= value && value <= 1000000)
                    inputArray[i] = value;
            }
//        System.out.print("inputArray = ");
//        for (int i : inputArray) {
//            System.out.print(" " + i + " ");
//        }
//        System.out.println();
            scanner.nextLine();
            for (int i = 0; i < numberOfQuestions; i++) {
                int value = scanner.nextInt();
                if (1 <= value && value <= 1000000)
                    questionArray[i] = value;
                scanner.nextLine();
            }
            scanner.close();
//        System.out.print("questionArray = ");
//        for (int i : questionArray) {
//            System.out.print(" " + i + " ");
//        }
//        System.out.println();
            // answerArray
            for (int questionIndex = 0; questionIndex < numberOfQuestions; questionIndex++) {
                int counter = 0;
                for (int elem : inputArray) {
                    if (elem < questionArray[questionIndex]) counter++;
                }
                answerArray[questionIndex] = counter;
            }

            for (int answerElem : answerArray) {
                System.out.println(answerElem);
            }
        }
    }
}
