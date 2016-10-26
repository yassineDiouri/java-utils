package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ColumnValueGenerator {

	public static ColumnValue getColumnValue() {
		return new ColumnValue();
	}
	
	public static ColumnValue getColumnValue(Object value) {
		return new ColumnValue(value);
	}
}
