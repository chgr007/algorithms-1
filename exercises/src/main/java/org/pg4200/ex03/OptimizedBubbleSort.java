package org.pg4200.ex03;

import java.util.Arrays;
import java.util.Comparator;

public class OptimizedBubbleSort<T> {
     public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized) {
         boolean shouldRun = true;
         int numberOfCompares = 0;
         if (!optimized) {
             do {
                 shouldRun = false;
                 for (int i = 0; i < array.length-1; i++) {
                     numberOfCompares++;
                     if (comparator.compare(array[i], array[i+1]) < 0) {
                         T temp = array[i+1];
                         array[i+1] = array[i];
                         array[i] = temp;
                         shouldRun = true;
                     }
                 }
             } while (shouldRun);
         }
         else {
             int lastPosSorted = array.length-1;
             do {
                 shouldRun = false;
                 int index = lastPosSorted;
                 for (int i = 0; i < lastPosSorted; i++) {

                     if (comparator.compare(array[i], array[i+1]) < 0) {
                         numberOfCompares++;
                         T temp = array[i+1];
                         array[i+1] = array[i];
                         array[i] = temp;
                         shouldRun = true;
                         index = i;
                     }
                 } if(shouldRun) lastPosSorted = index;
             } while (shouldRun);
         }
         Arrays.stream(array).forEach(System.out::print);
         System.out.println(numberOfCompares);
        return numberOfCompares;
    }
}
