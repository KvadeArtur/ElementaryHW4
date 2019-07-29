package com.kvart;

public interface IntList {

    void add(int element);

    boolean add(int index, int element);

    void clear();

    int get(int index);

    boolean isEmpty();

    boolean remove(int index) throws Exception;

    boolean removeByValue(int value) throws Exception;

    boolean set(int index, int element);

    int size();

    IntList subList(int fromIndex, int toIndex);

    int[] toArray();

}
