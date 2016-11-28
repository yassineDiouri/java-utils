package org.binx.utils.database.memdb.core.generator;

import org.binx.utils.database.memdb.core.model.Database;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class DatabaseGenerator {

	public static Database getDatabase(String name) {
		return new Database(name);
	}
}
