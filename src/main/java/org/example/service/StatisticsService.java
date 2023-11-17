package org.example.service;

import java.util.List;
import org.example.model.GasEmissions;

public interface StatisticsService {

    //Mean
    Double meanCarbonDioxide();
    Double meanMethane();
    Double meanNitrousOxide();
    Double meanGreenhouseGases();

    //Median
    Double medianCarbonDioxide();
    Double medianMethane();
    Double medianNitrousOxide();
    Double medianGreenhouseGases();

    //Mode
    Double modeGreenhouseGases();
    List<GasEmissions> listGasEmissions();

    GasEmissions addGasEmissions (GasEmissions newGasEmissions);

}
