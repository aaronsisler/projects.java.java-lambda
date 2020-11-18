package com.eandbsolutions.services;

import com.eandbsolutions.utils.FoodUtil;
import com.eandbsolutions.utils.LifeUtil;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SwissArmyServiceTest {
    private Logger mockLogger;
    private FoodUtil mockFoodUtil;
    private FoodUtil spyFoodUtil;
    private LifeUtil mockLifeUtil;
    private LifeUtil spyLifeUtil;

    @BeforeClass
    public static void inTheBeginning() {
        System.out.println();
    }

    @Before
    public void initialize() {
        mockLogger = mock(Logger.class);
        mockFoodUtil = mock(FoodUtil.class);
        mockLifeUtil = mock(LifeUtil.class);
    }

    @After
    public void teardown() {
//        System.out.println("After test");
        System.out.println();
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void callFoodUtilityThroughMock() {
        System.out.println("Begin: callFoodUtilityThroughMock");

        // Must set a return for called functions when mock is used
        mockFoodUtil = mock(FoodUtil.class);
        when(mockFoodUtil.getFood()).thenReturn("test-taco");

        SwissArmyService swissArmyService = new SwissArmyService(mockLogger, mockFoodUtil, null);
        String result = swissArmyService.getFood();
        assertEquals("test-taco", result);

        System.out.println("End: callFoodUtilityThroughMock");
    }

    @Test
    public void callFoodUtilityThroughSpy() {
        System.out.println("Begin: callFoodUtilityThroughSpy");

        // Internals of 'spy'ed class will still be called
        spyFoodUtil = spy(FoodUtil.class);
        SwissArmyService swissArmyService = new SwissArmyService(mockLogger, spyFoodUtil, null);
        String resultNormal = swissArmyService.getFood();
        assertEquals("taco", resultNormal);

        when(spyFoodUtil.getFood()).thenReturn("test-taco");
        String resultMocked = swissArmyService.getFood();
        assertEquals("test-taco", resultMocked);

        System.out.println("End: callFoodUtilityThroughSpy");
    }
}