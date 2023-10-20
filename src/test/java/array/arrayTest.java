package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 10/21/2023
 * @project algorithms_practice
 * &
 */
public class arrayTest {

    @Test
    void movesZeroes() {
        // given
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt() % 10;
        }
        int[] clone = arr.clone();

        ArrayMoveZeroes arrayMoveZeroes = new ArrayMoveZeroes();
        int[] arrResult = arrayMoveZeroes.move(arr);

        Assertions.assertNotSame(arrResult, clone);

    }

}
