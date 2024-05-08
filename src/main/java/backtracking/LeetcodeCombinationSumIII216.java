package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/8/2024
 * @project algorithms_practice
 * &
 */
public class LeetcodeCombinationSumIII216 {


    public static void main(String[] args) {

        for (List<Integer> integers : combinationSum3(3, 7)) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new ArrayList<>(), result, k, n);

        return result;


    }


    public static void backtrack(int startIndex, int[] selectionList, List<Integer> path, List<List<Integer>> result, int level, int target) {

        // end
        if (level == 0 && target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (level == 0) {
            return;
        }

        for (int i = startIndex; i < selectionList.length && target >= selectionList[i]; i++) {

            Integer thisChoice = selectionList[i];
            path.add(thisChoice);

            backtrack(i + 1, selectionList, path, result, level - 1, target - thisChoice);

            path.remove(path.size() - 1);

        }

    }


}
