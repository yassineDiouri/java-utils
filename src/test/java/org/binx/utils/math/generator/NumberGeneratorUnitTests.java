package org.binx.utils.math.generator;

import java.math.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */

public class NumberGeneratorUnitTests extends TestCase {

	protected Long nul;
	protected float flot;
	protected Object decimal;
	
	protected void setUp() {
		nul = null;
		flot = 4f;
		decimal = new BigDecimal("5.02");
	}
	
	public void testGetFunctionMustReturnNullNumber(){
		assertNull(NumberGenerator.get(nul));
	}
	
	public void testGetFunctionMustReturnNotNullNumber(){
		assertNotNull(NumberGenerator.get(flot));
	}
	
	public void testGetFunctionMustReturnTheSameValue(){
		assertEquals(NumberGenerator.get(decimal).doubleValue(), 5.02d);
	}
}
