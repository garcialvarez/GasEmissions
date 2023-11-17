package org.example.service;
import org.example.model.GasEmissions;
import org.example.repository.EmissionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class StatisticsServiceImpl implements StatisticsService{

    private final EmissionsRepository emissionsRepository;
    public StatisticsServiceImpl(EmissionsRepository emissionsRepository) {
        this.emissionsRepository = emissionsRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    //Mean
    public Double meanCarbonDioxide(){

        logger.info("Carbon Dioxide Mean");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        Double totalCarbonDioxide = emissionsList.stream().mapToDouble(GasEmissions::carbonDioxide).sum();

        return totalCarbonDioxide / emissionsList.size();

    }
    public Double meanMethane(){

        logger.info("Methane Mean");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        Double totalMethane = emissionsList.stream().mapToDouble(GasEmissions::methane).sum();

        return totalMethane / emissionsList.size();
    }
    public Double meanNitrousOxide(){

        logger.info("Nitrous Oxide Mean");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        Double totalNitrousOxide = emissionsList.stream().mapToDouble(GasEmissions::nitrousOxide).sum();

        return totalNitrousOxide / emissionsList.size();
    }
    public Double meanGreenhouseGases(){

        logger.info("Greenhouse Gases Mean");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        Double totalGreenhouseGases = emissionsList.stream().mapToDouble(GasEmissions::greenhouseGases).sum();

        return totalGreenhouseGases / emissionsList.size();
    }

    //Median
    public Double medianCarbonDioxide(){

        logger.info("Carbon Dioxide Median");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();
        emissionsList.sort(Comparator.comparing(GasEmissions::carbonDioxide));

        int n = emissionsList.size();

        if (n % 2 == 0) {
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            return (emissionsList.get(mid1).carbonDioxide() + emissionsList.get(mid2).carbonDioxide()) / 2.0;
        } else {
            int mid = n / 2;
            return emissionsList.get(mid).carbonDioxide();
        }
    }
    public Double medianMethane(){

        logger.info("Methane Median");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();
        emissionsList.sort(Comparator.comparing(GasEmissions::methane));

        int n = emissionsList.size();

        if (n % 2 == 0) {
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            return (emissionsList.get(mid1).methane() + emissionsList.get(mid2).methane()) / 2.0;
        } else {
            int mid = n / 2;
            return emissionsList.get(mid).methane();
        }
    }
    public Double medianNitrousOxide(){

        logger.info("Nitrous Oxide Median");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();
        emissionsList.sort(Comparator.comparing(GasEmissions::nitrousOxide));

        int n = emissionsList.size();


        if (n % 2 == 0) {
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            return (emissionsList.get(mid1).nitrousOxide() + emissionsList.get(mid2).nitrousOxide()) / 2.0;
        } else {
            int mid = n / 2;
            return emissionsList.get(mid).nitrousOxide();
        }
    }
    public Double medianGreenhouseGases(){

        logger.info("Greenhouse Gases Median");

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();
        emissionsList.sort(Comparator.comparing(GasEmissions::greenhouseGases));

        int n = emissionsList.size();

        if (n % 2 == 0) {
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            return (emissionsList.get(mid1).greenhouseGases() + emissionsList.get(mid2).greenhouseGases()) / 2.0;
        } else {
            int mid = n / 2;
            return emissionsList.get(mid).greenhouseGases();
        }
    }

    //Mode
    public Double modeGreenhouseGases(){

        List<GasEmissions> emissionsList = this.emissionsRepository.findAllEmissions();

        int frequencyCounter = 0;
        int maxFrequency = 0;
        Double mode = -1D;

        for (int i = 1; i < emissionsList.size(); i++){

            if (Objects.equals(emissionsList.get(i).greenhouseGases(), emissionsList.get(i - 1).greenhouseGases())){
                frequencyCounter++;
            }else{
                frequencyCounter=1;
            }

            if(frequencyCounter > maxFrequency){
                maxFrequency = frequencyCounter;
                mode = emissionsList.get(i).greenhouseGases();
            }
        }

        if(maxFrequency == 1){
            logger.info("Mode does not apply");
            return null;
        }else{
            return mode;
        }
    }

    @Override
    public List<GasEmissions> listGasEmissions() { return this.emissionsRepository.findAllEmissions(); }

    @Override
    public GasEmissions addGasEmissions(GasEmissions newGasEmissions) {
        return this.emissionsRepository.addGasEmissions(newGasEmissions);
    }
}
