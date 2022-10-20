package com.rbc.basket;

import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the Basket class.
 * 
 * @author Arnab Chakraborty 
 *
 */
public class ConsoleBasketReaderTest {

   private ConsoleBasketReader consoleBasketReaderTest;

	@Before
	public void setup(){
		consoleBasketReaderTest = new ConsoleBasketReader();
	}

	@Test
	public void getBasketTestWhenUserGivenAllinfoWantsToExit() {
		String simulatedUserInput = "5" + System.getProperty("line.separator")
				+ "2"+System.getProperty("line.separator")+"6";
		InputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		try{
			Basket basket= consoleBasketReaderTest.getBasket();
			assertNotNull(basket);
			assertTrue(basket.getAllItems().containsKey("Lemons"));
		}
		catch (Exception e){
			fail();
		}
	}

	@Test
	public void getBasketTestWithProperInput() {
		String simulatedUserInput = "5" + System.getProperty("line.separator")
				+ "2"+System.getProperty("line.separator");
		InputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		try{
			consoleBasketReaderTest.getBasket();
		}
		catch (Exception e){
			assertEquals(NoSuchElementException.class,e.getClass());
		}
	}
	@Test
	public void getBasketTestThrowsExceptionDueToInvalidInput() {
		String simulatedUserInput = "ds5";
		InputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		try{
			consoleBasketReaderTest.getBasket();
		}
		catch (Exception e){
			assertEquals(NoSuchElementException.class,e.getClass());
		}
	}
	@Test
	public void getBasketTestWhenItemChoiceIsNotBetweenTheRange() {
		String simulatedUserInput = "0";
		InputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		try{
			consoleBasketReaderTest.getBasket();
		}
		catch (Exception e){
			assertEquals(NoSuchElementException.class,e.getClass());
		}
	}


	@Test
	public void getBasketTestWhenUserProvidesNoQuantity() {
		String simulatedUserInput = "5" + System.getProperty("line.separator")
				+ "0"+System.getProperty("line.separator");
		InputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		try{
			consoleBasketReaderTest.getBasket();
		}
		catch(Exception e){
			assertEquals(NoSuchElementException.class,e.getClass());
		}
	}
}
