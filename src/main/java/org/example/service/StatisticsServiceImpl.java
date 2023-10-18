package org.example.service;

import org.example.model.GasEmissions;
import org.example.repository.EmissionsInMemoryRepositoryImpl;
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

    //TODO
    //Median
    /*public Double medianCarbonDioxide();
    public Double medianMethane();
    public Double medianNitrousOxide();
    public Double medianGreenhouseGases();
    //Mode
    public Double modeGreenhouseGases();*/

}
