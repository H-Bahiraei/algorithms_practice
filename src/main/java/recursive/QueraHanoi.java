package recursive;

import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/29/2024
 * @project algorithms_practice
 * &
 */
public class QueraHanoi {
    static int count=1;
    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1)
        {
            System.out.println(count + " " +  from_rod + " " + to_rod);
            count+=1;
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println( count + " " +  from_rod + " " + to_rod);
        count+=1;
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }

    //  Driver method
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt(); // Number of disks
        towerOfHanoi(n, 'A', 'B', 'C');
    }

}
