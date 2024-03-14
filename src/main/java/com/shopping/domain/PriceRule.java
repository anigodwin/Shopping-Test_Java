package com.shopping.domain;

import java.util.List;
import java.util.Set;

public interface PriceRule {
    int calculateCost(List<String> items);

    static int getPrice(String item) {
        return switch (item) {
            case "Apple" -> 35;
            case "Banana" -> 20;
            case "Melon" -> 50;
            case "Lime" -> 15;
            default -> throw new InvalidItemException();
        };
    }

    static int getCost(List<String> items, Set<String> rule, int ruleItemCount) {
        int totalCost = 0;
        int count2 = 0;
        for (String item : items) {
            if (rule.contains(item)) {
                if (count2 < ruleItemCount) {
                    totalCost += PriceRule.getPrice(item);
                    count2++;
                } else {
                    count2 = 0;
                }
            }
        }
        return totalCost;
    }
}
