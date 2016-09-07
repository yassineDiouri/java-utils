package org.binx.utils.nulls.test;

import java.math.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class NullTestUtilsUnitTests extends TestCase {

	protected Object nul;
	protected String nul2;
	protected String notNull;
	protected BigDecimal notNull2;
	
	@Override
	protected void setUp() throws Exception {
		nul = null;
		nul2 = null;
		notNull = new String("str");
		notNull2 = new BigDecimal(1);
	}
	
	public void testIsNotNullReturnTrue(){
		assertTrue(NullTestUtils.isNotNull(notNull));
	}
	
	public void testIsNotNullReturnFalse(){
		assertFalse(NullTestUtils.isNotNull(nul));
	}
	
	public void testIsNullReturnTrue(){
		assertTrue(NullTestUtils.isNull(nul));
	}
	
	public void testIsNullReturnFalse(){
		assertFalse(NullTestUtils.isNull(notNull));
	}
	
	public void testAreNullReturnNull(){
		assertNull(NullTestUtils.areNull());
	}
	
	public void testAreNullReturnTrue(){
		assertTrue(NullTestUtils.areNull(nul, nul2));
	}
	
	public void testAreNullReturnFalse(){
		assertFalse(NullTestUtils.areNull(notNull, notNull2));
	}
	
	public void testOnlyTheFirstIsNotNullReturnNull(){
		assertNull(NullTestUtils.onlyTheFirstIsNotNull());
	}
	
	public void testOnlyTheFirstIsNotNullReturnTrue(){
		assertTrue(NullTestUtils.onlyTheFirstIsNotNull(notNull));
		assertTrue(NullTestUtils.onlyTheFirstIsNotNull(notNull, nul, nul2));
	}
	
	public void testOnlyTheFirstIsNotNullReturnFalse(){
		assertFalse(NullTestUtils.onlyTheFirstIsNotNull(nul));
		assertFalse(NullTestUtils.onlyTheFirstIsNotNull(notNull, notNull2));
	}
	
	public void testOnlyTheFirstIsNullReturnNull(){
		assertNull(NullTestUtils.onlyTheFirstIsNull());
	}
	
	public void testOnlyTheFirstIsNullReturnTrue(){
		assertTrue(NullTestUtils.onlyTheFirstIsNull(nul));
		assertTrue(NullTestUtils.onlyTheFirstIsNull(nul, notNull, notNull2));
	}
	
	public void testOnlyTheFirstIsNullReturnFalse(){
		assertFalse(NullTestUtils.onlyTheFirstIsNull(notNull));
		assertFalse(NullTestUtils.onlyTheFirstIsNull(nul, nul2));
	}
	
	public void testOnlyTheObjectInPositionIsNotNullReturnNull(){
		assertNull(NullTestUtils.onlyTheObjectInPositionIsNotNull(2));
		assertNull(NullTestUtils.onlyTheObjectInPositionIsNotNull(-2));
		assertNull(NullTestUtils.onlyTheObjectInPositionIsNotNull(0));
		assertNull(NullTestUtils.onlyTheObjectInPositionIsNotNull(3, nul, notNull));
	}
	
	public void testOnlyTheObjectInPositionIsNotNullReturnTrue(){
		assertTrue(NullTestUtils.onlyTheObjectInPositionIsNotNull(1, notNull));
		assertTrue(NullTestUtils.onlyTheObjectInPositionIsNotNull(2, nul, notNull, nul2));
	}
	
	public void testOnlyTheObjectInPositionIsNotNullReturnFalse(){
		assertFalse(NullTestUtils.onlyTheObjectInPositionIsNotNull(3, nul, notNull, notNull2));
		assertFalse(NullTestUtils.onlyTheObjectInPositionIsNotNull(2, nul, notNull, notNull2));
		assertFalse(NullTestUtils.onlyTheObjectInPositionIsNotNull(1, nul, notNull, notNull2));
		assertFalse(NullTestUtils.onlyTheObjectInPositionIsNotNull(1, nul));
	}
	
	public void testOnlyTheObjectInPositionIsNullReturnNull(){
		assertNull(NullTestUtils.onlyTheObjectInPositionIsNull(2));
		assertNull(NullTestUtils.onlyTheObjectInPositionIsNull(0));
		assertNull(NullTestUtils.onlyTheObjectInPositionIsNull(-3, nul, notNull));
		assertNull(NullTestUtils.onlyTheObjectInPositionIsNull(3, nul, notNull));
	}
	
	public void testOnlyTheObjectInPositionIsNullReturnTrue(){
		assertTrue(NullTestUtils.onlyTheObjectInPositionIsNull(1, nul));
		assertTrue(NullTestUtils.onlyTheObjectInPositionIsNull(2, notNull, nul, notNull2));
	}
	
	public void testOnlyTheObjectInPositionIsNullReturnFalse(){
		assertFalse(NullTestUtils.onlyTheObjectInPositionIsNull(3, notNull, nul, nul2));
		assertFalse(NullTestUtils.onlyTheObjectInPositionIsNull(2, notNull, nul, nul2));
		assertFalse(NullTestUtils.onlyTheObjectInPositionIsNull(1, notNull, nul, nul2));
		assertFalse(NullTestUtils.onlyTheObjectInPositionIsNull(1, notNull));
	}
	
	public void testXObjectsAreNotNullReturnNull(){
		assertNull(NullTestUtils.xObjectsAreNotNull(5));
		assertNull(NullTestUtils.xObjectsAreNotNull(-3, nul, notNull));
		assertNull(NullTestUtils.xObjectsAreNotNull(3, nul, notNull));
	}
	
	public void testXObjectsAreNotNullReturnTrue(){
		assertTrue(NullTestUtils.xObjectsAreNotNull(0, nul , nul2));
		assertTrue(NullTestUtils.xObjectsAreNotNull(1, nul , notNull));
		assertTrue(NullTestUtils.xObjectsAreNotNull(2, notNull, notNull2));
		assertTrue(NullTestUtils.xObjectsAreNotNull(2, nul , notNull, nul2, notNull2));
	}
	
	public void testXObjectsAreNotNullReturnFalse(){
		assertFalse(NullTestUtils.xObjectsAreNotNull(1, nul , nul2));
		assertFalse(NullTestUtils.xObjectsAreNotNull(0, nul , notNull));
		assertFalse(NullTestUtils.xObjectsAreNotNull(1, nul , notNull, nul2, notNull2));
		assertFalse(NullTestUtils.xObjectsAreNotNull(3, nul , notNull, nul2, notNull2));
	}
	
	public void testXObjectsAreNullReturnNull(){
		assertNull(NullTestUtils.xObjectsAreNull(5));
		assertNull(NullTestUtils.xObjectsAreNull(-3, nul, notNull));
		assertNull(NullTestUtils.xObjectsAreNull(3, nul, notNull));
	}
	
	public void testXObjectsAreNullReturnTrue(){
		assertTrue(NullTestUtils.xObjectsAreNull(0, notNull, notNull2));
		assertTrue(NullTestUtils.xObjectsAreNull(1, nul , notNull));
		assertTrue(NullTestUtils.xObjectsAreNull(2, nul , nul2));
		assertTrue(NullTestUtils.xObjectsAreNull(2, nul , notNull, nul2, notNull2));
	}
	
	public void testXObjectsAreNullReturnFalse(){
		assertFalse(NullTestUtils.xObjectsAreNull(1, nul , nul2));
		assertFalse(NullTestUtils.xObjectsAreNull(0, nul , notNull));
		assertFalse(NullTestUtils.xObjectsAreNull(1, nul , notNull, nul2, notNull2));
		assertFalse(NullTestUtils.xObjectsAreNull(3, nul , notNull, nul2, notNull2));
	}
}
