package com.sudhar.examples;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedListIterator implements Iterator<Integer> {
    Stack<NestedListIterator> stack = new Stack<>();

    public NestedListIterator(List<NestedListIterator> nestedListIterators) {
        if (nestedListIterators == null) {
            return;
        }

        for (int i = nestedListIterators.size() - 1; i >= 0; i--) {
            stack.push(nestedListIterators.get(i));
        }
    }

//    @Override
//    public boolean hasNext() {
//        while (!stack.isEmpty()) {
//            NestedListIterator temp = stack.peek();
//
//            if (temp.isInteger()) {
//                return true;
//            } else {
//                stack.pop();
//
//                for (int i = temp.size() - 1; i >= 0; i--) {
//                    stack.push(temp.getList(i));
//                }
//            }
//        }
//        return false;
//    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return stack.pop().next();
    }
}
