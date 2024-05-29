package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 5/29/2024
 * @project algorithms_practice
 * &
 */
public class LeetCodeSpiralMatrix54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0)
            return result;


        int beginRow = 0;
        int endRow = matrix.length - 1;
        int beginCol = 0;
        int endCol = matrix[0].length - 1;


        while (beginRow <= endRow && beginCol <= endCol) {
/*
beginRow ++i
    beginRow++;
    */
            for (int i = beginCol; i <= endCol; i++)
                result.add(matrix[beginRow][i]);
            beginRow++;

    /*
endCol ++i
    endCol--;
    */
            for (int i = beginRow; i <= endRow; i++)
                result.add(matrix[i][endCol]);
            endCol--;

    /*
endRow --i
    endRow --;
*/
            if (beginRow <= endRow)
                for (int i = endCol; i >= beginCol; i--)
                    result.add(matrix[endRow][i]);
            endRow--;

/*
beginCol --i
    beginCol++;
    */
            if (beginCol <= endCol)
                for (int i = endRow; i >= beginRow; i--)
                    result.add(matrix[i][beginCol]);
            beginCol++;

        }

        return result;

    }

}
