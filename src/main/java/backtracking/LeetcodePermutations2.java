package backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/23/2024
 * @project algorithms_practice
 * &
 */
public class LeetcodePermutations2 {


    public static void main(String[] args) {
        int[] myArray = {2, 2, 1,1};
        for (List<Integer> integers : permuteUnique(myArray)) {
            System.out.println(integers);
        }

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new LinkedList();
        Map<Integer, Integer> selectionMap = new HashMap<>();

        for (Integer num : nums) {
            if (selectionMap.containsKey(num))
                selectionMap.put(num, selectionMap.get(num) + 1);
            else
                selectionMap.put(num, 1);
        }

        backTrack(selectionMap, path, result);

        return result;

    }


    public static void backTrack(Map<Integer, Integer> selectionMap, List<Integer> path, List<List<Integer>> result) {

        // if we don't have any entrySet with value>0, it means path is a result
        if (selectionMap.values().stream().allMatch(integer -> integer<1)) {
//            if (!(result.stream().anyMatch(integers -> Objects.equals(integers, path))))
            result.add(new ArrayList<>(path));
            return;
        }

        // we use loop for creating new branches
        // we specify possible opportunities collection for selection in this node, each selection is a new branch
        for (Integer key :
                selectionMap.entrySet().stream().filter(entry -> entry.getValue() > 0)
                        .map(Map.Entry::getKey).collect(Collectors.toSet())) {

            path.add(key);
            selectionMap.put(key, selectionMap.get(key) - 1);
            backTrack(selectionMap, path, result);

            path.remove(path.size()-1);
            selectionMap.put(key, selectionMap.get(key) + 1);
        }

    }


}

