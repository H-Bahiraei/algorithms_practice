package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/19/2024
 * @project algorithms_practice
 * &
 */
public class EmployyLife {


    /*
    #In the name of God

input()
task=list(map(int,input().split()))
count_of_task=0
current_time=1
for x in sorted(task):
    #if deadline of task 'x' be <= 'current_time', add 1 to 'count_of_task'
    if current_time<=x:
        current_time+=1
        count_of_task+=1
print(count_of_task)
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine(); // Skipping the first input line as it's not used in the calculation

        String[] tasksStr = scanner.nextLine().split(" ");
        int[] tasks = new int[tasksStr.length];
        for (int i = 0; i < tasksStr.length; i++) {
            tasks[i] = Integer.parseInt(tasksStr[i]);
        }

        int countOfTasks = 0;
        int currentTime = 1;
        Arrays.sort(tasks);
        for (int x : tasks) {
            if (currentTime <= x) {
                currentTime++;
                countOfTasks++;
            }
        }

        System.out.println(countOfTasks);
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputArray = new int[n];

        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }

        System.out.println(calculateTheTasksCount(inputArray));
    }

    private static long calculateTheTasksCount(int[] inputArray) {
        long count = 0;
        int length = inputArray.length;

//        Arrays.stream(inputArray).sorted().filter(x -> )

        Arrays.sort(inputArray);

        for (int minute = 1; minute <= length; minute++) {

            for (int i = minute; i <= 100000; i++) {
                int index = Arrays.binarySearch(inputArray, i);
                if (index >= 0) {
                    count += 1;
                    inputArray[index] = minute;
                    Arrays.sort(inputArray);
                    int delIndex = Arrays.binarySearch(inputArray, minute);
                    inputArray = Arrays.copyOfRange(inputArray, delIndex + 1, inputArray.length);
//                    Arrays.sort(inputArray);
                    break;
                }

            }

            if (inputArray.length == 0 || inputArray[inputArray.length - 1] <= minute) break;
        }

        return count;
    }

}
