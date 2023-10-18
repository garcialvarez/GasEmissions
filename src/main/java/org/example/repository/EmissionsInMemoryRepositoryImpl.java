package org.example.repository;

import org.example.model.GasEmissions;
import java.util.List;

public class EmissionsInMemoryRepositoryImpl implements EmissionsRepository {
    @Override
    public List<GasEmissions> findAllEmissions(){

        List<GasEmissions> emissionsList =
                List.of(
                        new GasEmissions("China",11948120.39D, 1186285.50D, 536920.23D, 13942868.65D),
                        new GasEmissions("United States",4464106.23D, 748241.95D, 258002.12D, 5505181.63D),
                        new GasEmissions("India",2396337.16D, 697655.79D, 279004.78D, 3500821.56D),
                        new GasEmissions("Russia",1797595.34D, 617227.45D, 69231.52D, 2631479.97D),
                        new GasEmissions("Japan",1054904.14D, 25783.20D, 18498.24D, 1104556.11D),
                        new GasEmissions("Iran",690864.47D, 174642.66D, 39720.97D, 967649.42D),
                        new GasEmissions("Germany",629099.32D, 46918.62D, 33815.79D, 781751.12D),
                        new GasEmissions("South Korea",605449.94D, 21990.23D, 10097.92D, 659330.40D),
                        new GasEmissions("Indonesia",591319.32D, 333995.79D, 75596.81D, 1024488.46D),
                        new GasEmissions("Saudi Arabia",574916.64D, 102631.34D, 8249.79D, 712585.13D),
                        new GasEmissions("Canada",548455.34D, 100143.46D, 47080.74D, 744709.43D),
                        new GasEmissions("Brazil",441369.91D, 449214.87D, 191103.98D, 1135709.94D),
                        new GasEmissions("South Africa",427816.24D, 72213.45D, 17993.55D, 546521.65D),
                        new GasEmissions("Turkey",416514.44D, 50445.65D, 38132.51D, 527956.78D),
                        new GasEmissions("Mexico",401126.14D, 143481.73D, 43291.64D, 599321.79D),
                        new GasEmissions("Australia",376779.95D, 131485.29D, 49332.83D, 571903.46D),
                        new GasEmissions("Vietnam",322018.76D, 79619.63D, 26833.67D, 470578.32D),
                        new GasEmissions("United Kingdom",318923.72D, 50416.24D, 27697.36D, 398324.97D),
                        new GasEmissions("Poland",295931.29D, 29540.61D, 22864.79D, 355384.14D),
                        new GasEmissions("Italy",295419.36D, 43889.47D, 15990.14D, 367129.74D));

        return emissionsList;
    }
}
