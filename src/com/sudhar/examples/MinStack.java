package com.sudhar.examples;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    /**
     * initialize your data structure here.
     */
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.add(x);
        } else {
            if (x <= minStack.peek()) {
                minStack.add(x);
            } else {
                int min = minStack.peek();
                minStack.add(min);
            }
        }

        stack.push(x);
    }

    public void pop() {
        stack.pop();

        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
