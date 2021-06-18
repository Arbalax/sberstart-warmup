package com.bootcamp.model;

import java.util.Map;

public class Directory {

    private Map<String, City> cities;

    public Directory(Map<String, City> cities) {
        this.cities = cities;
    }

    public Map<String, City> getCities() {
        return cities;
    }

}
