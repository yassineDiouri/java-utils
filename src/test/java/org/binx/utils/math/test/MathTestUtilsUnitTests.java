package org.binx.utils.math.test;

import java.math.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class MathTestUtilsUnitTests extends TestCase {

	protected Object nul;
	protected BigDecimal number;
	protected String notNumber;
	protected int intNumber;
	protected Double doubleNumber;
	protected short zero;
	
	@Override
	public void setUp(){
		nul = null;
		number = new BigDecimal(5.2);
		notNumber = "Not Number";
		intNumber = 2015;
		doubleNumber = -15.024;
		zero = 0;
	}
	
	public void testIsNumberReturnTrue() {
		assertTrue(MathTestUtils.isNumber(number));
		assertTrue(MathTestUtils.isNumber(intNumber));
		assertTrue(MathTestUtils.isNumber(doubleNumber));
	}
	
	public void testIsNumberReturnFalse() {
		assertFalse(MathTestUtils.isNumber(notNumber));
		assertFalse(MathTestUtils.isNumber(nul));
	}
	
	public void testAreNumbersReturnNull() {
		assertNull(MathTestUtils.areNumbers());
	}
	
	public void testAreNumbersReturnTrue() {
		assertTrue(MathTestUtils.areNumbers(number));
		assertTrue(MathTestUtils.areNumbers(number, intNumber, doubleNumber));
	}
	
	public void testAreNumbersReturnFalse() {
		assertFalse(MathTestUtils.areNumbers(notNumber, nul));
		assertFalse(MathTestUtils.areNumbers(number, nul, notNumber, intNumber, doubleNumber));
	}
	
	public void testIsPositiveReturnNull() {
		assertNull(MathTestUtils.isPositive(notNumber));
	}
	
	public void testIsPositiveReturnTrue() {
		assertTrue(MathTestUtils.isPositive(number));
		assertTrue(MathTestUtils.isPositive(intNumber));
	}
	
	public void testIsPositiveReturnFalse() {
		assertFalse(MathTestUtils.isPositive(doubleNumber));
		assertFalse(MathTestUtils.isPositive(zero));
	}
	
	public void testArePositiveReturnNull() {
		assertNull(MathTestUtils.arePositive());
		assertNull(MathTestUtils.arePositive(notNumber, number, zero));
	}
	
	public void testArePositiveReturnTrue() {
		assertTrue(MathTestUtils.arePositive(number));
		assertTrue(MathTestUtils.arePositive(intNumber, number));
	}
	
	public void testArePositiveReturnFalse() {
		assertFalse(MathTestUtils.arePositive(zero, doubleNumber));
		assertFalse(MathTestUtils.arePositive(zero, number, doubleNumber));
	}
	
	public void testIsNegativeReturnNull() {
		assertNull(MathTestUtils.isNegative(notNumber));
	}
	
	public void testIsNegativeReturnTrue() {
		assertTrue(MathTestUtils.isNegative(doubleNumber));
	}
	
	public void testIsNegativeReturnFalse() {
		assertFalse(MathTestUtils.isNegative(number));
		assertFalse(MathTestUtils.isNegative(intNumber));
		assertFalse(MathTestUtils.isNegative(zero));
	}
	
	public void testAGreaterThanBReturnNull() {
		assertNull(MathTestUtils.AGreaterThanB(notNumber, number));
		assertNull(MathTestUtils.AGreaterThanB(number, notNumber));
	}
	
	public void testAGreaterThanBReturnTrue() {
		assertTrue(MathTestUtils.AGreaterThanB(intNumber, number));
		assertTrue(MathTestUtils.AGreaterThanB(number, doubleNumber));
	}
	
	public void testAGreaterThanBReturnFalse() {
		assertFalse(MathTestUtils.AGreaterThanB(number, intNumber));
		assertFalse(MathTestUtils.AGreaterThanB(doubleNumber, zero));
	}
}
