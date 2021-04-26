package com.eandbsolutions.services;

import com.eandbsolutions.utils.FoodUtil;
import com.eandbsolutions.utils.LifeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwissArmyService {
    private final FoodUtil foodUtil;
    private final LifeUtil lifeUtil;
    private Logger logger;

    public SwissArmyService() {
        logger = LoggerFactory.getLogger(getClass());
        foodUtil = new FoodUtil();
        lifeUtil = new LifeUtil();
        fireLogger("Init");
    }

    public SwissArmyService(Logger logger, FoodUtil foodUtil, LifeUtil lifeUtil) {
        this.logger = logger;
        this.foodUtil = foodUtil;
        this.lifeUtil = lifeUtil;
    }

    public String getFood() {
        return foodUtil.getFood();
    }

    public int getLife() {
        return lifeUtil.getLife();
    }

    public void fireLogger(String message) {
        logger.info(message);
    }
}
