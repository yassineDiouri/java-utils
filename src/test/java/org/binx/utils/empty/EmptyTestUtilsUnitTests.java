package org.binx.utils.empty;

import java.util.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class EmptyTestUtilsUnitTests extends TestCase {

	protected Object nul;
	protected Object notEmptiable;
	protected String empty_str;
	protected String notEmpty_str;
	protected Collection<Object> empty_col;
	protected Collection<Object> notEmpty_col;
	protected Object[] empty_array;
	protected Object[] noEmpty_array;
	protected Map<Object,Object> empty_map;
	protected Map<Object,Object> notEmpty_map;
	
	@Override
	protected void setUp() {
		nul = null;
		notEmptiable = new Short((short) 5);
		empty_str = "";
		notEmpty_str = "notEmpty";
		empty_col = new LinkedList<>();
		notEmpty_col = new ArrayList<>();
		notEmpty_col.add("");
		empty_map = new HashMap<>();
		notEmpty_map = new HashMap<>();
		notEmpty_map.put("", "");
		empty_array = new Object[]{};
		noEmpty_array = new Object[]{""};
	}
	
	public void testIsEmptyReturnNull(){
		assertNull(EmptyTestUtils.isEmpty(nul));
		assertNull(EmptyTestUtils.isEmpty(notEmptiable));
	}
	
	public void testIsEmptyReturnTrue(){
		assertTrue(EmptyTestUtils.isEmpty(empty_str));
		assertTrue(EmptyTestUtils.isEmpty(empty_col));
		assertTrue(EmptyTestUtils.isEmpty(empty_map));
		assertTrue(EmptyTestUtils.isEmpty(empty_array));
	}
}
