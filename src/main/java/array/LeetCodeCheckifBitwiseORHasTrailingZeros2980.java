package array;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeCheckifBitwiseORHasTrailingZeros2980 {

    public boolean hasTrailingZeros(int[] nums) {
        int evenCounter=0;
        for(int num : nums){
            if (num % 2 ==0) evenCounter++;
            if (evenCounter==2) {
                return true;
            }
        }
        return false;
    }

}
