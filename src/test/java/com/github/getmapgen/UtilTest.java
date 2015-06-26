/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Ivan Maslov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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