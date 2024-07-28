package com;

public class Deque {
    private int[] items;
    private int front,rear,size,capacity;

    public Deque(int capacity){
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

    public void addFirst(int item){
        if (isFull()){
            throw new RuntimeException("Queue is Full...");
        }

        if (front == -1){
            front = rear = 0;
        }else if(front == 0) {
            front = capacity -1;
        }else {
            front--;
        }

        items[front] = item;
        size++;
    }

    public void addLast(int item){
        if (isFull()){
            throw new RuntimeException("Queue is Full...");
        }

        if(front == -1){
            front = rear = 0;
        }else if(rear == capacity -1){
            rear = 0;
        }else {
            rear++;
        }

        items[rear] = item;
        size++;
    }

    public int getFirst(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return items[front];
    }

    public int getLast(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return items[rear];
    }

    public int removeFirst(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }

        int item = items[front];
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % capacity;
        size--;
        return item;

    }

    public int removeLast(){
        if (isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }

        int item = items[rear];
        if (front == rear)
            front = rear = -1;
        else if(rear == 0)
            rear = capacity -1;
        else
            rear--;
        size--;
        return item;
    }

    public int getSize(){
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

    public void print(){
        System.out.print("[");
        for (int i = 0; i < items.length; i++){
            System.out.print(items[i]);
            if (i != items.length -1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}
