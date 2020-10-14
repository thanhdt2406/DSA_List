package com.codegym;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(10);
        linkedList.addFirst(15);
        linkedList.addFirst(18);
        linkedList.addFirst(1);
        linkedList.add(2,8);
        linkedList.add(1,18);

        linkedList.printList();
    }
}
