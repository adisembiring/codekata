package com.learnkata.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adisembiring on 12/16/2014.
 */
public class WhenAddItemToEmptyCartWithOneQuantity extends ShopingCartContext {

    public WhenAddItemToEmptyCartWithOneQuantity() {
        cart.addItem(citato, 1);
    }

    @Test
    public void item_added() {
        assertEquals(1, cart.getItems().size());
    }

    @Test
    public void total_price_equal_to_item_price() {
        assertEquals(citato.getPrice(), cart.getTotalPrice(), 0);
    }

}
