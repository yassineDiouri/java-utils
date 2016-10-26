package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ColumnGenerator {

	public static Column getColumn(String name) {
		return new Column(name);
	}
	
	public static Column getColumn(String name, Class<?> type) {
		return new Column(name, type);
	}
}
