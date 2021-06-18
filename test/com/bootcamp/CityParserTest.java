package com.bootcamp;

import com.bootcamp.model.City;
import com.bootcamp.service.CityParser;
import org.junit.Assert;
import org.junit.Test;

public class CityParserTest {

    City city0 = new City("Москва", "Московская область", "Центральный", 12_655_050, "1147");
    City city1 = new City("Самара", "Самарская область", "Приволжский", 1_144_759, "1568");
    City city2 = new City("Санкт-Петербург", "Ленинградская область", "Северо-Западный", 5_384_342, "1703");
    City city3 = new City("Кемерово", "Кузбасс", "Сибирский", 552_546, "1918");
    City city4 = new City("Барнаул", "Алтайский край", "Сибирский", 631_124, "1730");

    @Test
    public void testGetCity() {
        String string0 = "1;Москва;Московская область;Центральный;12655050;1147";
        String string1 = "2;Самара;Самарская область;Приволжский;1144759;1568;1234567890";
        String string2 = "3;Санкт-Петербург;Ленинградская область;Северо-Западный;5384342;1703";
        String string3 = "4;Кемерово;Кузбасс;Сибирский;552546;1918";
        String string4 = "Барнаул;Алтайский край;Сибирский;631124;1730";

        Assert.assertEquals(city0, CityParser.getCity(string0));
        Assert.assertEquals(city1, CityParser.getCity(string1));
        Assert.assertEquals(city2, CityParser.getCity(string2));
        Assert.assertEquals(city3, CityParser.getCity(string3));
        Assert.assertNull(CityParser.getCity(string4));
    }
}
