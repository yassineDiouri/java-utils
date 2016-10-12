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
	 * Return List of Tables on specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @return
	 * Null if database..schema not exist
	 */
	public static List<Table> getAllTables(String databaseName, String schemaName) {
		return SchemaManager.getAllTables(databaseName, schemaName);
	}
	/**
	 * Return List of Tables on specified database..default(schema)
	 * 
	 * @param databaseName
	 * @return
	 * Null if database not exist
	 */
	public static List<Table> getAllTables(String databaseName) {
		return SchemaManager.getAllTables(databaseName);
	}

	/**
	 * Return List of Tables on specified default(database)..schema
	 * 
	 * @param schemaName
	 * @return
	 * Null if no default(database)..schema
	 */
	public static List<Table> getAllTablesDefaultDB(String schemaName) {
		return SchemaManager.getAllTablesDefaultDB(schemaName);
	}

	/**
	 * Return List of Tables on specified default(database)..default(schema)
	 * 
	 * @return
	 * Null if no default(database)
	 */
	public static List<Table> getAllTables() {
		return SchemaManager.getAllTables();
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
	 * add column into specified table on database..schema 
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param column
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * null if table, schema or database not exists
	 */
	public static Boolean addColumn(String databaseName, String schemaName, String tableName, Column<?> column) {
		Table tab = getTable(databaseName, schemaName, tableName);
		if(tab != null) {
			return tab.getColumns().add(column);
		}
		return null;
	}

	/**
	 * add column into specified table on database..default(schema) 
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param column
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * null if table or database not exists
	 */
	public static Boolean addColumn(String databaseName, String tableName, Column<?> column) {
		Table tab = getTable(databaseName, tableName);
		if(tab != null) {
			return tab.getColumns().add(column);
		}
		return null;
	}

	/**
	 * add column into specified table on default(database)..schema 
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param column
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * null if table, schema or default database not exists
	 */
	public static Boolean addColumnDefaultDB(String schemaName, String tableName, Column<?> column) {
		Table tab = getTableDefaultDB(schemaName, tableName);
		if(tab != null) {
			return tab.getColumns().add(column);
		}
		return null;
	}

	/**
	 * add column into specified table on default(database)..default(schema) 
	 * 
	 * @param tableName
	 * @param column
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * null if table or default database not exists
	 */
	public static Boolean addColumn(String tableName, Column<?> column) {
		Table tab = getTable(tableName);
		if(tab != null) {
			return tab.getColumns().add(column);
		}
		return null;
	}
	
	/**
	 * Get Column from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static Column<?> getColumn(String databaseName, String schemaName, String tableName, String columnName) {
		if(existsColumn(databaseName, schemaName, tableName, columnName)) {
			for(Column<?> col : getAllColumns(databaseName, schemaName, tableName))
				if(col.getName().equals(columnName))
					return col;
		}
		return null;
	}

	/**
	 * Get Column from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table or database not exist
	 */
	public static Column<?> getColumn(String databaseName, String tableName, String columnName) {
		if(existsColumn(databaseName, tableName, columnName)) {
			for(Column<?> col : getAllColumns(databaseName, tableName))
				if(col.getName().equals(columnName))
					return col;
		}
		return null;
	}
	
	/**
	 * Get Column from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table or schema not exist, or no default database
	 */
	public static Column<?> getColumnDefaultDB(String schemaName, String tableName, String columnName) {
		if(existsColumnDefaultDB(schemaName, tableName, columnName)) {
			for(Column<?> col : getAllColumnsDefaultDB(schemaName, tableName))
				if(col.getName().equals(columnName))
					return col;
		}
		return null;
	}

	/**
	 * Get Column from specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table not exist, or no default database
	 */
	public static Column<?> getColumn(String tableName, String columnName) {
		if(existsColumn(tableName, columnName)) {
			for(Column<?> col : getAllColumns(tableName))
				if(col.getName().equals(columnName))
					return col;
		}
		return null;
	}
	
	/**
	 * Return List of Columns from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table or database..schema not exist
	 */
	public static List<Column<?>> getAllColumns(String databaseName, String schemaName, String tableName) {
		if(exists(databaseName, schemaName, tableName)) {
			return getTable(databaseName, schemaName, tableName).getColumns();
		}
		return null;
	}

	/**
	 * Return List of Columns from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * Null if table or database not exist
	 */
	public static List<Column<?>> getAllColumns(String databaseName, String tableName) {
		if(exists(databaseName, tableName)) {
			return getTable(databaseName, tableName).getColumns();
		}
		return null;
	}
	
	/**
	 * Return List of Columns from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table or schema not exist or no default database
	 */
	public static List<Column<?>> getAllColumnsDefaultDB(String schemaName, String tableName) {
		if(existsDefaultDB(schemaName, tableName)) {
			return getTableDefaultDB(schemaName, tableName).getColumns();
		}
		return null;
	}

	
	/**
	 * Return List of Columns from specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table not exist or no default database
	 */
	public static List<Column<?>> getAllColumns(String tableName) {
		if(exists(tableName)) {
			return getTable(tableName).getColumns();
		}
		return null;
	}
	
	/**
	 * Remove Column from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if removed<br/>
	 * False if not<br/>
	 * Null if table, schema or database not exists
	 */
	public static Boolean deleteColumn(String databaseName, String schemaName, String tableName, String columnName) {
		if(exists(databaseName, schemaName, tableName)) {
			for(Column<?> col : getAllColumns(databaseName, schemaName, tableName)) {
				if(col.getName().equals(columnName)) {
					return getAllColumns(databaseName, schemaName, tableName).remove(col);
				}
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Remove Column from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if removed<br/>
	 * False if not<br/>
	 * Null if table or database not exists
	 */
	public static Boolean deleteColumn(String databaseName, String tableName, String columnName) {
		if(exists(databaseName, tableName)) {
			for(Column<?> col : getAllColumns(databaseName, tableName)) {
				if(col.getName().equals(columnName)) {
					return getAllColumns(databaseName, tableName).remove(col);
				}
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Remove Column from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if removed<br/>
	 * False if not<br/>
	 * Null if table or schema not exists, or there is no default databse
	 */
	public static Boolean deleteColumnDefaultDB(String schemaName, String tableName, String columnName) {
		if(existsDefaultDB(schemaName, tableName)) {
			for(Column<?> col : getAllColumnsDefaultDB(schemaName, tableName)) {
				if(col.getName().equals(columnName)) {
					return getAllColumnsDefaultDB(schemaName, tableName).remove(col);
				}
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Remove Column from specified table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if removed<br/>
	 * False if not<br/>
	 * Null if table not exists, or there is no default databse
	 */
	public static Boolean deleteColumn(String tableName, String columnName) {
		if(exists(tableName)) {
			for(Column<?> col : getAllColumns(tableName)) {
				if(col.getName().equals(columnName)) {
					return getAllColumns(tableName).remove(col);
				}
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Verify if column exists on specified table in database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsColumn(String databaseName, String schemaName, String tableName, String columnName) {
		List<String> names = getAllNamesColumns(databaseName, schemaName, tableName);
		if(names != null) {
			if(names.contains(columnName)) return true;
		}
		return false;
	}

	/**
	 * Verify if column exists on specified table in database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsColumn(String databaseName, String tableName, String columnName) {
		List<String> names = getAllNamesColumns(databaseName, tableName);
		if(names != null) {
			if(names.contains(columnName)) return true;
		}
		return false;
	}

	/**
	 * Verify if column exists on specified table in default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsColumnDefaultDB(String schemaName, String tableName, String columnName) {
		List<String> names = getAllNamesColumnsDefaultDB(schemaName, tableName);
		if(names != null) {
			if(names.contains(columnName)) return true;
		}
		return false;
	}

	/**
	 * Verify if column exists on specified table in default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsColumn(String tableName, String columnName) {
		List<String> names = getAllNamesColumns(tableName);
		if(names != null) {
			if(names.contains(columnName)) return true;
		}
		return false;
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
