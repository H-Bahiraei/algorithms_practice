package array;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 11/14/2023
 * @project algorithms_practice
 * &
 */
class ThreeSumTest {

    @Test
    void threeSumMethod() {

        // when
//        int[] arr= {-1,0,2,2,-1,-4};
//        int[] arr = {0, 0, 0};
        int[] arr = {5, -3, -2};
//        int[] arr= {0,1,1};

        int[] arr2 = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr2[i] = random.nextInt() % 10;
        }

        // given
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(arr2);
    }
}