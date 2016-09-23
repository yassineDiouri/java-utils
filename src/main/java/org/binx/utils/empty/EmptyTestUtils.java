package org.binx.utils.empty;

import java.util.*;

/**
 * This Class contain static functions that offers<br/>
 * Boolean empty tests of Objects or Arrays<br/>
 * <i>Objects must be emptiable :
 * <ul>
 * <li>String</li>
 * <li>Collection</li>
 * <li>Map</li>
 * <li>Array</li>
 * </ul></i><br/>
 * 
 * @author Yassine Diouri
 *
 */
public abstract class EmptyTestUtils {

	/**
	 * Verify if the Object given is empty or not<br/>
	 * <i>Condition : the Object must be emptiable and not null</i><br/>
	 * <i>emptiable list : String, Collection, Array, Map</i>
	 * 
	 * @param o
	 * @return
	 *    True if the element is empty<br/>
	 *    False if not<br/>
	 *    Null if the element is null or is not emptiable
	 */
	public static Boolean isEmpty(Object o) {
		if(o == null) return null;
		if(o instanceof java.lang.String) return ((String) o).length() == 0;
		if(o instanceof java.util.Collection) return ((Collection<?>) o).size() == 0;
		if(o instanceof java.util.Map) return ((Map<?, ?>) o).size() == 0;
		if(o.getClass().isArray()) return ((Object[]) o).length == 0;
		return null;
	}
	
	/**
	 * Verify if the array of Objects given are empty or not<br/>
	 * <i>Condition : the Objects must be emptiable and not null</i><br/>
	 * <i>emptiable list : String, Collection, Array, Map</i>
	 * 
	 * @param objects
	 * @return
	 *    True if all element are empty<br/>
	 *    False if not<br/>
	 *    Null if One or more elements are null or are not emptiable
	 */
	public static Boolean areEmpty(Object... objects) {
		for(int i = 0; i < objects.length; i++){
			Boolean result = isEmpty(objects[i]);
			if(result == null) return null;
			if(!result) return false;
		}
		return true;
	}
}
