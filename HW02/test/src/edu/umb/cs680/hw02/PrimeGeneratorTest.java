package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PrimeGeneratorTest {
	@Test
	public void getInstanceReturnsNotNullValue() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		cut.setRange(1, 10);
		cut.generatePrimes();

		Assertions.assertNotNull(cut);			//Check for object to be an instance of class using getInstance returns a non-null value.
	}

	@Test
	public void getInstanceReturnsIdenticalInstance() {
		SingletonPrimeGenerator cut_1 = SingletonPrimeGenerator.getInstance();
		SingletonPrimeGenerator cut_2 = SingletonPrimeGenerator.getInstance();

		cut_1.setRange(1, 10);
		cut_1.generatePrimes();

		cut_2.setRange(1, 10);
		cut_2.generatePrimes();

		Assertions.assertSame(cut_1, cut_1);			//Checks whether .hashCode() is same for both
		Assertions.assertSame(cut_1, cut_2);			//Check getInstance() returns the identical instance when it is called multiple times
	}
	@Test
	public void primeBetween1And10() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		cut.setRange(1, 10);
		cut.generatePrimes();
		LinkedList<Long> actual = cut.getPrimes();

		LinkedList<Long> expected = new LinkedList<>();
		expected.add(2L);
		expected.add(3L);
		expected.add(5L);
		expected.add(7L);

		Assertions.assertIterableEquals(expected, actual);	//Check with assertIterableEquals if getPrimes() returns the expected result
	}

	@Test
	public void primeBetween1And5() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		cut.setRange(1, 5);
		cut.generatePrimes();

		LinkedList<Long> expected = new LinkedList<>();
		expected.add(2L);
		expected.add(3L);
		expected.add(5L);
		LinkedList<Long> actual = cut.getPrimes();

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof SingletonPrimeGenerator);			//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);		//Check if list of primes in 'expectedArray' is same as in 'actualArray'
	}
	@Test
	public void primeBetweenNeg10And10() {

		try{
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(-10, 10);

			Assertions.fail("from is less than 1");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=-10 to=10", ex.getMessage());	//RuntimeException raised as 'from' is less than 1
		}
	}


	@Test
	public void primeBetween10And1() {

		try{
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(10, 1);

			Assertions.fail("from is gretaer than to");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=10 to=1", ex.getMessage());	//RuntimeException raised as 'from' is greater than 'to'
		}
	}
}