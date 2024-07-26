package com;

public class SimpleQueue {
    private int[] items;
    private int front, rear, capacity;

    public SimpleQueue(int capacity){
        this.capacity = capacity;
        items = new int[capacity];
        front = rear = -1;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return rear == capacity -1;
    }

    public void enqueue(int item){
        if (isFull()){
            throw new RuntimeException("Queue is Full...");
        }

        if (front == -1){
            front = 0;
        }
        items[++rear] = item;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty...");
        }

        int item = items[front];
        if (front == rear){
            front = rear = -1;
        }else {
            front++;
        }
        return item;
    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return items[front];
    }

    public int size(){
        return rear - front;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }

        StringBuilder out = new StringBuilder("[");
        for (int i = front; i <= rear; i++) {
            out.append(items[i]);
            if (i == rear) {
                out.append("]");
            } else{
                out.append(",");
            }
        }

        return out.toString();
    }
}
