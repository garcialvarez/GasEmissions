package org.example;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import org.example.repository.EmissionsInMemoryRepositoryImpl;
import org.example.service.StatisticsService;
import org.example.service.StatisticsServiceImpl;

public class ApplicationRunner {
    public static void main(String[] args) {

        StatisticsService statisticsService =
                new StatisticsServiceImpl(new EmissionsInMemoryRepositoryImpl());

        DecimalFormat df = new DecimalFormat("###,###.00");
//
//        System.out.println(
//                MessageFormat.format(
//                        "Suma de número calificaciones: {0}", academicRecordService.sumNumberOfGrades()));
//
//        System.out.println(
//                MessageFormat.format("Promedio: {0}", academicRecordService.calculateAverage()));
        System.out.println(df.format(statisticsService.meanCarbonDioxide()));
        System.out.println(df.format(statisticsService.meanMethane()));
        System.out.println(df.format(statisticsService.meanNitrousOxide()));
        System.out.println(df.format(statisticsService.meanGreenhouseGases()));
    }
}
