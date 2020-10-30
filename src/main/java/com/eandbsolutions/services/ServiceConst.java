package com.eandbsolutions.services;

import com.eandbsolutions.utils.UtilityConst;

public class ServiceConst {
    private UtilityConst utilityConst;

     public ServiceConst(UtilityConst utilityConst) {
         this.utilityConst = utilityConst == null ? new UtilityConst() : utilityConst;
     }

    public String getThing() {
        return utilityConst.getTaco();
    }
}
