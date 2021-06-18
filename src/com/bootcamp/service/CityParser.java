package com.bootcamp.service;

import com.bootcamp.ParseCityException;
import com.bootcamp.model.City;

import java.util.Arrays;
import java.util.List;

public class CityParser {
    private static int lineCounter = 0;

    /**
     * Метод парсит строку и созадет на ее основе сущность City.
     *
     * @param cityToParse Строка, из которой необходимо получить данные для полей City.
     * @return сущность City или null, если в исходной строке недостаточно параметров.
     */
    public static City getCity(String cityToParse) {
        try {
            List<String> parsedCity = Arrays.asList(cityToParse.split(";"));
            lineCounter++;
            if (parsedCity.size() < 6)
                throw new ParseCityException("Line " + lineCounter + ". Not enough parameters. Need 6, have " + parsedCity.size() +
                        ". Input string is \"" + cityToParse + "\".");
            String name = parsedCity.get(1).trim();
            String region = parsedCity.get(2).trim();
            String district = parsedCity.get(3).trim();
            int population = Integer.parseInt(parsedCity.get(4));
            String foundation = parsedCity.get(5).trim();
            return new City(name, region, district, population, foundation);
        } catch (ParseCityException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
