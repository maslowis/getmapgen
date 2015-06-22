package com.github.getmapgen;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UtilTest {

    @Test(dataProvider = "getStringToSplit")
    public void testSplitString(String source, String[] target) {
        final String[] result = Util.splitString(source);
        assertEquals(target, result);
    }

    @Test(dataProvider = "getStringsToInts")
    public void testStringToInt(String[] source, int[] target) {
        final int[] result = Util.stringToInt(source);
        assertEquals(target, result);
    }

    @DataProvider
    public Object[][] getStringToSplit() {
        return new Object[][]{
                {"1 22 333 4444 55555 666666", new String[]{"1", "22", "333", "4444", "55555", "666666"}},
                {"1,22,333,4444,55555,666666", new String[]{"1", "22", "333", "4444", "55555", "666666"}},
                {"1\n22\n333\n4444\n55555\n666666", new String[]{"1", "22", "333", "4444", "55555", "666666"}},
                {"1 \n22 \n333 \n4444 \n55555 \n666666", new String[]{"1", "22", "333", "4444", "55555", "666666"}},
                {"1,\n22,\n333,\n4444,\n55555,\n666666", new String[]{"1", "22", "333", "4444", "55555", "666666"}},
                {"1, \n22, \n333, \n4444, \n55555, \n666666", new String[]{"1", "22", "333", "4444", "55555", "666666"}}
        };
    }

    @DataProvider
    public Object[][] getStringsToInts() {
        return new Object[][]{
                {new String[]{"1", "22", "333", "4444", "55555", "666666"}, new int[]{1, 22, 333, 4444, 55555, 666666}},
        };
    }
}