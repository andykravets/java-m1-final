import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

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

    @Test
    public void testIsPairNumber(){
        int a = 2, b = 3;
        boolean expectedResultA = true;
        boolean expectedResultB = false;

        boolean actualResultA = exam.isPairNumber(a);
        boolean actualResultB = exam.isPairNumber(b);

        assertEquals(expectedResultA, actualResultA);
        assertEquals(expectedResultB, actualResultB);
    }

    @Test
    public void testIsPrimeNumber(){
        int a = 15, b = 7;

        boolean expectedResultA = false;
        boolean expectedResultB = true;

        boolean actualResultA = exam.isPrimeNumber(a);
        boolean actualResultB = exam.isPrimeNumber(b);

        assertEquals(expectedResultA, actualResultA);
        assertEquals(expectedResultB, actualResultB);
    }

    @Test
    public void testDeleteSameNumbersFromArray(){
        int[] in = {1,1,2,2,3,3,4,4,5,5};
        int[] expectedResult = {1,2,3,4,5};
        int[] actualResult = exam.deleteSameNumbersFromArray(in);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteAllLowerThen(){
        int[] in = {1,1,2,2,3,3,4,4,5,5};
        int border = 3;
        int[] expectedResult = {3,3,4,4,5,5};
        int[] actualResult = exam.deleteAllLowerThen(in, border);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testStringReplacement(){
        String in = "Hello world!";
        String replace = "John Galt";
        String expectedResult = "Hello John Galt!";
        String actualResult = exam.stringReplacement(in, replace);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetRandomPrime(){
        int primeResult = exam.getRandomPrime();
        assertNotEquals(0, primeResult);
        assertTrue(primeResult > 1);
        for (int i = 2; i < primeResult-1; i++) {
            if(primeResult%i==0){
                assertTrue(false);
            }
        }
        assertFalse(primeResult%2==0);
    }

    @Test
    public void testGetDateFromLong(){
        long time = System.currentTimeMillis();
        Class expectedResult = Date.class;
        Date resultDate = exam.getDateFromLong(time);
        assertNotNull(resultDate);
        Class actualResult = resultDate.getClass();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetStringFromDate(){
        Date in = new Date(660373200000l);
        String expectedResult = "05/12/1990";
        String actualResult = exam.getGetStringFromDate(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testArrayShuffle(){
        int[] in = {1,2,3,4,5};
        int[] actualResult = exam.intArrayShuffle(in);
        assertThat(in, not(equalTo(actualResult)));
    }

    @Test
    public void testBigNumberAddition(){
        String a = "123213211234135421521512523523521523523523523523523553352352353523";
        String b = "675685823483648356814675472584254782145863483457813582158313485821548482486482";
        String expectedResult ="675685823483771570025909608005776294669387004981337105681837009374900834840005";

        String actualResult = exam.sumBigNumbers(a,b);
        assertEquals(expectedResult, actualResult);

    }
}
