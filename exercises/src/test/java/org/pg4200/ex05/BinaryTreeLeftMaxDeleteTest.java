package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;
import org.pg4200.les05.MyMapBinarySearchTreeTest;

public class BinaryTreeLeftMaxDeleteTest<K extends Comparable<K>, V> extends MyMapBinarySearchTreeTest {

    @Override
    public BinaryTreeLeftMaxDelete getTreeInstance() {
        return new BinaryTreeLeftMaxDelete<K,V>();
    }
}
