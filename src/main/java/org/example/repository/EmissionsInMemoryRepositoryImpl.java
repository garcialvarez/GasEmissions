package org.example.repository;

import org.example.model.GasEmissions;
import java.util.List;

public class EmissionsInMemoryRepositoryImpl implements EmissionsRepository {
    @Override
    public List<GasEmissions> findAllEmissions(){

        List<GasEmissions> emissionsList =
                List.of(
                        new GasEmissions("China",11948120D, 1186285D, 536920D, 13942868D),
                        new GasEmissions("United States",4464106D, 748241D, 258002D, 5505181D),
                        new GasEmissions("India",2396337D, 697655D, 279004D, 3500821D),
                        new GasEmissions("Russia",1797595D, 617227D, 69231D, 2631479D),
                        new GasEmissions("Japan",1054904D, 25783D, 18498D, 1104556D),
                        new GasEmissions("Iran",690864D, 174642D, 39720D, 967649D),
                        new GasEmissions("Germany",629099D, 46918D, 33815D, 781751D),
                        new GasEmissions("South Korea",605449D, 21990D, 10097D, 659330D),
                        new GasEmissions("Indonesia",591319D, 333995D, 75596D, 1024488D),
                        new GasEmissions("Saudi Arabia",574916D, 102631D, 8249D, 712585D),
                        new GasEmissions("Canada",548455D, 100143D, 47080D, 744709D),
                        new GasEmissions("Brazil",441369D, 449214D, 191103D, 1135709D),
                        new GasEmissions("South Africa",427816D, 72213D, 17993D, 546521D),
                        new GasEmissions("Turkey",416514D, 50445D, 38132D, 527956D),
                        new GasEmissions("Mexico",401126D, 143481D, 43291D, 599321D),
                        new GasEmissions("Australia",376779D, 131485D, 49332D, 571903D),
                        new GasEmissions("Vietnam",322018D, 79619D, 26833D, 470578D),
                        new GasEmissions("United Kingdom",318923D, 50416D, 27697D, 398324D),
                        new GasEmissions("Poland",295931D, 29540D, 22864D, 355384D),
                        new GasEmissions("Italy",295419D, 43889D, 15990D, 367129D));

        return emissionsList;
    }
}
