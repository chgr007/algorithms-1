package org.pg4200.ex08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnotherExampleStreamTest {

    @Test
    void testCount() {
           AnotherStreamList<String> list = new AnotherStreamList<>();

           list.add("a");
           list.add("b");
           list.add("c");
           list.add("strange");

           assertEquals(4, list.stream().count());
    }

    @Test
    void testDistinct() {
        AnotherStreamList<String> items = new AnotherStreamList<>();

        items.add("a");
        items.add("b");
        items.add("a");
        items.add("c");

        assertEquals(3, items.stream().distinct().count());
    }
}
