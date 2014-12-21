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
    boolean evaluate(Product product, int quantity) {
        return this.product.equals(product) && quantity >= requiredQuantity;
    }

    @Override
    public float discount(Product product, int quantity) {
        if (!evaluate(product, quantity)) {
            throw new IllegalArgumentException("Product is not availiable for discount");
        }

        int n = Math.floorDiv(quantity, requiredQuantity);
        int div = quantity % requiredQuantity;

        return (n * discountPrice) + (div * product.getPrice());
    }
}
