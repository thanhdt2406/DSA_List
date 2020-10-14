package com.codegym;

import com.sun.jmx.snmp.SnmpNull;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {

    }

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void add(int index, E element) {
        if (index > numNodes || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node holder;
        Node temp = head;
        if (index == 0) {
            addFirst(element);
        } else if (index == numNodes) {
            addLast(element);
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node temp = new Node(e);
        temp.next = head;
        head = temp;
        numNodes++;
    }

    public void addLast(E e) {
        if (isEmpty()) {
            addFirst(e);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(e);
            numNodes++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        if (index == 0) {
            return removeFirst();
        }
        Node holder;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = holder.next;
        holder.next = null;
        numNodes--;
        return (E) holder;
    }

    public E removeFirst() {
        Node temp = head;
        head = head.next;
        temp.next = null;
        numNodes--;
        return (E) temp;
    }

    public boolean remove(Object e) {
        if (isEmpty()) {
            return false;
        }
        if (head == e) {
            removeFirst();
            return true;
        }
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.next.data != e) {
                temp = temp.next;
                continue;
            }
            remove(i + 1);
            return true;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> copy = new MyLinkedList<>();
        Node temp = head;
        while (temp != null) {
            copy.addLast((E) temp);
            temp = temp.next;
        }
        Node tempCopy = copy.head;
        temp = head;
        while (tempCopy != null) {
            tempCopy.setData(null);
            tempCopy = tempCopy.next;
        }
        return copy;
    }

    public boolean contains(E o) {
        if (isEmpty()) {
            return false;
        }
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data == o) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return (E) temp;
    }

    public E getFirst() {
        if(isEmpty()){
            return null;
        }
        return (E) head.data;
    }

    public E getLast() {
        if (isEmpty()){
            return null;
        }
        Node temp = head;
        for(int i=0;i<numNodes-1;i++){
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public void print() {
        if(isEmpty()){
            System.out.println("Empty list");
        }
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Element " + i + ": " + temp.data);
            temp = temp.next;
        }
    }
}
