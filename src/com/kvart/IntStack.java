package com.kvart;

public interface IntStack {

    boolean push(int value);

    int pop() throws Exception; // remove and get value on top of Stack

    int peek(); // get value on top of Stack

}
