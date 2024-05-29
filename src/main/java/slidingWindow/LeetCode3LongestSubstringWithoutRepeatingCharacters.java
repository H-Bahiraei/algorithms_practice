package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * & #86 Beats 68.26% of users with Java
 */
public class LeetCode3LongestSubstringWithoutRepeatingCharacters {
    /*
    FIRST WAY:
    (a) b c a b c b b   max=1
    (a b) c a b c b b   max=2
    (a b c) a b c b b   max=3
    a (b) c a b c b b   max=3
    a (b c a) b c b b   max=3
    a b (c) a b c b b   max=3
    a b (c a b) c b b   max=3
    a b c (a) b c b b   max=3
    a b c (a b c) b b   max=3
    a b c a b c b (b)   max=3

    SECOND WAY:

    (a) b c a b c b b   a:0     max=1
    (a b c) a b c b b   a:0 b:1 c:2     max=3
    a (b c a) b c b b   a:3 b:1 c:2     max=3
    a b (c a b) c b b   a:3 b:4 c:2     max=3
    a b c (a b c) b b   a:3 b:4 c:5     max=3
    a b c a b (c b) b a   a:3 b:6 c:5     max=3
    a b c a b c b (b) a  a:3 b:7 c:5     max=3
    a b c a b c b (b a)  a:8 b:7 c:5     max=3



    (a) b c a b c d  a:0    max:1
    a b (c a b) c d  a:3 b:4 c:2    max:3
    a b c (a b c) d  a:3 b:4 c:5    max:3
    a b c (a b c d)  a:3 b:4 c:5 d:6    max:4



    */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> happendedChars = new HashMap<>();
        int leftIndex = 0;
        int max = 0;

        for (int rightIndex = 0; rightIndex <= s.length() - 1; rightIndex++) {
            Character currentChar = s.charAt(rightIndex);

            if (happendedChars.containsKey(currentChar) &&
                    leftIndex <= happendedChars.get(currentChar)) {
                leftIndex = happendedChars.get(currentChar) + 1;
            }
            max = (max < rightIndex - leftIndex + 1) ? rightIndex - leftIndex + 1 : max;
            happendedChars.put(currentChar, rightIndex);
        }

        return max;

    }
}