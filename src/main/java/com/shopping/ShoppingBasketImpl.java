package com.shopping;

import com.shopping.domain.PriceRule;

import java.util.*;

public class ShoppingBasketImpl implements ShoppingBasket{
    List<PriceRule> priceRules;

    public ShoppingBasketImpl(List<PriceRule> priceRules) {
        this.priceRules = priceRules;
    }

    @Override
    public int calculateTotalCost(List<String> items) {
        return priceRules.stream()
                .mapToInt(e -> e.calculateCost(items))
                .sum();
    }

}
