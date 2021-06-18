package com.bootcamp.dao;

import com.bootcamp.model.City;
import com.bootcamp.model.Directory;

import java.util.*;

public class DirectoryDAO {

    private static Directory directory;

    public void addCities(List<City> cities) {
        for (City city : cities) {
            directory.getCities().put(city.getName(), city);
        }
    }

    public static Directory getDirectory() {
        if (directory == null) {
            directory = new Directory(new LinkedHashMap<>());
        }
        return directory;
    }
}
