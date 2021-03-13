package com.sudhar.examples;

import java.util.Stack;

public class ItemsInContainers {

    public static void main(String[] args) {
        String ip = "|**|*|*";
        String ip1 = "|**|*|*|";
        String ip2 = "||*|*|****|";


        ItemsInContainers iic = new ItemsInContainers();
        System.out.println(iic.noOfContainers(ip));
        System.out.println(iic.noOfContainers(ip1));
        System.out.println(iic.noOfContainers(ip2));
    }

    public int noOfContainers(String input) {
        int count = 0, temp = 0;


        char[] ip = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        boolean started = false;

        for (int i=0; i < ip.length; i++) {
            if (ip[i] == '|') {
                if (!started) {
                    stack.add(ip[i]);
                    started  =true;
                } else {
                    while(!stack.isEmpty() && stack.peek() != '|') {
                        count++;
                        stack.pop();
                    }

                    stack.pop();
                    stack.push(ip[i]);
                }

            } else if (ip[i] == '*') {
                stack.add(ip[i]);
            }
        }


        return count;
    }
}
