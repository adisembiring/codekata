package com.learnkata.kata01;

import java.util.Optional;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class Item {
    private final Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item cartItem = (Item) o;

        if (quantity != cartItem.quantity) return false;
        if (product != null ? !product.equals(cartItem.product) : cartItem.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + quantity;
        return result;
    }

    public float getPrice(Optional<Discount> discount) {
        if (discount.isPresent()) {
            return discount.get().discount(product, quantity);
        } else {
            return quantity * product.getPrice();
        }
    }
}
