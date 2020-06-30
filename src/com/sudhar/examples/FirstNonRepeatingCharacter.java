package com.sudhar.examples;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class CharacterUtil {
    public static Character fetchFirstNonRepeatingCharacter(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> list = new LinkedList<>();

        for (char c: input.toCharArray()) {
            int count = map.getOrDefault(c, 0);

            list.add(c);

            map.put(c, count +1);
        }

        while (!list.isEmpty()) {
            Character c = list.poll();

            if (map.get(c) == 1) {
                System.out.println("First non repeating characters is " + c);
                return c;
            }
        }

        System.err.println("There are no non-repeating characters in the given string");
        return null;
    }
}

public class FirstNonRepeatingCharacter {


    public static void main(String[] args) {

        CharacterUtil.fetchFirstNonRepeatingCharacter("hello world");

        CharacterUtil.fetchFirstNonRepeatingCharacter("aabbcc");
    }
}
