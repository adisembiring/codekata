package com.learnkata.test.BuyXForYPriceDiscountTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class When_quantity_item_equal_to_x extends BuyXForYPriceDiscountContext {
    @Before
    public void because() {
        cart.addItem(pringles, 3);
    }

    @Test
    public void total_should_equal_to_discount_price() {
        assertEquals(pringlesDiscount.getDiscountPrice(), cart.getTotalPrice(), 0);
    }
}
