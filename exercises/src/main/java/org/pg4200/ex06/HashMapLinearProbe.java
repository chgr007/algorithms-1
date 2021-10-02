package org.pg4200.ex06;

import org.pg4200.les06.hash.MyHashMap;
import org.pg4200.les06.hash.MyHashMapWithLists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HashMapLinearProbe<K,V> implements MyHashMap<K,V> {
    /**
     * Important this is a prime number.
     * "A prime number (or a prime) is a natural number greater than 1 that has no
     * positive divisors other than 1 and itself"
     * https://en.wikipedia.org/wiki/Prime_number
     */
    private final int M = 997;
    private int size = 0;
    private class Entry{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);


    @Override
    public void put(K key, V value) {

        Objects.requireNonNull(key);

        int i = index(key);

        if (data[i] == null) data[i] = new Entry(key,value);
        else if (data[i].key == key) {
            data[i].value = value;
            return;
        }
        else {
            for(int j = i+1; j < data.length; i++) {
                if (data[j] == null) {
                    data[j] = new Entry(key,value);
                    break;
                } else if (data[j].key == key) {
                    data[j].value = value;
                    return;
                }
                if (j +1 == data.length && size() < data.length) j = 0;
            }
        }
        size++;
    }

    private int index(K key){

        /*
            The hash is an integer, so in the range -2B, +2B
            But here we want to map into 0..M-1, ie a valid
            index on the array.

            So, first step is to make sure the hash is positive,
            by throwing away its first leftmost bit (which define
            the sign of the number).

            How to do it? By using the mask 0x7f_ff_ff_ff
            But what does it mean?

            An F is the value 15 in hexadecimal format, which in
            binary is 1111 (ie, 2^3 + 2^2 + 2^1 + 2^0 = 8 + 4 + 2 + 1 = 15)
            So an "& F" means take all the bits at that position.
            However, if we want to skip a first bit in a &, we
            need the following mask in binary

            0111

            as an & with 0 is always 0, ie
            0 & 0 = 0
            0 & 1 = 0
            1 & 0 = 0
            1 & 1 = 1

            in hexadecimal (and decimal as well), the binary 0111 is
            a 7 (ie 2^2 + 2^1 + 2^0 = 4 + 2 + 1)
         */
        int positiveHash = key.hashCode() & 0x7f_ff_ff_ff;

        /*
            The result of %M is a value in 0..M-1
         */

        return positiveHash % M;
    }

    @Override
    public void delete(K key) {

        Objects.requireNonNull(key);
        int i = index(key);
        if(data[i] == null){
            return;
        }

        if (data[i].key == key) {
            data[i] = null;
            size--;
            return;
        }

        if (data[i] != null) {
            int goToMax = data.length;
            for (int j = i+1; j < goToMax; j++) {
                if (data[j].key == key) {
                    data[j].key = null;
                    size--;
                    return;
                }
                if (j+1 == data.length) {
                    goToMax = i+1;
                    j = 0;
                }
            }
        }

    }

    @Override
    public V get(K key) {

        Objects.requireNonNull(key);

        int i = index(key);
        if (data[i] == null) return null;
        if (data[i].key == key) return data[i].value;
        else {
            for (int j = ++i; j < data.length; j++) {
                if (data[j].key == key) {
                    return data[j].value;
                }
            }
        }

        return null;
    }

    @Override
    public int size() {

        /*
            Note: it would had been more efficient to keep track of the size
            in a variable, updated at each put/delete.
            However, for didactic reasons here I just show how the size relates
            to the size of each list in the array.
            This is inefficient, as it would cost O(n) instead of O(1)
         */

        //int size = 0;


        return size;
    }
}
