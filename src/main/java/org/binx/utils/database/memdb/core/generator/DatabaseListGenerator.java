package org.binx.utils.database.memdb.core.generator;

import org.binx.utils.database.memdb.core.model.DatabaseList;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class DatabaseListGenerator {

	public static DatabaseList getDatabaseList() {
		return new DatabaseList();
	}
}
