package org.binx.utils.database.memdb.core.generator;

import org.binx.utils.database.memdb.core.model.Table;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class TableGenerator {

	public static Table getTable(String name) {
		return new Table(name);
	}
}
