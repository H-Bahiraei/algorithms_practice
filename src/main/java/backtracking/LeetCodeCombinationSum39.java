package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/30/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeCombinationSum39 {

    public static void main(String[] args) {

        int[] inputArray = {2, 3, 6, 7};
        int target = 7;

        for (List<Integer> integers : combinationSum(inputArray, target)) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        List<Integer> selectionList = new LinkedList<>();
        for (Integer item : candidates) {
            selectionList.add(item);
        }
        Integer sum = 0;

        backTrack(selectionList, path, sum, target, result);
        return result;
    }


    public static void backTrack(List<Integer> selectionList, List<Integer> path, Integer sum, Integer target, List<List<Integer>> result) {
        if (Objects.equals(sum, target)) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target)
            return;

        for (int i = 0; i < selectionList.size(); i++) {
            Integer thisChoice = selectionList.get(i);
            List<Integer> removeList = new ArrayList<>();
            path.add(thisChoice);
            sum += thisChoice;
            for (int j = 0; j < i; j++)
                removeList.add(selectionList.get(j));
            for (Integer item : removeList)
                selectionList.remove(item);

            backTrack(selectionList, path, sum, target, result);

            path.remove(path.size() - 1);
            sum -= thisChoice;
            for (int j = removeList.size() - 1; j >= 0; j--) {
                selectionList.add(0, removeList.get(j));
            }
            removeList.clear();

        }
    }
}
