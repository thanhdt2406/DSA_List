package com.codegym;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException();
        }
        E temp = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return temp;
    }

    public int size() {
        return this.size;
    }

    public MyList<E> clone() {
        MyList<E> copy = new MyList<>(this.size);
        copy.size = this.size;
        return copy;
    }

    public boolean contains(E o) {
        if (indexOf(o) != -1) {
            return true;
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < this.size; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (this.size == elements.length) {
            ensureCapacity(1);
        }
        elements[this.size++] = e;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= this.size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < this.size; i++) {
            elements[i] = null;
        }
        this.size = 0;
    }

    public void print() {
        if (this.size == 0) {
            System.out.println("Empty list");
        } else {
            for (int i = 0; i < this.size; i++) {
                System.out.println("Element " + i + ": " + elements[i]);
            }
        }
    }
}
