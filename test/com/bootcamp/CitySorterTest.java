package com.bootcamp;

import com.bootcamp.model.City;
import com.bootcamp.service.CitySorter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CitySorterTest {

    @Test
    public void testNameDecreaseSorting() {
        List<City> testCities = CityFinderTest.getTestCities();
        List<City> sortedCities = CitySorter.nameDecreaseSorting(testCities);

        Assert.assertEquals(testCities.get(0), sortedCities.get(2));
        Assert.assertEquals(testCities.get(1), sortedCities.get(1));
        Assert.assertEquals(testCities.get(2), sortedCities.get(0));
        Assert.assertEquals(testCities.get(3), sortedCities.get(3));
        Assert.assertEquals(testCities.get(4), sortedCities.get(4));
    }

    @Test
    public void testDistrictAndNameDecreaseSorting() {
        List<City> testCities = CityFinderTest.getTestCities();
        List<City> sortedCities = CitySorter.districtAndNameDecreaseSorting(testCities);

        Assert.assertEquals(testCities.get(0), sortedCities.get(0));
        Assert.assertEquals(testCities.get(1), sortedCities.get(4));
        Assert.assertEquals(testCities.get(2), sortedCities.get(3));
        Assert.assertEquals(testCities.get(3), sortedCities.get(1));
        Assert.assertEquals(testCities.get(4), sortedCities.get(2));
    }
}
