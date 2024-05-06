package backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/1/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeCombinationSumII40 {

    public static void main(String[] args) {
        int[] myArray = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};

        for (List<Integer> integers : combinationSum2(myArray, 27)) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        Map<Integer, Integer> selectionMap = new HashMap<>();

        for (Integer item : candidates) {
            if (selectionMap.containsKey(item))
                selectionMap.put(item, selectionMap.get(item) + 1);
            else
                selectionMap.put(item, 1);
        }

        Integer sum = 0;
        backTrack(path, sum, selectionMap, result, target);
        return result;
    }

    public static void backTrack(List<Integer> path, Integer sum, Map<Integer, Integer> selectionMap, List<List<Integer>> result, Integer target) {
        if (Objects.equals(sum, target)) {
            result.add(new LinkedList<>(path));
            return;
        }
        if (sum > target)
            return;

        List<Integer> selectionList = selectionMap.entrySet().stream()
                                            .filter(entry -> entry.getValue() > 0)
                                                .map(Map.Entry::getKey).toList();

        for (int i = 0; i < selectionList.size(); i++) {

            Integer thisChoice = selectionList.get(i);
            List<Integer> removedList = new LinkedList<>();
            Map<Integer,Integer> removedItemFromMap= new HashMap<>();
            for (int j = 0; j < i; j++) {
                removedList.add(selectionList.get(j));
            }
            for (Integer item : removedList) {
                removedItemFromMap.put(item,selectionMap.get(item));
                selectionMap.put(item,0);
            }
            path.add(thisChoice);
            sum += thisChoice;
            selectionMap.put(thisChoice, selectionMap.get(thisChoice) - 1);

            backTrack(path, sum, selectionMap, result, target);

            path.remove(path.size() - 1);
            sum -= thisChoice;
            for (Integer item : removedList) {
                selectionMap.put(item,removedItemFromMap.get(item));
            }
            removedList.clear();
            removedItemFromMap.clear();
            selectionMap.put(thisChoice, selectionMap.get(thisChoice) + 1);
        }

    }

}
