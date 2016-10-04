package org.binx.utils.database.memdb.manager;

import java.util.*;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class DatabaseListManager {

	private static DatabaseList databaseList = null;
	
	/**
	 * initialize and get databases
	 * 
	 * @return
	 * Existing databaseList<br/>
	 * else return a newer.
	 */
	public static DatabaseList getDatabaseList() {
		if(databaseList == null) 
			databaseList = DatabaseListGenerator.getDatabaseList();
		return databaseList;
	}
	
	/**
	 * Add a new Database<br/>
	 * <i>Condition : database not null, name not empty and did not exists</i>
	 * 
	 * @param db
	 * @return
	 * False if database is null, or name is empty or exists<br/>
	 * else True
	 */
	public static Boolean addDatabase(Database db) {
		if(db == null || db.getName().equals("") || existsDatabase(db.getName()))
			return false;
		getDatabaseList().getDatabases().add(db);
		return true;
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
		if(name != null && !name.equals("")) {
			for(Database db : getDatabaseList().getDatabases()){
				if(db.getName().equals(name))
					return db;
			}
		}
		return null;
	}
	
	/**
	 * Return default database
	 * 
	 * @return
	 * Null if default database not set
	 * else return instance of database
	 */
	public static Database getDefaultDatabase() {
		if(getDatabaseList().getDefaultDatabase() < 0)
			return null;
		else
			return getDatabaseList().getDatabases().
				get(getDatabaseList().getDefaultDatabase());
	}
	
	public static List<Database> getAllDatabases() {
		return getDatabaseList().getDatabases();
	}
	
	/**
	 * Set the given database name to default
	 * 
	 * @param name
	 * @return
	 * True if database exists and set to default<br/>
	 * False else 
	 */
	public static Boolean setToDefaultDatabase(String name) {
		if(name!= null && !name.equals("")) {
			for(int i = 0; i < getAllDatabases().size(); i++) {
				if(getAllDatabases().get(i).getName().equals(name)) {
					getDatabaseList().setDefaultDatabase(i);
					return true;
				}
			}
		}
		return false;
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
		if(name != null && !name.equals("")) {
			for(Database db : getAllDatabases()){
				if(db.getName().equals(name)) {
					getAllDatabases().remove(db);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Test if the database already exists<br/>
	 * <i>Test By Name</i>
	 * 
	 * @param name
	 * @return
	 * True if exists<br/>
	 * else False
	 */
	public static Boolean existsDatabase(String name) {
		if(name != null && getAllNamesDatabases().contains(name))
			return true;
		return false;
	}
	
	/**
	 * List all names of existing databases
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesDatabases() {
		List<String> names = new ArrayList<>();
		for(Database db : getAllDatabases())
			names.add(db.getName());
		return names;
	}
	
	/**
	 * Get number of databases
	 * 
	 * @return
	 */
	public static Integer size() {
		return getAllDatabases().size();
	}
}
