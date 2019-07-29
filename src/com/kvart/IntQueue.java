package com.kvart;

public interface IntQueue {

    void add(int value);

    int remove() throws Exception; // return first in Queue and remove it

    int element(); // return first in Queue but not remove it


}
