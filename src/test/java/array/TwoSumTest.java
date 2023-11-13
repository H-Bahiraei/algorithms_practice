package array;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 11/13/2023
 * @project algorithms_practice
 * &
 */
public class TwoSumTest {


    @Test
    void twosumMethodTesting() {

        // given
//            input: an array of Integers
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
//            output: an array with two indices

//        Integer[] arrTest= {9, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer target = 10;

//        Integer[] realResult= {1,7};

        Integer[] arrTest = new Integer[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            arrTest[i] = random.nextInt() % 10;
        }


//when
        TwoSum twoSum = new TwoSum();
        Integer[] methodResult = twoSum.findIndices(arrTest, target);
//        Assertions.assertArrayEquals(methodResult,realResult);

    }


}
