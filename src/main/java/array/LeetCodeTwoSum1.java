package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeTwoSum1 {

    Map minesMap = new HashMap<Integer, Integer>();

    void fillingMinesMap(int[] arr, Integer target) {
        for (int i = 0; i < arr.length; i++) { //O(n)
            minesMap.put(target - arr[i], i);
        }
    }

    public int[] twoSum(int[] arr, int target) {
        int[] resultArr = new int[2];
        this.fillingMinesMap(arr, target);
        for (int i = 0; i < arr.length; i++) { //O(n)
            if (minesMap.containsKey(arr[i])) { //O(1)
                Integer secondIndex = (Integer) minesMap.get(arr[i]);
                if (!(i == secondIndex)) {
                    resultArr[0] = i;
                    resultArr[1] = secondIndex;
                    return resultArr;
                }
            }
        }

        return resultArr;
    }
}
