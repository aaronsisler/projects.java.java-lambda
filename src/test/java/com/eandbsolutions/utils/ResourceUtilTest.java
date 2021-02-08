package com.eandbsolutions.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@RunWith(MockitoJUnitRunner.class)
public class ResourceUtilTest {
    private final String TEST_PROPERTY_KEY = "my-test-prop-key";
    private final String TEST_PROPERTY_VALUE = "my-test-prop-value";
    private ResourceUtil resourceUtil;

    //    @BeforeClass
    public static void inTheBeginning() {
//        System.out.println();
    }

    //    @Before
    public void initialize() {
        resourceUtil = new ResourceUtil();
    }

    //    @After
    public void teardown() {
        System.out.println();
    }

    //    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    //    @Test
    public void shouldSetPropertyCorrectly() {
        assertEquals(null, System.getProperty(TEST_PROPERTY_KEY));
        resourceUtil.setResource(TEST_PROPERTY_KEY, TEST_PROPERTY_VALUE);

        assertEquals(TEST_PROPERTY_VALUE, System.getProperty(TEST_PROPERTY_KEY));
    }
}