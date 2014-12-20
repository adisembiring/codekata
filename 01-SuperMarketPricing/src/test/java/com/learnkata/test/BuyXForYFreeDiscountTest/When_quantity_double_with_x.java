package com.learnkata.test.BuyXForYFreeDiscountTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class When_quantity_double_with_x extends BuyXForYFreeDiscountContext {

    @Before
    public void because() {
        cart.addItem(pepsi, 6);
    }

    @Test
    public void total_should_equal_to_discount_price() {
        float expected = pepsi.getPrice() * 4;
        assertEquals(expected, cart.getTotal(), 0);
    }
}
