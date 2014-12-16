package com.learnkata.kata01;

/**
 * Created by adisembiring on 12/16/2014.
 */
public abstract class Discount {
    protected int id;
    protected String name;

    public Discount(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    abstract boolean evaluate(CartItem item);
    abstract float calculatePrice(CartItem item);
}
