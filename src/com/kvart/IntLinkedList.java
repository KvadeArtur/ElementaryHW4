package com.kvart;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {
        int value;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Entry first;
    private Entry last;

    //IntQueue

    @Override
    public void add(int element) {
        Entry newEntry = new Entry(element);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.previous = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    public int remove() {
        Entry remove = first;
        if (size == 0) {
            throw new IllegalArgumentException("Такого елемента не существует");
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return remove.value;
    }

    @Override
    public int element() {
        return first.value;
    }

    //IntList

    @Override
    public boolean add(int index, int element) {
        Entry newEntry = new Entry(element);

        Entry tmp = first;
        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }

        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            newEntry.next = tmp;
            newEntry.previous = tmp.previous;
            tmp.previous = newEntry;
            newEntry.previous.next = newEntry;
        }
        size++;
        return true;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int get(int index) {
        Entry tmp = first;
        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }

        return tmp.value;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(int index) {
        Entry tmp = first;

        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }

        if (size == 0) {
            throw new IllegalArgumentException("Такого елемента не существует");
        }else if (tmp.next == null){
            tmp.previous.next = null;
        }else if (tmp.previous == null){
            tmp.next.previous = null;
        } else {
            tmp.next.previous = tmp.previous;
            tmp.previous.next = tmp.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        Entry tmp = first;

        for (int i = 1; i < size; i++) {
            if (tmp.value == value) {
                break;
            } else {
                tmp = tmp.next;
            }
        }

        if (size == 0) {
            throw new IllegalArgumentException("Такого елемента не существует");
        } else if (tmp.next == null){
            tmp.previous.next = null;
        }else if (tmp.previous == null){
            tmp.next.previous = null;
        } else {
            tmp.next.previous = tmp.previous;
            tmp.previous.next = tmp.next;
        }
        size--;
        return true;

    }

    @Override
    public boolean set(int index, int element) {
        Entry tmp = first;

        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.value = element;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList intList = new IntLinkedList();
        for (int i = fromIndex; i <= toIndex; i++) {
            intList.add(get(i));
        }
        return intList;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry tmp = first;
        for (int i = 0; i < size; i++) {
            result[i] = tmp.value;
            tmp = tmp.next;
        }
        return result;
    }

    //IntStack

    @Override
    public boolean push(int value) {
        Entry newEntry = new Entry(value);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            first.previous = newEntry;
            newEntry.next = first;
            first = newEntry;
        }
        size++;
        return true;
    }

    @Override
    public int pop() {
        Entry remove = first;
        if (size == 0) {
            throw new IllegalArgumentException("Такого елемента не существует");
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return remove.value;
    }

    @Override
    public int peek() {
        return first.value;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
