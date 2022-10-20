package com.rbc.basket;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tests the Basket class.
 * 
 * @author Arnab Chakraborty 
 *
 */
public class ItemPriceProviderTest {

	private ItemPriceProviderImpl itemPriceProvider;
	private Map<String, Double> itemToPriceMap;
	@Before
	public void setup(){
		itemToPriceMap = new HashMap<>();
		itemToPriceMap.put("item1",4.0);
		itemToPriceMap.put("item2",3.0);
		itemPriceProvider = new ItemPriceProviderImpl(itemToPriceMap);
	}
	@Test
	public void getPriceForItemTestWhenItemNull() {
         try{
			 itemPriceProvider.getPriceForItem(null);
		 }catch (IllegalArgumentException e)
		 {
			 assertEquals("item cannot be null!",e.getMessage());
		 }
	}
	@Test
	public void getPriceForItemTestWhenItemIsNotNull() {
		try{
			double price=itemPriceProvider.getPriceForItem("item1");
			assertEquals("4.0",String.valueOf(price));
		}catch (Exception e)
		{
			fail();
		}
	}

	@Test
	public void getPriceForItemTestWhenItemIsNotInList() {
		String itemNotExist="item3";
		try{
			itemPriceProvider.getPriceForItem(itemNotExist);
		}catch (ItemPriceNotFoundException e)
		{
			assertEquals("Could not find price for item: " + itemNotExist,e.getMessage());
		}
	}

	@Test
	public void getPriceForItemTestWhenItemPriceMapIsNull() {
		try{
			itemPriceProvider = new ItemPriceProviderImpl(null);
			itemPriceProvider.getPriceForItem(null);
		}catch (IllegalArgumentException e)
		{
			assertEquals("itemToPriceMap cannot be null!",e.getMessage());
		}
	}
}
