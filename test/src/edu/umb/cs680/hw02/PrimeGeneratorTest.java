package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PrimeGeneratorTest {

	@Test
	public void initializeNonNullLinkedListWithoutGeneratingPrimes() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		Assertions.assertNotNull(cut.getPrimes());								//Check if initialization is done, when instances of class is created
	}

	@Test
	public void verifyFromAs1ForPrimeBetween1And5() {							//From is start of range
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertTrue(cut.from == 1);									//Check if data member is initialized with correct value
	}

	@Test
	public void checkFromAsNot4ForPrimeBetween1And5() {							//From is not in the range
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertFalse(cut.from == 4);									//Check if data member is initialized with correct value
	}

	@Test
	public void checkFromAsNot6ForPrimeBetween1And5() {							//From is not out of range
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertFalse(cut.from == 6);									//Check if data member is initialized with correct value
	}

	@Test
	public void verifyToAs5ForPrimeBetween1And5() {								//To is end of range
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertTrue(cut.to == 5);										//Check if data member is initialized with correct value
	}

	@Test
	public void checkToAs6ForPrimeBetween1And5() {								//To is not out of range
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertFalse(cut.to == 6);									//Check if data member is initialized with correct value
	}

	@Test
	public void checkToAs1ForPrimeBetween1And5() {								//To is not start of range
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertFalse(cut.to == 1);									//Check if data member is initialized with correct value
	}

	@Test
	public void checkToAs3ForPrimeBetween1And5() {								//To is not between of range
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertFalse(cut.to == 3);									//Check if data member is initialized with correct value
	}

	@Test
	public void checkToAs3ForPrimeBetween1And5WithoutSettingRange() {			//To is not between of range
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		Assertions.assertFalse(cut.to == 3);									//Check if data member is initialized with correct value
	}

	@Test
	public void verifyIsEvenReturnsTrueFor2() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertTrue(cut.isEven(2));									//Check if method returns true for known even number
	}

	@Test
	public void verifyIsEvenReturnsTrueFor2WithoutSettingRange() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		Assertions.assertTrue(cut.isEven(2));									//Check if method returns true for known even number
	}

	@Test
	public void verifyIsEvenReturnsFalseFor3() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertFalse(cut.isEven(3));									//Check if method returns false for known odd number
	}

	@Test
	public void verifyIsEvenReturnsFalseFor3WithoutSettingRange() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		Assertions.assertFalse(cut.isEven(3));									//Check if method returns false for known odd number
	}

	@Test
	public void verifyIsPrimeReturnsTrueFor5() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertTrue(cut.isPrime(5));									//Check if method returns true for known prime number
	}

	@Test
	public void verifyIsPrimeReturnsTrueFor5WithoutSettingRange() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		Assertions.assertTrue(cut.isPrime(5));									//Check if method returns true for known prime number
	}

	@Test
	public void verifyIsPrimeReturnsFalseFor6() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		cut.setRange(1, 5);														//Set range
		Assertions.assertFalse(cut.isPrime(6));									//Check if method returns false for known non-prime number
	}

	@Test
	public void verifyIsPrimeReturnsFalseFor6WithoutSettingRange() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();	//Object created
		Assertions.assertFalse(cut.isPrime(6));									//Check if method returns false for known non-prime number
	}

	@Test
	public void verifyGetPrimesWithoutCallingGeneratePrimesForPrimeBetween1And5() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		cut.setRange(1, 5);

		if(cut.primes.size() != 0){
			cut.primes.clear();											//if primes list member of class was assigned before with some values, clear those
		}

		LinkedList<Long> expected = new LinkedList<>();					//LinkedList object created for expected
		LinkedList<Long> actual = cut.getPrimes();						//Actual list of primes

		Long[] expectedArray = expected.toArray(new Long[0]);			//Convert to Long array to use assertArrayEquals
		Long[] actualArray = actual.toArray(new Long[0]);				//Convert to Long array to use assertArrayEquals

		Assertions.assertTrue(cut instanceof SingletonPrimeGenerator);	//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);		//Check if both arrays are same -> [] and []
	}

	@Test
	public void primeBetween1And5() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		cut.setRange(1, 5);

		if(cut.primes.size() != 0){
			cut.primes.clear();											//if primes list member of class was assigned before with some values, clear those
		}

		cut.generatePrimes();											//Generates prime and stores in member variable

		LinkedList<Long> expected = new LinkedList<>();					//Expected list of primes
		expected.add(2L);
		expected.add(3L);
		expected.add(5L);
		LinkedList<Long> actual = cut.getPrimes();						//Actual list of primes

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof SingletonPrimeGenerator);	//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);		//Check if list of primes in 'expectedArray' is same as in 'actualArray'
	}

	@Test
	public void noPrimeBetween14And16() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		cut.setRange(14, 16);

		if(cut.primes.size() != 0){
			cut.primes.clear();											//if primes list member of class was assigned before with some values, clear those
		}
		
		cut.generatePrimes();

		LinkedList<Long> expected = new LinkedList<>();
		LinkedList<Long> actual = cut.getPrimes();

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof SingletonPrimeGenerator);					//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);				//Check if list of primes in 'expectedArray' is same as in 'actualArray'
		Assertions.assertEquals(expectedArray.length, actualArray.length);		//Check if size of list of primes 'expectedArray' is equal to 'actualArray'
	}

	@Test
	public void primeBetween2And50() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		cut.setRange(2, 50);

		if(cut.primes.size() != 0){
			cut.primes.clear();											//if primes list member of class was assigned before with some values, clear those
		}

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

		Assertions.assertTrue(cut instanceof SingletonPrimeGenerator);			//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);		//Check if list of primes in 'expectedArray' is same as in 'actualArray'
	}

	@Test
	public void primeBetween3And11() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		cut.setRange(3, 11);

		if(cut.primes.size() != 0){
			cut.primes.clear();											//if primes list member of class was assigned before with some values, clear those
		}

		cut.generatePrimes();

		LinkedList<Long> expected = new LinkedList<>();
		expected.add(3L);
		expected.add(5L);
		expected.add(7L);
		expected.add(11L);
		LinkedList<Long> actual = cut.getPrimes();

		Long[] expectedArray = expected.toArray(new Long[0]);
		Long[] actualArray = actual.toArray(new Long[0]);

		Assertions.assertTrue(cut instanceof SingletonPrimeGenerator);		//Check for object to be an instance of class
		Assertions.assertArrayEquals(expectedArray, actualArray);	//Check if list of primes in 'expectedArray' is same as in 'actualArray'
		Assertions.assertTrue(actual.contains(11L));				//Check if 'actual' list of primes contains 11
		Assertions.assertTrue(!actual.contains(111L));				//Check if 'actual' list of primes does not contain 111
	}
	@Test
	public void primeBetween5And1() {
		try{
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(5, 1);

			if(cut.primes.size() != 0){
				cut.primes.clear();											//if primes list member of class was assigned before with some values, clear those
			}
			
			cut.generatePrimes();
			
			LinkedList<Long> actual = cut.getPrimes();


			Assertions.fail("from is greater than to");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=5 to=1", ex.getMessage());	//RuntimeException raised as 'from' is greater than 'to'
		}
	}
	@Test
	public void primeBetweenNeg1And10() {
		try{
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(-1, 10);
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
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(1,-10);
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
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(-1, -10);
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
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(-13, -13);
			cut.generatePrimes();
			LinkedList<Long> actual = cut.getPrimes();

			Assertions.fail("to is equal to from");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=-13 to=-13", ex.getMessage());	//RuntimeException raised as 'to' is not greater than 'from'
		}
	}
	@Test
	public void verifyGetInstanceCreatesInstanceOfSingletonClass() {
		SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
		Assertions.assertTrue(cut instanceof SingletonPrimeGenerator);			//Check for object to be an instance of class using getInstance returns a non-null value.
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

		Assertions.assertIterableEquals(expected, actual);						//Check with assertIterableEquals if getPrimes() returns the expected result
	}
	@Test
	public void primeBetweenNeg13AndNeg10() {

		try{
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(-13, -10);

			Assertions.fail("from is less than 1");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=-13 to=-10", ex.getMessage());	//RuntimeException raised as 'from' is less than 1
		}
	}
	@Test
	public void primeBetween5And5() {
		try{
			SingletonPrimeGenerator cut = SingletonPrimeGenerator.getInstance();
			cut.setRange(5, 5);

			Assertions.fail("from is not less than to");
		}
		catch(RuntimeException ex){
			Assertions.assertEquals("Wrong input values: from=5 to=5", ex.getMessage());	//RuntimeException raised as 'from' is not less than 'to'
		}
	}
}