package com.sudhar.examples;

import java.util.List;

public class PromotionCheck {

    public int promotionCheck(List<List<String>> codes, List<String> shoppingCart) {
        int codesIndex = 0;
        int shoppingCartIndex = 0;
        boolean currListMatches = false;

        List<String> currList = codes.get(codesIndex++);

        for (String item : shoppingCart) {
            String code = currList.get(shoppingCartIndex);
            if (currListMatches && !itemsMatch(code, item)) {
                shoppingCartIndex = 0; //reset to current code list starting position
            } else if (itemsMatch(code, item)) {
                currListMatches = true;
                shoppingCartIndex++;
                if (shoppingCartIndex == currList.size()) {
                    if (codesIndex == codes.size()) {
                        return 1; //all the codes matched
                    }
                    currList = codes.get(codesIndex++); //move on to next code list
                    currListMatches = false;
                    shoppingCartIndex = 0;
                }
            }
        }
        return 0;
    }

    private boolean itemsMatch(String code, String item) {
        if ("anything".equals(code)) {
            return true;
        } else if (item.equals(code)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        List<String> shoppingCart = List.of("orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana");
//        List<List<String>> codes = List.of(List.of("anything", "apple"), List.of("banana", "anything", "banana"));

        List<String> shoppingCart = List.of("orange", "apple", "apple", "banana", "orange", "banana");
        List<List<String>> codes = List.of(List.of("apple", "apple"), List.of("banana", "anything", "banana"));

        PromotionCheck pc = new PromotionCheck();

        System.out.println(pc.promotionCheck(codes, shoppingCart));
    }
}
