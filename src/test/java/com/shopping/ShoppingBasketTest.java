package com.shopping;

import com.shopping.domain.Buy1ForPriceOf1RuleImpl;
import com.shopping.domain.Buy1Get1FreeRuleImpl;
import com.shopping.domain.Buy3ForPriceOf2RuleImpl;
import com.shopping.domain.PriceRule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ShoppingBasketTest {
    @Test
    public void calculateCostOfBasketTest() {
        List<PriceRule> priceRules = List.of(new Buy1ForPriceOf1RuleImpl(), new Buy1Get1FreeRuleImpl(), new Buy3ForPriceOf2RuleImpl());
        List<String> items = List.of("Apple", "Apple", "Banana", "Melon", "Melon","Lime","Lime","Lime");
        long price = new ShoppingBasketImpl(priceRules).calculateTotalCost(items);
        assertEquals(170, price);
    }

    @Test
    public void calculateCostOfBasketWithBuy1ForPriceOf1Test() {
        List<PriceRule> priceRules = List.of(new Buy1ForPriceOf1RuleImpl(), new Buy1Get1FreeRuleImpl(), new Buy3ForPriceOf2RuleImpl());
        List<String> items = List.of("Apple", "Apple", "Banana", "Banana", "Apple", "Banana");
        long price = new ShoppingBasketImpl(priceRules).calculateTotalCost(items);
        assertEquals(165, price);
    }

    @Test
    public void calculateCostOfBasketWithMultipleBuyOneGetOneFreeTest() {
        List<PriceRule> priceRules = List.of(new Buy1ForPriceOf1RuleImpl(), new Buy1Get1FreeRuleImpl(), new Buy3ForPriceOf2RuleImpl());
        List<String> items = List.of("Melon", "Melon", "Melon", "Melon");
        long price = new ShoppingBasketImpl(priceRules).calculateTotalCost(items);
        assertEquals(100, price);
    }

    @Test
    public void calculateCostOfBasketWithMultiple3ForPriceOf2Test() {
        List<PriceRule> priceRules = List.of(new Buy1ForPriceOf1RuleImpl(), new Buy1Get1FreeRuleImpl(), new Buy3ForPriceOf2RuleImpl());
        List<String> items = List.of("Lime", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime");
        long price = new ShoppingBasketImpl(priceRules).calculateTotalCost(items);
        assertEquals(75, price);
    }

    @Test
    public void calculateCostOfBasketWithUnordered3ForPriceOf2Test() {
        List<PriceRule> priceRules = List.of(new Buy1ForPriceOf1RuleImpl(), new Buy1Get1FreeRuleImpl(), new Buy3ForPriceOf2RuleImpl());
        List<String> items = List.of("Lime", "Apple", "Lime", "Lime", "Lime", "Banana", "Lime", "Lime");
        long price = new ShoppingBasketImpl(priceRules).calculateTotalCost(items);
        assertEquals(115, price);
    }

    @Test
    public void calculateCostOfEmptyBasketTest() {
        List<PriceRule> priceRules = List.of(new Buy1ForPriceOf1RuleImpl(), new Buy1Get1FreeRuleImpl(), new Buy3ForPriceOf2RuleImpl());
        List<String> items = List.of();
        long price = new ShoppingBasketImpl(priceRules).calculateTotalCost(items);
        assertEquals(0, price);
    }
}
