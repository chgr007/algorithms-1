package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>,V> extends MyMapBinarySearchTree<K,V> {

    @Override
    protected TreeNode delete(K key, TreeNode subtreeRoot) {

        if (subtreeRoot == null) return null;

        int compare = key.compareTo(subtreeRoot.key);

        if (compare < 0) {
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }
        if (compare > 0) {
            subtreeRoot.right = delete(key, subtreeRoot.right);
            return subtreeRoot;
        }

        assert compare == 0;
        size--;
        // 0 or 1 child
        if (subtreeRoot.left == null) {
            return subtreeRoot.right;
        }
        if (subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        assert subtreeRoot.left != null && subtreeRoot.right != null;

        // 2 childs l/r
        TreeNode tmp = subtreeRoot;
        subtreeRoot = max(tmp.left);
        subtreeRoot.left = deleteMax(tmp.left);
        subtreeRoot.right = tmp.right;
        return subtreeRoot;
    }

    private TreeNode deleteMax(TreeNode subtree) {
        if (subtree.right == null) return subtree.left;

        subtree.right = deleteMax(subtree.right);
        return subtree;
    }

    private TreeNode max(TreeNode subtree) {
        if (subtree.right == null) return subtree;
        return max(subtree.right);
    }
}
