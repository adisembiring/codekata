package com.learnkata.kata01;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class BuyXForYPriceDiscount extends Discount {
    private final int requiredQuantity;
    private final Product product;
    private final float discountPrice;

    public BuyXForYPriceDiscount(int id, String name, Product product, int quantity, float price) {
        super(id, name);
        this.product = product;
        this.discountPrice = price;
        this.requiredQuantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public float getDiscountPrice() {
        return discountPrice;
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

        int n = Math.floorDiv(item.getQuantity(), requiredQuantity);
        int div = item.getQuantity() % requiredQuantity;

        return (n * discountPrice) + (div * item.getProduct().getPrice());
    }
}
