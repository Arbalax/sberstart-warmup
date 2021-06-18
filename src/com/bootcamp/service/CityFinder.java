package com.bootcamp.service;

import com.bootcamp.model.City;

import java.util.*;

public class CityFinder {
    /**
     * Метод находит сущность City с наибольшим значением population.
     *
     * @param cities Список сущностей City.
     * @return Индекс сущности City с наибольшим значением population в массиве.
     */
    public static int findMaxPopulation(List<City> cities) {
        int maxPopulation = 0;
        int indexOfMax = 0;

        if (cities.isEmpty())
            return -1;
        City[] arrCities = cities.toArray(new City[cities.size()]);
        for (int i = 0; i < arrCities.length; i++) {
            int currentPopulation = arrCities[i].getPopulation();
            if (currentPopulation > maxPopulation) {
                indexOfMax = i;
                maxPopulation = currentPopulation;
            }
        }
        return indexOfMax;
    }

    /**
     * Метод создает Map, содержащую названия регионов с количеством входящих в них городов.
     *
     * @param cities Список сущностей City.
     * @return Map, в которой ключом является значение region, а значением -
     * количество City с данным значением region.
     */
    public static Map<String, Integer> countCitiesInRegions(List<City> cities) {
        Map<String, Integer> result = new TreeMap<>();

        for (City city : cities) {
            String region = city.getRegion();
            if (result.containsKey(region))
                result.replace(region, result.get(region) + 1);
            result.putIfAbsent(city.getRegion(), 1);
        }
        return result;
    }
}