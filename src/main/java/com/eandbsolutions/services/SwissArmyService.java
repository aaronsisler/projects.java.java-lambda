package com.eandbsolutions.services;

import com.eandbsolutions.utils.FoodUtility;
import com.eandbsolutions.utils.LifeUtility;

public class SwissArmyService {
    private FoodUtility foodUtility;
    private LifeUtility lifeUtility;

    public  SwissArmyService(){
        this.foodUtility = new FoodUtility();
        this.lifeUtility = new LifeUtility();
    }

     public SwissArmyService(FoodUtility foodUtility, LifeUtility lifeUtility) {
         this.foodUtility = foodUtility == null ? new FoodUtility() : foodUtility;
         this.lifeUtility = lifeUtility == null ? new LifeUtility() : lifeUtility;
     }

    public String getFood() {
        return foodUtility.getFood();
    }

    public int getLife() {
        return lifeUtility.getLife();
    }
}
