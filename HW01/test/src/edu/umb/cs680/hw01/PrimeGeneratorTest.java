package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimeGeneratorTest {
	@Test
	public void primeBetween1And5() {
		PrimeGenerator cut = new PrimeGenerator(1, 5);
		cut.generatePrimes();

		LinkedList<Long> expected = new LinkedList<>();
		expected.add(2L);
		expected.add(3L);
		expected.add(5L);
		LinkedList<Long> actual = cut.getPrimes();

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof PrimeGenerator);			//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);		//Check if list of primes in 'expectedArray' is same as in 'actualArray'
	}

	@Test
	public void primeBetween14And16() {
		PrimeGenerator cut = new PrimeGenerator(14, 16);
		cut.generatePrimes();

		LinkedList<Long> expected = new LinkedList<>();
		LinkedList<Long> actual = cut.getPrimes();

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof PrimeGenerator);					//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);				//Check if list of primes in 'expectedArray' is same as in 'actualArray'
		Assertions.assertEquals(expectedArray.length, actualArray.length);		//Check if size of list of primes 'expectedArray' is equal to 'actualArray'
	}

	@Test
	public void primeBetween2And50() {
		PrimeGenerator cut = new PrimeGenerator(2, 50);
		cut.generatePrimes();

		LinkedList<Long> expected = new LinkedList<>();
		expected.add(2L);
		expected.add(3L);
		expected.add(5L);
		expected.add(7L);
		expected.add(11L);
		expected.add(13L);
		expected.add(17L);
		expected.add(19L);
		expected.add(23L);
		expected.add(29L);
		expected.add(31L);
		expected.add(37L);
		expected.add(41L);
		expected.add(43L);
		expected.add(47L);

		LinkedList<Long> actual = cut.getPrimes();

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof PrimeGenerator);			//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);		//Check if list of primes in 'expectedArray' is same as in 'actualArray'
	}

	@Test
	public void primeBetween3And11() {
		PrimeGenerator cut = new PrimeGenerator(3, 11);
		cut.generatePrimes();

		LinkedList<Long> expected = new LinkedList<>();
		expected.add(3L);
		expected.add(5L);
		expected.add(7L);
		expected.add(11L);
		LinkedList<Long> actual = cut.getPrimes();

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof PrimeGenerator);		//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);	//Check if list of primes in 'expectedArray' is same as in 'actualArray'
		Assertions.assertTrue(actual.contains(11L));				//Check if 'actual' list of primes contains 11
		Assertions.assertTrue(!actual.contains(111L));				//Check if 'actual' list of primes does not contain 111
	}

	@Test
	public void primeBetween5And1() {
		try{
			PrimeGenerator cut = new PrimeGenerator(5, 1);
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			//Long[] expectedArray = expected.toArray(new Long[0]);
			//Long[] actualArray = actual.toArray(new Long[0]);

			Assertions.fail("from is greater than to");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=5 to=1", ex.getMessage());	//RuntimeException raised as 'from' is greater than 'to'
		}
	}

	@Test
	public void primeBetweenNeg1And10() {
		try{
			PrimeGenerator cut = new PrimeGenerator(-1, 10);
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			//Long[] expectedArray = expected.toArray(new Long[0]);
			//Long[] actualArray = actual.toArray(new Long[0]);

			Assertions.fail("from is less than 1");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=-1 to=10", ex.getMessage());	//RuntimeException raised as 'from' is less than 1
		}
	}

	@Test
	public void primeBetweenNeg1AndNeg10() {
		try{
			PrimeGenerator cut = new PrimeGenerator(-1, -10);
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			//Long[] expectedArray = expected.toArray(new Long[0]);
			//Long[] actualArray = actual.toArray(new Long[0]);

			Assertions.fail("from is less than 1");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=-1 to=-10", ex.getMessage());	//RuntimeException raised as 'from' is less than 1 and 'to' is not greater than 'from'
		}
	}

	@Test
	public void primeBetweenNeg13AndNeg13() {
		try{
			PrimeGenerator cut = new PrimeGenerator(13, 13);
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			//Long[] expectedArray = expected.toArray(new Long[0]);
			//Long[] actualArray = actual.toArray(new Long[0]);

			Assertions.fail("to is equal to from");	//
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=13 to=13", ex.getMessage());	//RuntimeException raised as 'to' is not greater than 'from'
		}
	}
}