package com.bootcamp;

import com.bootcamp.dao.DirectoryDAO;
import com.bootcamp.model.City;
import com.bootcamp.model.Directory;
import com.bootcamp.service.CityFinder;
import com.bootcamp.service.CityParser;
import com.bootcamp.service.CitySorter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEnter the file's path to add data to directory.\n" +
                    "You can enter 'std' to use default file or 'exit' to exit from program.");
            Scanner userScanner = new Scanner(System.in);
            String userPath = userScanner.next();
            Path filePath;
            if (userPath.equals("exit"))
                System.exit(0);
            if (userPath.equals("std")) {
                filePath = Paths.get("resources/Cities.txt");
            } else {
                filePath = Paths.get(userPath);
            }


//        try (Scanner scanner = new Scanner(new File("resources/Cities.txt"))){
            try (Scanner scanner = new Scanner(filePath)) {
                List<City> cities = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    String cityToParse = scanner.nextLine();
                    City city = CityParser.getCity(cityToParse);
                    if (city != null)
                        cities.add(city);
                }
                System.out.println("\nCities was read from file:\n");
                cities.forEach(System.out::println);
                System.out.println("\n==============\n");
                Directory directory = DirectoryDAO.getDirectory();
                DirectoryDAO directoryDAO = new DirectoryDAO();
                directoryDAO.addCities(cities);
                List<City> directoryValues = new ArrayList<>(directory.getCities().values());
                List<City> nameDecreaseSorted = CitySorter.nameDecreaseSorting(directoryValues);
                System.out.println("Cities in name decrease order:\n");
                nameDecreaseSorted.forEach(System.out::println);
                System.out.println("\n==============\n");
                System.out.println("Cities in district and name decrease order:\n");
                List<City> districtAndNameDecreaseSorted =
                        CitySorter.districtAndNameDecreaseSorting(directoryValues);
                districtAndNameDecreaseSorted.forEach(System.out::println);
                System.out.println("\n==============\n");
                System.out.println("Max population:\n");
                int maxPopulationIndex = CityFinder.findMaxPopulation(directoryValues);
                if (maxPopulationIndex != -1) {
                    System.out.println("[" + maxPopulationIndex + "] = "
                            + directoryValues.get(maxPopulationIndex).getPopulation());
                } else {
                    System.out.println("Cities not found.");
                }
                System.out.println("\n==============\n");
                System.out.println("Number of cities in regions:\n");
                Map<String, Integer> numOfCitiesInRegions = CityFinder.countCitiesInRegions(directoryValues);
                for (Map.Entry<String, Integer> entry : numOfCitiesInRegions.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            } catch (IOException e) {
                System.err.println("File in path '" + filePath + "' not found, try another.");
            }
        }
    }
//    private static Path getPath()
}
