package com;

public class LinkedListQueue {
    private Node head;
    private int size;

    public void enqueue(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public int dequeue() {
        if (head == null) {
            throw new RuntimeException("Queue is Empty");
        } else {
            Node node = head;
            head = head.next;
            size--;
            return node.data;
        }
    }

    public int peek(){
        if (head == null) {
            throw new RuntimeException("Queue is Empty");
        } else {
            return head.data;
        }
    }

    public int getSize(){
        return size;
    }


    private static class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
        }
    }
}
