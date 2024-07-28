package com;

public class SinglyCircularLinkedList {
    private Node head;

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = node;
            node.next = head;
        }
    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            node.next = head;
            current.next = node;
            head = node;
        }
    }

    public void insertAtIndex(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if (index == 0) {
            insertAtBeginning(value);
        } else {
            Node node = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current.next == head) {
                    throw new IndexOutOfBoundsException("Invalid Index");
                }
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    public void deleteByIndex(int index) {
        if (head != null && index >= 0) {
            if (index == 0) {
                if (head.next == head) {
                    head = null;
                } else {
                    Node current = head;
                    while (current.next != head) {
                        current = current.next;
                    }
                    current.next = head.next;
                    head = head.next;
                }
            } else {
                Node current = head;
                Node previous = null;
                for (int i = 0; i < index; i++) {
                    if (current.next == head) {
                        throw new IndexOutOfBoundsException("Invalid Index");
                    }
                    previous = current;
                    current = current.next;
                }

                previous.next = current.next;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        if (current != null) {
            do {
                sb.append(current.data);
                current = current.next;
                if (current != head) {
                    sb.append(",");
                }
            } while (current != head);
        }
        return sb.append("]").toString();
    }


    private static class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
        }
    }
}
