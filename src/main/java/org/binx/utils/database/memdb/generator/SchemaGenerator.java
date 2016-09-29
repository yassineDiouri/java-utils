package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class SchemaGenerator {

	public static Schema getDefaultSchema() {
		return new Schema();
	}
	
	public static Schema getSchema(String name) {
		return new Schema(name);
	}
}
