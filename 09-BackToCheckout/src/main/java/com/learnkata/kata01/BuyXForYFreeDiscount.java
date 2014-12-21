package com.learnkata.kata01;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class BuyXForYFreeDiscount extends Discount {
    private final Product product;
    private final int requiredQuantity;
    private final int freeQuantity;

    public BuyXForYFreeDiscount(int id, String name, Product product, int requiredQuantity, int freeQuantity) {
        super(id, name);
        this.product = product;
        this.requiredQuantity = requiredQuantity;
        this.freeQuantity = freeQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    @Override
    boolean evaluate(Product product, int quantity) {
        return this.product.equals(product) && quantity >= requiredQuantity;
    }

    @Override
    public float discount(Product product, int quantity) {
        int n = Math.floorDiv(quantity, requiredQuantity + freeQuantity);
        int div = quantity % (requiredQuantity + freeQuantity);

        return (n * getDiscountPrice(product)) + (div * product.getPrice());
    }

    private float getDiscountPrice(Product product) {
        return product.getPrice() * requiredQuantity;
    }
}
