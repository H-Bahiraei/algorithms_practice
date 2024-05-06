package backtracking;

import java.util.*;

public class LeetCodeCombinationSumII40SecondSolution {


    public static void main(String[] args) {
//        int[] myArray = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int[] myArray = {10,1,2,7,6,1,5};

//        for (List<Integer> integers : combinationSum2(myArray, 27)) {
        for (List<Integer> integers : combinationSum2(myArray, 8)) {
            System.out.println(integers);
        }
    }



    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> path,
                                  int[] selectionList, int target, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < selectionList.length && selectionList[i] <= target; i++) {
            if (i > startIndex && selectionList[i] == selectionList[i - 1]) continue; // Skip duplicates
            path.add(selectionList[i]);
            backtrack(result, path, selectionList,
                    target - selectionList[i], i + 1);
            path.remove(path.size() - 1);
        }
    }






    public static List<List<Integer>> combinationSum21(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> selectionList = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        Integer sum = 0;

        for (Integer item : candidates) {
            selectionList.add(item);
        }


        Collections.sort(selectionList);

        backtrack1(result, path, sum, selectionList, target);

        return result;


    }


    public static void backtrack1(List<List<Integer>> result, List<Integer> path, Integer sum, List<Integer> selectionList, Integer target) {

        if (Objects.equals(target, sum)) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < selectionList.size(); i++) {
            Integer thisChoice = selectionList.get(i);
            if (i != 0) {
                Integer preChoice = selectionList.get(i - 1);
                if (Objects.equals(thisChoice, preChoice))
                    continue;
            }

            path.add(thisChoice);
            sum += thisChoice;
            selectionList.remove(thisChoice);

            List<Integer> removedList = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                removedList.add(selectionList.get(j));
            }
            for (Integer item : removedList) {
                selectionList.remove(item);
            }


            backtrack1(result, path, sum, selectionList, target);

            path.remove(path.size() - 1);
            sum -= thisChoice;
            for (int j = removedList.size() - 1; j >= 0; j--)
                selectionList.add(0, removedList.get(j));
            selectionList.add(i, thisChoice);
            removedList.clear();

        }

    }


}
