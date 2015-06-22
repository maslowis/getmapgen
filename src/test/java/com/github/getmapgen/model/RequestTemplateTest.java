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