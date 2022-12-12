package dsa_day_6;

public class Stack {

    int maxElementCount = 5;
    int top = 0;
    int[] stackData = new int[maxElementCount];

    public void push(int value) {
        if (maxElementCount > top) {
            stackData[top++] = value;
        } else {
            System.out.println("Max Element Count Reached!");
        }
    }

    public int pop() {
        if (top > 0) {
            return stackData[--top];
        } else {
            return 0;
        }
    }

    public int peek() {
        if (top > 0) {
            return stackData[top - 1];
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(100);
        s.push(200);
        s.push(300);
        s.push(400);
        s.push(500);

        System.out.println("pop : " + s.pop());
        System.out.println("peek : " + s.peek());

        for (int i = 0; i < s.top; i++) {
            int arg = s.stackData[i];
            System.out.println("arg: " + arg);
        }
    }
}
