package org.binx.utils.database.memdb.core.generator;

import org.binx.utils.database.memdb.core.model.ColumnValue;

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
