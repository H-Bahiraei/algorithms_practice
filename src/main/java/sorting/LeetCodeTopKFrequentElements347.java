package sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeTopKFrequentElements347 {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> mapFrequency = new HashMap<>();
        List<Integer>[] bucketArray = new List[nums.length + 1];

        for (int num : nums) {
            if (mapFrequency.containsKey(num)) {
                mapFrequency.put(num, mapFrequency.get(num) + 1);
            } else {
                mapFrequency.put(num, 1);
            }
        }

        for (int key : mapFrequency.keySet()) {
            int freq = mapFrequency.get(key);
            if (bucketArray[freq] == null) {
                bucketArray[freq] = new ArrayList<>();
            }
            bucketArray[freq].add(key);
        }

        int[] res = new int[k];
        List<Integer> resultList = new ArrayList<Integer>();
        int counter = 0;

        for (int i = bucketArray.length - 1; i >= 0 && counter < k; i--) {
            if (bucketArray[i] != null) {
                for (Integer num : bucketArray[i]) {
                    res[counter++] = num;
                    // resultList.add(num);
                }
            }
        }
        return res;
    }
}
