package org.example.service;
import static org.junit.jupiter.api.Assertions.*;
import org.example.repository.EmissionsInMemoryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class StatisticsServiceImplTest {

    private StatisticsService statisticsService;

    @BeforeEach
    void setUp() {this.statisticsService = new StatisticsServiceImpl(new EmissionsInMemoryRepositoryImpl());}

    @Test
    void carbon_dioxide_mean_calculated_successfully(){
        Double carbonDioxideMean = this.statisticsService.meanCarbonDioxide();

        assertNotNull(carbonDioxideMean);
        assertEquals(1429853.405D, carbonDioxideMean,0.001);
    }
    @Test
    void methane_mean_calculated_successfully(){
        Double methaneMean = this.statisticsService.meanMethane();

        assertNotNull(methaneMean);
        assertEquals(255291.1465D, methaneMean,0.001);
    }
    @Test
    void nitrous_oxide_mean_calculated_successfully(){
        Double nitrousOxideMean = this.statisticsService.meanNitrousOxide();

        assertNotNull(nitrousOxideMean);
        assertEquals(90472.969D, nitrousOxideMean,0.001);
    }
    @Test
    void greenhouse_gases_mean_calculated_successfully(){
        Double greenhouseGasesMean = this.statisticsService.meanGreenhouseGases();

        assertNotNull(greenhouseGasesMean);
        assertEquals(1827412.634D, greenhouseGasesMean,0.001);
    }



}
