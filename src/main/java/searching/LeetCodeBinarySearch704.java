package searching;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeBinarySearch704 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right= nums.length-1;

        while(left <= right){
            int mid= left + (right-left)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(target > nums[mid]){
                left= mid+1;
            }
            else if(target < nums[mid]){
                right= mid-1;
            }

        }
        return -1;

    }



}
