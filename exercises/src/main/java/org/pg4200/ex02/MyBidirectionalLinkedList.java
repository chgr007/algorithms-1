package org.pg4200.ex02;

import org.pg4200.les02.list.MyList;

public class MyBidirectionalLinkedList<T> implements MyList<T> {
    int size = 0;
    ListNode head;
    ListNode tail;

    private class ListNode {
        T value;
        ListNode next;
        ListNode previous;
    }

    @Override
    public void add(int index, T value) {
        validateIndex(index);
        ListNode node = new ListNode();
        node.value = value;

        if (head == null) {
            assert size == 0 : "Size greater than zero, but head is null";
            head = node;
            tail = head;
        } else if (index == 0) {
            node.next = head;
            head.previous = node;
            head = node;
        } else if (index == size) {
            tail.next = node;
            node.previous = tail;
            tail = node;
        } else {
            ListNode alreadyAtPosition = getNode(index);
            alreadyAtPosition.previous.next = node;
            node.previous = alreadyAtPosition.previous;
            alreadyAtPosition.previous = node;
            node.next = alreadyAtPosition;
        }
        size++;
    }

    private void validateIndex(int index) {
        if(index < 0 || index > size){
            //note that here "size" is a valid index
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void delete(int index) {
        validateIndex(index);
        ListNode nodeToDelete = getNode(index);

        if (head == tail) {
            assert size == 1;
            head = null;
            tail = null;
        } else if (nodeToDelete == tail) {
            nodeToDelete.previous.next = null;
            tail = nodeToDelete.previous;
        } else if (nodeToDelete == head) {
            nodeToDelete.next.previous = null;
            head = nodeToDelete.next;
        }
        else {
            nodeToDelete.previous.next = nodeToDelete.next;
            nodeToDelete.next.previous = nodeToDelete.previous;
        }
        nodeToDelete = null;
        size--;
    }

    private ListNode getNode(int index) {
        int middleIndex = size/2;
        int counter = 0;
        ListNode currentNode = head;

        if (index >= middleIndex) {
            counter = size-1;
            currentNode = tail;

            while(counter != index) {
                currentNode = currentNode.previous;
                counter--;
            }
        } else {
            while(counter != index) {
                currentNode = currentNode.next;
                counter++;
            }
        }

        return currentNode;
    }
    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) getNode(index).value;
    }

    @Override
    public void add(T value) {

        add(size, value);
    }


    @Override
    public int size() {
        return size;
    }

}
