package twoPointers;

import java.util.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCode3Sum15 {
    /*
-1,0,1,2,-1,-4
sort:
-4 -1 -1 0 1 2
-4 | L:-1 -1 0 1 R:2 --> -1 -1 0 L:1 R:2
-1 | L:-1 0 1 R:2 ==> [-1,-1,-2] -1 L:0 R:1 2 --> -1 L:0 R:1 2 ==> [-1,-1,0]
-1 | L:0 1 R:2 --> L:0 R:1 2 ==>[-1,-1,0] ***preventing using HashSet

*/
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3 || nums == null)
            return new ArrayList<>();


        Arrays.sort(nums);

        int ref = 0;
        int left = 0;
        int right = 0;
        Set<List<Integer>> resultHash = new HashSet<>();

        for (int i = 0; i <= nums.length - 2; i++) {

            ref = i;
            left = i + 1;
            right = nums.length - 1;

            while (left < right) {

                int sum = nums[ref] + nums[left] + nums[right];
                if (sum == 0) {
                    resultHash.add(Arrays.asList(nums[ref], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }


        }

        return new ArrayList<>(resultHash);

    }

}
