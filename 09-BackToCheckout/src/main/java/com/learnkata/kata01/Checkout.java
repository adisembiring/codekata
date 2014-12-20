package com.learnkata.kata01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class Checkout {
    private final List<Product> products;
    private final List<Item> items;
    private final List<Discount> discounts;

    public Checkout(List<Product> products) {
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.products = products;
    }

    public void addItem(Product product, int quantity) {
        if (!isExists(product)) {
            items.add(new Item(product, quantity));
        } else {
            Item item = getItem(product);
            item.addQuantity(quantity);
        }
    }

    private Optional<Discount> getProductDiscount(Item item) {
        return discounts.stream().filter(x -> x.evaluate(item)).findFirst();
    }

    public Collection<Item> getItems() {
        return items;
    }

    public float getTotal() {
        float totalPrice = 0;
        for (Item item : items) {
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

    private Item getItem(Product product) {
        return items.stream().filter(p -> p.getProduct().equals(product)).findFirst().get();
    }

    public void addDiscountPolicy(Discount discount) {
        discounts.add(discount);
    }

    public void scan(String item) {
        Optional<Product> product = products.stream().filter(x -> x.getName().equals(item)).findFirst();
        if (product.isPresent()) {
            addItem(product.get(), 1);
        }
    }
}
