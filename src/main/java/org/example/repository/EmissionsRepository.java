package org.example.repository;
import java.util.List;
import org.example.model.GasEmissions;

public interface EmissionsRepository {

    List<GasEmissions> findAllEmissions();

    GasEmissions addGasEmissions(GasEmissions newGasEmissions);
}
