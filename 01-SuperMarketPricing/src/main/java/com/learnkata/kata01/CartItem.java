package com.learnkata.kata01;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
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

        CartItem cartItem = (CartItem) o;

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

}
