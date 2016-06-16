package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class MyListImplTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("\navant tout\n\n");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("après tout\n");
    }
    
    @Before
    public void setUp() throws Exception {
        System.out.println("avant un test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("après un test\n");
    }

    @Test
    public void add() throws Exception {
        System.out.println("test add");
    }

    @Test
    public void removeAt() throws Exception {
        System.out.println("test removeAt");
    }

    @Test
    public void removeItem() throws Exception {
        System.out.println("test removeItem");
    }

    @Test
    public void setAt() throws Exception {
        System.out.println("test setAt");
    }

}
