package com.eandbsolutions.services;

import com.eandbsolutions.utils.UtilityConst;
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
    private UtilityConst mockUtilityConst;
    private UtilityConst spyUtilityConst;

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
    public void callUtilityConstThroughMock() {
        System.out.println("Begin: callUtilityConstThroughMock");

        // Must set a return for called functions when mock is used
        mockUtilityConst = mock(UtilityConst.class);
        when(mockUtilityConst.getTaco()).thenReturn("test-taco");

        ServiceConst service = new ServiceConst(mockUtilityConst);
        String result = service.getThing();
        assertEquals("test-taco", result);

        System.out.println("End: callUtilityConstThroughMock");
    }

    @Test
    public void callUtilityConstThroughSpy() {
        System.out.println("Begin: callUtilityConstThroughSpy");

        // Internals of 'spy'ed class will still be called
        spyUtilityConst = spy(UtilityConst.class);
        ServiceConst service = new ServiceConst(spyUtilityConst);
        String resultNormal = service.getThing();
        assertEquals("taco", resultNormal);

        when(spyUtilityConst.getTaco()).thenReturn("test-taco");
        String resultMocked = service.getThing();
        assertEquals("test-taco", resultMocked);

        System.out.println("End: callUtilityConstThroughSpy");
    }
}