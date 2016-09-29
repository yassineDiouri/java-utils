package org.binx.utils.logic.test;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class LogicTestUtilsUnitTest extends TestCase {

	private Boolean nul;
	private Boolean tru;
	private Boolean fals;
	
	@Override
	protected void setUp() {
		nul = null;
		tru = true;
		fals = false;
	}
	
	public void testNotReturnNull(){
		assertNull(LogicTestUtils.not(nul));
	}
	
	public void testNotReturnTrue(){
		assertTrue(LogicTestUtils.not(fals));
	}
	
	public void testNotReturnFalse(){
		assertFalse(LogicTestUtils.not(tru));
	}
	
	public void testAndReturnNull(){
		assertNull(LogicTestUtils.and());
		assertNull(LogicTestUtils.and(nul, tru, fals));
	}
	
	public void testAndReturnTrue(){
		assertTrue(LogicTestUtils.and(tru));
		assertTrue(LogicTestUtils.and(tru, tru, tru));
	}
	
	public void testAndReturnFalse(){
		assertFalse(LogicTestUtils.and(fals));
		assertFalse(LogicTestUtils.and(tru, fals, tru, fals));
	}
	
	public void testOrReturnNull(){
		assertNull(LogicTestUtils.or());
		assertNull(LogicTestUtils.or(tru, nul));
	}
	
	public void testOrReturnTrue(){
		assertTrue(LogicTestUtils.or(tru));
		assertTrue(LogicTestUtils.or(tru, tru));
		assertTrue(LogicTestUtils.or(tru, fals, fals, tru));
	}
	
	public void testOrReturnFalse(){
		assertFalse(LogicTestUtils.or(fals));
		assertFalse(LogicTestUtils.or(fals, fals, fals));
	}
	
	public void testXorReturnNull(){
		assertNull(LogicTestUtils.xor(tru, nul));
		assertNull(LogicTestUtils.xor(nul, fals));
	}
	
	public void testXorReturnTrue(){
		assertTrue(LogicTestUtils.xor(tru, fals));
		assertTrue(LogicTestUtils.xor(fals, tru));
	}
	
	public void testXorReturnFalse(){
		assertFalse(LogicTestUtils.xor(fals, fals));
		assertFalse(LogicTestUtils.xor(tru, tru));
	}
}
