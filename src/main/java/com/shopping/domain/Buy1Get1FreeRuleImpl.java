package com.shopping.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Buy1Get1FreeRuleImpl implements PriceRule {
    Set<String> buy1Get1Free;

    public Buy1Get1FreeRuleImpl() {
        this.buy1Get1Free = new HashSet<>();
        this.buy1Get1Free.add("Melon");
    }

    @Override
    public int calculateCost(List<String> items) {
        int ruleItemCount = 1;
        return PriceRule.getCost(items, buy1Get1Free, ruleItemCount);
    }
}
