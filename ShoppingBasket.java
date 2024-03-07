package com.shopping;

import java.util.*;

public class ShoppingBasket {

    public int calculateTotalCost(List<String> items) {
        Set<String> buy1Get1Free = new HashSet<>();
        buy1Get1Free.add("Melon");
        Set<String> buy3ForPriceOf2 = new HashSet<>();
        buy3ForPriceOf2.add("Lime");

        int totalCost = 0;
        int count1 = 0;
        int count2 = 0;
        for (String item : items) {
            if (buy3ForPriceOf2.contains(item)) {
                if (count2 < 2) {
                    totalCost += getPrice(item);
                    count2++;
                } else {
                    count2 = 0;
                }
            } else if (buy1Get1Free.contains(item)) {
                if (count1 < 1) {
                    totalCost += getPrice(item);
                    count1++;
                } else {
                    count1 = 0;
                }
            } else {
                totalCost += getPrice(item);
            }
        }

        return totalCost;
    }

    private int getPrice(String item) {
        return switch (item) {
            case "Apple" -> 35;
            case "Banana" -> 20;
            case "Melon" -> 50;
            case "Lime" -> 15;
            default -> 0;
        };
    }
}
