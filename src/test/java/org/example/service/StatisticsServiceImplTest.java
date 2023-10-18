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
    void carbon_dioxide_mean_calculated_succesfully(){
        Double carbonDioxideMean = this.statisticsService.meanCarbonDioxide();

        assertNotNull(carbonDioxideMean);
        assertEquals(1429853.405D, carbonDioxideMean);
    }



}
