package edu.umb.cs681.hw05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class NASADataProcessor {

    private static final String API_BASE_URL = "https://power.larc.nasa.gov/api/temporal/daily/point";

    public static void main(String[] args) {
        // Define locations
        List<Location> locations = List.of(
                new Location(42.3601, -71.0589, "Boston"), // Boston, MA
                new Location(40.7128, -74.0060, "New York"), // New York, NY
                new Location(38.9072, -77.0369, "Washington, D.C."), // Washington, D.C.
                new Location(32.0809, -81.0912, "Savannah"), // Savannah, Georgia
                new Location(39.2904, -76.6122, "Baltimore"), // Baltimore, Maryland
                new Location(25.7617, -80.1918, "Miami"), // Miami, Florida
                new Location(39.9526, -75.1652, "Philadelphia"), // Philadelphia, Pennsylvania
                new Location(33.7488, -84.3877, "Atlanta"), // Atlanta, Georgia
                new Location(35.7796, -78.6382, "Raleigh"), // Raleigh, North Carolina
                new Location(40.7178, -74.0431, "Jersey City") // Jersey City, New Jersey
        );

        // Define start and end dates
        LocalDate startDate = LocalDate.of(2023, 5, 1);
        LocalDate endDate = LocalDate.of(2023, 8, 31);

        // Process 1: Best time to grow crops with proper sunlight and high temperature
        System.out.println("Processing for growing crops:");
        List<Location> sunnyLocations = findTop3CitiesForCrops(locations, startDate, endDate);
        System.out.println("Top 3 cities to grow Peanuts and other crops that need sunlight and high temperature:");
        sunnyLocations.forEach(location -> System.out.println(location.getName()));

        // Process 2: Best time for tourists to travel the East Coast(when its not
        // cloudy and not too cold)
        System.out.println("\nProcessing for tourist-friendly cities:");
        List<Location> bestCities = findTop3CitiesForTourists(locations, startDate,
                endDate);
        System.out.println("\nTop 3 cities for tourists with moderate temperature and No Clouds:");
        bestCities.forEach(location -> System.out.println(location.getName()));

        // Process 3: Calculate statistics for downloaded data
        System.out.println("\nProcessing for statistics:");
        Map<String, DoubleSummaryStatistics> temperatureStats = new HashMap<>();
        locations.forEach(location -> {
            try {
                System.out.println("Downloading data for " + location.getName() + "...");
                String temperatureUrl = buildApiUrl(location.getLatitude(),
                        location.getLongitude(), startDate, endDate,
                        "T2M");
                List<String> temperatureCsvData = downloadData(temperatureUrl);
                System.out.println("Processing data for " + location.getName() + "...");
                List<Double> temperatures = processData(temperatureCsvData);
                DoubleSummaryStatistics stats = temperatures.stream().mapToDouble(Double::doubleValue)
                        .summaryStatistics();
                temperatureStats.put(location.getName(), stats);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(
                "\nStatistics for East Coast Cities - temperature data during summer(May 1st - August 31st 2023):");
        printStatistics(temperatureStats);
    }

    private static List<Location> findTop3CitiesForCrops(List<Location> locations, LocalDate startDate,
            LocalDate endDate) {
        // Make API calls for clear sky days, soil wetness, and temperature
        Map<Location, Integer> clearSkyDays = new HashMap<>();
        Map<Location, Double> soilWetness = new HashMap<>();
        Map<Location, List<Double>> temperaturesMap = new HashMap<>();
        locations.forEach(location -> {
            try {
                String clearSkyUrl = buildApiUrl(location.getLatitude(), location.getLongitude(), startDate, endDate,
                        "CLRSKY_DAYS");
                List<String> clearSkyCsvData = downloadData(clearSkyUrl);
                int clearSky = processData(clearSkyCsvData).stream().mapToInt(Double::intValue).sum();
                clearSkyDays.put(location, clearSky);

                String soilWetnessUrl = buildApiUrl(location.getLatitude(), location.getLongitude(), startDate, endDate,
                        "GWETTOP");
                List<String> soilWetnessCsvData = downloadData(soilWetnessUrl);
                List<Double> wetnessValues = processData(soilWetnessCsvData);
                double avgWetness = wetnessValues.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                soilWetness.put(location, avgWetness);

                String temperatureUrl = buildApiUrl(location.getLatitude(), location.getLongitude(), startDate, endDate,
                        "T2M");
                List<String> temperatureCsvData = downloadData(temperatureUrl);
                List<Double> temperatures = processData(temperatureCsvData);
                temperaturesMap.put(location, temperatures);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Process the data to find top cities
        return locations.stream()
                .filter(location -> clearSkyDays.getOrDefault(location, 0) > 10)
                .filter(location -> soilWetness.getOrDefault(location, 0.0) > 0.5)
                .filter(location -> {
                    List<Double> temperatures = temperaturesMap.get(location);
                    if (temperatures != null && !temperatures.isEmpty()) {
                        double avgTemperature = temperatures.stream().mapToDouble(Double::doubleValue).average()
                                .orElse(0.0);
                        return avgTemperature > 20 && avgTemperature < 26;
                    }
                    return false;
                })
                .sorted(Comparator.comparingDouble(location -> -clearSkyDays.getOrDefault(location, 0)))
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<Location> findTop3CitiesForTourists(List<Location> locations, LocalDate startDate,
            LocalDate endDate) {
        // Make API calls for clear sky days and temperature
        Map<Location, Integer> clearSkyDays = new HashMap<>();
        Map<Location, Double> averageTemperatures = new HashMap<>();
        locations.forEach(location -> {
            try {
                String clearSkyUrl = buildApiUrl(location.getLatitude(), location.getLongitude(), startDate, endDate,
                        "CLRSKY_DAYS");
                List<String> clearSkyCsvData = downloadData(clearSkyUrl);

                int clearSky = processData(clearSkyCsvData).stream().mapToInt(Double::intValue).sum();
                clearSkyDays.put(location, clearSky);

                String temperatureUrl = buildApiUrl(location.getLatitude(), location.getLongitude(), startDate, endDate,
                        "T2M");
                List<String> temperatureCsvData = downloadData(temperatureUrl);

                List<Double> temperatures = processData(temperatureCsvData);
                double avgTemperature = temperatures.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                averageTemperatures.put(location, avgTemperature);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Process the data to find top 3 cities
        return locations.stream()
                .sorted(Comparator.comparingDouble(location -> -averageTemperatures.getOrDefault(location, 0.0)))
                .filter(location -> clearSkyDays.getOrDefault(location, 0) > 0)
                .filter(location -> clearSkyDays.getOrDefault(location, 0) > 0) // Filter out locations with no clear
                                                                                // sky days
                .limit(3)
                .collect(Collectors.toList());
    }

    // Print Temperature-City statistics in table format
    private static void printStatistics(Map<String, DoubleSummaryStatistics> data) {
        // Print statistics for temperature data
        System.out.println("Location\tMean\tMedian\tMax\tMin\tStandard Deviation");
        data.forEach((location, stats) -> {
            double mean = stats.getAverage();
            double median = median(stats);
            double max = stats.getMax();
            double min = stats.getMin();
            double stdDev = calculateStandardDeviation(stats);
            System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n",
                    location, mean, median, max, min, stdDev);
        });
    }

    // Calculate StandardDeviation with the help of DoubleSummaryStatistics
    private static double calculateStandardDeviation(DoubleSummaryStatistics stats) {
        double mean = stats.getAverage();
        double sumOfSquares = stats.getSum() - (stats.getCount() * mean * mean);
        double variance = sumOfSquares / (stats.getCount() - 1);
        return Math.sqrt(variance);
    }

    // Calculate Median with the help of DoubleSummaryStatistics
    private static double median(DoubleSummaryStatistics stats) {
        return stats.getCount() % 2 == 0 ? (stats.getSum() / stats.getCount() + stats.getMax()) / 2
                : stats.getSum() / stats.getCount();
    }

    // Build Dynamic URL
    private static String buildApiUrl(double latitude, double longitude, LocalDate startDate, LocalDate endDate,
            String dataType) {
        StringBuilder apiUrlBuilder = new StringBuilder(API_BASE_URL);
        apiUrlBuilder.append("?parameters=").append(dataType)
                .append("&community=SB")
                .append("&longitude=").append(longitude)
                .append("&latitude=").append(latitude)
                .append("&start=").append(startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .append("&end=").append(endDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .append("&format=CSV");
        return apiUrlBuilder.toString();
    }

    // process the List of String type data to get the last value of each record
    private static List<Double> processData(List<String> records) {
        List<Double> data = new ArrayList<>();

        for (String record : records) {
            String[] values = record.split(",");
            if (values.length > 0) {
                // Assuming the last value in each record is at index values.length - 1
                try {
                    double number = Double.parseDouble(values[values.length - 1].trim());
                    data.add(number);
                } catch (NumberFormatException e) {
                    // Ignore non-numeric values
                }
            }
        }

        return data;
    }

    // Download data and pre-process a bit(Not storing header)
    private static List<String> downloadData(String url) throws Exception {
        URL apiUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        List<String> records = new ArrayList<>();
        String line;
        boolean headerPassed = false;

        while ((line = reader.readLine()) != null) {
            if (headerPassed) {
                records.add(line);
            } else if (line.startsWith("YEAR,MO,DY")) { // Assuming the header starts with this line
                headerPassed = true;
            }
        }
        reader.close();

        return records;
    }

}
