package org.example.model;

public record GasEmissions(String country,
                           Double carbonDioxide,
                           Double methane,
                           Double nitrousOxide,
                           Double greenhouseGases) {}
