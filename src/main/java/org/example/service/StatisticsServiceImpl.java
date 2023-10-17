package org.example.service;

import org.example.repository.EmissionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatisticsServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);
    private final EmissionsRepository emissionsRepository;
    public StatisticsServiceImpl(EmissionsRepository emissionsRepository) {
        this.emissionsRepository = emissionsRepository;
    }
}
