package org.pg4200.ex01;
import org.pg4200.ex01.ArrayUtils;

import java.util.Arrays;

public class ArrayUtilsImp implements org.pg4200.ex01.ArrayUtils{
    @Override
    public int min(int[] array) throws IllegalArgumentException {
        isEmpty(array);
        return Arrays.stream(array).min().getAsInt();
    }


    @Override
    public int max(int[] array) throws IllegalArgumentException {
        isEmpty(array);
        return Arrays.stream(array).max().getAsInt();
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        isEmpty(array);
        return Arrays.stream(array).average().getAsDouble();
    }

    private void isEmpty(int[] array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException();
    }

}
