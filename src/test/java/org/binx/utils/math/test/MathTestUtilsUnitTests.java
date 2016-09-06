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
		assertNull(MathTestUtils.isPositive(nul));
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
		assertNull(MathTestUtils.arePositive(notNumber, nul));
		assertNull(MathTestUtils.arePositive(notNumber, nul, number, zero));
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
		assertNull(MathTestUtils.isNegative(nul));
	}
	
	public void testIsNegativeReturnTrue() {
		assertTrue(MathTestUtils.isNegative(doubleNumber));
	}
	
	public void testIsNegativeReturnFalse() {
		assertFalse(MathTestUtils.isNegative(number));
		assertFalse(MathTestUtils.isNegative(intNumber));
		assertFalse(MathTestUtils.isNegative(zero));
	}
	
	public void testAreNegativeReturnNull() {
		assertNull(MathTestUtils.areNegative());
		assertNull(MathTestUtils.areNegative(notNumber, nul));
		assertNull(MathTestUtils.areNegative(notNumber, nul, number, zero));
	}
	
	public void testAreNegativeReturnTrue() {
		assertTrue(MathTestUtils.areNegative(doubleNumber, doubleNumber));
	}
	
	public void testAreNegativeReturnFalse() {
		assertFalse(MathTestUtils.areNegative(number));
		assertFalse(MathTestUtils.areNegative(doubleNumber, intNumber, zero));
	}
	
	public void testAGreaterThanBReturnNull() {
		assertNull(MathTestUtils.AGreaterThanB(notNumber, number));
		assertNull(MathTestUtils.AGreaterThanB(number, notNumber));
		assertNull(MathTestUtils.AGreaterThanB(nul, number));
		assertNull(MathTestUtils.AGreaterThanB(number, nul));
	}
	
	public void testAGreaterThanBReturnTrue() {
		assertTrue(MathTestUtils.AGreaterThanB(intNumber, number));
		assertTrue(MathTestUtils.AGreaterThanB(number, doubleNumber));
	}
	
	public void testAGreaterThanBReturnFalse() {
		assertFalse(MathTestUtils.AGreaterThanB(number, number));
		assertFalse(MathTestUtils.AGreaterThanB(number, intNumber));
		assertFalse(MathTestUtils.AGreaterThanB(doubleNumber, zero));
	}
	
	public void testAGreaterOrEqualToBReturnNull() {
		assertNull(MathTestUtils.AGreaterOrEqualToB(notNumber, number));
		assertNull(MathTestUtils.AGreaterOrEqualToB(number, notNumber));
		assertNull(MathTestUtils.AGreaterOrEqualToB(nul, number));
		assertNull(MathTestUtils.AGreaterOrEqualToB(number, nul));
	}
	
	public void testAGreaterOrEqualToBReturnTrue() {
		assertTrue(MathTestUtils.AGreaterOrEqualToB(number, number));
		assertTrue(MathTestUtils.AGreaterOrEqualToB(intNumber, number));
		assertTrue(MathTestUtils.AGreaterOrEqualToB(number, doubleNumber));
	}
	
	public void testAGreaterOrEqualToBReturnFalse() {
		assertFalse(MathTestUtils.AGreaterOrEqualToB(number, intNumber));
		assertFalse(MathTestUtils.AGreaterOrEqualToB(doubleNumber, zero));
	}
	
	public void testFirstGreaterThanOthersReturnNull() {
		assertNull(MathTestUtils.firstGreaterThanOthers());
		assertNull(MathTestUtils.firstGreaterThanOthers(notNumber));
		assertNull(MathTestUtils.firstGreaterThanOthers(notNumber, nul, number));
	}
	
	public void testFirstGreaterThanOthersReturnTrue() {
		assertTrue(MathTestUtils.firstGreaterThanOthers(number));
		assertTrue(MathTestUtils.firstGreaterThanOthers(intNumber, zero, number, doubleNumber));
	}
	
	public void testFirstGreaterThanOthersReturnFalse() {
		assertFalse(MathTestUtils.firstGreaterThanOthers(number, zero, number));
		assertFalse(MathTestUtils.firstGreaterThanOthers(number, zero, doubleNumber, intNumber));
	}
	
	public void testFirstGreaterOrEqualToOthersReturnNull() {
		assertNull(MathTestUtils.firstGreaterOrEqualToOthers());
		assertNull(MathTestUtils.firstGreaterOrEqualToOthers(notNumber));
		assertNull(MathTestUtils.firstGreaterOrEqualToOthers(notNumber, nul, number));
	}
	
	public void testFirstGreaterOrEqualToOthersReturnTrue() {
		assertTrue(MathTestUtils.firstGreaterOrEqualToOthers(number));
		assertTrue(MathTestUtils.firstGreaterOrEqualToOthers(number, zero, number));
		assertTrue(MathTestUtils.firstGreaterOrEqualToOthers(intNumber, zero, number, doubleNumber));
	}
	
	public void testFirstGreaterOrEqualToOthersReturnFalse() {
		assertFalse(MathTestUtils.firstGreaterOrEqualToOthers(number, zero, doubleNumber, intNumber));
	}
	
	public void testLatestGreaterThanOthersReturnNull() {
		assertNull(MathTestUtils.latestGreaterThanOthers());
		assertNull(MathTestUtils.latestGreaterThanOthers(notNumber));
		assertNull(MathTestUtils.latestGreaterThanOthers(notNumber, nul, number));
	}
	
	public void testLatestGreaterThanOthersReturnTrue() {
		assertTrue(MathTestUtils.latestGreaterThanOthers(number));
		assertTrue(MathTestUtils.latestGreaterThanOthers(zero, number, doubleNumber, intNumber));
	}
	
	public void testLatestGreaterThanOthersReturnFalse() {
		assertFalse(MathTestUtils.latestGreaterThanOthers(number, zero, number));
		assertFalse(MathTestUtils.latestGreaterThanOthers(zero, intNumber, number, doubleNumber));
	}
	
	public void testLatestGreaterOrEqualToOthersReturnNull() {
		assertNull(MathTestUtils.latestGreaterOrEqualToOthers());
		assertNull(MathTestUtils.latestGreaterOrEqualToOthers(notNumber));
		assertNull(MathTestUtils.latestGreaterOrEqualToOthers(notNumber, nul, number));
	}
	
	public void testLatestGreaterOrEqualToOthersReturnTrue() {
		assertTrue(MathTestUtils.latestGreaterOrEqualToOthers(number));
		assertTrue(MathTestUtils.latestGreaterOrEqualToOthers(number, zero, number));
		assertTrue(MathTestUtils.latestGreaterOrEqualToOthers(zero, number, doubleNumber, intNumber));
	}
	
	public void testLatestGreaterOrEqualToOthersReturnFalse() {
		assertFalse(MathTestUtils.latestGreaterOrEqualToOthers(zero, intNumber, number, doubleNumber));
	}
	
	public void testNumberAtPositionIsGreaterThanOthersReturnNull() {
		assertNull(MathTestUtils.numberAtPositionIsGreaterThanOthers(5));
		assertNull(MathTestUtils.numberAtPositionIsGreaterThanOthers(2, notNumber, nul, zero));
		assertNull(MathTestUtils.numberAtPositionIsGreaterThanOthers(0, number));
		assertNull(MathTestUtils.numberAtPositionIsGreaterThanOthers(4, number, intNumber, zero));
	}
	
	public void testNumberAtPositionIsGreaterThanOthersReturnTrue() {
		assertTrue(MathTestUtils.numberAtPositionIsGreaterThanOthers(1, zero));
		assertTrue(MathTestUtils.numberAtPositionIsGreaterThanOthers(3, number, zero, intNumber, doubleNumber));
	}
	
	public void testNumberAtPositionIsGreaterThanOthersReturnFalse() {
		assertFalse(MathTestUtils.numberAtPositionIsGreaterThanOthers(2, number, zero, intNumber, doubleNumber));
		assertFalse(MathTestUtils.numberAtPositionIsGreaterThanOthers(3, number, zero, intNumber, doubleNumber, intNumber));
	}
	
	public void testNumberAtPositionIsGreaterOrEqualToOthersReturnNull() {
		assertNull(MathTestUtils.numberAtPositionIsGreaterOrEqualToOthers(5));
		assertNull(MathTestUtils.numberAtPositionIsGreaterOrEqualToOthers(2, notNumber, nul, zero));
		assertNull(MathTestUtils.numberAtPositionIsGreaterOrEqualToOthers(0, number));
		assertNull(MathTestUtils.numberAtPositionIsGreaterOrEqualToOthers(4, number, intNumber, zero));
	}
	
	public void testNumberAtPositionIsGreaterOrEqualToOthersReturnTrue() {
		assertTrue(MathTestUtils.numberAtPositionIsGreaterOrEqualToOthers(1, zero));
		assertTrue(MathTestUtils.numberAtPositionIsGreaterOrEqualToOthers(3, number, zero, intNumber, doubleNumber));
		assertTrue(MathTestUtils.numberAtPositionIsGreaterOrEqualToOthers(3, number, zero, intNumber, doubleNumber, intNumber));
	}
	
	public void testNumberAtPositionIsGreaterOrEqualToOthersReturnFalse() {
		assertFalse(MathTestUtils.numberAtPositionIsGreaterOrEqualToOthers(2, number, zero, intNumber, doubleNumber));
	}
	
	public void testALowerThanBReturnNull() {
		assertNull(MathTestUtils.ALowerThanB(notNumber, number));
		assertNull(MathTestUtils.ALowerThanB(number, notNumber));
		assertNull(MathTestUtils.ALowerThanB(nul, number));
		assertNull(MathTestUtils.ALowerThanB(number, nul));
	}
	
	public void testALowerThanBReturnTrue() {
		assertTrue(MathTestUtils.ALowerThanB(doubleNumber, number));
	}
	
	public void testALowerThanBReturnFalse() {
		assertFalse(MathTestUtils.ALowerThanB(number, number));
		assertFalse(MathTestUtils.ALowerThanB(zero, doubleNumber));
	}
	
	public void testALowerOrEqualToBReturnNull() {
		assertNull(MathTestUtils.ALowerOrEqualToB(notNumber, number));
		assertNull(MathTestUtils.ALowerOrEqualToB(number, notNumber));
		assertNull(MathTestUtils.ALowerOrEqualToB(nul, number));
		assertNull(MathTestUtils.ALowerOrEqualToB(number, nul));
	}
	
	public void testALowerOrEqualToBReturnTrue() {
		assertTrue(MathTestUtils.ALowerOrEqualToB(doubleNumber, number));
		assertTrue(MathTestUtils.ALowerOrEqualToB(number, number));
	}
	
	public void testALowerOrEqualToBReturnFalse() {
		assertFalse(MathTestUtils.ALowerOrEqualToB(zero, doubleNumber));
	}
	
	public void testFirstLowerThanOthersReturnNull() {
		assertNull(MathTestUtils.firstLowerThanOthers());
		assertNull(MathTestUtils.firstLowerThanOthers(notNumber));
		assertNull(MathTestUtils.firstLowerThanOthers(notNumber, nul, number));
	}
	
	public void testFirstLowerThanOthersReturnTrue() {
		assertTrue(MathTestUtils.firstLowerThanOthers(number));
		assertTrue(MathTestUtils.firstLowerThanOthers(doubleNumber, number, intNumber, zero));
	}
	
	public void testFirstLowerThanOthersReturnFalse() {
		assertFalse(MathTestUtils.firstLowerThanOthers(zero, doubleNumber, number, intNumber));
		assertFalse(MathTestUtils.firstLowerThanOthers(doubleNumber, number, doubleNumber, intNumber, zero));
	}
	
	public void testFirstLowerOrEqualToOthersReturnNull() {
		assertNull(MathTestUtils.firstLowerOrEqualToOthers());
		assertNull(MathTestUtils.firstLowerOrEqualToOthers(notNumber));
		assertNull(MathTestUtils.firstLowerOrEqualToOthers(notNumber, nul, number));
	}
	
	public void testFirstLowerOrEqualToOthersReturnTrue() {
		assertTrue(MathTestUtils.firstLowerOrEqualToOthers(number));
		assertTrue(MathTestUtils.firstLowerOrEqualToOthers(doubleNumber, number, intNumber, zero));
		assertTrue(MathTestUtils.firstLowerOrEqualToOthers(doubleNumber, number, doubleNumber, intNumber, zero));
	}
	
	public void testFirstLowerOrEqualToOthersReturnFalse() {
		assertFalse(MathTestUtils.firstLowerOrEqualToOthers(zero, doubleNumber, number, intNumber));
	}
	
	public void testLatestLowerThanOthersReturnNull() {
		assertNull(MathTestUtils.latestLowerThanOthers());
		assertNull(MathTestUtils.latestLowerThanOthers(notNumber));
		assertNull(MathTestUtils.latestLowerThanOthers(notNumber, nul, number));
	}
	
	public void testLatestLowerThanOthersReturnTrue() {
		assertTrue(MathTestUtils.latestLowerThanOthers(number));
		assertTrue(MathTestUtils.latestLowerThanOthers(number, intNumber, zero, doubleNumber));
	}
	
	public void testLatestLowerThanOthersReturnFalse() {
		assertFalse(MathTestUtils.latestLowerThanOthers(number, intNumber, doubleNumber, zero));
		assertFalse(MathTestUtils.latestLowerThanOthers(number, intNumber, zero, doubleNumber, doubleNumber));
	}
	
	public void testLatestLowerOrEqualToOthersReturnNull() {
		assertNull(MathTestUtils.latestLowerOrEqualToOthers());
		assertNull(MathTestUtils.latestLowerOrEqualToOthers(notNumber));
		assertNull(MathTestUtils.latestLowerOrEqualToOthers(notNumber, nul, number));
	}
	
	public void testLatestLowerOrEqualToOthersReturnTrue() {
		assertTrue(MathTestUtils.latestLowerOrEqualToOthers(number));
		assertTrue(MathTestUtils.latestLowerOrEqualToOthers(number, intNumber, zero, doubleNumber));
		assertTrue(MathTestUtils.latestLowerOrEqualToOthers(number, intNumber, zero, doubleNumber, doubleNumber));
	}
	
	public void testLatestLowerOrEqualToOthersReturnFalse() {
		assertFalse(MathTestUtils.latestLowerOrEqualToOthers(number, intNumber, doubleNumber, zero));
	}
	
	public void testNumberAtPositionIsLowerThanOthersReturnNull() {
		assertNull(MathTestUtils.numberAtPositionIsLowerThanOthers(5));
		assertNull(MathTestUtils.numberAtPositionIsLowerThanOthers(2, notNumber, nul, zero));
		assertNull(MathTestUtils.numberAtPositionIsLowerThanOthers(0, number));
		assertNull(MathTestUtils.numberAtPositionIsLowerThanOthers(4, number, intNumber, zero));
	}
	
	public void testNumberAtPositionIsLowerThanOthersReturnTrue() {
		assertTrue(MathTestUtils.numberAtPositionIsLowerThanOthers(1, zero));
		assertTrue(MathTestUtils.numberAtPositionIsLowerThanOthers(4, number, zero, intNumber, doubleNumber));
	}
	
	public void testNumberAtPositionIsLowerThanOthersReturnFalse() {
		assertFalse(MathTestUtils.numberAtPositionIsLowerThanOthers(1, number, zero, intNumber, doubleNumber));
		assertFalse(MathTestUtils.numberAtPositionIsLowerThanOthers(5, number, doubleNumber, zero, intNumber, doubleNumber));
	}
	
	public void testNumberAtPositionIsLowerOrEqualToOthersReturnNull() {
		assertNull(MathTestUtils.numberAtPositionIsLowerOrEqualToOthers(5));
		assertNull(MathTestUtils.numberAtPositionIsLowerOrEqualToOthers(2, notNumber, nul, zero));
		assertNull(MathTestUtils.numberAtPositionIsLowerOrEqualToOthers(0, number));
		assertNull(MathTestUtils.numberAtPositionIsLowerOrEqualToOthers(4, number, intNumber, zero));
	}
	
	public void testNumberAtPositionIsLowerOrEqualToOthersReturnTrue() {
		assertTrue(MathTestUtils.numberAtPositionIsLowerOrEqualToOthers(1, zero));
		assertTrue(MathTestUtils.numberAtPositionIsLowerOrEqualToOthers(4, number, zero, intNumber, doubleNumber));
		assertTrue(MathTestUtils.numberAtPositionIsLowerOrEqualToOthers(5, number, doubleNumber, zero, intNumber, doubleNumber));
	}
	
	public void testNumberAtPositionIsLowerOrEqualToOthersReturnFalse() {
		assertFalse(MathTestUtils.numberAtPositionIsLowerOrEqualToOthers(1, number, zero, intNumber, doubleNumber));
	}
	
	public void testAEqualToBReturnNull() {
		assertNull(MathTestUtils.AEqualToB(notNumber, number));
		assertNull(MathTestUtils.AEqualToB(number, notNumber));
		assertNull(MathTestUtils.AEqualToB(nul, number));
		assertNull(MathTestUtils.AEqualToB(number, nul));
	}
	
	public void testAEqualToBReturnTrue() {
		assertTrue(MathTestUtils.AEqualToB(number, number));
	}
	
	public void testAEqualToBReturnFalse() {
		assertFalse(MathTestUtils.AEqualToB(doubleNumber, intNumber));
	}
	
	public void testAreEqualReturnNull() {
		assertNull(MathTestUtils.areEqual());
		assertNull(MathTestUtils.areEqual(number));
		assertNull(MathTestUtils.areEqual(number, nul));
	}
	
	public void testAreEqualReturnTrue() {
		assertTrue(MathTestUtils.areEqual(number, number, number));
	}
	
	public void testAreEqualReturnFalse() {
		assertFalse(MathTestUtils.areEqual(number, intNumber, number));
	}
	
	public void testADifferentFromBReturnNull() {
		assertNull(MathTestUtils.ADifferentFromB(notNumber, number));
		assertNull(MathTestUtils.ADifferentFromB(number, notNumber));
		assertNull(MathTestUtils.ADifferentFromB(nul, number));
		assertNull(MathTestUtils.ADifferentFromB(number, nul));
	}
	
	public void testADifferentFromBReturnTrue() {
		assertTrue(MathTestUtils.ADifferentFromB(number, zero));
	}
	
	public void testADifferentFromBReturnFalse() {
		assertFalse(MathTestUtils.ADifferentFromB(number, number));
	}
	
	public void testAreDifferentFromEachOthersReturnNull() {
		assertNull(MathTestUtils.areDifferentFromEachOthers());
		assertNull(MathTestUtils.areDifferentFromEachOthers(notNumber, nul, number));
	}
	
	public void testAreDifferentFromEachOthersReturnTrue() {
		assertTrue(MathTestUtils.areDifferentFromEachOthers(number));
		assertTrue(MathTestUtils.areDifferentFromEachOthers(number, intNumber, doubleNumber, zero));
	}
	
	public void testAreDifferentFromEachOthersReturnFalse() {
		assertTrue(MathTestUtils.areDifferentFromEachOthers(number, zero, zero, intNumber, doubleNumber, zero));
	}
	
	public void testABetweenBAndCReturnNull() {
		assertNull(MathTestUtils.ABetweenBAndC(notNumber, nul, number));
	}
	
	public void testABetweenBAndCReturnTrue() {
		assertTrue(MathTestUtils.ABetweenBAndC(number, doubleNumber, intNumber));
	}
	
	public void testABetweenBAndCReturnFalse() {
		assertFalse(MathTestUtils.ABetweenBAndC(number, doubleNumber, number));
		assertFalse(MathTestUtils.ABetweenBAndC(number, number, intNumber));
		assertFalse(MathTestUtils.ABetweenBAndC(number, number, number));
		assertFalse(MathTestUtils.ABetweenBAndC(zero, number, intNumber));
		assertFalse(MathTestUtils.ABetweenBAndC(zero, intNumber, number));
	}
	
	public void testABetweenBAndCOrEqualToBReturnNull() {
		assertNull(MathTestUtils.ABetweenBAndCOrEqualToB(notNumber, nul, number));
	}
	
	public void testABetweenBAndCOrEqualToBReturnTrue() {
		assertTrue(MathTestUtils.ABetweenBAndCOrEqualToB(number, doubleNumber, intNumber));
		assertTrue(MathTestUtils.ABetweenBAndCOrEqualToB(number, number, intNumber));
	}
	
	public void testABetweenBAndCOrEqualToBReturnFalse() {
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToB(number, doubleNumber, number));
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToB(number, number, number));
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToB(zero, number, intNumber));
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToB(zero, intNumber, number));
	}
	
	public void testABetweenBAndCOrEqualToCReturnNull() {
		assertNull(MathTestUtils.ABetweenBAndCOrEqualToC(notNumber, nul, number));
	}
	
	public void testABetweenBAndCOrEqualToCReturnTrue() {
		assertTrue(MathTestUtils.ABetweenBAndCOrEqualToC(number, doubleNumber, intNumber));
		assertTrue(MathTestUtils.ABetweenBAndCOrEqualToC(number, doubleNumber, number));
	}
	
	public void testABetweenBAndCOrEqualToCReturnFalse() {
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToC(number, number, intNumber));
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToC(number, number, number));
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToC(zero, number, intNumber));
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToC(zero, intNumber, number));
	}
	
	public void testABetweenBAndCOrEqualToBAndCReturnNull() {
		assertNull(MathTestUtils.ABetweenBAndCOrEqualToBAndC(notNumber, nul, number));
	}
	
	public void testABetweenBAndCOrEqualToBAndCReturnTrue() {
		assertTrue(MathTestUtils.ABetweenBAndCOrEqualToBAndC(number, doubleNumber, intNumber));
		assertTrue(MathTestUtils.ABetweenBAndCOrEqualToBAndC(number, doubleNumber, number));
		assertTrue(MathTestUtils.ABetweenBAndCOrEqualToBAndC(number, number, intNumber));
		assertTrue(MathTestUtils.ABetweenBAndCOrEqualToBAndC(number, number, number));
	}
	
	public void testABetweenBAndCOrEqualToBAndCReturnFalse() {
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToBAndC(zero, number, intNumber));
		assertFalse(MathTestUtils.ABetweenBAndCOrEqualToBAndC(zero, intNumber, number));
	}
}
