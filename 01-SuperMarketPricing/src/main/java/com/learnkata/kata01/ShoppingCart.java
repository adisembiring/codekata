package com.learnkata.kata01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class ShoppingCart {
    private List<CartItem> items;
    private List<Discount> discounts;

    public ShoppingCart() {
        items = new ArrayList<>();
        discounts = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        if (!isExists(product)) {
            items.add(new CartItem(product, quantity));
        } else {
            CartItem item = getItem(product);
            item.addQuantity(quantity);
        }
    }

    private Optional<Discount> getProductDiscount(CartItem item) {
        return discounts.stream().filter(x -> x.evaluate(item)).findFirst();
    }

    public Collection<CartItem> getItems() {
        return items;
    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for (CartItem item : items) {
            Optional<Discount> discount = getProductDiscount(item);
            if (discount.isPresent()) {
                totalPrice += discount.get().calculatePrice(item);
            } else {
                totalPrice += item.getQuantity() * item.getProduct().getPrice();
            }
        }
        return totalPrice;
    }

    private boolean isExists(Product product) {
        return items.stream().filter(p -> p.getProduct().equals(product)).count() > 0;
    }

    private CartItem getItem(Product product) {
        return items.stream().filter(p -> p.getProduct().equals(product)).findFirst().get();
    }

    public void addDiscountPolicy(Discount discount) {
        discounts.add(discount);
    }
}
