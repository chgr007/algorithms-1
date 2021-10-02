package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;

import java.util.Arrays;

public class QuickSort implements MySort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        Integer[] intArray = {5,4,2,7,3,6,1};
        quickSort.sort(intArray);
        Arrays.stream(intArray).forEach(System.out::print);
    }

    public <T extends Comparable<T>> void sort(T[] a) {

        sort(a,0,a.length-1);
    }

    private <T extends Comparable<T>> void sort(T[] a, int low, int high) {
        int i = low, j = high;
        T pivot = a[low + (high-low) /2];

        while(i <= j) {

            while (a[i].compareTo(pivot) < 0) {
                i++;
            }
            while (a[j].compareTo(pivot)>0) {
                j--;
            }

            if (i <= j) {
                T tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }

        if (i < high) {
            sort(a,i,high);
        }
        if (j > low) {
            sort(a, low, j);
        }
    }
}
