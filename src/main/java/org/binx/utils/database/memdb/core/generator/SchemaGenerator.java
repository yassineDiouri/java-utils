package org.binx.utils.database.memdb.core.generator;

import org.binx.utils.database.memdb.core.model.Schema;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class SchemaGenerator {

	public static Schema getDefaultSchema() {
		return new Schema(Schema.DEFAULT_NAME);
	}
	
	public static Schema getSchema(String name) {
		return new Schema(name);
	}
}
