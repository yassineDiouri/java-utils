package org.binx.utils.database.memdb.manager;

import java.util.ArrayList;
import java.util.List;

import org.binx.utils.database.memdb.generator.DatabaseGenerator;
import org.binx.utils.database.memdb.model.Database;
import org.binx.utils.database.memdb.model.Schema;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class DatabaseManager {
	
	/**
	 * Create a new database<br/>
	 * <i>condition : name not empty and not exists</i>
	 * 
	 * @param databaseName
	 * @return
	 * True if database added successfully<br/>
	 * False if not
	 */
	public static Boolean createNewDatabase(String databaseName) {
		if(!exists(databaseName))
			return DatabaseListManager.addDatabase(DatabaseGenerator.getDatabase(databaseName));
		return false;
	}
	
	/**
	 * Return database with specified name
	 * 
	 * @param databaseName
	 * @return
	 * Null if database not exist<br/>
	 * else get instance of database with "name"
	 */
	public static Database getDatabase(String databaseName) {
		return DatabaseListManager.getDatabase(databaseName);
	}
	
	/**
	 * Set the given database name to default
	 * 
	 * @param name
	 * @return
	 * True if database exists and set to default<br/>
	 * False else 
	 */
	public static Boolean setToDefault(String databaseName) {
		return DatabaseListManager.setToDefaultDatabase(databaseName);
	}
	
	/**
	 * Return default database
	 * 
	 * @return
	 * Null if default database not set<br/>
	 * else return instance of database
	 */
	public static Database getDefault() {
		return DatabaseListManager.getDefaultDatabase();
	}
	
	/**
	 * Remove database with specified name 
	 * 
	 * @param name
	 * @return
	 * True if database is removed<br/>
	 * else False
	 */
	public static Boolean deleteDatabase(String databaseName) {
		return DatabaseListManager.deleteDatabase(databaseName);
	}
	
	/**
	 * Test if the database exists or not<br/>
	 * <i>Test By Name</i>
	 * 
	 * @param name
	 * @return
	 * True if exists<br/>
	 * else False
	 */
	public static Boolean exists(String databaseName) {
		return DatabaseListManager.existsDatabase(databaseName);
	}

	/**
	 * Verify if the specified database is empty
	 * 
	 * @param name
	 * @return
	 * True if database don't contains schemas and the default schema don't contains tables<br/>
	 * else False
	 */
	public static Boolean isEmpty(String databaseName) {
		if(exists(databaseName)) {
			if(countSchemas(databaseName) == 1)
				if(getAllSchemas(databaseName).get(0).getTables().size() == 0)
					return true;
			return false;
		}
		return null;
	}
	
	/**
	 * Verify if the default database is empty
	 * 
	 * @param name
	 * @return
	 * True if database don't contains schemas and the default schema don't contains tables<br/>
	 * else False
	 */
	public static Boolean isEmpty() {
		Database defaultDB = getDefault();
		if(defaultDB != null) {
			if(countSchemas() == 1)
				if(getAllSchemas().get(0).getTables().size() == 0)
					return true;
			return false;
		}
		return null;
	}
	
	/**
	 * add given Schema to database with specified name
	 * 
	 * @param databaseName
	 * @param schema
	 * @return
	 * False if database did not exist, schema given is null or its name null<br/>
	 * True if success to be added<br/>
	 * Null if database not exists
	 */
	public static Boolean addSchema(String databaseName, Schema schema) {
		if(exists(databaseName)) {
			if(schema != null && !existsSchema(databaseName, schema.getName())) {
				getDatabase(databaseName).getSchemas().add(schema);
				return true;
			}
			return false;
		}
		return null;
	}

	/**
	 * add given Schema to default database
	 * 
	 * @param schema
	 * @return
	 * False if there is no default database, schema given is null or name of schema is null<br/>
	 * True if success to be added to default database<br/>
	 * Null if there is no default database
	 */
	public static Boolean addSchema(Schema schema) {
		return getDefault() != null ? addSchema(getDefault().getName(), schema) :  null;
	}
	
	/**
	 * Return Schema with specified name from database "name"
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @return
	 * Specified Schema with name if exist<br/>
	 * else return default schema<br/>
	 * Null if database not exists
	 */
	public static Schema getSchema(String databaseName, String schemaName) {
		if(exists(databaseName)) {
			for(Schema sc : getAllSchemas(databaseName)) {
				if(sc.getName().equals(schemaName))
					return sc;
			}
			return getAllSchemas(databaseName).get(0); // default schema
		}
		return null;
	}
	
	/**
	 * Return Schema with specified name from default database
	 * 
	 * @param databaseName
	 * @param name
	 * @return
	 * Specified Schema with name if exist<br/>
	 * else return default schema<br/>
	 * Null if there is no default database
	 */
	public static Schema getSchema(String schemaName) {
		Database db = getDefault();
		if(db != null) {
			for(Schema sc : getAllSchemas()) {
				if(sc.getName().equals(schemaName))
					return sc;
			}
			return db.getSchemas().get(0); // default schema
		}
		return null;
	}
	
	/**
	 * Return Default Schema from specified database
	 * 
	 * @param databaseName
	 * @return
	 * Null if database not exists
	 */
	public static Schema getDefaultSchema(String databaseName) {
		if(exists(databaseName)) {
			return getDatabase(databaseName).getSchemas().get(0);
		}
		return null;
	}
	
	/**
	 * Return Default Schema from default database
	 * 
	 * @return
	 * Null if there is no default database
	 */
	public static Schema getDefaultSchema() {
		Database defaultDB = getDefault();
		if(defaultDB != null) {
			return defaultDB.getSchemas().get(0);
		}
		return null;
	}
	
	/**
	 * Return all schemas of database name
	 * 
	 * @param databaseName
	 * @return
	 * Null if database not exist
	 */
	public static List<Schema> getAllSchemas(String databaseName) {
		Database db = getDatabase(databaseName);
		return db != null ? db.getSchemas() : null;
	}
	
	/**
	 * Return all schemas of default database
	 * 
	 * @param databaseName
	 * @return
	 * Null if database not exist
	 */
	public static List<Schema> getAllSchemas() {
		Database db = getDefault();
		return db != null ? db.getSchemas() : null;
	}
	
	/**
	 * Delete database from specified database
	 * 
	 * @param databaseName
	 * @param name
	 * @return
	 * False if not delete, or not exist schema<br/>
	 * else True<br/>
	 * Null if database not exists, or name is default schema
	 */
	public static Boolean deleteSchema(String databaseName, String schemaName) {
		if(exists(databaseName) && !schemaName.equals(Schema.DEFAULT_SCHEMA.getName())) {
			for(int i = 1; i < countSchemas(databaseName); i++) {
				if(getAllSchemas(databaseName).get(i).getName().equals(schemaName)) {
					getAllSchemas(databaseName).remove(i);
					return true;
				}
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Delete database from default database
	 * 
	 * @param databaseName
	 * @param name
	 * @return
	 * False if not delete, or not exist schema<br/>
	 * else True<br/>
	 * Null if there is no default database, or name is default schema
	 */
	public static Boolean deleteSchema(String schemaName) {
		Database defaultDB = getDefault();
		if(defaultDB != null && !schemaName.equals(Schema.DEFAULT_SCHEMA.getName())) {
			for(int i = 1; i < countSchemas(); i++) {
				if(getAllSchemas().get(i).getName().equals(schemaName)) {
					getAllSchemas().remove(i);
					return true;
				}
			}
			return false;
		}
		return null;
	}

	/**
	 * Verify if schema given exists on the database specified
	 * 
	 * @param databaseName
	 * @param schema
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsSchema(String databaseName, String schemaName) {
		if(exists(databaseName) && getAllNamesSchemas(databaseName).contains(schemaName)) 
			return true;
		return false;
	}
	
	/**
	 * Verify if schema given exists on default database 
	 * 
	 * @param schema
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsSchema(String schemaName) {
		if(getDefault() != null && getAllNamesSchemas().contains(schemaName)) 
			return true;
		return false;
	}
	
	/**
	 * Verify if the given schema is default 
	 * 
	 * @param schema
	 * @return
	 * True if the schema is default<br/>
	 * False if not
	 */
	public static Boolean isDefaultSchema(Schema schema) {
		if(schema != null && schema.getName().equals(Schema.DEFAULT_SCHEMA.getName()))
			return true;
		return false;
	}
	
	/**
	 * List all names of existing schemas on specified database
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesSchemas(String databaseName) {
		List<String> names = new ArrayList<>();
		if(exists(databaseName)) {
			for(Schema sc : getDatabase(databaseName).getSchemas()) {
				names.add(sc.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * List all names of existing schemas on default database
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesSchemas() {
		return getDefault() != null ? getAllNamesSchemas(getDefault().getName()) : null;
	}
	
	/**
	 * Return count of schemas for the specified database
	 * 
	 * @param databaseName
	 * @return
	 * -1 : if database not exists
	 */
	public static Integer countSchemas(String databaseName) {
		return exists(databaseName) ? getAllSchemas(databaseName).size() : -1;
	}

	/**
	 * Return count of schemas for default database
	 * 
	 * @param databaseName
	 * @return
	 * -1 : if there is no default database
	 */
	public static Integer countSchemas() {
		return getDefault() != null ? getAllSchemas().size() : -1;
	}
}
