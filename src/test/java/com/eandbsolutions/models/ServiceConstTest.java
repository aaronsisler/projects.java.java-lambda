package com.eandbsolutions.models;

import com.eandbsolutions.services.SwissArmyService;
import com.eandbsolutions.utils.FoodUtility;
import com.eandbsolutions.utils.LifeUtility;
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
public class ServiceConstTest {
    private FoodUtility mockFoodUtility;
    private FoodUtility spyFoodUtility;
    private LifeUtility mockLifeUtility;
    private LifeUtility spyLifeUtility;

    @BeforeClass
    public static void inTheBeginning() {
//        System.out.println("Before tests");
        System.out.println();
    }

    @Before
    public void initialize() {
//        System.out.println("Before test");
    }

    @After
    public void teardown() {
//        System.out.println("After test");
        System.out.println();
    }

    //    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void callFoodUtilityThroughMock() {
        System.out.println("Begin: callFoodUtilityThroughMock");

        // Must set a return for called functions when mock is used
        mockFoodUtility = mock(FoodUtility.class);
        when(mockFoodUtility.getFood()).thenReturn("test-taco");

        SwissArmyService swissArmyService = new SwissArmyService(mockFoodUtility, null);
        String result = swissArmyService.getFood();
        assertEquals("test-taco", result);

        System.out.println("End: callFoodUtilityThroughMock");
    }

    @Test
    public void callFoodUtilityThroughSpy() {
        System.out.println("Begin: callFoodUtilityThroughSpy");

        // Internals of 'spy'ed class will still be called
        spyFoodUtility = spy(FoodUtility.class);
        SwissArmyService swissArmyService = new SwissArmyService(spyFoodUtility, null);
        String resultNormal = swissArmyService.getFood();
        assertEquals("taco", resultNormal);

        when(spyFoodUtility.getFood()).thenReturn("test-taco");
        String resultMocked = swissArmyService.getFood();
        assertEquals("test-taco", resultMocked);

        System.out.println("End: callFoodUtilityThroughSpy");
    }
}