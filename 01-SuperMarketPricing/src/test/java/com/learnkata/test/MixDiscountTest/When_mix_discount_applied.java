package com.learnkata.test.MixDiscountTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class When_mix_discount_applied extends MixDiscountContext {

    @Before
    public void because() {
        cart.addItem(pringles, 3);
        cart.addItem(pepsi, 3);
        cart.addItem(citato, 2);
    }

    @Test
    public void total_should_incoude_pringles_discount_pepsi_discount_and_citato_normal_price() {
        float expected = pringlesDiscount.getDiscountPrice() + pepsi.getPrice() * 2 + citato.getPrice() * 2;
        assertEquals(expected, cart.getTotal(), 0);
    }
}
