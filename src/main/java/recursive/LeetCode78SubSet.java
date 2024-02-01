package recursive;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78SubSet {

    //issues 48

        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int n = nums.length;

            for (int i = 0; i < (1 << n); i++) {
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        subset.add(nums[j]);
                    }
                }
                result.add(subset);
            }

            return result;
        }

        public static void main(String[] args) {
            int[] nums1 = {1, 2, 3};
            System.out.println("Subsets for [1, 2, 3]: " + subsets(nums1));

//            int[] nums2 = {0};
//            System.out.println("Subsets for [0]: " + subsets(nums2));
        }


}
