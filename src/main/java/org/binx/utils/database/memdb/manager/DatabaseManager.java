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
	 * Create a new database<br/>
	 * <i>condition : name not empty and not exists</i>
	 * 
	 * @param name
	 * @return
	 * True if database added successfully<br/>
	 * False if not
	 */
	public static Boolean createNewDatabase(String name) {
		String formatedName = name.toLowerCase().trim();
		if(formatedName.equals("")) return false;
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
		String formatedName = name.toLowerCase().trim();
		if(formatedName.equals("")) return null;
		return DatabaseListManager.getDatabase(formatedName);
	}
}
