package com.learnkata.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class WhenAddTwoDiferentProduct extends ShopingCartContext {

    @Before
    public void because() {
        cart.addItem(citato, 1);
        cart.addItem(pringles, 1);
    }

    @Test
    public void item_should_be_added() {
        assertEquals(2, cart.getItems().size());
    }

    @Test
    public void price_equal_from_first_and_second_price() {
        float expected = citato.getPrice() + pringles.getPrice();
        assertEquals(expected, cart.getTotalPrice(), 0);
    }
}
