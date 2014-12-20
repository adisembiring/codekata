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
    boolean evaluate(Item item) {
        return product.equals(item.getProduct()) && item.getQuantity() >= requiredQuantity;
    }

    @Override
    public float calculatePrice(Item item) {
        if (!evaluate(item)) {
            throw new IllegalArgumentException("Product is not availiable for discount");
        }

        int n = Math.floorDiv(item.getQuantity(), requiredQuantity + freeQuantity);
        int div = item.getQuantity() % (requiredQuantity + freeQuantity);

        return (n * getDiscountPrice(item)) + (div * item.getProduct().getPrice());
    }

    private float getDiscountPrice(Item item) {
        return item.getProduct().getPrice() * requiredQuantity;
    }
}
