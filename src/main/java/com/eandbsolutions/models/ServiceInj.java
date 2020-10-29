package com.eandbsolutions.models;

public class ServiceInj {
    private UtilityInj utilityInj;

     public ServiceInj(UtilityInj utilityInj) {
         this.utilityInj = utilityInj == null ? new UtilityInj() : utilityInj;
     }

    public String getThing() {
        return utilityInj.getTaco();
    }
}
