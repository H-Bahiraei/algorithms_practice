package twoPointers;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCode31NextPermutation {
/*
1 3 5 7
1 3 7 5 --> 1 5 7 3 --reverse()--> 1 5 3 7
1 5 3 7
1 5 7 3
1 7 3 5
1 7 5 3 --> 3 7 5 1 --sort()--> 3 1 5 7
*/


    public void nextPermutation(int[] nums) {

        int indexReplacement;
        int indexForReplacement;
        int i = nums.length - 2;


// step 1: finding the first descending
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        indexReplacement = i;

// step 2: finding first bigger in right side of rest of array
        if (indexReplacement >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[indexReplacement]) j--;
            indexForReplacement = j;
            swap(nums, indexReplacement, indexForReplacement);
        }

// step 2: reverse the rest left of array

        reverse(nums, indexReplacement + 1);


    }

    void swap(int[] nums, int first, int second) {
        int t = nums[first];
        nums[first] = nums[second];
        nums[second] = t;
    }


    void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

