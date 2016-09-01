package org.binx.utils.math.bigdecimal.generator;

import java.math.*;

public abstract class BigDecimalGenerator {
	
	public static BigDecimal get(Number number) {
		return new BigDecimal(number.doubleValue());
	}

	public static BigDecimal get(Integer scale, RoundingMode mode, Number number) {
		return new BigDecimal(number.doubleValue()).setScale(scale, mode);
	}
}
