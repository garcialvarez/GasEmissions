package org.example.service;
import static org.junit.jupiter.api.Assertions.*;
import org.example.repository.EmissionsUsingFileRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticsServiceImplTest {

    private StatisticsService statisticsService;

    @BeforeEach
    void setUp() {this.statisticsService = new StatisticsServiceImpl(new EmissionsUsingFileRepositoryImpl());}

    //Mean
    @Test
    void carbon_dioxide_mean_calculated_successfully(){
        Double carbonDioxideMean = this.statisticsService.meanCarbonDioxide();

        assertNotNull(carbonDioxideMean);
        assertEquals(1429853.405D, carbonDioxideMean,0.001); //Checked in calculator
    }
    @Test
    void methane_mean_calculated_successfully(){
        Double methaneMean = this.statisticsService.meanMethane();

        assertNotNull(methaneMean);
        assertEquals(255291.1465D, methaneMean,0.001); //Checked in calculator
    }
    @Test
    void nitrous_oxide_mean_calculated_successfully(){
        Double nitrousOxideMean = this.statisticsService.meanNitrousOxide();

        assertNotNull(nitrousOxideMean);
        assertEquals(90472.969D, nitrousOxideMean,0.001); //Checked in calculator
    }
    @Test
    void greenhouse_gases_mean_calculated_successfully(){
        Double greenhouseGasesMean = this.statisticsService.meanGreenhouseGases();

        assertNotNull(greenhouseGasesMean);
        assertEquals(1827412.634D, greenhouseGasesMean,0.001); //Checked in calculator
    }

    //Median
    @Test
    void carbon_dioxide_median_calculated_successfully(){
        Double carbonDioxideMedian = this.statisticsService.medianCarbonDioxide();

        assertNotNull(carbonDioxideMedian);
        assertEquals(561685.99D, carbonDioxideMedian,0.001); //Checked in calculator
    }
    @Test
    void methane_median_calculated_successfully(){
        Double methaneMedian = this.statisticsService.medianMethane();

        assertNotNull(methaneMedian);
        assertEquals(101387.4D, methaneMedian,0.001); //Checked in calculator
    }
    @Test
    void nitrous_oxide_median_calculated_successfully(){
        Double nitrousOxideMedian = this.statisticsService.medianNitrousOxide();

        assertNotNull(nitrousOxideMedian);
        assertEquals(38926.74D, nitrousOxideMedian,0.001); //Checked in calculator
    }
    @Test
    void greenhouse_gases_median_calculated_successfully(){
        Double greenhouseGasesMedian = this.statisticsService.medianGreenhouseGases();

        assertNotNull(greenhouseGasesMedian);
        assertEquals(728647.28D, greenhouseGasesMedian,0.001); //Checked in calculator
    }

    //Mode
    @Test
    void greenhouse_gases_mode_calculated_successfully(){
        Double greenhouseGasesMode = this.statisticsService.modeGreenhouseGases();

        assertNull(greenhouseGasesMode); //Mode does not apply
    }



}
