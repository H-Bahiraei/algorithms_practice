package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 11/13/2023
 * @project algorithms_practice
 * &
 */
public class TwoSum {


    Map minesMap = new HashMap<Integer, Integer>();
    int[] resultArr = new int[2];

    // helper func: fill HashMap put mines
    void fillingMinesMap(int[] arr, Integer target) {
        for (int i = 0; i < arr.length; i++) { //O(n)
            minesMap.put(target - arr[i], i);
        }
    }

    public int[] findIndices(int[] arr, Integer target) {

// check for invalid inputs

//        System.out.println("arr = " + Arrays.deepToString(arr));
// in main func: ask HM in loop for arr
        for (int i = 0; i < arr.length; i++) { //O(n)
            this.fillingMinesMap(arr, target);
            if (minesMap.containsKey(arr[i])) { //O(1)
                Integer secondIndex = (Integer) minesMap.get(arr[i]);
                if (!(i == secondIndex)) {
                    // solved
                    resultArr[0] = i;
                    System.out.println("index 1 = " + i);
                    System.out.println("V1 = " + arr[i]);
                    resultArr[1] = secondIndex;
                    System.out.println("index 2 = " + secondIndex);
                    System.out.println("V2 = " + arr[secondIndex]);
                    return resultArr;
                }
            }
        }

        return resultArr;
    }
}
