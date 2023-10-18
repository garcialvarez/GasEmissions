package org.example.service;
import org.example.model.GasEmissions;
import org.example.repository.EmissionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class StatisticsServiceImpl implements StatisticsService{

    private static final Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);
    private final EmissionsRepository emissionsRepository;
    public StatisticsServiceImpl(EmissionsRepository emissionsRepository) {
        this.emissionsRepository = emissionsRepository;
    }

    //Mean
    public Double meanCarbonDioxide(){

        logger.info("Carbon Dioxide Mean");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        Double totalCarbonDioxide = 0D;
        for (GasEmissions data : emissionsList) {
            totalCarbonDioxide += data.carbonDioxide();
        }

        return totalCarbonDioxide / emissionsList.size();
    }
    public Double meanMethane(){

        logger.info("Methane Mean");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        Double totalMethane = 0D;
        for (GasEmissions data : emissionsList) {
            totalMethane += data.methane();
        }

        return totalMethane / emissionsList.size();
    }
    public Double meanNitrousOxide(){

        logger.info("Nitrous Oxide Mean");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        Double totalNitrousOxide = 0D;
        for (GasEmissions data : emissionsList) {
            totalNitrousOxide += data.nitrousOxide();
        }

        return totalNitrousOxide / emissionsList.size();
    }
    public Double meanGreenhouseGases(){

        logger.info("Greenhouse Gases Mean");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        Double totalGreenhouseGases = 0D;
        for (GasEmissions data : emissionsList) {
            totalGreenhouseGases += data.greenhouseGases();
        }

        return totalGreenhouseGases / emissionsList.size();
    }

    //Median
    public Double medianCarbonDioxide(){

        logger.info("Carbon Dioxide Median");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        int n = emissionsList.size();
        Double medianCarbonDioxide;
        if (n % 2 == 0) {
            // If data quantity is even, calculates the average of the two middle values
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            medianCarbonDioxide = (emissionsList.get(mid1).carbonDioxide() + emissionsList.get(mid2).carbonDioxide()) / 2.0;
        } else {
            // If data quantity is odd, takes the middle value
            int mid = n / 2;
            medianCarbonDioxide = emissionsList. get(mid).carbonDioxide();
        }

        return medianCarbonDioxide;
    }
    public Double medianMethane(){

        logger.info("Methane Median");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        int n = emissionsList.size();
        Double medianMethane;
        if (n % 2 == 0) {
            // If data quantity is even, calculates the average of the two middle values
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            medianMethane = (emissionsList.get(mid1).methane() + emissionsList.get(mid2).methane()) / 2.0;
        } else {
            // If data quantity is odd, takes the middle value
            int mid = n / 2;
            medianMethane = emissionsList. get(mid).methane();
        }

        return medianMethane;
    }
    public Double medianNitrousOxide(){

        logger.info("Carbon Dioxide Median");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        int n = emissionsList.size();
        Double medianNitrousOxide;
        if (n % 2 == 0) {
            // If data quantity is even, calculates the average of the two middle values
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            medianNitrousOxide = (emissionsList.get(mid1).nitrousOxide() + emissionsList.get(mid2).nitrousOxide()) / 2.0;
        } else {
            // If data quantity is odd, takes the middle value
            int mid = n / 2;
            medianNitrousOxide = emissionsList. get(mid).nitrousOxide();
        }

        return medianNitrousOxide;
    }
    public Double medianGreenhouseGases(){

        logger.info("Greenhouse Gases Median");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        int n = emissionsList.size();
        Double medianGreenhouseGases;
        if (n % 2 == 0) {
            // If data quantity is even, calculates the average of the two middle values
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            medianGreenhouseGases = (emissionsList.get(mid1).greenhouseGases() + emissionsList.get(mid2).greenhouseGases()) / 2.0;
        } else {
            // If data quantity is odd, takes the middle value
            int mid = n / 2;
            medianGreenhouseGases = emissionsList. get(mid).greenhouseGases();
        }

        return medianGreenhouseGases;
    }

}
