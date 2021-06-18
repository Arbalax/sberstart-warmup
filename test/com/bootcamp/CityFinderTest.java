package com.bootcamp;

import com.bootcamp.model.City;
import com.bootcamp.service.CityFinder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class CityFinderTest {

    public static List<City> getTestCities() {
        City city0 = new City("Москва", "Московская область", "Центральный", 12_655_050, "1147");
        City city1 = new City("Самара", "Самарская область", "Приволжский", 1_144_759, "1568");
        City city2 = new City("Санкт-Петербург", "Ленинградская область", "Северо-Западный", 5_384_342, "1703");
        City city3 = new City("Кемерово", "Кузбасс", "Сибирский", 552_546, "1918");
        City city4 = new City("Барнаул", "Алтайский край", "Сибирский", 631_124, "1730");

        List<City> testCities = new ArrayList<>();
        testCities.add(city0);
        testCities.add(city1);
        testCities.add(city2);
        testCities.add(city3);
        testCities.add(city4);
        return testCities;
    }

    @Test
    public void testFindMaxPopulation() {

        List<City> testCities = CityFinderTest.getTestCities();

        int maxPopulation = CityFinder.findMaxPopulation(testCities);
        Assert.assertEquals(0, maxPopulation);

        testCities.remove(0);
        maxPopulation = CityFinder.findMaxPopulation(testCities);
        Assert.assertEquals(1, maxPopulation);

        testCities.clear();
        maxPopulation = CityFinder.findMaxPopulation(testCities);
        Assert.assertEquals(-1, maxPopulation);
    }

    @Test
    public void testCountCitiesInRegions(){

        List<City> testCities = CityFinderTest.getTestCities();
        Map<String, Integer> correctMap = new TreeMap<>();
        correctMap.put("Алтайский край", 1);
        correctMap.put("Кузбасс", 1);
        correctMap.put("Ленинградская область", 1);
        correctMap.put("Московская область", 1);
        correctMap.put("Самарская область", 1);

        Map<String, Integer> testMap = CityFinder.countCitiesInRegions(testCities);
        Assert.assertEquals(correctMap, testMap);

        testMap.remove("Кузбасс");
        correctMap.remove("Кузбасс");
        Assert.assertEquals(correctMap, testMap);
    }
}

