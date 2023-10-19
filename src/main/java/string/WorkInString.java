package string;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 10/19/2023
 * @project algorithms_practice
 * &
 */
public class WorkInString {
    public String calculateTimeForFindSubString(String str1, String str2) {
        Instant start = Instant.now();
        String result= str1.contains(str2) ? "found!" : "not found!";
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant end = Instant.now();
        long durationTime = Duration.between(start, end).toMillis();
        System.out.println(result + " in " + durationTime+ " millis");
        return durationTime+"";
    }
}
