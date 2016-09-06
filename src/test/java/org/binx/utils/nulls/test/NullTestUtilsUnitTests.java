package org.binx.utils.nulls.test;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class NullTestUtilsUnitTests extends TestCase {

	protected Object nul;
	protected String notNull;
	
	@Override
	protected void setUp() throws Exception {
		nul = null;
		notNull = new String("str");
	}
	
	public void testIsNotNullReturnTrue(){
		assertTrue(NullTestUtils.isNotNull(notNull));
	}
}
