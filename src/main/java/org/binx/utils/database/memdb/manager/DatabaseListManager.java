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
	 * initialize or get databases
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
	 * Test if the database already exists<br/>
	 * <i>Test By Name</i>
	 * 
	 * @param name
	 * @return
	 * True if exists<br/>
	 * else False
	 */
	public static Boolean existsDatabase(String name) {
		if(name != null && getNamesDatabases().contains(formatName(name)))
			return true;
		return false;
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
		if(databaseList == null || db == null || db.getName().equals("") || existsDatabase(db.getName()))
			return false;
		databaseList.getDatabases().add(db);
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
		if(databaseList != null && name != null && !name.equals("")) {
			for(Database db : databaseList.getDatabases()){
				if(db.getName().equals(name))
					return db;
			}
		}
		return null;
	}
	
	/**
	 * List all names of existing databases
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getNamesDatabases() {
		List<String> names = new ArrayList<>();
		if(databaseList != null)
			for(Database db : databaseList.getDatabases())
				names.add(db.getName());
		return names;
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
		if(databaseList != null || !name.equals("")) {
			for(int i = 0; i < databaseList.getDatabases().size(); i++) {
				if(databaseList.getDatabases().get(i).getName().equals(name)) {
					databaseList.setDefaultDatabase(i);
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
	 * Null if name given is null or empty
	 */
	public static Boolean removeDatabase(String name) {
		if(databaseList != null && name != null && !name.equals("")) {
			for(Database db : databaseList.getDatabases()){
				if(db.getName().equals(name)) {
					databaseList.getDatabases().remove(db);
					return true;
				}
			}
			return false;
		}
		return null;
	}
	
	/*format name to lower case and delete spaces*/
	private static String formatName(String name) {
		return name == null ? name : name.toLowerCase().trim();
	}
}
