package com;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack {
    private int[] data;
    private int capacity,size,top;

    public Stack(int capacity){
        this.capacity = capacity;
        this.data = new int[capacity];
        this.top = -1;
    }

    public boolean isFull(){
        return top == capacity - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (!isFull()){
            data[++top] = value;
            size++;
        }else
            throw new StackOverflowError("Stack is Full");
    }

    public int pop(){
        if (!isEmpty()){
            int value = data[top--];
            data[--size] = 0;
           return value;
        }else {
            throw new EmptyStackException();
        }
    }

    public int peek(){
        if (!isEmpty()){
            return data[top];
        }else {
            throw new EmptyStackException();
        }
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            out.append(data[i]);
            if (i == size - 1) {
                out.append("]");
            } else{
                out.append(",");
            }
        }
        if (size == 0){
            out.append("]");
        }
        return out.toString();
    }

}
