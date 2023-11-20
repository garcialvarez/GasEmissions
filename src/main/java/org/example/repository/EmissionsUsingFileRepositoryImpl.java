package org.example.repository;

import org.example.model.GasEmissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
public class EmissionsUsingFileRepositoryImpl implements EmissionsRepository {

    private static final Logger logger = LoggerFactory.getLogger( EmissionsUsingFileRepositoryImpl.class);
    private final List<GasEmissions> emissionsList;

    public EmissionsUsingFileRepositoryImpl() {
        this.emissionsList = new ArrayList<>(loadEmissions()); //At the moment of constructing the repository, data is loaded from the archive
    }

    private List<GasEmissions> loadEmissions(){
        logger.info( "Loading data from the archive" );
        List<String> plainTextGasEmissonsList =  readFileWithGrades();
        return plainTextGasEmissonsList.stream().map( this::buildGasEmission ).toList();
    }

    private List<String> readFileWithGrades(){
        //This method reads the archive and adds every line in a position of a list

        Path path = Paths.get( "./src/main/resources/emissions.txt");
        try (Stream<String> stream = Files.lines( path)) {
            return stream.toList();
        } catch (IOException x) {
            logger.error("IOException: {0}", x);
        }
        return Collections.emptyList();//Returns an empty list
    }

    private GasEmissions buildGasEmission(String plainTextGrade){
    //This method takes a line of the archive to generate a vector, and create an emission with it

        String[] questionArray = plainTextGrade.split(","); //In the archive, emissions are separated by commas, like this: Country, 123, 123, 123, 123

        return new GasEmissions( questionArray[0], Double.valueOf(questionArray[1]), Double.valueOf(questionArray[2]), Double.valueOf(questionArray[3]), Double.valueOf(questionArray[4]));
    }

    @Override
    public List<GasEmissions> findAllEmissions() { return emissionsList; }

    @Override
    public GasEmissions addGasEmissions (GasEmissions newGasEmissions) {
        this.emissionsList.add( newGasEmissions );

        return this.emissionsList.stream()
                .filter( isTheEmissionsOfTheCountry( newGasEmissions ) )//Looks for the emissions in a list according to the country of the emissions
                .findAny()
                .orElse( null );//If doesn't find them, returns null
    }

    private Predicate<GasEmissions> isTheEmissionsOfTheCountry(GasEmissions newGasEmissions) {
        return p -> p.country().equals( newGasEmissions.country() );
    }
}