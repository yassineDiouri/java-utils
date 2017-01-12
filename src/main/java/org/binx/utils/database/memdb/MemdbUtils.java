package org.binx.utils.database.memdb;

import org.binx.utils.database.memdb.core.manager.DatabaseManager;
import org.binx.utils.database.memdb.model.Column;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class MemdbUtils {
	
	public static Boolean createDatabase(String databaseName) {
		DatabaseManager.createNewDatabase(databaseName);
		DatabaseManager.setToDefault(databaseName);
		return true;
	}
	
	public static Boolean changeDatabase(String databaseName) {
		if(DatabaseManager.exists(databaseName)) {
			DatabaseManager.setToDefault(databaseName);
			return true;
		}
		return false;
	}
	
	public static Boolean createTable(String tableName, Column... columns) {
		TableManager.createNewTable(tableName);
		for(Column column : columns) {
			if(!TableManager.addColumn(tableName, column)) {
				return null;
			}
		}
		return true;
	}
}