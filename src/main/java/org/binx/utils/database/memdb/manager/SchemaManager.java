package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.SchemaGenerator;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class SchemaManager {

	/**
	 * Create new Schema into specified database
	 * 
	 * @param databaseName
	 * @param name
	 * @return
	 * False if database did not exist, schema given is null or its name null<br/>
	 * True if success to be added<br/>
	 * Null if database not exists
	 */
	public static Boolean createNewSchema(String databaseName, String name) {
		return DatabaseManager.addSchema(databaseName, SchemaGenerator.getSchema(name));
	}
	
	/**
	 * Verify if database contains specified schema
	 * 
	 * @param databaseName
	 * @param name
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String databaseName, String name) {
		return DatabaseManager.existsSchema(databaseName, name);
	}
}
