package com.codegym;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Object> linkedList = new MyLinkedList<>();
        linkedList.add(0, 2);
        linkedList.add(0, 3);
        linkedList.add(1, 4);
        linkedList.addFirst(0);
        linkedList.addLast(9);
        linkedList.add(0, -1);
        linkedList.add(6, 123);

        linkedList.print();
        System.out.println(linkedList.size());
        System.out.println();

        linkedList.remove(0);
        linkedList.print();
        System.out.println(linkedList.size());
        System.out.println();

        Integer e = 123;

        linkedList.remove(e);
        linkedList.print();
        System.out.println(linkedList.size());
        System.out.println();

        linkedList.print();

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        linkedList.clear();
        linkedList.print();
    }
}
