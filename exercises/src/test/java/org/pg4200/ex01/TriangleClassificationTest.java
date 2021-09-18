package org.pg4200.ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleClassificationTest {

    @Test
    public void isNotTriangle() {
        int a = 0;
        int b = 0;
        int c = 0;
        assertEquals(TriangleClassification.Classification.NOT_A_TRIANGLE,TriangleClassification.classify(a,b,c));
    }

    @Test
    public void isNotAnotherTriangle() {
        assertEquals(TriangleClassification.Classification.NOT_A_TRIANGLE, TriangleClassification.classify(8,5,2));

    }

    @Test
    public void isEquilateral() {
        int a = 2,b = 2, c = 2;

        assertEquals(TriangleClassification.Classification.EQUILATERAL, TriangleClassification.classify(a,b,c));
    }

    @Test
    public void isIsoceles() {
        int a = 3, b = 3, c = 5;
        assertEquals(TriangleClassification.Classification.ISOSCELES, TriangleClassification.classify(a,b,c));
    }

    @Test
    public void isScalene() {
        int a = 3, b = 4, c = 5;
        assertEquals(TriangleClassification.Classification.SCALENE, TriangleClassification.classify(a,b,c));
    }
}
