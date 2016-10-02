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
	 * Test if the database exists or not<br/>
	 * <i>Test By Name</i>
	 * 
	 * @param name
	 * @return
	 * True if exists<br/>
	 * else False
	 */
	public static Boolean exists(String name) {
		return DatabaseListManager.existsDatabase(name);
	}
	
	/**
	 * Create a new database<br/>
	 * <i>condition : name not empty and not exists</i>
	 * 
	 * @param name
	 * @return
	 * True if database added successfully<br/>
	 * False if not
	 */
	public static Boolean createNewDatabase(String name) {
		return DatabaseListManager.addDatabase(DatabaseGenerator.getDatabase(name));
	}
	
	/**
	 * Return database with specified name
	 * 
	 * @param name
	 * @return
	 * Null if database not exist<br/>
	 * else get instance of database with "name"
	 */
	public static Database getDatabase(String name) {
		return DatabaseListManager.getDatabase(name);
	}
	
	/**
	 * Set the given database name to default
	 * 
	 * @param name
	 * @return
	 * True if database exists and set to default<br/>
	 * False else 
	 */
	public static Boolean setToDefault(String name) {
		return DatabaseListManager.setToDefaultDatabase(name);
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
	 * else False<br/>
	 */
	public static Boolean deleteDatabase(String name) {
		return DatabaseListManager.removeDatabase(name);
	}
	
	/**
	 * add given Schema to database with specified name
	 * 
	 * @param databaseName
	 * @param schema
	 * @return
	 * False if database did not exist, schema given is null or its name null<br/>
	 * True if success to be added
	 */
	public static Boolean addSchema(String databaseName, Schema schema) {
		Database db = getDatabase(databaseName);
		if(db == null || schema == null 
				|| schema.getName() == null || isDefaultSchema(schema)) 
			return false;
		db.getSchemas().add(schema);
		return true;
	}

	/**
	 * add given Schema to default database
	 * 
	 * @param schema
	 * @return
	 * False if there is no default database, schema given is null or name of schema is null<br/>
	 * True if success to be added to default database
	 */
	public static Boolean addSchema(Schema schema) {
		return getDefault() != null ? addSchema(getDefault().getName(), schema) :  null;
	}
	
	/**
	 * Return Schema with specified name from database "name"
	 * 
	 * @param databaseName
	 * @param name
	 * @return
	 * Specified Schema with name if exist<br/>
	 * else return default schema<br/>
	 * Null if database not exists
	 */
	public static Schema getSchema(String databaseName, String name) {
		if(exists(databaseName)) {
			for(Schema sc : getAllSchemas(databaseName)) {
				if(sc.getName().equals(name))
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
	public static Schema getSchema(String name) {
		Database db = getDefault();
		if(db != null) {
			for(Schema sc : getAllSchemas()) {
				if(sc.getName().equals(name))
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
	 * Null if database not exists
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
	 * False if not delete, or not exist schema
	 * else True
	 * Null if database not exists, or name is default schema
	 */
	public static Boolean deleteSchema(String databaseName, String name) {
		if(exists(databaseName) && !name.equals(Schema.DEFAULT_SCHEMA.getName())) {
			for(int i = 1; i < countSchemas(databaseName); i++) {
				if(getAllSchemas(databaseName).get(i).getName().equals(name)) {
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
	 * False if not delete, or not exist schema
	 * else True
	 * Null if there is no default database, or name is default schema
	 */
	public static Boolean deleteSchema(String name) {
		Database defaultDB = getDefault();
		if(defaultDB != null && !name.equals(Schema.DEFAULT_SCHEMA.getName())) {
			for(int i = 1; i < countSchemas(); i++) {
				if(getAllSchemas().get(i).getName().equals(name)) {
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
	public static Boolean existsSchema(String databaseName, Schema schema) {
		if(exists(databaseName) && schema != null && 
				getAllNamesSchemas(databaseName).contains(schema.getName())) 
			return true;
		return false;
	}
	
	/**
	 * Verify if schema given exists on the database specified
	 * 
	 * @param schema
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsSchema(Schema schema) {
		if(getDefault() != null && schema != null && 
				getAllNamesSchemas().contains(schema.getName())) 
			return true;
		return false;
	}
	
	/**
	 * Verify if the given schema is default 
	 * 
	 * @param schema
	 * @return
	 * True if the schema is default
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
	 * Null if database not exists
	 */
	public static Integer countSchemas(String databaseName) {
		if(exists(databaseName)) {
			return getDatabase(databaseName).getSchemas().size();
		}
		return null;
	}

	/**
	 * Return count of schemas for default database
	 * 
	 * @param databaseName
	 * @return
	 * Null if there is no default database
	 */
	public static Integer countSchemas() {
		Database defaultDB = getDefault();
		if(defaultDB != null) {
			return getDefault().getSchemas().size();
		}
		return null;
	}
}
