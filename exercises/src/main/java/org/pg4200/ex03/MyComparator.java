package org.pg4200.ex03;

import java.util.Comparator;

public class MyComparator<T extends Comparable<?super T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o2.compareTo(o1);
    }
}
