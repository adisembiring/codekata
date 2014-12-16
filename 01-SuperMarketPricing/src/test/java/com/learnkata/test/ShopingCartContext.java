package com.learnkata.test;

import com.learnkata.kata01.Product;
import com.learnkata.kata01.ShoppingCart;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class ShopingCartContext {
    protected final ShoppingCart cart;
    protected final Product citato;
    protected final Product pringles;
    protected final Product pepsi;

    public ShopingCartContext() {
        cart = new ShoppingCart();
        citato = new Product(1, "Citato", 12000);
        pringles = new Product(2, "Pringles", 18000);
        pepsi = new Product(3, "Pepsi", 10000);
    }
}
