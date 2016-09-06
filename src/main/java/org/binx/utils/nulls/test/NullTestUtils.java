package org.binx.utils.nulls.test;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class NullTestUtils {

	public static Boolean isNotNull(Object o) {
		return o != null;
	}

	public static Boolean isNull(Object o) {
		return o == null;
	}
	
	/**
	 * All Objects of the array are not null<br/>
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param objects
	 * @return true if all objects are not null, false if just one is null
	 */
	public static Boolean areNotNull(Object... objects) {
		if(objects.length > 0){
			for (int i = 0; i < objects.length; i++) {
				if (isNull(objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * All Objects of the array are null<br/>
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param objects
	 * @return true if all objects are null, false if just one is not null
	 */
	public static Boolean areNull(Object... objects) {
		if(objects.length > 0){
			for (int i = 0; i < objects.length; i++) {
				if (isNotNull(objects[i]))
					return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * Test if only the first Object is not null and others are null<br/>
	 * <i>Whatever the classes</i><br/>
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean onlyTheFirstIsNotNull(Object... objects) {
		if(objects.length > 0){
			for (int i = 0; i < objects.length; i++) {
				if (i == 0) {
					if (isNull(objects[i]))
						return false;
				} else {
					if (isNotNull(objects[i]))
						return false;
				}
			}
			return true;
		}
		return null;
	}

	/**
	 * Test if only the first Object is null and others are not null<br/>
	 * <i>Whatever the classes</i><br/>
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean onlyTheFirstIsNull(Object... objects) {
		if(objects.length > 0){
			for (int i = 0; i < objects.length; i++) {
				if (i == 0) {
					if (isNotNull(objects[i]))
						return false;
				} else {
					if (isNull(objects[i]))
						return false;
				}
			}
			return true;
		}
		return null;
	}

	/**
	 * Test if only the latest Object is not null and others are null<br/>
	 * <i>Whatever the classes</i><br/>
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean onlyTheLatestIsNotNull(Object... objects) {
		if(objects.length > 0){
			for (int i = 0; i < objects.length; i++) {
				if (i == objects.length - 1) {
					if (isNull(objects[i]))
						return false;
				} else {
					if (isNotNull(objects[i]))
						return false;
				}
			}
			return true;
		}
		return null;
	}

	/**
	 * Test if only the latest Object is null and others are not null<br/>
	 * <i>Whatever the classes</i><br/>
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param objects
	 * @return
	 */
	public static Boolean onlyTheLatestIsNull(Object... objects) {
		if(objects.length > 0){
			for (int i = 0; i < objects.length; i++) {
				if (i == objects.length - 1) {
					if (isNotNull(objects[i]))
						return false;
				} else {
					if (isNull(objects[i]))
						return false;
				}
			}
			return true;
		}
		return null;
	}

	/**
	 * Test if only the Object in the position X is not null and others are null<br/>
	 * <i>Whatever the classes</i><br/>
	 * <i>Return null if the list is empty or on not valid position</i>
	 * 
	 * @param position : start from '1'
	 * @param objects
	 * @return
	 */
	public static Boolean onlyTheObjectInPositionIsNotNull(Integer position, Object... objects) {
		if(objects.length > 0 && position >= 1 && position <= objects.length){
			for (int i = 0; i < objects.length; i++) {
				if (i == position - 1) {
					if (isNull(objects[i]))
						return false;
				} else {
					if (isNotNull(objects[i]))
						return false;
				}
			}
			return true;
		}
		return null;
	}

	/**
	 * Test if only the Object in the position X is null and others are not null<br/>
	 * <i>Whatever the classes</i><br/>
	 * <i>Return null if the list is empty or on not valid position</i>
	 * 
	 * @param position : start from '1'
	 * @param objects
	 * @return
	 */
	public static Boolean onlyTheObjectInPositionIsNull(Integer position, Object... objects) {
		if(objects.length > 0 && position >= 1 && position <= objects.length){
			for (int i = 0; i < objects.length; i++) {
				if (i == position - 1) {
					if (isNotNull(objects[i]))
						return false;
				} else {
					if (isNull(objects[i]))
						return false;
				}
			}
			return true;
		}
		return null;
	}

	/**
	 * Test if only X Objects are not null and others are null<br/>
	 * <i>Whatever the classes</i><br/>
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param x : Number of Objects how must be null on the list
	 * @param objects
	 * @return 
	 */
	public static Boolean xObjectsAreNotNull(Integer x, Object... objects) {
		if(objects.length > 0 && x >= 0 && x <= objects.length){
			int n = 0;
			for(int i = 0; i < objects.length; i++){
				if(isNotNull(objects[i]))
					n++;
			}
			return n == x;
		}
		return null;
	}

	/**
	 * Test if only X Objects are null and others are not null<br/>
	 * <i>Whatever the classes</i><br/>
	 * <i>Return null if the list is empty</i>
	 * 
	 * @param x : Number of Objects how must be null on the list
	 * @param objects
	 * @return 
	 */
	public static Boolean xObjectsAreNull(Integer x, Object... objects) {
		if(objects.length > 0 && x >= 0 && x <= objects.length){
			int n = 0;
			for(int i = 0; i < objects.length; i++){
				if(isNull(objects[i]))
					n++;
			}
			return n == x;
		}
		return null;
	}
}
