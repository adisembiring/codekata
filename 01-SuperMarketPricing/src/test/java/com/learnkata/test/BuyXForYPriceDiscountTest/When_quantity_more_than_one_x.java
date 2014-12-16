package com.learnkata.test.BuyXForYPriceDiscountTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class When_quantity_more_than_one_x extends BuyXForYPriceDiscountContext {

    @Before
    public void because() {
        cart.addItem(pringles, 4);
    }

    @Test
    public void total_should_equal_to_discount_price() {
        float expected = pringlesDiscount.getDiscountPrice() + pringles.getPrice();
        assertEquals(expected, cart.getTotalPrice(), 0);
    }
}
