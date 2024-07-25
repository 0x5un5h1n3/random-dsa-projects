package com;

public class LinkedList {

    private Node head;
    private int size;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null)
            head = node;
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public void insert(int value, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        if (index == 0) {
            insertAtBeginning(value);
        } else {
            Node node = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }

            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bound");
            }

            node.next = current.next;
            current.next = node;
            size++;
        }

    }

    public void delete(int value) {
        if (head == null) {
            throw new RuntimeException("List is Empty");
        } else {
            if (head.data == value) {
                head = head.next;
            } else {
                Node current = head;
                while (current.next != null && current.next.data != value) {
                    current = current.next;
                }

                if (current.next != null) {
                    current.next = current.next.next;
                }

            }
            size--;
        }
    }

    public void deleteByIndex(int index) {
        if (head == null) {
            throw new RuntimeException("List is Empty");
        } else {
            if (index < 0) {
                throw new IndexOutOfBoundsException("Index cannot be negative");
            }

            if (index == 0) {
                head = head.next;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1 && current != null; i++) {
                    current = current.next;
                }

                if (current == null || current.next == null) {
                    throw new IndexOutOfBoundsException();
                }

                current.next = current.next.next;
                size--;
            }
        }

    }


    public boolean search(int value){
        Node current = head;
        while (current != null){
            if (current.data == value)
                return true;
            current = current.next;
        }
        return false;
    }

    public void reverse(){
        Node current = head, previous = null, next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public int getSize(){
        return this.size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(",");
            }
        }
        return sb.append("]").toString();
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
