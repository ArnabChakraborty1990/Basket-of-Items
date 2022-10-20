package com.rbc.basket;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

/**
 * Tests the Basket class.
 * 
 * @author Arnab Chakraborty 
 *
 */
public class BasketTest {

	@Test
	public void getAllItemsTest() {
		Basket testBasket = new Basket();
		testBasket.addItem("one", 5);
		testBasket.addItem("two", 3);
		testBasket.addItem("one", 4);

		final Map<String, Integer> allItems = testBasket.getAllItems();
		assertEquals(2, allItems.size());
		assertEquals(9, allItems.get("one").intValue());
		assertEquals(3, allItems.get("two").intValue());
	}
}
