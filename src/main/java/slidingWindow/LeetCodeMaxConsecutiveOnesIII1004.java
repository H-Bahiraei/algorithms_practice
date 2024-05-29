package slidingWindow;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeMaxConsecutiveOnesIII1004 {

    /*
l = r = 0

(1),1,1,0,0,0,1,1,1,1,0       k = 2    r-l=1
(1,1),1,0,0,0,1,1,1,1,0       k = 2    r-l=2
(1,1,1),0,0,0,1,1,1,1,0       k = 2    r-l=3
(1,1,1,0),0,0,1,1,1,1,0       k = 1    r-l=4
(1,1,1,0,0),0,1,1,1,1,0       k = 0    r-l=5
1,(1,1,0,0,0),1,1,1,1,0       k = -1 --> move left  r-l=6-1=5
1,1,(1,0,0,0,1),1,1,1,0       k = -1 --> move left  r-l=5
1,1,1,(0,0,0,1,1),1,1,0       k = -1 --> move left  r-l=5
1,1,1,0,(0,0,1,1,1),1,0       k = 0   r-l=5
1,1,1,0,(0,0,1,1,1,1),0       k = 0   r-l=6
1,1,1,0,0,(0,1,1,1,1,0)       k = -1 --> move left  r-l= 11-5=6


*/

    public int longestOnes(int[] nums, int k) {


        int left = 0;
        int right = 0;

        while (right <= nums.length - 1) {

            if (nums[right] == 0) k--;

            if (k < 0) {
                if (nums[left] == 0) k++;
                left++;
            }

            right++;
        }

        return right - left;

    }


}
