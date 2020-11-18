package com.eandbsolutions.services;

import com.eandbsolutions.utils.FoodUtil;
import com.eandbsolutions.utils.LifeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SwissArmyService {
    private Logger logger;
    private final FoodUtil foodUtil;
    private final LifeUtil lifeUtil;

    public SwissArmyService() {
        logger = LogManager.getLogger(getClass());
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
