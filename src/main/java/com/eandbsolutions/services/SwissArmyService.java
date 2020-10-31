package com.eandbsolutions.services;

import com.eandbsolutions.utils.FoodUtility;
import com.eandbsolutions.utils.LifeUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwissArmyService {
    //    private Logger logger = LoggerFactory.getLogger(SwissArmyService.class);
    private final Logger logger;
    private final FoodUtility foodUtility;
    private final LifeUtility lifeUtility;

    public SwissArmyService() {
        this.logger = LoggerFactory.getLogger(getClass());
        this.foodUtility = new FoodUtility();
        this.lifeUtility = new LifeUtility();
    }

    public SwissArmyService(Logger logger, FoodUtility foodUtility, LifeUtility lifeUtility) {
        this.logger = logger;
        this.foodUtility = foodUtility == null ? new FoodUtility() : foodUtility;
        this.lifeUtility = lifeUtility == null ? new LifeUtility() : lifeUtility;

    }

    public String getFood() {
        return foodUtility.getFood();
    }

    public int getLife() {
        return lifeUtility.getLife();
    }

    public void fireLogger(String message) {
        logger.info(message);
    }
}
