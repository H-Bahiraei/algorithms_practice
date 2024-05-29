package array;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeMaxConsecutiveOnes485 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int counter = 0;
        int max = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == 1) {
                counter += 1;
                if (counter > max)
                    max = counter;
            } else {
                counter = 0;
            }
        }

        return max;

    }

}
