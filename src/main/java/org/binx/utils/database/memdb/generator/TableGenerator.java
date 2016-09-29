package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

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
