package com.eandbsolutions.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CacheKeyTest {
    private CacheKey cacheKeyFull;
    private CacheKey cacheKeyCusip;
    private CacheKey cacheKeySecurityId;
    private CacheKey cacheKeyOther;

    private String cusip = "ABC123";
    private Long securityId = 123L;

    @Before
    public void setup() {
        cacheKeyFull = new CacheKey(cusip, securityId);
        cacheKeyCusip = new CacheKey(cusip, null);
        cacheKeySecurityId = new CacheKey(null, securityId);
        cacheKeyOther = new CacheKey("DEF456", 456L);
    }

    @Test
    public void fullToCusipShouldCorrectlyMatchCusip() {
        assertTrue(cacheKeyFull.equals(cacheKeyCusip));
    }

    @Test
    public void cusipToFullShouldCorrectlyMatchCusip() {
        assertTrue(cacheKeyCusip.equals(cacheKeyFull));
    }

    @Test
    public void fullToSecurityIdShouldCorrectlyMatchSecurityId() {
        assertTrue(cacheKeyFull.equals(cacheKeySecurityId));
    }

    @Test
    public void securityIdToFullShouldCorrectlyMatchSecurityId() {
        assertTrue(cacheKeySecurityId.equals(cacheKeyFull));
    }

    @Test
    public void otherToSecurityIdShouldCorrectlySkipNonMatchingSecurityId() {
        assertFalse(cacheKeyOther.equals(cacheKeySecurityId));
    }

    @Test
    public void securityIdToOtherShouldCorrectlySkipNonMatchingSecurityId() {
        assertFalse(cacheKeySecurityId.equals(cacheKeyOther));
    }

    @Test
    public void otherToCusipShouldCorrectlySkipNonMatchingCusip() {
        assertFalse(cacheKeyOther.equals(cacheKeyCusip));
    }

    @Test
    public void cusipToOtherShouldCorrectlySkipNonMatchingCusip() {
        assertFalse(cacheKeyCusip.equals(cacheKeyOther));
    }
}
