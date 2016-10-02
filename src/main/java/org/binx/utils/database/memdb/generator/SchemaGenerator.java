package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.Schema;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class SchemaGenerator {

	public static Schema getDefaultSchema() {
		return Schema.DEFAULT_SCHEMA;
	}
	
	public static Schema getSchema(String name) {
		return new Schema(name);
	}
}
