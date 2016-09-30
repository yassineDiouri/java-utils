package org.binx.utils.database.memdb.manager;

import java.util.*;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

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
	 * Null if default database not set
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
	 * Return all schemas of database name
	 * 
	 * @param databaseName
	 * @return
	 * Null if database not exist
	 */
	public List<Schema> getAllSchemas(String databaseName) {
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
	public List<Schema> getAllSchemas() {
		Database db = getDefault();
		return db != null ? db.getSchemas() : null;
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
	 * True if the scheam is default
	 * False if not
	 */
	public static Boolean isDefaultSchema(Schema schema) {
		if(schema != null && schema.getName().equals("public")) return true;
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
}
