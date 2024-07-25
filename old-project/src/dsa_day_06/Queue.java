package dsa_day_06;

public class Queue {

    int maxSize = 10;
    int front = 0;
    int rear = 0;

    int[] array = new int[maxSize];

    public void enQueue(int value) {

        if (maxSize == rear) {
            System.out.println("Queue is Full");
            return;
        } else {
            array[rear] = value;
            rear++;
        }
    }

    public void deQueue() {

        if (front == rear) {
            System.out.println("Empty Queue");

        }
        for (int i = 0; i < rear - 1; i++) {
            array[i] = array[i + 1];
        }

        if (rear < maxSize) {
            array[rear] = 0;
        }

    }

    public void displayQueue() {

        if (front == rear) {
            System.out.println("Empty Queue");
        }
        for (int j = front; j < rear; j++) {
            System.out.println("data: " + array[j]);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(100);// FIRST IN FIRST OUT
        System.out.println("100 enQueued successfully!");
        q.enQueue(200);
        System.out.println("200 enQueued successfully!");
        System.out.println("Queue displayed successfully!");
        q.displayQueue();
        System.out.println("Dequeue successfully!");
        q.deQueue();
        System.out.println("After Dequeue");
        q.displayQueue();

    }
}
