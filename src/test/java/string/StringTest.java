package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 10/19/2023
 * @project algorithms_practice
 * &
 */
public class StringTest {


    @Test
    void calculateTimeInMilliSecond() {
        //given
        String str1 = "qwertyuiop";
        String str2 = "iop";
        WorkInString workInString = new WorkInString();
        String time = null;

        // then
        time = workInString.calculateTimeForFindSubString(str1, str2);
        Assertions.assertNotNull(time);
    }

    @Test
    void giveAnArrayFromADocument(){
//        given
        String path= "E:\\algorithms_practice\\src\\main\\resources\\input.text";
        int length=0;

        //        then
        WorkInString workInString = new WorkInString();
        char[] finalCharArray =workInString.convertTextFileToCharArray(path);
        length = finalCharArray.length;
        Assertions.assertNotEquals(length, 0);

    }
}
