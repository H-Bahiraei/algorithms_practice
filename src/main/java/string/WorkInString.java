package string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 10/19/2023
 * @project algorithms_practice
 * &
 */
public class WorkInString {
    public String calculateTimeForFindSubString(String str1, String str2) {
        Instant start = Instant.now();
        String result = str1.contains(str2) ? "found!" : "not found!";
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant end = Instant.now();
        long durationTime = Duration.between(start, end).toMillis();
        System.out.println(result + " in " + durationTime + " millis");
        return durationTime + "";
    }

    public char[] convertTextFileToCharArray(String path) {
        String finalString = "";
        try {
            FileReader fileReader = new FileReader(new File(path));
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                finalString += scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("WorkInString.convertTextFileToCharArray--> something went wrong");
            e.printStackTrace();
        }
//        System.out.println("finalString = " + finalString);
        System.out.println("finalString = " + Arrays.toString(finalString.toCharArray()));
        return finalString.toCharArray();

    }
}
