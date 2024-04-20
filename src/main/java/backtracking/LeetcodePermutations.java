package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/19/2024
 * @project algorithms_practice
 * &
 */
public class LeetcodePermutations {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        List<Integer> selectionList = new LinkedList<>();
        for (int i : nums) {
            selectionList.add(i);
        }

        backtrack(selectionList, path, result);

        return result;
    }

    private static void backtrack(List<Integer> selectionList, List<Integer> path, List<List<Integer>> result) {
        if (selectionList.size() == 0) {
            result.add(new ArrayList<>(path)); // ???
            return;
        }

        for (int i = 0; i < selectionList.size(); i++) {
            Integer newChoice = selectionList.get(i);

            path.add(newChoice);
            selectionList.remove(newChoice);
            backtrack(selectionList, path, result);

            path.remove(newChoice);
            selectionList.add(i,newChoice);
        }
    }


}
