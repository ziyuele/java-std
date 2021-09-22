package com.ziyue;

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stackA;
    Stack<Integer> stackB;



    public StackToQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackB.isEmpty()) {
            a2b();
        }
        return stackB.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackB.isEmpty()) {
            a2b();
        }
        return stackB.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackB.isEmpty() && stackA.isEmpty();
    }
    public void a2b() {
       while (!stackA.isEmpty()) {
           stackB.push(stackA.pop());
       }
    }
}
