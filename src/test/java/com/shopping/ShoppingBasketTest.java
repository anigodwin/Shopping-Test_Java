package com.shopping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ShoppingBasketTest {
    @Test
    public void calculateCostOfBasketTest() {
        List<String> items = List.of("Apple", "Apple", "Banana", "Melon", "Melon","Lime","Lime","Lime");
        long price = new ShoppingBasket().calculateTotalCost(items);
        assertEquals(170, price);
    }

    @Test
    public void calculateCostOfBasketWithBuy1ForPriceOf1Test() {
        List<String> items = List.of("Apple", "Apple", "Banana", "Banana", "Apple", "Banana");
        long price = new ShoppingBasket().calculateTotalCost(items);
        assertEquals(165, price);
    }

    @Test
    public void calculateCostOfBasketWithMultipleBuyOneGetOneFreeTest() {
        List<String> items = List.of("Melon", "Melon", "Melon", "Melon");
        long price = new ShoppingBasket().calculateTotalCost(items);
        assertEquals(100, price);
    }

    @Test
    public void calculateCostOfBasketWithMultiple3ForPriceOf2Test() {
        List<String> items = List.of("Lime", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime");
        long price = new ShoppingBasket().calculateTotalCost(items);
        assertEquals(75, price);
    }

    @Test
    public void calculateCostOfBasketWithUnordered3ForPriceOf2Test() {
        List<String> items = List.of("Lime", "Apple", "Lime", "Lime", "Lime", "Banana", "Lime", "Lime");
        long price = new ShoppingBasket().calculateTotalCost(items);
        assertEquals(115, price);
    }

    @Test
    public void calculateCostOfEmptyBasketTest() {
        List<String> items = List.of();
        long price = new ShoppingBasket().calculateTotalCost(items);
        assertEquals(0, price);
    }
}
