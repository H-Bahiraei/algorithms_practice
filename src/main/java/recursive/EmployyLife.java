package recursive;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/19/2024
 * @project algorithms_practice
 * &
 */
public class EmployyLife {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] deadlines = new int[n];
        for (int i = 0; i < n; i++) {
            deadlines[i] = scanner.nextInt();
        }

        // Use a priority queue to sort tasks by their deadlines (ascending order)
        PriorityQueue<Task> tasks = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.deadline, t2.deadline));

        // Add tasks to the queue with their corresponding deadlines
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(i + 1, deadlines[i]));
        }

        int completedTasks = 0;
        int currentTime = 0;

        // Process tasks as long as we haven't exceeded the deadline or completed all tasks
        while (currentTime <= deadlines[deadlines.length - 1] && !tasks.isEmpty()) {
            Task currentTask = tasks.poll();

            // Check if we can still complete the current task before its deadline
            if (currentTime <= currentTask.deadline) {
                completedTasks++;
                currentTime++;
            } else {
                // Break as exceeding the deadline for this task means we can't complete any more
                break;
            }
        }

        System.out.println(completedTasks);
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

            if (inputArray.length == 0 || inputArray[inputArray.length - 1] <= minute)
                break;
        }

        return count;
    }

    private static class Task {
        int id;
        int deadline;

        public Task(int id, int deadline) {
            this.id = id;
            this.deadline = deadline;
        }
    }

}
