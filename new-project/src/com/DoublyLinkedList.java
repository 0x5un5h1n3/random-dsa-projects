package com;

public class DoublyLinkedList {

    private Node head;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.previous = current;
        }
    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        if (head != null) {
            head.previous = node;
        }
        node.next = head;
        head = node;
    }

    public void insert(int index, int value) {
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
                throw new IndexOutOfBoundsException("Invalid index");
            }
            node.next = current.next;
            node.previous = current;
            if (current.next != null) {
                current.next.previous = node;
            }
            current.next = node;
        }
    }

    public void delete(int value) {
        if (head == null) {
            throw new RuntimeException("List is Empty...");
        } else {
            if (head.data == value) {
                head = head.next;
                if (head != null) {
                    head.previous = null;
                }
            } else {
                Node current = head;
                while (current != null && current.data != value) {
                    current = current.next;
                }

                if (current != null) {
                    if (current.next != null) {
                        current.next.previous = current.previous;
                    }

                    if (current.previous != null) {
                        current.previous.next = current.next;
                    }
                }
            }
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

                if (current == null) {
                    throw new IndexOutOfBoundsException();
                }

                if (current.previous != null){
                    current.previous = current.next;
                }

                if(current.next != null){
                    current.next = current.next.next;
                }
            }
        }
    }


    public void reverse(){
        Node current = head, node = null;
        while (current != null){
            node = current.previous;
            current.previous = current.next;
            current.next = node;
            current = current.previous;
        }

        if (node != null){
            head = node.previous;
        }
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
        Node next, previous;

        Node(int value) {
            this.data = value;
        }

    }
}
