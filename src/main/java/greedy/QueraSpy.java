package greedy;

import java.util.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/7/2024
 * @project algorithms_practice
 * &
 */
public class QueraSpy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEnterprise = scanner.nextInt();
        List<String> listOfEnterprises = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < numberOfEnterprise; i++) {
            listOfEnterprises.add(scanner.nextLine());
        }
        int numberOfData = scanner.nextInt();
        List<String> listOfData = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < numberOfData; i++) {
            listOfData.add(scanner.nextLine());
        }

        Map<String, List<Integer>> mapEnterpriseNextDays = new HashMap<>();

        for (int i = 0; i < numberOfData; i++) {
            List temp = Optional.ofNullable(mapEnterpriseNextDays.get(listOfData.get(i))).
                    orElse(new ArrayList<Integer>());
            temp.add(i);
            mapEnterpriseNextDays.put(listOfData.get(i), temp);
        }

        int thisDay = 0;
        int counter = -1;
        int max = 0;
        if (numberOfData == 0)
            counter = 0;
        else {
            while (thisDay < numberOfData) {
                counter += 1;
                for (String enterprise : listOfEnterprises) {
                    List<Integer> daysList = Optional.ofNullable(mapEnterpriseNextDays.get(enterprise))
                            .orElse(new ArrayList<>());
                    boolean check = false;
                    for (Integer day : daysList) {
                        if (day >= thisDay) {
                            check = true;
                            max = Math.max(max, day);
                            break;
                        }
                    }
                    if (!check) {
                        max = numberOfData;
                    }
                }
                thisDay = max;
            }
        }
        System.out.println(counter);
    }
}