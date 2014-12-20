package com.learnkata.test.BuyXForYFreeDiscountTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class When_quantity_more_than_x_one_item extends BuyXForYFreeDiscountContext {

    @Before
    public void because() {
        cart.addItem(pepsi, 4);
    }

    @Test
    public void total_should_equal_to_discount_price() {
        float expected = pepsi.getPrice() * 2 + pepsi.getPrice();
        assertEquals(expected, cart.getTotal(), 0);
    }
}
