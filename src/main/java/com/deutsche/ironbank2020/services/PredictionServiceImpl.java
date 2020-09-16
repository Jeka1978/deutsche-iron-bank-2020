package com.deutsche.ironbank2020.services;

import com.ironbank.ironbankstarter2020.ConditionalOnProduction;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static com.deutsche.ironbank2020.constants.Profiles.WINTER_IS_COMING;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile(WINTER_IS_COMING)
public class PredictionServiceImpl implements PredictionService {



    @Override
    public boolean willSurvive(String name) {
        return !name.toLowerCase().contains("stark");
    }
}
