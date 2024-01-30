package recursive;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.TimeZone;

public class QueraTuple {


    public static void main(String[] args) {
//        LocalDateTime t1 = LocalDateTime.now();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sequence = new int[n];
        generateLexicographicSequences(sequence, n, 0);

//        LocalDateTime t2 = LocalDateTime.now();
//        long durationTime = Duration.between(t1, t2).toMillis();
//        System.out.println("time = " + durationTime);

    }

    public static void generateLexicographicSequences(int[] sequence, int n, int index) {
        if (index == n) {
            // چاپ دنباله به ترتیب لغت‌نامه‌ای
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            sequence[index] = i;
            generateLexicographicSequences(sequence, n, index + 1);
        }
    }

    public static void main2(String[] args) {
        LocalDateTime t1=LocalDateTime.now();
        Scanner scanner= new Scanner(System.in);
        int n= scanner.nextInt();
        int[] sequence = new int[n];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i: sequence){
            stringBuilder.append(i);
        }
//        generateLexicographicSequences(sequence, n, 0);
        withStringBuilderGenerateLexicographicSequences(stringBuilder, n, 0);
        LocalDateTime t2=LocalDateTime.now();
        long durationTime = Duration.between(t1, t2).toMillis();
        System.out.println("time = " +durationTime);

    }


    public static void withStringBuilderGenerateLexicographicSequences(StringBuilder stringBuilder, int n, int index) {


        if (index == n) {
            // چاپ دنباله به ترتیب لغت‌نامه‌ای

            for (int i = 0; i < stringBuilder.length(); i++) {
                System.out.print(stringBuilder.charAt(i));
                System.out.print(" ");
            }
            System.out.println("");

//            for (int num : sequence) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
            return;
        }


//        if (index == n - 1) {
//
//            for (int i = 1; i <= n; i++) {
//                sequence[index] = i;
//                for (int num : sequence) {
//                    System.out.print(num + " ");
//                }
//                System.out.println();
//
//            }
//
//            // چاپ دنباله به ترتیب لغت‌نامه‌ای
//            return;
//        }

        for (int i = 1; i <= n; i++) {
//            sequence[index] = i;
//            stringBuilder.append(i+"");
            stringBuilder.setCharAt(index,(char) (i+'0'));
            withStringBuilderGenerateLexicographicSequences(stringBuilder, n, index + 1);
        }
    }


}
