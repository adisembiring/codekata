package com.learnkata.test.BuyXForYPriceDiscountTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class When_quantity_item_double_with_x extends BuyXForYPriceDiscountContext {

    @Before
    public void because() {
        cart.addItem(pringles, 6);
    }

    @Test
    public void total_should_equal_to_discount_price() {
        float expected = pringlesDiscount.getDiscountPrice() * 2;
        assertEquals(expected, cart.getTotal(), 0);
    }
}
