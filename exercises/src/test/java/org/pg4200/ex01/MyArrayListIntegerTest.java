package org.pg4200.ex01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyArrayListIntegerTest {

    /**
     * All tests here are based on an interface.
     * They should work regardless of the chosen implementation.
     * So, here we use an abstract method to specify that the concrete
     * class that will extend this one must provide the chosen implementation
     * here.
     */
    private MyArrayListInteger myArrayListInteger;

    @BeforeEach
    public void initTest(){
        //before each test is executed, create a new container
        myArrayListInteger = new MyArrayListInteger();
    }


    @Test
    public void testEmpty(){

        //a newly created container should be empty
        assertEquals(0, myArrayListInteger.size());
    }


    @Test
    public void testAddOneElement(){

        int n = myArrayListInteger.size();

        myArrayListInteger.add(1);

        assertEquals(n + 1, myArrayListInteger.size());

        /*
            An option here would have to be to test if size is just 1, as
            the container (should) starts empty, instead of n+1.
            However, we would conflate the testing of two different features
            in the same test.
            Here, I am testing that adding an element increases the size by 1,
            regardless of its original size (even though I do actually test it
            with just 0 as starting size, although I could add more tests to handle
            further different cases)
         */
    }

    @Test
    public void testAddAndRetrieveElement() {

        Integer value = 1;

        myArrayListInteger.add(value);

        /*
            As the container is empty, I m expecting to have it in position 0
         */
        Integer res = myArrayListInteger.get(0);

        assertEquals(value, res);
    }

    @Test
    public void testAdd5Elements(){

        assertEquals(0, myArrayListInteger.size());
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        myArrayListInteger.add(a);
        myArrayListInteger.add(b);
        myArrayListInteger.add(c);
        myArrayListInteger.add(a);
        myArrayListInteger.add(a);

        assertEquals(1, myArrayListInteger.get(0));
        assertEquals(2, myArrayListInteger.get(1));
        assertEquals(3, myArrayListInteger.get(2));
        assertEquals(1, myArrayListInteger.get(3));
        assertEquals(1, myArrayListInteger.get(4));
    }

    @Test
    public void testOutOfIndex(){

        assertNull(myArrayListInteger.get(-5));
        assertNull(myArrayListInteger.get(42));
    }
}
