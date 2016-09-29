package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

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
