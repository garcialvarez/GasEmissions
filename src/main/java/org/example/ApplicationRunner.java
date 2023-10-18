package org.example;
import org.example.repository.EmissionsInMemoryRepositoryImpl;
import org.example.service.StatisticsService;
import org.example.service.StatisticsServiceImpl;
import java.text.DecimalFormat;
import java.text.MessageFormat;

public class ApplicationRunner {
    public static void main(String[] args) {

        StatisticsService statisticsService =
                new StatisticsServiceImpl(new EmissionsInMemoryRepositoryImpl());

        DecimalFormat df = new DecimalFormat("###,###.00");

        //Mean
        System.out.println(
                MessageFormat.format(
                        "Carbon Dioxide emissions mean: {0}",
                        df.format(statisticsService.meanCarbonDioxide())));
        System.out.println(
                MessageFormat.format(
                        "Methane emissions mean: {0}",
                        df.format(statisticsService.meanMethane())));
        System.out.println(
                MessageFormat.format(
                        "Nitrous Oxide emissions mean: {0}",
                        df.format(statisticsService.meanNitrousOxide())));
        System.out.println(
                MessageFormat.format(
                        "Greenhouse Gases emissions mean: {0}\n",
                        df.format(statisticsService.meanGreenhouseGases())));

        //Median
        System.out.println(
                MessageFormat.format(
                        "\nCarbon Dioxide emissions median: {0}",
                        df.format(statisticsService.medianCarbonDioxide())));
        System.out.println(
                MessageFormat.format(
                        "Methane emissions median: {0}",
                        df.format(statisticsService.medianMethane())));
        System.out.println(
                MessageFormat.format(
                        "Nitrous Oxide emissions median: {0}",
                        df.format(statisticsService.medianNitrousOxide())));
        System.out.println(
                MessageFormat.format(
                        "Greenhouse Gases emissions median: {0}\n",
                        df.format(statisticsService.medianGreenhouseGases())));
    }
}
