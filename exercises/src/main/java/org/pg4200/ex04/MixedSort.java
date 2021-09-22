package org.pg4200.ex04;

import org.pg4200.ex03.MyComparator;
import org.pg4200.ex03.OptimizedBubbleSort;
import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {

        if (array == null) return;
        T[] buffer = (T[]) new Comparable[array.length];
        mergeSort(array,buffer,0, array.length-1);
    }

    private <T extends Comparable<T>> void mergeSort(T[] array,T[] buffer, int low, int high) {
        if (low >= high) return;
        if (high-low <= 4) {
            MyComparator myComparator = new MyComparator();
            OptimizedBubbleSort<T> bubbleSort = new OptimizedBubbleSort<>();
            bubbleSort.sort(array,myComparator,true);
            return;
        }
        int middle = low + (high-low) / 2;
        mergeSort(array, buffer, low, middle);
        mergeSort(array, buffer,middle+1, high);
        merge(array, buffer, low,middle,high);
    }

    private <T extends Comparable<T>>  void merge(T[] array, T[] buffer, int low, int middle, int high) {

        for (int i = low; i <= high ; i++) {
            buffer[i] = array[i];
        }

        int i = low;
        int j = middle + 1;

        for (int k = low; k <= high; k++) {
            if(i > middle) {
                // Done with left half, just copy over the right
                array[k] = buffer[j++];
            } else if (j > high) {
                //done with right half, just copy over the left
                array[k] = buffer[i++];
            } else if (buffer[j].compareTo(buffer[i]) < 0) {
                array[k] = buffer[j++];
            } else {
                array[k] = buffer[i++];
            }
        }
    }
}
