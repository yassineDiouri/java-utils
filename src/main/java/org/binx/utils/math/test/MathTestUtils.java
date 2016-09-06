package org.binx.utils.math.test;

import org.binx.utils.math.generator.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class MathTestUtils {
	
	/**
	 * Verify if that the Object given is a Number
	 * 
	 * @param o
	 * @return
	 */
	public static Boolean isNumber(Object o) {
		return o instanceof java.lang.Number;
	}
	
	/**
	 * Test if all element of list are Numbers
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean areNumbers(Object... objects) {
		if(objects.length > 0){
			for (int i = 0; i < objects.length; i++) {
				if (!isNumber(objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Verify that the Object given is Positive Number<br/>
	 * <i>Return null if is not a number</i>
	 * 
	 * @param o : instance of java.lang.Number
	 * @return
	 * @throws NotNumberException
	 */
	public static Boolean isPositive(Object o) {
		return AGreaterThanB(NumberGeneratorUtils.get(o), 0);
	}
	
	/**
	 * Tests if all element of the list given are positive<br/>
	 * <i>condition : Objects must be instance of java.lang.Number</i><br/>
	 * <i>Return null if are not numbers or it's an empty list</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean arePositive(Object... objects) {
		if(objects.length == 1) return isPositive(objects[0]);
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 0; i < objects.length; i++){
				if(isNegative(objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Verify that the Object given is Negative Number<br/>
	 * <i>Return null if is not a number</i>
	 * 
	 * @param o : instance of java.lang.Number
	 * @return
	 */
	public static Boolean isNegative(Object o) {	
		return ALowerThanB(NumberGeneratorUtils.get(o), 0);
	}
	
	/**
	 * Tests if all element of the list given are negative<br/>
	 * <i>condition : Objects must be instance of java.lang.Number</i><br/>
	 * <i>Return null if are not numbers or it's an empty list</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean areNegative(Object... objects) {
		if(objects.length == 1) return isNegative(objects[0]);
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 0; i < objects.length; i++){
				if(isPositive(objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Test that the Object A is greater than B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static Boolean AGreaterThanB(Object A, Object B) {
		if(areNumbers(A, B)){
			Number varA = NumberGeneratorUtils.get(A);
			Number varB = NumberGeneratorUtils.get(B);

			return varA.doubleValue() > varB.doubleValue();
		}
		return null;
	}
	
	/**
	 * Test that the Object A is greater or equal to B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static Boolean AGreaterOrEqualToB(Object A, Object B) {
		if(areNumbers(A, B)){
			Number varA = NumberGeneratorUtils.get(A);
			Number varB = NumberGeneratorUtils.get(B);
			
			return varA.doubleValue() >= varB.doubleValue();
		}
		return null;
	}
	
	/**
	 * Test that the first element is greater than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean firstGreaterThanOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for (int i = 1; i < objects.length; i++) {
				if (ALowerOrEqualToB(objects[0], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Test that the first element is greater or equal to other elements of the list<br/>
	 * Accept that there is an other element with the same value in other position<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean firstGreaterOrEqualToOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for (int i = 1; i < objects.length; i++) {
				if (ALowerThanB(objects[0], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Test that the last element is greater than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param objects
	 */
	public static Boolean latestGreaterThanOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 0; i < objects.length - 1; i++){
				if(ALowerOrEqualToB(objects[objects.length - 1], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Test that the last element is greater or equal to other elements of the list<br/>
	 * Accept that there is an other element with the same value in other position<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param objects
	 */
	public static Boolean latestGreaterOrEqualToOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 0; i < objects.length - 1; i++){
				if(ALowerThanB(objects[objects.length - 1], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * Test that the element in the position POS is greater than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param position : start from 1
	 * @param objects
	 */
	public static Boolean numberAtPositionIsGreaterThanOthers(Integer position, Object... objects) {
		if(position >= 1 && position <= objects.length && areNumbers(objects)){
			for(int i = 0; i < position - 1; i++){
				if(ALowerOrEqualToB(objects[position - 1], objects[i]))
					return false;
			}
			for(int i = position; i < objects.length; i++){
				if(ALowerOrEqualToB(objects[position - 1], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * Test that the element in the position POS is greater or equal to other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param position : start from 1
	 * @param objects
	 */
	public static Boolean numberAtPositionIsGreaterOrEqualToOthers(Integer position, Object... objects) {
		if(position >= 1 && position <= objects.length && areNumbers(objects)){
			for(int i = 0; i < position - 1; i++){
				if(ALowerThanB(objects[position - 1], objects[i]))
					return false;
			}
			for(int i = position; i < objects.length; i++){
				if(ALowerThanB(objects[position - 1], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Test that the Object A is greater than B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static Boolean ALowerThanB(Object A, Object B) {
		if(areNumbers(A, B)){
			Number varA = NumberGeneratorUtils.get(A);
			Number varB = NumberGeneratorUtils.get(B);
			
			return varA.doubleValue() < varB.doubleValue();
		}
		return null;
	}
	
	/**
	 * Test that the Object A is greater than or equal to B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static Boolean ALowerOrEqualToB(Object A, Object B) {
		if(areNumbers(A, B)){
			Number varA = NumberGeneratorUtils.get(A);
			Number varB = NumberGeneratorUtils.get(B);
			
			return varA.doubleValue() <= varB.doubleValue();
		}
		return null;
	}

	/**
	 * Test that the first element is lower than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param objects
	 */
	public static Boolean firstLowerThanOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 1; i < objects.length; i++){
				if(AGreaterOrEqualToB(objects[0], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * Test that the first element is lower or equal to other elements of the list<br/>
	 * Accept that there is an other element with the same value in other position<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param objects
	 */
	public static Boolean firstLowerOrEqualToOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 1; i < objects.length; i++){
				if(AGreaterThanB(objects[0], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * Test that the last element is lower than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param objects
	 */
	public static Boolean latestLowerThanOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 0; i < objects.length - 1; i++){
				if(AGreaterOrEqualToB(objects[objects.length - 1], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * Test that the last element is lower or equal to other elements of the list<br/>
	 * Accept that there is an other element with the same value in other position<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param objects
	 */
	public static Boolean latestLowerOrEqualToOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 1; i < objects.length; i++){
				if(AGreaterThanB(objects[objects.length - 1], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * Test that the element in the position POS is lower than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param position : start from 1
	 * @param objects
	 */
	public static Boolean numberAtPositionIsLowerThanOthers(Integer position, Object... objects) {
		if(position >= 1 && position <= objects.length && areNumbers(objects)){
			for(int i = 0; i < position - 1; i++){
				if(AGreaterOrEqualToB(objects[position - 1], objects[i]))
					return false;
			}
			for(int i = position; i < objects.length; i++){
				if(AGreaterOrEqualToB(objects[position - 1], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * Test that the element in the position POS is lower than other elements of the list<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * @param position : start from 1
	 * @param objects
	 */
	public static Boolean numberAtPositionIsLowerOrEqualToOthers(Integer position, Object... objects) {
		if(position >= 1 && position <= objects.length && areNumbers(objects)){
			for(int i = 0; i < position - 1; i++){
				if(AGreaterThanB(objects[position - 1], objects[i]))
					return false;
			}
			for(int i = position; i < objects.length; i++){
				if(AGreaterThanB(objects[position - 1], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Test that the Object A is equal to B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static Boolean AEqualToB(Object A, Object B) {
		if(areNumbers(A, B)){
			Number varA = NumberGeneratorUtils.get(A);
			Number varB = NumberGeneratorUtils.get(B);

			return varA.doubleValue() == varB.doubleValue();
		}
		return null;
	}

	/**
	 * Test that all elements of the list are equal<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or if the list is empty or with one element</i>
	 * 
	 * @param objects
	 */
	public static Boolean areEqual(Object... objects) {
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 1; i < objects.length; i++){
				if(ADifferentFromB(objects[0], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Test that the Object A is different to B<br/>
	 * <i>Condition : A and B are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static Boolean ADifferentFromB(Object A, Object B) {
		if(areNumbers(A, B)){
			Number varA = NumberGeneratorUtils.get(A);
			Number varB = NumberGeneratorUtils.get(B);

			return varA.doubleValue() != varB.doubleValue();
		}
		return null;
	}

	/**
	 * Test that all elements of the list are different<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers or it's an empty list</i>
	 * 
	 * 
	 * @param objects
	 */
	public static Boolean areDifferentFromEachOthers(Object... objects) {
		if(objects.length == 1 && isNumber(objects[0])) return true;
		if(objects.length > 1 && areNumbers(objects)){
			for(int i = 1; i < objects.length; i++){
				if(AEqualToB(objects[0], objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}
	
	/**
	 * Test that A is greater than B and lower than C<br/>
	 * B < A < C<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	public static Boolean ABetweenBAndC(Object A, Object B, Object C) {
		if(areNumbers(A, B, C)){
			return AGreaterThanB(A, B) && ALowerThanB(A, C);
		}
		return null;
	}
	
	/**
	 * Test that A is greater or Equal to B and lower than C<br/>
	 * B <= A < C<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return 
	 */
	public static Boolean ABetweenBAndCOrEqualToB(Object A, Object B, Object C) {
		if(areNumbers(A, B, C)){
			return AGreaterOrEqualToB(A, B) && ALowerThanB(A, C);
		}
		return null;
	}
	
	/**
	 * Test that A is greater than B and lower or Equal to C<br/>
	 * B < A <= C<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return 
	 */
	public static Boolean ABetweenBAndCOrEqualToC(Object A, Object B, Object C) {
		if(areNumbers(A, B, C)){
			return AGreaterThanB(A, B) && ALowerOrEqualToB(A, C);
		}
		return null;
	}
	
	/**
	 * Test that A is greater or Equal to B and lower or Equal to C<br/>
	 * B <= A <= C<br/>
	 * <i>Condition : elements are Numbers (primitive numbers or java.lang.Number)</i><br/>
	 * <i>Return null if are not a numbers</i>
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return 
	 */
	public static Boolean ABetweenBAndCOrEqualToBAndC(Object A, Object B, Object C) {
		if(areNumbers(A, B, C)){
			return AGreaterOrEqualToB(A, B) && ALowerOrEqualToB(A, C);
		}
		return null;
	}
}
