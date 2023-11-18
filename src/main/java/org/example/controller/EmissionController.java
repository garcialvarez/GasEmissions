package org.example.controller;

import java.util.List;

import org.example.model.GasEmissions;
import org.example.service.StatisticsService;
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

    //StatisticsService statisticsService = new StatisticsServiceImpl( new EmissionsUsingFileRepositoryImpl());
    private final StatisticsService statisticsService;

    public EmissionController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public List<GasEmissions> listGasEmissions(){

        System.out.println("listing emissions");
        List<GasEmissions> emissionsList = statisticsService.listGasEmissions();

        //http://localhost:8080/gasEmissions/

        return emissionsList;
    }

    @PostMapping
    public ResponseEntity<GasEmissions> addGasEmissions(@RequestBody GasEmissions newGasEmission){
        System.out.println("adding emissions");
        GasEmissions gasEmissions = statisticsService.addGasEmissions(newGasEmission );
        return ResponseEntity.status( HttpStatus.OK).body(gasEmissions);
    }
}