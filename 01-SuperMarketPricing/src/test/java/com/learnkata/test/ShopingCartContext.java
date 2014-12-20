package com.learnkata.test;

import com.learnkata.kata01.Checkout;
import com.learnkata.kata01.Product;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class ShopingCartContext {
    protected final Checkout cart;
    protected final Product citato;
    protected final Product pringles;
    protected final Product pepsi;

    public ShopingCartContext() {
        cart = new Checkout();
        citato = new Product(1, "Citato", 12000);
        pringles = new Product(2, "Pringles", 18000);
        pepsi = new Product(3, "Pepsi", 10000);
    }
}
