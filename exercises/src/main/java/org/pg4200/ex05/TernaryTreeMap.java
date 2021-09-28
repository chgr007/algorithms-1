package org.pg4200.ex05;

import org.pg4200.les05.MyMapTreeBased;

import java.util.Objects;

public class TernaryTreeMap<K extends Comparable<K>,V> implements MyMapTreeBased<K,V> {

    protected class Node {
        public  Node left;
        public Node middle;
        public Node right;
        public K firstKey, secondKey;
        public V firstVal, secondVal;
    }
    protected Node root;
    protected int size;
    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(key, value, root);
    }

    private Node put(K key, V value, Node subTree) {

        if (subTree == null) {
            Node node = new Node();
            node.firstKey = key;
            node.firstVal = value;
            size++;
            return node;
        }
        int compareFirst = key.compareTo(subTree.firstKey);

        if (compareFirst > 0) {
            // If second spot in node is available, use it
            if (subTree.secondKey == null) {
                subTree.secondKey = key;
                subTree.secondVal = value;
                size++;
                return subTree;
            }
            int compareSecond = key.compareTo(subTree.secondKey);
            // If second spot is in use, but the key is lower than secondKey, yet greater than
            // firstKey - use the middle child
            if (compareSecond < 0) {
                subTree.middle = put(key,value,subTree.middle);
                return subTree;
            }
            // If key is greater than second key, use right child
            if (compareSecond > 0) {
                subTree.right = put(key,value,subTree.right);
                return subTree;
            }

            // If key is equal, just set a new secondValue
            assert compareSecond == 0;
            subTree.secondVal = value;
            return subTree;
        }
        // If key is less than firstKey, use left child node
        if (compareFirst < 0) {
            subTree.left = put(key,value,subTree.left);
            return subTree;
        }

        // Only case left is key equals firstKey
        assert compareFirst == 0;
        subTree.firstVal = value;
        return subTree;
    }

    @Override
    public void delete(K key) {
        Objects.requireNonNull(key);
        delete(key,root);
    }

    private void delete(K key, Node root) {

    }

    @Override
    public V get(K key) {
        Objects.requireNonNull(key);
        return get(key, root);
    }

    protected V get(K key, Node subtreeRoot) {
        if (subtreeRoot == null) return null;
        int compareFirst = key.compareTo(subtreeRoot.firstKey);

        if (compareFirst > 0) {
            if (subtreeRoot.secondKey == null) return null;
            int compareSecond = key.compareTo(subtreeRoot.secondKey);

            if (compareSecond > 0) {
                return get(key, subtreeRoot.right);
            }
            if (compareSecond < 0) {
                return get(key, subtreeRoot.middle);
            }

            assert compareSecond == 0;
            return subtreeRoot.secondVal;
        }
        if (compareFirst < 0) {
            return get(key, subtreeRoot.left);
        }
        assert compareFirst == 0;
        return subtreeRoot.firstVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getMaxTreeDepth() {
        return 0;
    }
}
