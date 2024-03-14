package com.shopping.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceRuleTest {
    @Test
    public void getCostForBuy3ForPriceOf2Test(){
        List<String> items = List.of("Lime","Lime","Lime");
        Set<String> buy3ForPriceOf2 = new HashSet<>();
        buy3ForPriceOf2.add("Lime");
        int itemCount = 2;
        int cost = PriceRule.getCost(items, buy3ForPriceOf2, itemCount);
        assertEquals(30, cost);
    }

    @Test
    public void getCostForBuy1Get1FreeTest(){
        List<String> items = List.of("Melon","Melon","Melon","Melon");
        Set<String> buy1Get1Free = new HashSet<>();
        buy1Get1Free.add("Melon");
        int itemCount = 1;
        int cost = PriceRule.getCost(items, buy1Get1Free, itemCount);
        assertEquals(100, cost);
    }

    @Test
    public void getCostForMixedUpRulesTest(){
        List<String> items = List.of("Lime","Lime","Lime","Lime");
        Set<String> buy1Get1Free = new HashSet<>();
        buy1Get1Free.add("Melon");
        int itemCount = 1;
        int cost = PriceRule.getCost(items, buy1Get1Free, itemCount);
        assertEquals(0, cost);
    }

    @Test
    public void getCostForEmptyItemsTest(){
        List<String> items = List.of();
        Set<String> buy1Get1Free = new HashSet<>();
        buy1Get1Free.add("Melon");
        int itemCount = 1;
        int cost = PriceRule.getCost(items, buy1Get1Free, itemCount);
        assertEquals(0, cost);
    }

    @Test
    void getPriceTest() {
        assertEquals(35, PriceRule.getPrice("Apple"));
        assertEquals(20, PriceRule.getPrice("Banana"));
        assertEquals(50, PriceRule.getPrice("Melon"));
        assertEquals(15, PriceRule.getPrice("Lime"));
        assertEquals(0, PriceRule.getPrice("Orange"));
    }

}
