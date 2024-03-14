package com.shopping.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Buy3ForPriceOf2RuleImpl implements PriceRule {
    Set<String> buy3ForPriceOf2;

    public Buy3ForPriceOf2RuleImpl() {
        this.buy3ForPriceOf2 = new HashSet<>();
        this.buy3ForPriceOf2.add("Lime");
    }

    @Override
    public int calculateCost(List<String> items) {
        int ruleItemCount = 2;
        return PriceRule.getCost(items, buy3ForPriceOf2, ruleItemCount);
    }


}
