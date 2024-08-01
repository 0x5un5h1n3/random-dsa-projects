package com;

public class PriorityQueue {
    private Node head;

    public void enqueue(int value, int priority){
        Node node = new Node(value,priority);

        if (head == null || priority > head.priority){
            node.next = head;
            head = node;
        }else {
            Node current = head;

            while (current.next != null && current.next.priority >= priority){
                current = current.next;
            }

            node.next = current.next;
            current.next = node;

        }
    }

    public int dequeue(){
        if (head == null){
            throw new RuntimeException("Empty Queue");
        }

        Node top = head;
        head = head.next;
        top.next = null;
        return top.data;
    }

    public int peek(){
        if (head == null){
            throw new RuntimeException("Empty Queue");
        }
        return head.data;
    }

    private static class Node{
        int data,priority;
        Node next;

        Node(int value, int priority){
            this.data = value;
            this.priority = priority;
        }
    }
}
