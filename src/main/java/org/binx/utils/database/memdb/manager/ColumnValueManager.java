package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ColumnValueManager {

	/**
	 * Insert ColumnValue witn null value into specified Line from table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table, schema or database not exists
	 */
	public static Boolean createNewColumnValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		ColumnValue cv = ColumnValueGenerator.getColumnValue();
		cv.setOrder(columnOrder);
		cv.setIndex(lineIndex);
		return LineManager.addColumnValue(databaseName, schemaName, tableName, lineIndex, cv);
	}
	
	/**
	 * Insert ColumnValue with null value into specified Line from table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table or database not exists
	 */
	public static Boolean createNewColumnValue(String databaseName, String tableName, Long lineIndex, Integer columnOrder) {
		ColumnValue cv = ColumnValueGenerator.getColumnValue();
		cv.setOrder(columnOrder);
		cv.setIndex(lineIndex);
		return LineManager.addColumnValue(databaseName, tableName, lineIndex, cv);
	}
	
	/**
	 * Insert ColumnValue with null value into specified Line from table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table, schema or default database not exists
	 */
	public static Boolean createNewColumnValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		ColumnValue cv = ColumnValueGenerator.getColumnValue();
		cv.setOrder(columnOrder);
		cv.setIndex(lineIndex);
		return LineManager.addColumnValueDefaultDB(schemaName, tableName, lineIndex, cv);
	}
	
	/**
	 * Insert ColumnValue with null value into specified Line from table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table or default database not exists
	 */
	public static Boolean createNewColumnValue(String tableName, Long lineIndex, Integer columnOrder) {
		ColumnValue cv = ColumnValueGenerator.getColumnValue();
		cv.setOrder(columnOrder);
		cv.setIndex(lineIndex);
		return LineManager.addColumnValue(tableName, lineIndex, cv);
	}

	/**
	 * Insert ColumnValue witn specified value into specified Line from table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table, schema or database not exists
	 */
	public static Boolean createNewColumnValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		ColumnValue cv = ColumnValueGenerator.getColumnValue(value);
		cv.setOrder(columnOrder);
		cv.setIndex(lineIndex);
		return LineManager.addColumnValue(databaseName, schemaName, tableName, lineIndex, cv);
	}
	
	/**
	 * Insert ColumnValue with specified value into specified Line from table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table or database not exists
	 */
	public static Boolean createNewColumnValue(String databaseName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		ColumnValue cv = ColumnValueGenerator.getColumnValue(value);
		cv.setOrder(columnOrder);
		cv.setIndex(lineIndex);
		return LineManager.addColumnValue(databaseName, tableName, lineIndex, cv);
	}
	
	/**
	 * Insert ColumnValue with specified value into specified Line from table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table, schema or default database not exists
	 */
	public static Boolean createNewColumnValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		ColumnValue cv = ColumnValueGenerator.getColumnValue(value);
		cv.setOrder(columnOrder);
		cv.setIndex(lineIndex);
		return LineManager.addColumnValueDefaultDB(schemaName, tableName, lineIndex, cv);
	}
	
	/**
	 * Insert ColumnValue with specified value into specified Line from table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table or default database not exists
	 */
	public static Boolean createNewColumnValue(String tableName, Long lineIndex, Integer columnOrder, Object value) {
		ColumnValue cv = ColumnValueGenerator.getColumnValue(value);
		cv.setOrder(columnOrder);
		cv.setIndex(lineIndex);
		return LineManager.addColumnValue(tableName, lineIndex, cv);
	}
	
	/**
	 * Get ColumnValue from specified Line from table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @return
	 * Null if column order, line, table, schema or database not exists
	 */
	public static ColumnValue getColumnValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		return LineManager.getColumnValue(databaseName, schemaName, tableName, lineIndex, columnOrder);
	}
	
	/**
	 * Get ColumnValue from specified Line from table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @return
	 * Null if column order, line, table or database not exists
	 */
	public static ColumnValue getColumnValue(String databaseName, String tableName, Long lineIndex, Integer columnOrder) {
		return LineManager.getColumnValue(databaseName, tableName, lineIndex, columnOrder);
	}
	
	/**
	 * Get ColumnValue from specified Line from table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @return
	 * Null if column order, line, table, schema or default database not exists
	 */
	public static ColumnValue getColumnValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		return LineManager.getColumnValueDefaultDB(schemaName, tableName, lineIndex, columnOrder);
	}
	
	/**
	 * Get ColumnValue from specified Line from table on default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @return
	 * Null if column order, line, table or default database not exists
	 */
	public static ColumnValue getColumnValue(String tableName, Long lineIndex, Integer columnOrder) {
		return LineManager.getColumnValue(tableName, lineIndex, columnOrder);
	}
	
	/**
	 * Get value of specified ColumnValue from Line from table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @return
	 * Null if column order, line, table, schema or database not exists
	 */
	public static Object getValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		ColumnValue cv = getColumnValue(databaseName, schemaName, tableName, lineIndex, columnOrder);
		if(cv != null) {
			return cv.getValue();
		}
		return null;
	}
	
	/**
	 * Get value of specified ColumnValue from Line from table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @return
	 * Null if column order, line, table or database not exists
	 */
	public static Object getValue(String databaseName, String tableName, Long lineIndex, Integer columnOrder) {
		ColumnValue cv = getColumnValue(databaseName, tableName, lineIndex, columnOrder);
		if(cv != null) {
			return cv.getValue();
		}
		return null;
	}
	
	/**
	 * Get value of specified ColumnValue from Line from table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @return
	 * Null if column order, line, table, schema or default database not exists
	 */
	public static Object getValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		ColumnValue cv = getColumnValueDefaultDB(schemaName, tableName, lineIndex, columnOrder);
		if(cv != null) {
			return cv.getValue();
		}
		return null;
	}
	
	/**
	 * Get value of specified ColumnValue from Line from table on default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @return
	 * Null if column order, line, table or default database not exists
	 */
	public static Object getValue(String tableName, Long lineIndex, Integer columnOrder) {
		ColumnValue cv = getColumnValue(tableName, lineIndex, columnOrder);
		if(cv != null) {
			return cv.getValue();
		}
		return null;
	}
	
	/**
	 * Update value of specified columnValue of line from table from database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if updated<br/>
	 * Null if value can't be changed, or columnValue, line, table, schema or database not exists
	 */
	public static Boolean updateValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		return LineManager.updateColumnValue(databaseName, schemaName, tableName, lineIndex, columnOrder, value);
	}
	
	/**
	 * Update value of specified columnValue of line from table from database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if updated<br/>
	 * Null if value can't be changed, or columnValue, line, table or database not exists
	 */
	public static Boolean updateValue(String databaseName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		return LineManager.updateColumnValue(databaseName, tableName, lineIndex, columnOrder, value);
	}
	
	/**
	 * Update value of specified columnValue of line from table from default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if updated<br/>
	 * Null if value can't be changed, or columnValue, line, table, schema or default database not exists
	 */
	public static Boolean updateValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		return LineManager.updateColumnValueDefaultDB(schemaName, tableName, lineIndex, columnOrder, value);
	}
	
	/**
	 * Update value of specified columnValue of line from table from default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if updated<br/>
	 * Null if value can't be changed, or columnValue, line, table or default database not exists
	 */
	public static Boolean updateValue(String tableName, Long lineIndex, Integer columnOrder, Object value) {
		return LineManager.updateColumnValue(tableName, lineIndex, columnOrder, value);
	}
	
	/**
	 * Verify if there is an instance of ColumnValue with specified order on line from table from database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * True if exists<br/>
	 * False if not
	 */
	public static Boolean exists(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		return LineManager.existsColumnValue(databaseName, schemaName, tableName, lineIndex, columnOrder);
	}
	
	/**
	 * Verify if there is an instance of ColumnValue with specified order on line from table from database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * True if exists<br/>
	 * False if not
	 */
	public static Boolean exists(String databaseName, String tableName, Long lineIndex, Integer columnOrder) {
		return LineManager.existsColumnValue(databaseName, tableName, lineIndex, columnOrder);
	}
	
	/**
	 * Verify if there is an instance of ColumnValue with specified order on line from table from default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * True if exists<br/>
	 * False if not
	 */
	public static Boolean existsDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		return LineManager.existsColumnValueDefaultDB(schemaName, tableName, lineIndex, columnOrder);
	}
	
	/**
	 * Verify if there is an instance of ColumnValue with specified order on line from table from default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * True if exists<br/>
	 * False if not
	 */
	public static Boolean exists(String tableName, Long lineIndex, Integer columnOrder) {
		return LineManager.existsColumnValue(tableName, lineIndex, columnOrder);
	}
}
