package com;

import java.util.Arrays;

public class Array {
    private int[] data;
    private int size;
    private int capacity;

    public Array(int capacity){
        this.capacity = capacity;
        data = new int[capacity];
    }

    //Add
    public void add(int value){
        if (size < capacity){
            data[size++] = value;
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    //Add by index
    public void add(int index, int value){
        if (index >= 0 && index <= size && size < capacity){
            for (int i = size; i > index; i--){
                data[i] = data[i -1];
            }
            data[index] = value;
            size++;
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //Find
    public int find(int value){
        for (int i = 0; i < size; i++){
            if (data[i] == value){
                return i;
            }
        }
        return -1;
    }

    // Delete
    public void remove(int value){
        int index = find(value);
        if (index == -1){
            throw new IllegalArgumentException("Value not fund in the Array");
        }

        for (int i = index; i < size - 1; i++){
            data[i] = data[i+1];
        }

        data[--size] = 0;

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
