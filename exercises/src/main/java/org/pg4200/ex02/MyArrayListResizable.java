package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizable<T> extends  MyArrayList<T> {

    public MyArrayListResizable(int size) {
        super(size);
    }
    public MyArrayListResizable() {
        super();
    }

    @Override
    public void add(int index, T value) {
        if (size < data.length) {
            super.add(index, value);
        } else {
            data = copyToNew(data);
            super.add(index, value);
        }
    }

    private Object[] copyToNew(Object[] arr) {
        Object[] newArr = new Object[(arr.length*2)];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
