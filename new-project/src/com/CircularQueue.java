package com;

public class CircularQueue {
    private int[] items;
    private int front, rear, size,capacity;

    public CircularQueue(int capacity){
        this.capacity = capacity;
        items = new int[capacity];
        front = rear = -1;
    }

    public boolean isFull(){
        return (rear + 1) % capacity == front;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public void enqueue(int item){
        if (isFull()){
            throw new RuntimeException("Queue id Full...");
        }

        if (front == -1){
            front = 0;
        }

        rear = (rear+1) % capacity;
        items[rear] = item;
        size++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }

        int item = items[front];
        if (front == rear){
            front = rear = -1;
        }else {
            front = (front + 1) % capacity;
        }
        size--;
        return item;

    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return items[front];
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }

        StringBuilder out = new StringBuilder("[");
        for (int i = front; i != rear; i = (i + 1) % capacity) {
            out.append(items[i]);
            out.append(",");
        }

        out.append(items[rear]).append("]");
        return out.toString();
    }

}
