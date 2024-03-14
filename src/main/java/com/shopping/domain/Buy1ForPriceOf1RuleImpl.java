package com.shopping.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Buy1ForPriceOf1RuleImpl implements PriceRule {
    Set<String> buy1ForPriceOf1;

    public Buy1ForPriceOf1RuleImpl() {
        this.buy1ForPriceOf1 = new HashSet<>();
        this.buy1ForPriceOf1.add("Apple");
        this.buy1ForPriceOf1.add("Banana");
    }

    @Override
    public int calculateCost(List<String> items) {
        int totalCost = 0;
        for (String item : items) {
            if (buy1ForPriceOf1.contains(item)) {
                totalCost += PriceRule.getPrice(item);
            }

        }
        return totalCost;
    }
}
