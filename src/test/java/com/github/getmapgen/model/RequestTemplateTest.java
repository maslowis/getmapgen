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

package com.github.getmapgen.model;

import com.github.getmapgen.view.InputValues;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RequestTemplateTest {


    @Test(dataProvider = "getDataRequest")
    public void testGetRequest(InputValues source, String target) {
        RequestTemplate template = new RequestTemplate(source);
        String result = template.getRequest(source.getMaxX(), source.getMaxY(), source.getMinX(), source.getMinY());
        assertEquals(target, result);
    }

    @DataProvider
    public Object[][] getDataRequest() {
        return new Object[][]{
                {new InputValues("test_mo_repl2", "3857", "8150614", "8696525.8792375", "8170181.8792375", "8716093.758475", "http://surgut.itpgrad.ru", "/CacheService/GetTile?FORMAT=&LAYERS=&SERVICE=&VERSION=&REQUEST=&STYLES=&SRS=&BBOX=&WIDTH=&HEIGHT=", "10000", "65924, 65945, 65830, 62949"), "http://surgut.itpgrad.ru/CacheService/GetTile?FORMAT=image%2Fpng&LAYERS=test_mo_repl2%3ACATALOG_65924%2Ctest_mo_repl2%3ACATALOG_65945%2Ctest_mo_repl2%3ACATALOG_65830%2Ctest_mo_repl2%3ACATALOG_62949&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&STYLES=&SRS=EPSG%3A3857&BBOX=8150614,8696525.8792375,8170181.8792375,8716093.758475&WIDTH=256&HEIGHT=256"}
        };
    }
}