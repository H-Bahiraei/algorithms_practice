package recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueraSegmentation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputArray = new int[n];

        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }

//        System.out.println(subsets(inputArray));
        System.out.println(subsets(inputArray));
    }


    public static Long subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int total = (1 << n);
        Long min = Long.MAX_VALUE;

//        for (int i = 0; i < total; i++) {
//            result.add(Arrays.asList(0));
//        }
//

        for (int i = 0; i < total / 2; i++) {
            Long count1 = 0L;
            Long count2 = 0L;
//            List<Integer> subset1 = new ArrayList<>();
//            List<Integer> subset2 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
//                    subset1.add(nums[j]);
                    count1 += nums[j];
                } else {
//                    subset2.add(nums[j]);
                    count2 += nums[j];
                }
            }
//            result.set(i, subset1);
//            result.set(total - 1 - i, subset2);
            min = Math.min(min, Math.abs(count1 - count2));
        }

        return min;


//        for (int i = 0; i < total / 2; i++) {
//            int count1 = 0;
//            int count2 = 0;
//
//            for (int a : result.get(i)) {
//                count1 += a;
//            }
//
//            for (int a : result.get(total - 1 - i)) {
//                count2 += a;
//            }
//
//            min = Math.min(min, Math.abs(count1 - count2));
//
//        }


    }


}
