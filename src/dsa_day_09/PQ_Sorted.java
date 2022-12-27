package dsa_day_09;

public class PQ_Sorted {

    static class Node {

        int data;

        // Lower values indicates higher priority
        int priority;
        Node next;
    }

    static Node node = new Node();

    static Node newNode(int data, int p) {

        Node temp = new Node();
        temp.data = data;
        temp.priority = p;
        temp.next = null;

        return temp;
    }

    static int peek(Node head) {
        return (head).data;
    }

    static Node deQueue(Node head) {

        (head) = (head).next;
        return head;
    }

    static int isEmpty(Node head) {
        return ((head) == null) ? 1 : 0;
    }

    static Node enQueue(Node head, int data, int p) {
        Node start = head;

        Node temp = newNode(data, p);

        if ((head).priority > p) {
            temp.next = head;
            (head) = temp;
        } else {
            while (start.next != null && start.next.priority < p) {
                start = start.next;
            }
            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Node pq = newNode(4, 0);
        pq = enQueue(pq, 3, 1);
        pq = enQueue(pq, 6, 2);
        pq = enQueue(pq, 1, 3);
        pq = enQueue(pq, 2, 5);
        pq = enQueue(pq, 5, 4);

        while (isEmpty(pq) == 0) {
            System.out.printf("%d ", peek(pq));
            pq = deQueue(pq);
        }
    }
}
