package com.rbc.basket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItemPriceNotFoundExceptionTest {

    private ItemPriceNotFoundException itemPriceNotFoundException;
    @Before
    public void setup(){
        itemPriceNotFoundException = new ItemPriceNotFoundException();
    }

    @Test
    public void ItemPriceNotFoundExceptionClassTest() {
        assertNotNull(itemPriceNotFoundException);
        itemPriceNotFoundException = new ItemPriceNotFoundException("ItemPriceNotFoundException1");
        assertEquals("ItemPriceNotFoundException1",itemPriceNotFoundException.getMessage());
        itemPriceNotFoundException = new ItemPriceNotFoundException(new Throwable("ItemPriceNotFoundException2"));
        assertEquals("ItemPriceNotFoundException2",itemPriceNotFoundException.getCause().getMessage());
        itemPriceNotFoundException = new ItemPriceNotFoundException("ItemPriceNotFoundException3",new Throwable("ItemPriceNotFoundException4"));
        assertEquals("ItemPriceNotFoundException3",itemPriceNotFoundException.getMessage());
        assertEquals("ItemPriceNotFoundException4",itemPriceNotFoundException.getCause().getMessage());
        itemPriceNotFoundException = new ItemPriceNotFoundException("ItemPriceNotFoundException5",new Throwable("ItemPriceNotFoundException6"),true,true);
        assertEquals("ItemPriceNotFoundException5",itemPriceNotFoundException.getMessage());
        assertEquals("ItemPriceNotFoundException6",itemPriceNotFoundException.getCause().getMessage());
    }
}
