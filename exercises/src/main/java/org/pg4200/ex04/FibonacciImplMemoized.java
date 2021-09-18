package org.pg4200.ex04;

public class FibonacciImplMemoized implements Fibonacci {

    @Override
    public int compute(int n) throws IllegalArgumentException {
        int[] calculatedValues = new int[n+1];

        return compute(n, calculatedValues);
    }

    private int compute(int n, int[] calculatedValues) {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (calculatedValues[n] == 0) {
            calculatedValues[n] = compute(n-2, calculatedValues) + compute(n-1, calculatedValues);
        }
        return calculatedValues[n];
    }

}
