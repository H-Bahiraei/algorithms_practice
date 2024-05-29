package array;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeValidAnagram242 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i <= s.length() - 1; i++) {
            counter[s.charAt(i) - 'a'] = counter[s.charAt(i) - 'a'] + 1;
            counter[t.charAt(i) - 'a'] = counter[t.charAt(i) - 'a'] - 1;
        }

        for (int i = 0; i <= counter.length - 1; i++) {
            if (counter[i] != 0)
                return false;
        }

        return true;
    }


}
