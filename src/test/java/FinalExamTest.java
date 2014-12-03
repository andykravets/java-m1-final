import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class FinalExamTest {
    FinalExam exam;

    @Before
    public void init() {
        exam = new FinalExam();
    }

    @Test
    public void testReturnTheSame() {
        int in = 10;
        int expectedResult = 10;
        int actualResult = exam.returnSameInt(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testChangeNumberSign() {
        int in = 10;
        int expectedResult = -10;
        int actualResult = exam.returnChangeSignInt(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddInt() {
        int a = 10, b = 20;
        int expectedResult = 30;
        int actualResult = exam.add(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddString() {
        String a = "Hello ", b = "world!";
        String expectedResult = "Hello world!";
        String actualResult = exam.add(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIntToStringConverter() {
        int in = 10;
        String expectedResult = "10";
        String actualResult = exam.intToStringConverter(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIntConcatenation() {
        int a = 10, b = 10;
        String expectedResult = "1010";
        String actualResult = exam.intConcatenation(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIntArrayCopy() {
        int[] in = {1, 2, 3};
        int[] expectedResult = {1, 2, 3};
        int[] actualResult = exam.intArrayCopy(in);

        assertEquals(expectedResult.length, actualResult.length);
        assertNotEquals(expectedResult, actualResult);
        assertArrayEquals(expectedResult, actualResult);

    }

    @Test
    public void testArrayAdd() {
        int[] a = {1, 2, 3}, b = {4, 5, 6};
        int[] expectedResult = {1, 2, 3, 4, 5, 6};
        int[] actualResult = exam.add(a, b);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testFillArray() {
        int[] in = {1, 2, 3};
        int[] expectedResult = {10, 10, 10};
        int[] actualResult = exam.fillArray(in, 10);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testArraySorting() {
        int[] in = {5, 4, 3, 2, 1};
        int[] expectedResult = {1, 2, 3, 4, 5};
        int[] actualResult = exam.intArraySort(in);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testArrayToString() {
        int[] in = {1, 2, 3, 4, 5};
        String expectedResult = "{1, 2, 3, 4, 5}";
        String actualResult = exam.arrayToString(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFillRandomWithBorder() {
        int[] in = new int[10];
        int border = 10;
        int[] actualResult = exam.fillRandomWithBorder(in, border);
        assertEquals(in.length, actualResult.length);
        for (int i = 0; i < in.length; i++) {
            assertTrue(actualResult[i] >= 0 && actualResult[i] < border);
        }
    }

    @Test
    public void testGetMaxInt(){
        int a = 10, b=20;
        int expectedResult = b;
        int actualResult = exam.getMaxInt(a, b);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetMaxIntFromArray(){
        int in[] = {1,2,3,4,5};
        int expectedResult = 5;
        int actualResult = exam.getMaxInt(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetMinIntFromArray(){
        int in[] = {1,2,3,4,5};
        int expectedResult = 1;
        int actualResult = exam.getMinInt(in);
        assertEquals(expectedResult, actualResult);
    }


}
