package recursive;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/26/2024
 * @project algorithms_practice
 * &
 */
public class QueraGCD {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long firstNumber = scanner.nextLong();
        long secondNumber = scanner.nextLong();
        System.out.println(GCD(firstNumber, secondNumber));
    }

    public static long GCD(long firstNumber, long secondNumber) {
//        long result;
//
//        long lowerNum = Math.min(firstNumber, secondNumber);
//        long higherNum = Math.max(firstNumber, secondNumber);

        while (secondNumber != 0) {
            long temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }
        return firstNumber;
//        if (higherNum%lowerNum==0)
//            return lowerNum;
//        long temp=lowerNum-1;
//        while (temp>0){
//            if(lowerNum%temp==0 && higherNum%temp==0)
//                return temp;
//            temp-=1;
//        }
//        return 0;
    }


    public static int calculateGCD(int firstNum, int secondNum) {
        // Base case: if secondNum is 0, the GCD is firstNum
        if (secondNum == 0) {
            return firstNum;
        }

        // Recursive case: call the function with swapped arguments
        return calculateGCD(secondNum, firstNum % secondNum);
    }

}
