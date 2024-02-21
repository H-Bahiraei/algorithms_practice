package greedy;

import java.util.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/21/2024
 * @project algorithms_practice
 * &
 */
public class QueraEnergyEater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantityOfFruits = scanner.nextInt();
        long currentEnergy = scanner.nextInt();
        Long[] getsArray = new Long[quantityOfFruits];
        Long[] givesArray = new Long[quantityOfFruits];
        int realQuantity = 0;

        for (int i = 0; i < quantityOfFruits; i++) {
            long gets = scanner.nextInt();
            long gives = scanner.nextInt();
            if (gets < gives) {
                if (currentEnergy >= gets)
                    currentEnergy += (gives - gets);
                else {
                    getsArray[realQuantity] = gets;
                    givesArray[realQuantity] = gives;
                    realQuantity += 1;
                }
            }
        }

        getsArray = Arrays.copyOfRange(getsArray, 0, realQuantity);
        givesArray = Arrays.copyOfRange(givesArray, 0, realQuantity);

        List<Long> getsList = new ArrayList<Long>(Arrays.asList(getsArray));
        List<Long> givesList = new ArrayList<Long>(Arrays.asList(givesArray));

        for (int i = 0; i < realQuantity; i++) {
            Long minGets = Collections.min(getsList);
            if (currentEnergy >= minGets) {
                int minIndex = getsList.indexOf(minGets);
                Long minGives = givesList.get(minIndex);
                currentEnergy += minGives - minGets;

                if (minIndex == 0) {
                    getsList.remove(0);
                    givesList.remove(0);
                } else if (minIndex == getsList.size() - 1) {
                    getsList= getsList.subList(0, minIndex);
                    givesList= givesList.subList(0, minIndex);

                } else {
                    List<Long> temp = getsList.subList(minIndex + 1, getsList.size());
                    getsList = getsList.subList(0, minIndex);
                    getsList.addAll(temp);

                    temp = givesList.subList(minIndex + 1, givesList.size());
                    givesList = givesList.subList(0, minIndex);
                    givesList.addAll(temp);
                }
            }
        }


        System.out.println(currentEnergy);

    }


}
