package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/29/2024
 * @project algorithms_practice
 * &
 */
public class Leetcode77Combinations {

    // we're not looking for permutations (repetitive combination) where the order  matters

    public static void main(String[] args) {

        for (List<Integer> integers : combine(4, 2)) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<Integer> selectionList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            selectionList.add(i);
        }
        backTrack(path, selectionList, k, result);
        return result;
    }
    public static void backTrack(List<Integer> path, List<Integer> selectionList, Integer targetLength, List<List<Integer>> result) {

        if (path.size() == targetLength) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < selectionList.size(); i++) {
            Integer thisChoice = selectionList.get(i);
            path.add(thisChoice);
            selectionList.remove(thisChoice);
            List<Integer> removedItems = new ArrayList<>();
            for (Integer item : selectionList) {
                if (item < thisChoice) {
                    removedItems.add(item);
                }
            }
            for (Integer item : removedItems) {
                selectionList.remove(item);
            }
            if (path.size() + selectionList.size() >= targetLength)
                backTrack(path, selectionList, targetLength, result);

            path.remove(path.size() - 1);
            for (int j = removedItems.size() - 1; j >= 0; j--) {
                selectionList.add(0, removedItems.get(j));
            }
            removedItems.clear();
            selectionList.add(i, thisChoice);

        }


    }


}
