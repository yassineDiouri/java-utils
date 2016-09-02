package org.binx.utils.math.generator;

import java.math.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */

public class NumberGeneratorUtilsUnitTests extends TestCase {

	protected Long nul;
	protected float flot;
	protected Object decimal;
	
	protected void setUp() {
		nul = null;
		flot = 4f;
		decimal = new BigDecimal("5.02");
	}
	
	public void testGetFunctionMustReturnNullNumber(){
		assertNull(NumberGeneratorUtils.get(nul));
	}
	
	public void testGetFunctionMustReturnNotNullNumber(){
		assertNotNull(NumberGeneratorUtils.get(flot));
	}
	
	public void testGetFunctionMustReturnTheSameValue(){
		assertEquals(NumberGeneratorUtils.get(decimal).doubleValue(), 5.02d);
	}
}
