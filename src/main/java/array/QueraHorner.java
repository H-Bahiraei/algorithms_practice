package array;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/26/2024
 * @project algorithms_practice
 * &
 */
public class QueraHorner {

    static final int mod = 1000000007;

    // https://www.youtube.com/watch?v=nRvSVxMItvk

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int value = 0;
        for (int i = 0; i <= n; i++) {
            value = (int) (((long) value * x + a[i]) % mod);
        }

        System.out.println((value + mod) % mod);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum=0;
        int n = scanner.nextInt();
        long x = scanner.nextInt();

        long[] myArray = new long[n+1];
        for (int i = n; i >= 0 ; i--) {
            myArray[i] = scanner.nextLong();
        }

        sum+= myArray[0];
        long mulx=1;
        for (int i=1; i<=n; i++){
            mulx*=x;
            sum+= myArray[i]* (mulx);

        }

//        for (int i=0; i<=n; i++){
////            sum+= Math.multiplyExact(myArray[i], (long) Math.pow(x,i));
//            sum+= myArray[i]* (Math.pow(x,i));
//        }

        System.out.println(sum%(1000000007));
//        System.out.println((long)(sum%(Math.pow(10,9)+7)));
//        System.out.println(sum);
    }
}
