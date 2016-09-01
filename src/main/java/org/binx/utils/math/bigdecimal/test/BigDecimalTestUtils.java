package org.binx.utils.math.bigdecimal.test;

import java.math.*;

public abstract class BigDecimalTestUtils {

	public static Boolean isBigDecimal(Object o) {
		return o instanceof java.math.BigDecimal;
	}
	
	/**
	 * Test that all elements of the list are equal with given scale<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param scale
	 * @param mode
	 * @param decimals
	 * @return
	 */
	public static Boolean areEqual(Integer scale, RoundingMode mode, BigDecimal... decimals) {
		if(decimals.length > 0){
			for(int i = 1; i < decimals.length; i++){
				if(decimals[0].setScale(scale, mode).compareTo(
						decimals[i].setScale(scale, mode)) != 0)
					return false;	
			}
			return true;
		}
		return null;
	}
}
