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



/**
 *
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *


 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 *
 *
 * Input: [[1,1],2,[1,1]]
 Output: [1,1,2,1,1]

 Input : [1,[2,[3],4],5]
 Output : [1,2,3,4,5]

 Input: [1,[4,[6,[7,[8,9],10],11],12]
 Output: [1,4,6,7,8,9,10,11,12]
 -> [ 1, [4,[6,[7,[8,9],10],11], 12]

 [[4,[6,[7,[8,9],10],11], 12]
 [4, [6,[7,[8,9],10],11], 12]
 * /**
 *
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

//    public class NestedIterator implements Iterator<Integer> {
//
//        // Queue<NestedInteger> queue = new LinkedList<>();
//        Stack<NestedInteger> stack = new Stack<>();
//
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            //  if (nestedList != null || nestedList.size() != 0) {
//            //   for (NestedInteger nestedInteger: nestedList) {
//            //       if (nestedInteger.isInteger()) {
//            //             queue.add(nestedInteger);
//            //       } else {
//            //           flattenNestedList(nestedIntger);
//            //       }
//            //   }
//            //  }
//
//            for (int i = nestedList.size() -1; i>=0; i--) {
//                stack.push(nestedList.get(i));
//            }
//        }
//
//        private void flattenNestedList(NestedInteger nestedInteger) {
//            for (NestedInteger item: nestedInteger.getList()) {
//                if (items.isInteger()) {
//                    queue.add(item);
//                } else {
//                    flattenNested(item);
//                }
//            }
//        }
//
//        @Override

        // Stack -> 5, [2,[3],4]

        // Stack -> 5, 4, [3], 2

        // Stack -> 5, 4, [3]

        // Stack -> 5, 4

        // Stack -> 5

        // Stack -> [empty]

        // [1,[2,[3],4],5]
//        public Integer next() {
//            NestedInteger top = stack.peek();
//            if (top.isInteger()) {
//                stack.pop();
//                return top.getInteger();
//            } else {
//                stack.pop();
//                for (int i = top.getList().size() -1; i>=0; i--) {
//                    stack.push(top.getList().get(i));
//                }
//
//            }
//            return stack.pop().getInteger();
//            //return queue.poll();
//        }
//        @Override
//        public boolean hasNext() {
//            // return !queue.isEmpty();
//            return !stack.isEmpty();
//        }
//    }

}
