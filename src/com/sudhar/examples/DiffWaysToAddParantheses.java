package com.sudhar.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToAddParantheses {
    Map<String, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        String input = "2*3-4*5";

        DiffWaysToAddParantheses diff = new DiffWaysToAddParantheses();

        // System.out.println(diff.diffWaysToCompute(input));

        System.out.println(diff.diffWaysToCompute("2-1-1"));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            if (c == '+' || c == '-' || c =='*' || c == '/') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);

                List<Integer> subset1 = map.getOrDefault(part1, diffWaysToCompute(part1));
                List<Integer> subset2 = map.getOrDefault(part2, diffWaysToCompute(part2));

                for (Integer p1 : subset1) {
                    for (Integer p2: subset2) {
                        int res = 0;
                        switch (c) {
                            case '+':
                                res = p1  + p2;
                                break;
                            case '-':
                                res = p1 - p2;
                                break;
                            case '*':
                                res = p1 * p2;
                                break;
                            case '/':
                                res = p1 / p2;
                                break;
                        }
                        result.add(res);
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }

        map.put(input, result);
        return result;
    }
}
