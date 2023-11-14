package array;

import java.util.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 11/14/2023
 * @project algorithms_practice
 * &
 */
public class ThreeSum {
    Map<Integer, Integer> minesMap = new HashMap<>();
    List<List<Integer>> answerList = new ArrayList<>();

    Map<Integer, ArrayList<ArrayList<Integer>>> previousTriplets = new HashMap<>();// in memory
    //given
    // input: array
    // don't use repeated indices (even two of them)

    void fillingNegativeMap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                minesMap.put(arr[i], i);
            }
        }
    }


    Boolean checkingMap(Integer key, Integer value1, Integer value2) {

        ArrayList<ArrayList<Integer>> allPreForSecondElem = previousTriplets.get(key);
        if (allPreForSecondElem!=null) {
            for (ArrayList<Integer> list : allPreForSecondElem) {
                if (list.contains(value1) && list.contains(value2)) {
                    // its duplicated
                    return true;
                }
            }
        }
        return false;


//        Optional<ArrayList<ArrayList<Integer>>> optionalAllPreForFirstIndex = Optional.ofNullable(previousTriplets.get(key));
//        if (optionalAllPreForFirstIndex.isPresent()) {
//            ArrayList<ArrayList<Integer>> allPreForSecondElem = optionalAllPreForFirstIndex.get();
//            for (ArrayList<Integer> list : allPreForSecondElem) {
//                if (list.contains(value1) && list.contains(value2)) {
//                    // its duplicated
//                    return true;
//                }
//            }
//        }
//        return false;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        // TODO: check for inputs

        // for {0,0,0}
        int countZero = 0;
        for (int elem : nums) {
            if (elem == 0) {
                countZero++;
                if (countZero == 3) {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(0);
                    innerList.add(0);
                    innerList.add(0);
                    answerList.add(innerList);
                    break;
                }
            }
        }

        //fill map with negative loop
        this.fillingNegativeMap(nums);

        // two nested for-loops and then check map
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {  // O(n)
            int firstVal = nums[firstIndex];
            for (int secondIndex = 0; secondIndex < nums.length; secondIndex++) { // O(n)
                int secondVal = nums[secondIndex];
                // check for not being equally indices
                if (firstIndex != secondIndex) {

                    int sumOfTwo = nums[firstIndex] + nums[secondIndex];

                    // ask to minesMap
                    if (sumOfTwo > 0 && minesMap.containsKey(-sumOfTwo)) { // O(1)
                        int thirdVal = -sumOfTwo;
                        // check for not being equally indices
                        Integer thirdIndex = minesMap.get(-sumOfTwo);

                        if (firstIndex != thirdIndex && secondIndex != thirdIndex) {
                            // solved
                            boolean hasIt = false;
                            boolean hasItfirst = false;
                            boolean hasItSecond = false;
                            //check for not contain duplicate triplets (at all)


                            hasIt = this.checkingMap(-sumOfTwo, nums[firstIndex], nums[secondIndex]);
                            if (nums[firstIndex] < 0)
                                hasItfirst = this.checkingMap(nums[firstIndex], nums[thirdIndex], nums[secondIndex]);
                            if (nums[secondIndex] < 0)
                                hasItSecond = this.checkingMap(nums[secondIndex], nums[firstIndex], nums[thirdIndex]);

                            if (!hasIt && !hasItfirst && !hasItSecond) {
                                ArrayList<ArrayList<Integer>> allPre = new ArrayList<ArrayList<Integer>>();
                                allPre = previousTriplets.get(-sumOfTwo);
                                if (allPre==null) {
                                    allPre =new ArrayList<ArrayList<Integer>>();
                                }

//                                ArrayList<ArrayList<Integer>> allPre;
//                                Optional<ArrayList<ArrayList<Integer>>> optionalAllPre = Optional.ofNullable(previousTriplets.get(-sumOfTwo));
//                                if (optionalAllPre.isPresent()) {
//                                    allPre = optionalAllPre.get();
//                                } else {
//                                    allPre =new ArrayList<ArrayList<Integer>>();
//                                }
//

//                                ArrayList<ArrayList<Integer>> allPre = previousTriplets.get(-sumOfTwo);
                                ArrayList<Integer> newHistory = new ArrayList<>();
                                newHistory.add(nums[firstIndex]);
                                newHistory.add(nums[secondIndex]);
//                                    ArrayList<ArrayList<Integer>> allPre = previousTriplets.get(-sumOfTwo);
                                allPre.add(newHistory);
                                previousTriplets.put(-sumOfTwo, allPre);
                                List<Integer> innerList = new ArrayList<>();
                                innerList.add(nums[firstIndex]);
                                innerList.add(nums[secondIndex]);
                                innerList.add(nums[thirdIndex]);
                                answerList.add(innerList);
                            }

//                            if (previousTriplets.containsKey(-sumOfTwo)) {
//                                ArrayList<ArrayList<Integer>> allPre = previousTriplets.get(-sumOfTwo);
//
//                                for (ArrayList<Integer> list : allPre) {
//                                    if (list.contains(nums[firstIndex]) && list.contains(nums[secondIndex])) {
//                                        // its duplicated
//                                        hasIt = true;
//                                        break;
//                                    }
//                                }
//                                if (!hasIt) {
//                                    if (nums[firstIndex] < 0) {
//                                        Optional<ArrayList<ArrayList<Integer>>> optionalAllPreForFirstIndex = Optional.ofNullable(previousTriplets.get(nums[firstIndex]));
//                                        if (optionalAllPreForFirstIndex.isPresent()) {
//                                            ArrayList<ArrayList<Integer>> allPreForSecondElem = optionalAllPreForFirstIndex.get();
//                                            for (ArrayList<Integer> list : allPreForSecondElem) {
//                                                if (list.contains(nums[thirdIndex]) && list.contains(nums[secondIndex])) {
//                                                    // its duplicated
//                                                    hasItfirst = true;
//                                                    break;
//                                                }
//                                            }
//                                        }
//
//                                    } else if (nums[secondIndex] < 0) {
////                                    ArrayList<ArrayList<Integer>> allPreForSecondElem =previousTriplets.get(nums[secondIndex]);
//                                        Optional<ArrayList<ArrayList<Integer>>> optionalAllPreForSecondElem = Optional.ofNullable(previousTriplets.get(nums[secondIndex]));
//                                        if (optionalAllPreForSecondElem.isPresent()) {
//                                            ArrayList<ArrayList<Integer>> allPreForSecondElem = optionalAllPreForSecondElem.get();
//                                            for (ArrayList<Integer> list : allPreForSecondElem) {
//                                                if (list.contains(nums[thirdIndex]) && list.contains(nums[firstIndex])) {
//                                                    // its duplicated
//                                                    hasItSecond = true;
//                                                    break;
//                                                }
//                                            }
//                                        }
//                                    }
//
//                                    if (!hasItfirst && !hasItSecond) { // next times
//                                        ArrayList<Integer> newHistory = new ArrayList<>();
//                                        newHistory.add(nums[firstIndex]);
//                                        newHistory.add(nums[secondIndex]);
////                                    ArrayList<ArrayList<Integer>> allPre = previousTriplets.get(-sumOfTwo);
//                                        allPre.add(newHistory);
//                                        previousTriplets.put(-sumOfTwo, allPre);
//                                        List<Integer> innerList = new ArrayList<>();
//                                        innerList.add(nums[firstIndex]);
//                                        innerList.add(nums[secondIndex]);
//                                        innerList.add(nums[thirdIndex]);
//                                        answerList.add(innerList);
//                                    }
//                                }
//                            }
//                            else { // first giving this negative value
//
//                                if (nums[firstIndex] < 0) {
//                                    Optional<ArrayList<ArrayList<Integer>>> optionalAllPreForFirstIndex = Optional.ofNullable(previousTriplets.get(nums[firstIndex]));
//                                    if (optionalAllPreForFirstIndex.isPresent()) {
//                                        ArrayList<ArrayList<Integer>> allPreForSecondElem = optionalAllPreForFirstIndex.get();
//                                        for (ArrayList<Integer> list : allPreForSecondElem) {
//                                            if (list.contains(nums[thirdIndex]) && list.contains(nums[secondIndex])) {
//                                                // its duplicated
//                                                hasItfirst = true;
//                                                break;
//                                            }
//                                        }
//                                    }
//
//                                } else if (nums[secondIndex] < 0) {
////                                    ArrayList<ArrayList<Integer>> allPreForSecondElem =previousTriplets.get(nums[secondIndex]);
//                                    Optional<ArrayList<ArrayList<Integer>>> optionalAllPreForSecondElem = Optional.ofNullable(previousTriplets.get(nums[secondIndex]));
//                                    if (optionalAllPreForSecondElem.isPresent()) {
//                                        ArrayList<ArrayList<Integer>> allPreForSecondElem = optionalAllPreForSecondElem.get();
//                                        for (ArrayList<Integer> list : allPreForSecondElem) {
//                                            if (list.contains(nums[thirdIndex]) && list.contains(nums[firstIndex])) {
//                                                // its duplicated
//                                                hasItSecond = true;
//                                                break;
//                                            }
//                                        }
//                                    }
//                                }
//                                if (!hasItfirst && !hasItSecond) { // next times
//                                    ArrayList<Integer> newHistory = new ArrayList<>();
//                                    newHistory.add(nums[firstIndex]);
//                                    newHistory.add(nums[secondIndex]);
//                                    ArrayList<ArrayList<Integer>> allPre = new ArrayList<>();
//                                    allPre.add(newHistory);
//                                    previousTriplets.put(-sumOfTwo, allPre);
//
//                                    List<Integer> innerList = new ArrayList<>();
//                                    innerList.add(nums[firstIndex]);
//                                    innerList.add(nums[secondIndex]);
//                                    innerList.add(nums[thirdIndex]);
//                                    answerList.add(innerList);
//                                }
//                            }
                        }
                    }
                }
            }
        }
        System.out.println("answerList = " + answerList);
        return answerList;
    }


    // output: arr of arr


}
