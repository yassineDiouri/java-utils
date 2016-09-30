package org.binx.utils.database.memdb.manager;

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
		String formatedName = formatName(name);
		return DatabaseListManager.existsDatabase(formatedName);
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
		String formatedName = formatName(name);
		return DatabaseListManager.addDatabase(DatabaseGenerator.getDatabase(formatedName));
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
		String formatedName = formatName(name);
		return DatabaseListManager.getDatabase(formatedName);
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
		String formatedName = formatName(name);
		return DatabaseListManager.setToDefaultDatabase(formatedName);
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
		String formatedName = formatName(name);
		return DatabaseListManager.removeDatabase(formatedName);
	}
	
	/*format name to lower case and delete spaces*/
	private static String formatName(String name) {
		return name == null ? name : name.toLowerCase().trim();
	}
}
