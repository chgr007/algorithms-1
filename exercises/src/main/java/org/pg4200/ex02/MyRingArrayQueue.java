package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue {
    protected Object[] data;
    private int head = -1, tail = -1;
    private int size = 0;

    MyRingArrayQueue(int capacity) {
        data = new Object[capacity];
    }
    MyRingArrayQueue() {
        this(10);
    }
    @Override
    public void enqueue(Object value) {
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else if (tail == data.length-1 && head != 0) {
            tail = 0;
        } else {
            data = expandArray(data);
        }
        data[tail] = value;
        size++;
    }

    private Object[] expandArray(Object[] data) {
        Object[] tmp = new Object[size()*2];
        int newTail = 0;
        if(tail < head) {
            for (int i = head; i < data.length ; i++) {
                tmp[newTail] = data[i];
                newTail++;
            }
            for (int i = 0; i <= tail; i++) {
                tmp[newTail] = data[i];
                newTail++;
            }
        } else {
            for (int i = 0; i < size(); i++) {
                tmp[i] = data[head + i];
                newTail++;
            }
        }
        head = 0;
        tail = newTail;
        return tmp;
    }


    public T peek() {
        if(isEmpty()){
            throw new RuntimeException();
        }

        return (T) data[head];
    }

    @Override
    public int size() {
        //if (head < 0) return 0;

        //return (tail - head) + 1;
        return size;
    }
    @Override
    public T dequeue() {

        if(isEmpty()){
            throw new RuntimeException();
        }

        T value = (T) data[head];

        if(size() == 1){
            head = -1;
            tail = -1;
        } else if (head == data.length - 1) {
            head = 0;
        }
        else {
            data[head] = null;
            head++;
        }
        size--;
        return value;
    }
}
