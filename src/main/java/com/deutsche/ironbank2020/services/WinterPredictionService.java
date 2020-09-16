package com.deutsche.ironbank2020.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static com.deutsche.ironbank2020.constants.Profiles.WINTER_IS_HERE;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile(WINTER_IS_HERE)
public class WinterPredictionService implements PredictionService {
    @Override
    public boolean willSurvive(String name) {
        return name.toLowerCase().contains("lanister");
    }
}
