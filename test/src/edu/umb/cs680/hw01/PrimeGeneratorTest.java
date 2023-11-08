package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
public class PrimeGeneratorTest {

	@Test
	public void initializeNonNullLinkedListWithoutGeneratingPrimes() {
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertNotNull(cut.getPrimes());		//Check if initialization is done, when instances of class is created
	}

	@Test
	public void verifyFromAs1ForPrimeBetween1And5() {	//From is start of range
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertTrue(cut.from == 1);			//Check if data member is initialized with correct value
	}

	@Test
	public void checkFromAs4ForPrimeBetween1And5() {	//From is in the range
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertFalse(cut.from == 4);			//Check if data member is initialized with correct value
	}

	@Test
	public void checkFromAsNot6ForPrimeBetween1And5() {	//From is out of range
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertFalse(cut.from == 6);			//Check if data member is initialized with correct value
	}

	@Test
	public void verifyToAs5ForPrimeBetween1And5() {		//To is end of range
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertTrue(cut.to == 5);				//Check if data member is initialized with correct value
	}

	@Test
	public void checkToAs6ForPrimeBetween1And5() {		//To is out of range
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertFalse(cut.to == 6);			//Check if data member is initialized with correct value
	}

	@Test
	public void checkToAs1ForPrimeBetween1And5() {		//To is start of range
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertFalse(cut.to == 1);			//Check if data member is initialized with correct value
	}

	@Test
	public void checkToAs3ForPrimeBetween1And5() {		//To is between of range
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertFalse(cut.to == 3);			//Check if data member is initialized with correct value
	}

	@Test
	public void verifyIsEvenReturnsTrueFor2() {
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertTrue(cut.isEven(2));			//Check if method returns true for known even number
	}

	@Test
	public void verifyIsEvenReturnsFalseFor3() {
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertFalse(cut.isEven(3));			//Check if method returns false for known odd number
	}

	@Test
	public void verifyIsPrimeReturnsTrueFor5() {
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertTrue(cut.isPrime(5));			//Check if method returns true for known prime number
	}

	@Test
	public void verifyIsPrimeReturnsFalseFor6() {
		PrimeGenerator cut = new PrimeGenerator(1, 5);	//Object created
		Assertions.assertFalse(cut.isPrime(6));			//Check if method returns false for known non-prime number
	}

	@Test
	public void verifyGetPrimesWithoutCallingGeneratePrimesForPrimeBetween1And5() {
		PrimeGenerator cut = new PrimeGenerator(1, 5);					//Object created

		LinkedList<Long> expected = new LinkedList<>();					//LinkedList object created for expected
		LinkedList<Long> actual = cut.getPrimes();						//Actual list of primes

		Long[] expectedArray = expected.toArray(new Long[0]);			//Convert to Long array to use assertArrayEquals
		Long[] actualArray = actual.toArray(new Long[0]);				//Convert to Long array to use assertArrayEquals

		Assertions.assertTrue(cut instanceof PrimeGenerator);			//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);		//Check if both arrays are same -> [] and []
	}

	@Test
	public void primeBetween1And5() {

		PrimeGenerator cut = new PrimeGenerator(1, 5);
		cut.generatePrimes();											//Generates prime and stores in member variable

		LinkedList<Long> expected = new LinkedList<>();					//Expected list of primes
		expected.add(2L);
		expected.add(3L);
		expected.add(5L);
		LinkedList<Long> actual = cut.getPrimes();						//Actual list of primes

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof PrimeGenerator);			//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);		//Check if list of primes in 'expectedArray' is same as in 'actualArray'
	}
	@Test
	public void noPrimeBetween14And16() {
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
		PrimeGenerator cut = new PrimeGenerator(2, 50);						//From 2, To 50
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
		PrimeGenerator cut = new PrimeGenerator(3, 11);								//From 3, To 11
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
			PrimeGenerator cut = new PrimeGenerator(5, 1);									//From 5, To 1
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
			PrimeGenerator cut = new PrimeGenerator(-1, 10);									//From -1, To 10
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			Assertions.fail("from is less than 1");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=-1 to=10", ex.getMessage());	//RuntimeException raised as 'from' is less than 1
		}
	}

	@Test
	public void primeBetween1AndNeg10() {
		try{
			PrimeGenerator cut = new PrimeGenerator(1, -10);									//From 1, To -10
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			Assertions.fail("to is less than from");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=1 to=-10", ex.getMessage());	//RuntimeException raised as 'to' is less than 'from'
		}
	}
	@Test
	public void primeBetweenNeg1AndNeg10() {
		try{
			PrimeGenerator cut = new PrimeGenerator(-1, -10);									//From -1, To -10
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			Assertions.fail("from is less than 1");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=-1 to=-10", ex.getMessage());	//RuntimeException raised as 'from' is less than 1 and 'to' is not greater than 'from'
		}
	}
	@Test
	public void primeBetweenNeg13AndNeg13() {
		try{
			PrimeGenerator cut = new PrimeGenerator(-13, -13);									//From -13, To -13
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			Assertions.fail("to is equal to from");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=-13 to=-13", ex.getMessage());	//RuntimeException raised as 'to' is not greater than 'from'
		}
	}
}