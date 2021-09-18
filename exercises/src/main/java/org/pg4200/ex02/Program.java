package org.pg4200.ex02;

public class Program {
    public static void main(String[] args) {
        MyBidirectionalLinkedList<String> linkedList = new MyBidirectionalLinkedList<>();

        linkedList.add("Arne");
        linkedList.add("Nesset");
        linkedList.add("Fjellheimen");
        linkedList.add(1, "Svarte");
    }
}
