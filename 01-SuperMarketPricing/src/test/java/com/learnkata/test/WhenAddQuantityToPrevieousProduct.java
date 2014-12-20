package com.learnkata.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class WhenAddQuantityToPrevieousProduct extends ShopingCartContext {

    @Before
    public void because() {
        cart.addItem(citato, 1);
        cart.addItem(citato, 1);
    }

    @Test
    public void group_product_to_first_item() {
        assertEquals(1, cart.getItems().size());
    }

    @Test
    public void price_multiply_to_two() {
        assertEquals(citato.getPrice() * 2, cart.getTotal(), 0);
    }
}
