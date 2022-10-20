package com.rbc.basket;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Main class.
 * 
 * @author Arnab Chakraborty 
 *
 */
public class MainTest {
	@Test
	public void finalCostCalculationTest() {
		final Basket b = new Basket();
		b.addItem("one", 2);
		b.addItem("two", 3);

		final ItemPriceProviderImpl ipp = new ItemPriceProviderImpl(new HashMap<String, Double>() {
			{
				put("one", 0.5);
				put("two", 0.25);

			}
		});

		final Main toTest = new Main();
		final double fc = toTest.getFinalCost(b, ipp);
		assertTrue(Double.compare(1.75, fc) == 0);
	}
	@Test
	public void mainTest() {
		String simulatedUserInput = "5" + System.getProperty("line.separator")
				+ "2"+System.getProperty("line.separator")+"6";
		InputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		Main mainTest = new Main();
		mainTest.main(new String[]{});
	}
}
