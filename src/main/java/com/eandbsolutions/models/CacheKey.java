package com.eandbsolutions.models;

import java.util.Objects;

public class CacheKey {
    private String cusip;
    private Long securityId;

    public CacheKey(String cusip, Long securityId) {
        this.cusip = cusip;
        this.securityId = securityId;
    }

    public CacheKey(Long securityId) {
        this.securityId = securityId;
    }

    public CacheKey(String cusip) {
        this.cusip = cusip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheKey cacheKey = (CacheKey) o;

        if (!Objects.equals(cusip, cacheKey.getCusip())) {
            if (!Objects.equals(securityId, cacheKey.getSecurityId())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cusip, securityId);
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public Long getSecurityId() {
        return securityId;
    }

    public void setSecurityId(Long securityId) {
        this.securityId = securityId;
    }
}
