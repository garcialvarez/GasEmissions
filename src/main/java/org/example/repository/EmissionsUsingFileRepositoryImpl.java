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
        this.emissionsList = new ArrayList<>(loadEmissions());//Al momento de construir el Repository se cargan los datos desde el archivo
    }

    private List<GasEmissions> loadEmissions(){
        logger.info( "Cargando los datos desde archivo" );
        List<String> plainTextGasEmissonsList =  readFileWithGrades();
        return plainTextGasEmissonsList.stream().map( this::buildGasEmission ).toList();
    }

    private List<String> readFileWithGrades(){
        //Este método lee el archivo y adiciona cada linea en una posicion de una Lista

        //Para el ejercicio se utiliza la ruta donde se encentra el archivo en el codigo fuente.
        //Este ruta es diferente al momento de empaquetar el proyecto

        Path path = Paths.get( "./src/main/resources/emissions.txt");
        try (Stream<String> stream = Files.lines( path)) {
            return stream.toList();
        } catch (IOException x) {
            logger.error("IOException: {0}", x);
        }
        return Collections.emptyList();//Devuelve una lista vacía
    }

    private GasEmissions buildGasEmission(String plainTextGrade){
    /*Este metodo toma una linea del archivo para generar un vector
   y con dicho vector generar una Nota
     */
        String[] questionArray = plainTextGrade.split(",");//En el archivo las notas vienen separadas por comas por ejemplo: UNIDAD 1,4.5D,2023-08-01

        return new GasEmissions( questionArray[0], Double.valueOf(questionArray[1]), Double.valueOf(questionArray[2]), Double.valueOf(questionArray[3]), Double.valueOf(questionArray[4]));
    }

    @Override
    public List<GasEmissions> findAllEmissions() { return emissionsList; }

    @Override
    public GasEmissions addGasEmissions (GasEmissions newGasEmissions) {
        this.emissionsList.add( newGasEmissions );

        return this.emissionsList.stream()
                .filter( isTheEmissionsOfTheCountry( newGasEmissions ) )//Busca las emisiones en la lista que corresponda al pais de las emisiones recien creadas
                .findAny()
                .orElse( null );//Si no las encuentra devuelve nulo
    }

    private Predicate<GasEmissions> isTheEmissionsOfTheCountry(GasEmissions newGasEmissions) {
        return p -> p.country().equals( newGasEmissions.country() );
    }
}
