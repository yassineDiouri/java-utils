package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

/**
 * @author Yassine Diouri
 *
 */
public abstract class LineManager {

	/**
	 * Add new empty line into specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if table do not contains columns or if table, schema or database not exists
	 */
	public static Boolean createNewEmptyLine(String databaseName, String schemaName, String tableName) {
		Line line =  LineGenerator.getLine();
		for(Column column : TableManager.getAllColumns(databaseName, schemaName, tableName)) {
			ColumnValue columnValue = ColumnValueGenerator.getColumnValue();
			columnValue.setOrder(column.getOrder());
			line.getValues().add(columnValue);
		}
		return TableManager.addLine(databaseName, schemaName, tableName, line);
	}
	
	/**
	 * Add line into specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if table do not contains columns or if table or database not exists
	 */
	public static Boolean createNewEmptyLine(String databaseName, String tableName) {
		Line line =  LineGenerator.getLine();
		for(Column column : TableManager.getAllColumns(databaseName, tableName)) {
			ColumnValue columnValue = ColumnValueGenerator.getColumnValue();
			columnValue.setOrder(column.getOrder());
			line.getValues().add(columnValue);
		}
		return TableManager.addLine(databaseName, tableName, LineGenerator.getLine());
	}
	
	/**
	 * Add new empty line into specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if table do not contains columns or if table, schema or default database not exists
	 */
	public static Boolean createNewEmptyLineDefaultDB(String schemaName, String tableName) {
		Line line =  LineGenerator.getLine();
		for(Column column : TableManager.getAllColumnsDefaultDB(schemaName, tableName)) {
			ColumnValue columnValue = ColumnValueGenerator.getColumnValue();
			columnValue.setOrder(column.getOrder());
			line.getValues().add(columnValue);
		}
		return TableManager.addLineDefaultDB(schemaName, tableName, line);
	}
	
	/**
	 * Add new empty line into specified table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if table do not contains columns or if table or default database not exists
	 */
	public static Boolean createNewEmptyLine(String tableName) {
		Line line =  LineGenerator.getLine();
		for(Column column : TableManager.getAllColumns(tableName)) {
			ColumnValue columnValue = ColumnValueGenerator.getColumnValue();
			columnValue.setOrder(column.getOrder());
			line.getValues().add(columnValue);
		}
		return TableManager.addLine(tableName, LineGenerator.getLine());
	}
	
	/**
	 * Get Line on index from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static Line getLine(String databaseName, String tableName, Long lineIndex) {
		return TableManager.getLine(databaseName, tableName, lineIndex);
	}
	
	/**
	 * Get Line on index from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table or database not exist
	 */
	public static Line getLineDefaultDB(String schemaName, String tableName, Long lineIndex) {
		return TableManager.getLineDefaultDB(schemaName, tableName, lineIndex);
	}
	
	/**
	 * Get Line on index from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table or schema not exist, or no default database
	 */
	public static Line getLine(String tableName, Long lineIndex) {
		return TableManager.getLine(tableName, lineIndex);
	}
	
	/**
	 * Get Line on index from specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table not exist, or no default database
	 */
	public static Line getLine(String databaseName, String schemaName, String tableName, Long lineIndex) {
		return TableManager.getLine(databaseName, schemaName, tableName, lineIndex);
	}
	
	/**
	 * Remove line from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table not exist or no default database
	 */
	public static Boolean delete(String databaseName, String schemaName, String tableName, Long lineIndex) {
		return TableManager.deleteLine(databaseName, schemaName, tableName, lineIndex);
	}
	
	/**
	 * Remove line from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table or database not exist
	 */
	public static Boolean delete(String databaseName, String tableName, Long lineIndex) {
		return TableManager.deleteLine(databaseName, tableName, lineIndex);
	}
	
	/**
	 * Remove line from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table or schema not exist or no default database
	 */
	public static Boolean deleteDefaultDB(String schemaName, String tableName, Long lineIndex) {
		return TableManager.deleteLineDefaultDB(schemaName, tableName, lineIndex);
	}
	
	/**
	 * Remove line from specified table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table not exist or no default database
	 */
	public static Boolean delete(String tableName, Long index) {
		return TableManager.deleteLine(tableName, index);
	}
	
	/**
	 * Insert ColumnValue into specified Line from specified table on database..schema
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
	public static Boolean addColumnValue(String databaseName, String schemaName, String tableName, Long lineIndex, ColumnValue columnValue) {
		Line line = getLine(databaseName, schemaName, tableName, lineIndex);
		if(line != null && canBeInsertedValue(databaseName, schemaName, tableName, columnValue))
			return line.getValues().add(columnValue);
		return null;
	}
	
	/**
	 * Insert ColumnValue into specified Line from specified table on database..default(schema)
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
	public static Boolean addColumnValue(String databaseName, String tableName, Long lineIndex, ColumnValue columnValue) {
		Line line = getLine(databaseName, tableName, lineIndex);
		if(line != null && canBeInsertedValue(databaseName, tableName, columnValue))
			return line.getValues().add(columnValue);
		return null;
	}
	
	/**
	 * Insert ColumnValue into specified Line from specified table on default(database)..schema
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
	public static Boolean addColumnValueDefaultDB(String schemaName, String tableName, Long lineIndex, ColumnValue columnValue) {
		Line line = getLineDefaultDB(schemaName, tableName, lineIndex);
		if(line != null && canBeInsertedValueDefaultDB(schemaName, tableName, columnValue))
			return line.getValues().add(columnValue);
		return null;
	}
	
	/**
	 * Insert ColumnValue into specified Line from specified table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param lineIndex
	 * @param columnValue
	 * @return
	 * True if inserted<br/>
	 * False if not<br/>
	 * Null if columnValue can't be inserted or line, table or default database not exists
	 */
	public static Boolean addColumnValue(String tableName, Long lineIndex, ColumnValue columnValue) {
		Line line = getLine(tableName, lineIndex);
		if(line != null && canBeInsertedValue(tableName, columnValue))
			return line.getValues().add(columnValue);
		return null;
	}
	
	/**
	 * Verify if the Value can be inserted in the specified Line for columnOrder<br/>
	 * from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnValue
	 * @return
	 * True it can be inserted<br/>
	 * False if order not valid or not same type of columnOrder or not verified constraints
	 */
	private static Boolean canBeInsertedValue(String databaseName, String schemaName, String tableName, ColumnValue columnValue) {
		Column column = ColumnManager.getColumn(databaseName, schemaName, tableName, columnValue.getOrder());
		if(column != null) {
			Boolean typeCondition = columnValue.getValue() == null ? true : column.getType().equals(columnValue.getValue().getClass());
			Boolean constraintsCondition = true; // TODO change when add constraints Tests
			return typeCondition && constraintsCondition;
		}
		return false;
	}
	
	/**
	 * Verify if the Value can be inserted in the specified Line for columnOrder<br/>
	 * from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnValue
	 * @return
	 * True it can be inserted<br/>
	 * False if order not valid or not same type of columnOrder or not verified constraints
	 */
	private static Boolean canBeInsertedValue(String databaseName, String tableName, ColumnValue columnValue) {
		Column column = ColumnManager.getColumn(databaseName, tableName, columnValue.getOrder());
		if(column != null) {
			Boolean typeCondition = columnValue.getValue() == null ? true : column.getType().equals(columnValue.getValue().getClass());
			Boolean constraintsCondition = true; // TODO change when add constraints Tests
			return typeCondition && constraintsCondition;
		}
		return false;
	}
	
	/**
	 * Verify if the Value can be inserted in the specified Line for columnOrder<br/>
	 * from specified table on default(database)..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnValue
	 * @return
	 * True it can be inserted<br/>
	 * False if order not valid or not same type of columnOrder or not verified constraints
	 */
	private static Boolean canBeInsertedValueDefaultDB(String schemaName, String tableName, ColumnValue columnValue) {
		Column column = ColumnManager.getColumnDefaultDB(schemaName, tableName, columnValue.getOrder());
		if(column != null) {
			Boolean typeCondition = columnValue.getValue() == null ? true : column.getType().equals(columnValue.getValue().getClass());
			Boolean constraintsCondition = true; // TODO change when add constraints Tests
			return typeCondition && constraintsCondition;
		}
		return false;
	}
	
	/**
	 * Verify if the Value can be inserted in the specified Line for columnOrder<br/>
	 * from specified table on default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnValue
	 * @return
	 * True it can be inserted<br/>
	 * False if order not valid or not same type of columnOrder or not verified constraints
	 */
	private static Boolean canBeInsertedValue(String tableName, ColumnValue columnValue) {
		Column column = ColumnManager.getColumn(tableName, columnValue.getOrder());
		if(column != null) {
			Boolean typeCondition = columnValue.getValue() == null ? true : column.getType().equals(columnValue.getValue().getClass());
			Boolean constraintsCondition = true; // TODO change when add constraints Tests
			return typeCondition && constraintsCondition;
		}
		return false;
	}
}
