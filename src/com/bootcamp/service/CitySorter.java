package com.bootcamp.service;

import com.bootcamp.model.City;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CitySorter {

    /**
     * Метод сортирует список городов по наименованию в алфавитном порядке по убыванию.
     *
     * @param cities Список сущностей City.
     * @return Новый список сущностей City, отсортированный по убыванию значения
     * поля name без учета регистра букв.
     */
    public static List<City> nameDecreaseSorting(List<City> cities) {
//        Comparator<City> nameComparator =
//                (h1, h2) -> h2.getName().compareToIgnoreCase(h1.getName());
        return cities.stream()
                .sorted(Comparator.comparing(City::getName)
                        .reversed())
                .collect(Collectors.toList());
    }

    /**
     * Метод сортирует список городов по округу, а затем по наименованию
     * в алфавитном порядке по убыванию.
     *
     * @param cities Список сущностей City.
     * @return Новый список сущностей City, отсортированный по убыванию значения
     * поля district, а затем поля name с учетом регистра букв.
     */
    public static List<City> districtAndNameDecreaseSorting(List<City> cities) {
        return cities.stream()
                .sorted(Comparator.comparing(City::getDistrict)
                        .thenComparing(City::getName).reversed())
                .collect(Collectors.toList());
    }

}
