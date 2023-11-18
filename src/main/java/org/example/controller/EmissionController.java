package org.example.controller;

import java.util.List;

import org.example.model.GasEmissions;
import org.example.service.StatisticsService;
import org.example.service.StatisticsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/emissions/")
@CrossOrigin(origins = "*")
public class EmissionController {

    private final StatisticsService statisticsService;

    private static final Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    public EmissionController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public List<GasEmissions> listGasEmissions(){

        logger.info("Listing emissions");

        return statisticsService.listGasEmissions();
    }

    @PostMapping
    public ResponseEntity<GasEmissions> addGasEmissions(@RequestBody GasEmissions newGasEmission){

        logger.info("Adding emissions");
        GasEmissions gasEmissions = statisticsService.addGasEmissions(newGasEmission );
        return ResponseEntity.status( HttpStatus.OK).body(gasEmissions);
    }
}