package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

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
