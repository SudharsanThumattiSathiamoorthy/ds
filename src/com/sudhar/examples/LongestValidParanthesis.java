package com.sudhar.examples;

import java.util.Stack;

// https://leetcode.com/discuss/explore/april-leetcoding-challenge-2021/1139990/longest-valid-parentheses-short-easy-w-explanation-using-stack

public class LongestValidParanthesis {

    public static void main(String[] args) {

        LongestValidParanthesis lvp = new LongestValidParanthesis();

        System.out.println(lvp.longestParanthesis("()())()"));
    }

    public int longestParanthesis(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    //    We can use a stack to find the longest valid parentheses.
    //
    //    We will start by pushing -1 into the stack at first. This will denote index preceding to potential start of valid parentheses. It will be more clear later. Now will start iterating over s and we will have two cases -
    //
    //    s[i] == '(' - In this case, we will push the index into the stack (just as we do in valid parentheses check).
    //    s[i] == ')' - In this case, we will pop the index from the stack (again just as in parentheses check). Now, after popping, we need to do some simple checks which are main steps of this problem. Again, there will be following scenarios that may occur -
    //    stack is not empty - If stack is not empty, then this may be our longest valid parentheses. We update the MAX_len as max(MAX_len, current index - stack.top()). Do notice, that our bottom of stack will always hold index preceding to a potential valid parentheses.
    //    stack becomes empty - This will only happen when we have an extra ')' bracket. There may have been valid parentheses previously which have been updated and stored in MAX_len. But, since we now have an extra closing bracket any further extensions of previous valid parentheses is not possible. So, push the current index into stack, again which will denote that bottom of stack will hold the index preceding to a potential valid parentheses.

    //    Example - '()())()'
    //    Initial stack(from bottom to top) :  [ -1 ] , MAX = 0
    //
    //            1. i = 0          |   s[i] = '('        =>     case-1: push current index into stack
    //    stack : [-1, 0]   |   MAX = 0
    //
    //            2. i = 1          |   s[i] = ')'        =>     case-2.1: pop. After pop, stack is not empty so update MAX.
    //    stack : [-1]      |   MAX = max(0, 1 - (-1)) = 2.
    //
    //            'NOTE : Since the index starts from 0, having index preceding to the start of valid parentheses will give us actual length of the valid parentheses,
    //    instead of us having to add 1 to it everytime.'
    //
    //            3. i = 2          |   s[i] = '('        =>     case-1: push current index into stack
    //    stack : [-1, 1]   |   MAX = 2.
    //
    //            4. i = 3          |   s[i] = ')'        =>     case-2.1: pop. After pop, stack is not empty so update MAX.
    //    stack : [-1]   |   MAX = max(2, 3 - (-1)) = 4.
    //
    //            5. i = 4          |   s[i] = ')'        =>     case-2.2: pop. After pop, stack is empty, so push current index into stack.
    //    This denotes any valid parentheses from now will start from next index and previous valid parentheses cant be extended further.
    //    stack : [4]   |   MAX = 4.
    //
    //            6. i = 5          |   s[i] = '('        =>     case-1: push current index into stack
    //    stack : [4, 5]   |   MAX = 4.
    //
    //            7. i = 6          |   s[i] = ')'        =>     case-2.2: pop. After pop, stack is empty, so push current index into stack.
    //            stack : [4]   |   MAX = max(4, 6 - 4) = 4.
}
