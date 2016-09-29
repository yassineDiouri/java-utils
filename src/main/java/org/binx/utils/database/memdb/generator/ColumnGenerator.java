package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ColumnGenerator {

	public static <T> Column<T> getColumn(String name) {
		return new Column<T>(name);
	}
	
	public static <T> Column<T> getColumn(String name, T value) {
		return new Column<T>(name, value);
	}
}
