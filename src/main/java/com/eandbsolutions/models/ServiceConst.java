package com.eandbsolutions.models;

public class ServiceConst {
    private UtilityConst utilityConst;

     public ServiceConst(UtilityConst utilityConst) {
         this.utilityConst = utilityConst == null ? new UtilityConst() : utilityConst;
     }

    public String getThing() {
        return utilityConst.getTaco();
    }
}
