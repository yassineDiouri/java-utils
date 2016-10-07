package org.binx.utils.database.memdb.manager;

import java.util.*;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class TableManager {

	/**
	 * Add table into specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if database..schema not exists
	 */
	public static Boolean createNewTable(String databaseName, String schemaName, String tableName) {
		return SchemaManager.addTable(databaseName, schemaName, TableGenerator.getTable(tableName));
	}
	
	/**
	 * Add table into specified database..default(schema)
	 * 
	 * @param databaseName
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if database not exists
	 */
	public static Boolean createNewTable(String databaseName, String tableName) {
		return SchemaManager.addTable(databaseName, TableGenerator.getTable(tableName));
	}

	/**
	 * Add table into specified default(database)..schema
	 * 
	 * @param schemaName
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if there is no default database or schema not exist
	 */
	public static Boolean createNewTableDefaultDB(String schemaName, String tableName) {
		return SchemaManager.addTableDefaultDB(schemaName, TableGenerator.getTable(tableName));
	}

	/**
	 * Add table into specified default(database)..default(schema)
	 * 
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if there is no default database
	 */
	public static Boolean createNewTable(String tableName) {
		return SchemaManager.addTable(TableGenerator.getTable(tableName));
	}

	/**
	 * Get table from database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static Table getTable(String databaseName, String schemaName, String tableName) {
		return SchemaManager.getTable(databaseName, schemaName, tableName);
	}

	/**
	 * Get table from database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * Null if table not exist or database not exist
	 */
	public static Table getTable(String databaseName, String tableName) {
		return SchemaManager.getTable(databaseName, tableName);
	}
	
	/**
	 * Get table from default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table not exist or default(database)..schema not exists
	 */
	public static Table getTableDefaultDB(String schemaName, String tableName) {
		return SchemaManager.getTableDefaultDB(schemaName, tableName);
	}
	
	/**
	 * Get table from default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * Null if table not exist or there is no default(database)
	 */
	public static Table getTable(String tableName) {
		return SchemaManager.getTable(tableName);
	}

	/**
	 * Delete Table from specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if success<br/>
	 * False if not or table not exist<br/>
	 * Null if database..schema not exist
	 */
	public static Boolean delete(String databaseName, String schemaName, String tableName) {
		return SchemaManager.deleteTable(databaseName, schemaName, tableName);
	}
	
	/**
	 * Delete Table from specified database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * True if success<br/>
	 * False if not or table not exist<br/>
	 * Null if database not exist
	 */
	public static Boolean delete(String databaseName, String tableName) {
		return SchemaManager.deleteTable(databaseName, tableName);
	}

	/**
	 * Delete Table from specified default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if success<br/>
	 * False if not or table not exist<br/>
	 * Null if schema not exist in default database
	 */
	public static Boolean deleteDefaultDB(String schemaName, String tableName) {
		return SchemaManager.deleteTableDefaultDB(schemaName, tableName);
	}

	/**
	 * Delete Table from specified default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * True if success<br/>
	 * False if not or table not exist<br/>
	 * Null if there is no dfault database
	 */
	public static Boolean delete(String tableName) {
		return SchemaManager.deleteTable(tableName);
	}
	
	/**
	 * Verify if table exists on specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String databaseName, String schemaName, String tableName) {
		return SchemaManager.existsTable(databaseName, schemaName, tableName);
	}
	
	/**
	 * Verify if table exists on specified database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String databaseName, String tableName) {
		return SchemaManager.existsTable(databaseName, tableName);
	}
	
	/**
	 * Verify if table exists on specified default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsDefaultDB(String schemaName, String tableName) {
		return SchemaManager.existsTableDefaultDB(schemaName, tableName);
	}
	
	/**
	 * Verify if table exists on specified default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String tableName) {
		return SchemaManager.existsTable(tableName);
	}

	/**
	 * List all names of existing columns on specified table from database..schema
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesColumns(String databaseName, String schemaName, String tableName) {
		List<String> names = new ArrayList<>();
		if(exists(databaseName, schemaName, tableName)) {
			for(Column<?> col : getTable(databaseName, schemaName, tableName).getColumns()) {
				names.add(col.getName());
			}
			return names;
		}
		return null;
	}

	/**
	 * List all names of existing columns on specified table from database..default(schema)
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesColumns(String databaseName, String tableName) {
		List<String> names = new ArrayList<>();
		if(exists(databaseName, tableName)) {
			for(Column<?> col : getTable(databaseName, tableName).getColumns()) {
				names.add(col.getName());
			}
			return names;
		}
		return null;
	}

	/**
	 * List all names of existing columns on specified table from default(database)..schema
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesColumnsDefaultDB(String schemaName, String tableName) {
		List<String> names = new ArrayList<>();
		if(existsDefaultDB(schemaName, tableName)) {
			for(Column<?> col : getTableDefaultDB(schemaName, tableName).getColumns()) {
				names.add(col.getName());
			}
			return names;
		}
		return null;
	}

	/**
	 * List all names of existing columns on specified table from default(database)..default(schema)
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesColumns(String tableName) {
		List<String> names = new ArrayList<>();
		if(exists(tableName)) {
			for(Column<?> col : getTable(tableName).getColumns()) {
				names.add(col.getName());
			}
			return names;
		}
		return null;
	}
}
