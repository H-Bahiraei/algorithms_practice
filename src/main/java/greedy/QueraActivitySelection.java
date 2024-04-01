package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/29/2024
 * @project algorithms_practice
 * &
 */
public class QueraActivitySelection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfActivities = scanner.nextInt();
        Activity[] activities = new Activity[numbersOfActivities];

        for (int i = 0; i < numbersOfActivities; i++) {
            activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
        }

        System.out.println(CalculateMaxActivities(activities, numbersOfActivities));
    }

    static Integer CalculateMaxActivities(Activity[] arr, int n) {

        Arrays.sort(arr, (a1, a2) -> a1.finish - a2.finish);

        int resultNumbersDoneMAx = 1;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[j].start >= arr[i].finish) {
                i = j;
                resultNumbersDoneMAx += 1;
            }
        }
        return resultNumbersDoneMAx;
    }

}

class Activity {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

