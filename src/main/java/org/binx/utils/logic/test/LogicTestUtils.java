package org.binx.utils.logic.test;

import org.binx.utils.nulls.test.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class LogicTestUtils {

	/**
	 * Returns the reversed logical value of its argument. I.e. <br/>
	 * If the argument is FALSE, then TRUE is returned and vice versa
	 * 
	 * @param b
	 * @return
	 */
	public static Boolean not(Boolean b) {
		if(b == null) return null;
		else return !b;
	}
	
	/**
	 * Do the AND operation between all element of the list given<br/>
	 * <i>Condition : All element of the list must be Boolean</i>
	 * 
	 * @param bools
	 * @return
	 * True if All elements are True<br/>
	 * False if one or more are False<br/>
	 * Null if one or more are Null or empty list
	 */
	public static Boolean and(Boolean... bools) {
		if(nullTestToList((Object[]) bools)) return null;
		for(Boolean b : bools) {
			if(!b) return false;
		}
		return true;
	}
	
	/**
	 * Do the OR operation between all element of the list given<br/>
	 * <i>Condition : All element of the list must be Boolean</i>
	 * 
	 * @param bools
	 * @return
	 * True if one or more elements are True<br/>
	 * False if all elements are False<br/>
	 * Null if one or more are Null
	 */
	public static Boolean or(Boolean... bools) {
		if(nullTestToList((Object[]) bools)) return null;
		for(Boolean b : bools) {
			if(b) return true;
		}
		return false;
	}
	
	/**
	 * Returns a logical Exclusive Or of 2 Boolean arguments
	 * 
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static Boolean xor(Boolean b1, Boolean b2) {
		if(!NullTestUtils.areNotNull(b1, b2)) return null;
		if(b1 == b2) return false;
		else return true;
	}
	
	/*Test if the list is empty or contains null args*/
	private static Boolean nullTestToList(Object... objects){
		Boolean notNulTest = NullTestUtils.areNotNull(objects);
		if(notNulTest == null) return true;
		if(!notNulTest) return true;
		return false;
	}
}
