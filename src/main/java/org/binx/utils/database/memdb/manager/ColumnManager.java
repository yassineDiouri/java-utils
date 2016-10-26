package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ColumnManager {

	/**
	 * Create a new column on specified table in database..schema with given name & type
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param columnType
	 * @return
	 * True if added,<br/>
	 * False if column exists or not added,<br/>
	 * Null if table or schema or database not exist
	 */
	public static Boolean createNewColumn(String databaseName, String schemaName, String tableName, String columnName, Class<?> columnType) {
		return TableManager.addColumn(databaseName, schemaName, tableName, ColumnGenerator.getColumn(columnName, columnType));
	}

	/**
	 * Create a new column on specified table in database..Default(schema) with given name & type
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @param columnType
	 * @return
	 * True if added,<br/>
	 * False if column exists or not added,<br/>
	 * Null if table or database not exist
	 */
	public static Boolean createNewColumn(String databaseName, String tableName, String columnName, Class<?> columnType) {
		return TableManager.addColumn(databaseName, tableName, ColumnGenerator.getColumn(columnName, columnType));
	}
	
	/**
	 * Create a new column on specified table in Default(database)..schema with given name & type
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param columnType
	 * @return
	 * True if added,<br/>
	 * False if column exists or not added,<br/>
	 * Null if table or schema or default database not exist
	 */
	public static Boolean createNewColumnDefaultDB(String schemaName, String tableName, String columnName, Class<?> columnType) {
		return TableManager.addColumn(schemaName, tableName, ColumnGenerator.getColumn(columnName, columnType));
	}
	
	/**
	 * Create a new column on specified table in default(database)..default(schema) with given name & type
	 * 
	 * @param tableName
	 * @param columnName
	 * @param columnType
	 * @return
	 * True if added,<br/>
	 * False if column exists or not added,<br/>
	 * Null if table or schema or default database not exist
	 */
	public static Boolean createNewColumn(String tableName, String columnName, Class<?> columnType) {
		return TableManager.addColumn(tableName, ColumnGenerator.getColumn(columnName, columnType));
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
	public static Column getColumn(String databaseName, String schemaName, String tableName, String columnName) {
		return TableManager.getColumn(databaseName, schemaName, tableName, columnName);
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
	public static Column getColumn(String databaseName, String tableName, String columnName) {
		return TableManager.getColumn(databaseName, tableName, columnName);
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
	public static Column getColumnDefaultDB(String schemaName, String tableName, String columnName) {
		return TableManager.getColumnDefaultDB(schemaName, tableName, columnName);
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
	public static Column getColumn(String tableName, String columnName) {
		return TableManager.getColumn(tableName, columnName);
	}
	
	/**
	 * Get type of specified columnName from table in database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Type of specified column<br/>
	 * Null if not exists column, table, schema or database
	 */
	public static Class<?> getType(String databaseName, String schemaName, String tableName, String columnName) {
		Column column = getColumn(databaseName, schemaName, tableName, columnName);
		if(column != null)
			return column.getType();
		return null;
	}
	
	/**
	 * Get type of specified columnName from table in database..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Object containing Column Value<br/>
	 * Null if not exists column, table or database
	 */
	public static Class<?> getType(String databaseName, String tableName, String columnName) {
		Column column = getColumn(databaseName, tableName, columnName);
		if(column != null)
			return column.getType();
		return null;
	}
	
	/**
	 * Get type of specified columnName from table in default(database)..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Object containing Column Value<br/>
	 * Null if not exists column, table, schema or no default database
	 */
	public static Class<?> getTypeDefaultDB(String schemaName, String tableName, String columnName) {
		Column column = getColumnDefaultDB(schemaName, tableName, columnName);
		if(column != null)
			return column.getType();
		return null;
	}	

	/**
	 * Get value of specified columnName from table in default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Object containing Column Value<br/>
	 * Null if value is null, or not exists column, table or no default database
	 */
	public static Class<?> getType(String tableName, String columnName) {
		Column column = getColumn(tableName, columnName);
		if(column != null)
			return column.getType();
		return null;
	}
	
	/**
	 * Update column name to specified newer name
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param oldName
	 * @param newName
	 * @return
	 * True if updated<br/>
	 * Null if column, table, schema or database not exist
	 */
	public static Boolean updateColumnName(String databaseName, String schemaName, String tableName, String oldName, String newName) {
		Column column = getColumn(databaseName, schemaName, tableName, oldName);
		if(column != null) {
			column.setName(newName);
			return true;
		}
		return null;
	}
	
	/**
	 * Update column name to specified newer name
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param oldName
	 * @param newName
	 * @return
	 * True if updated<br/>
	 * Null if column, table or database not exist
	 */
	public static Boolean updateColumnName(String databaseName, String tableName, String oldName, String newName) {
		Column column = getColumn(databaseName, tableName, oldName);
		if(column != null) {
			column.setName(newName);
			return true;
		}
		return null;
	}
	
	/**
	 * Update column name to specified newer name
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param oldName
	 * @param newName
	 * @return
	 * True if updated<br/>
	 * Null if column, table, schema or default database not exist
	 */
	public static Boolean updateColumnNameDefaultDB(String schemaName, String tableName, String oldName, String newName) {
		Column column = getColumnDefaultDB(schemaName, tableName, oldName);
		if(column != null) {
			column.setName(newName);
			return true;
		}
		return null;
	}
	
	/**
	 * Update column name to specified newer name
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param oldName
	 * @param newName
	 * @return
	 * True if updated<br/>
	 * Null if column, table, schema or default database not exist
	 */
	public static Boolean updateColumnName(String tableName, String oldName, String newName) {
		Column column = getColumn(tableName, oldName);
		if(column != null) {
			column.setName(newName);
			return true;
		}
		return null;
	}

	/**
	 * Update column type to specified newer type
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param newType
	 * @return
	 * True if updated<br/>
	 * Null if column, table, schema or database not exist
	 */
	public static Boolean updateColumnType(String databaseName, String schemaName, String tableName, String columnName, Class<?> newType) {
		Column column = getColumn(databaseName, schemaName, tableName, columnName);
		if(column != null) {
			column.setType(newType);
			return true;
		}
		return null;
	}

	/**
	 * Update column type to specified newer type
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param newType
	 * @return
	 * True if updated<br/>
	 * Null if column, table or database not exist
	 */
	public static Boolean updateColumnType(String databaseName, String tableName, String columnName, Class<?> newType) {
		Column column = getColumn(databaseName, tableName, columnName);
		if(column != null) {
			column.setType(newType);
			return true;
		}
		return null;
	}

	/**
	 * Update column type to specified newer type
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param newType
	 * @return
	 * True if updated<br/>
	 * Null if column, table, schema or default database not exist
	 */
	public static Boolean updateColumnTypeDefaultDB(String schemaName, String tableName, String columnName, Class<?> newType) {
		Column column = getColumnDefaultDB(schemaName, tableName, columnName);
		if(column != null) {
			column.setType(newType);
			return true;
		}
		return null;
	}

	/**
	 * Update column type to specified newer type
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param newType
	 * @return
	 * True if updated<br/>
	 * Null if column, table, schema or default database not exist
	 */
	public static Boolean updateColumnType(String tableName, String columnName, Class<?> newType) {
		Column column = getColumn(tableName, columnName);
		if(column != null) {
			column.setType(newType);
			return true;
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
	public static Boolean delete(String databaseName, String schemaName, String tableName, String columnName) {
		return TableManager.deleteColumn(databaseName, schemaName, tableName, columnName);
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
	public static Boolean delete(String databaseName, String tableName, String columnName) {
		return TableManager.deleteColumn(databaseName, tableName, columnName);
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
	public static Boolean deleteDefaultDB(String schemaName, String tableName, String columnName) {
		return TableManager.deleteColumnDefaultDB(schemaName, tableName, columnName);
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
	public static Boolean delete(String tableName, String columnName) {
		return TableManager.deleteColumn(tableName, columnName);
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
	public static Boolean exists(String databaseName, String schemaName, String tableName, String columnName) {
		return TableManager.existsColumn(databaseName, schemaName, tableName, columnName);
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
	public static Boolean exists(String databaseName, String tableName, String columnName) {
		return TableManager.existsColumn(databaseName, tableName, columnName);
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
	public static Boolean existsDefaultDB(String schemaName, String tableName, String columnName) {
		return TableManager.existsColumnDefaultDB(schemaName, tableName, columnName);
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
	public static Boolean exists(String tableName, String columnName) {
		return TableManager.existsColumn(tableName, columnName);
	}
}
