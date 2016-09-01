package org.binx.utils.math.generator;

import org.binx.utils.math.test.*;

public abstract class NumberGenerator {
	/**
	 * Get the equivalent number for the object given<br/>
	 * <i>Return null if not number</i>
	 * 
	 * @param o
	 * @return
	 */
	public static Number get(Object o) {
		if(MathTestUtils.isNumber(o))
			return (Number) o;
		return null;
	}
}
