package org.binx.utils.database.memdb.manager;

import java.util.List;

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
	public static Line createNewEmptyLine(String databaseName, String schemaName, String tableName) {
		Line line =  LineGenerator.getLine();
		List<Column> columns = TableManager.getAllColumns(databaseName, schemaName, tableName);
		if(columns != null) {
			for(Column column : columns) {
				ColumnValue columnValue = ColumnValueGenerator.getColumnValue();
				columnValue.setOrder(column.getOrder());
				line.getValues().add(columnValue);
			}
			return TableManager.addLine(databaseName, schemaName, tableName, line) ? line : null;
		}
		return null;
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
	public static Line createNewEmptyLine(String databaseName, String tableName) {
		Line line =  LineGenerator.getLine();
		List<Column> columns = TableManager.getAllColumns(databaseName, tableName);
		if(columns != null) {
			for(Column column : columns) {
				ColumnValue columnValue = ColumnValueGenerator.getColumnValue();
				columnValue.setOrder(column.getOrder());
				line.getValues().add(columnValue);
			}
			return TableManager.addLine(databaseName, tableName, line) ? line : null;
		}
		return null;
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
	public static Line createNewEmptyLineDefaultDB(String schemaName, String tableName) {
		Line line =  LineGenerator.getLine();
		List<Column> columns = TableManager.getAllColumnsDefaultDB(schemaName, tableName);
		if(columns != null) {
			for(Column column : columns) {
				ColumnValue columnValue = ColumnValueGenerator.getColumnValue();
				columnValue.setOrder(column.getOrder());
				line.getValues().add(columnValue);
			}
			return TableManager.addLineDefaultDB(schemaName, tableName, line) ? line : null;
		}
		return null;
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
	public static Line createNewEmptyLine(String tableName) {
		Line line =  LineGenerator.getLine();
		List<Column> columns = TableManager.getAllColumns(tableName);
		if(columns != null) {
			for(Column column : columns) {
				ColumnValue columnValue = ColumnValueGenerator.getColumnValue();
				columnValue.setOrder(column.getOrder());
				line.getValues().add(columnValue);
			}
			return TableManager.addLine(tableName, line) ? line : null;
		}
		return null;
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
	 * Insert ColumnValue into specified Line from table on database..schema
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
		if(line != null && canBeInsertedValue(databaseName, schemaName, tableName, columnValue)) {
			if(existsColumnValue(databaseName, schemaName, tableName, lineIndex, columnValue.getOrder())) {
				line.getValues().set(columnValue.getOrder(), columnValue);
				return true;
			}
			return line.getValues().add(columnValue);
		}
		return null;
	}
	
	/**
	 * Insert ColumnValue into specified Line from table on database..default(schema)
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
		if(line != null && canBeInsertedValue(databaseName, tableName, columnValue)) {
			if(existsColumnValue(databaseName, tableName, lineIndex, columnValue.getOrder())) {
				line.getValues().set(columnValue.getOrder(), columnValue);
				return true;
			}
			return line.getValues().add(columnValue);
		}
		return null;
	}
	
	/**
	 * Insert ColumnValue into specified Line from table on default(database)..schema
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
		if(line != null && canBeInsertedValueDefaultDB(schemaName, tableName, columnValue)) {
			if(existsColumnValueDefaultDB(schemaName, tableName, lineIndex, columnValue.getOrder())) {
				line.getValues().set(columnValue.getOrder(), columnValue);
				return true;
			}
			return line.getValues().add(columnValue);
		}
		return null;
	}
	
	/**
	 * Insert ColumnValue into specified Line from table on default(database)..default(schema)
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
		if(line != null && canBeInsertedValue(tableName, columnValue)) {
			if(existsColumnValue(tableName, lineIndex, columnValue.getOrder())) {
				line.getValues().set(columnValue.getOrder(), columnValue);
				return true;
			}
			return line.getValues().add(columnValue);
		}
		return null;
	}
	
	/**
	 * Get ColumnValue from specified Line from table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * Null if column order, line, table, schema or database not exists
	 */
	public static ColumnValue getColumnValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLine(databaseName, schemaName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return cv;
			}
		}
		return null;
	}
	
	/**
	 * Get ColumnValue from specified Line from table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * Null if column order, line, table or database not exists
	 */
	public static ColumnValue getColumnValue(String databaseName, String tableName, Long lineIndex, Integer ColumnOrder) {
		Line line = getLine(databaseName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(ColumnOrder))
					return cv;
			}
		}
		return null;
	}
	
	/**
	 * Get ColumnValue from specified Line from table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * Null if column order, line, table, schema or default database not exists
	 */
	public static ColumnValue getColumnValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer ColumnOrder) {
		Line line = getLineDefaultDB(schemaName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(ColumnOrder))
					return cv;
			}
		}
		return null;
	}
	
	/**
	 * Get ColumnValue from specified Line from table on default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * Null if column order, line, table or default database not exists
	 */
	public static ColumnValue getColumnValue(String tableName, Long lineIndex, Integer ColumnOrder) {
		Line line = getLine(tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(ColumnOrder))
					return cv;
			}
		}
		return null;
	}
	
	/**
	 * Get All ColumnValues of specified line from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @return
	 * Null if line, table, schema or database not exists
	 */
	public static List<ColumnValue> getAllColumnValues(String databaseName, String schemaName, String tableName, Long lineIndex) {
		Line line = getLine(databaseName, schemaName, tableName, lineIndex);
		if(line != null) {
			return line.getValues();
		}
		return null;
	}
	
	/**
	 * Get All ColumnValues of specified line from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @return
	 * Null if line, table or database not exists
	 */
	public static List<ColumnValue> getAllColumnValues(String databaseName, String tableName, Long lineIndex) {
		Line line = getLine(databaseName, tableName, lineIndex);
		if(line != null) {
			return line.getValues();
		}
		return null;
	}
	
	/**
	 * Get All ColumnValues of specified line from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @return
	 * Null if line, table, schema or default database not exists
	 */
	public static List<ColumnValue> getAllColumnValuesDefaultDB(String schemaName, String tableName, Long lineIndex) {
		Line line = getLineDefaultDB(schemaName, tableName, lineIndex);
		if(line != null) {
			return line.getValues();
		}
		return null;
	}
	
	/**
	 * Get All ColumnValues of specified line from specified table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param lineIndex
	 * @return
	 * Null if line, table or default database not exists
	 */
	public static List<ColumnValue> getAllColumnValues(String tableName, Long lineIndex) {
		Line line = getLine(tableName, lineIndex);
		if(line != null) {
			return line.getValues();
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
	public static Boolean updateColumnValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		ColumnValue columnValue = getColumnValue(databaseName, schemaName, tableName, lineIndex, columnOrder);
		if(columnValue != null) {
			if(canBeInsertedValue(databaseName, schemaName, tableName, columnValue)) {
				columnValue.setValue(value);
				return true;
			}
		}
		return null;
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
	public static Boolean updateColumnValue(String databaseName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		ColumnValue columnValue = getColumnValue(databaseName, tableName, lineIndex, columnOrder);
		if(columnValue != null) {
			if(canBeInsertedValue(databaseName, tableName, columnValue)) {
				columnValue.setValue(value);
				return true;
			}
		}
		return null;
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
	public static Boolean updateColumnValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder, Object value) {
		ColumnValue columnValue = getColumnValueDefaultDB(schemaName, tableName, lineIndex, columnOrder);
		if(columnValue != null) {
			if(canBeInsertedValueDefaultDB(schemaName, tableName, columnValue)) {
				columnValue.setValue(value);
				return true;
			}
		}
		return null;
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
	public static Boolean updateColumnValue(String tableName, Long lineIndex, Integer columnOrder, Object value) {
		ColumnValue columnValue = getColumnValue(tableName, lineIndex, columnOrder);
		if(columnValue != null) {
			if(canBeInsertedValue(tableName, columnValue)) {
				columnValue.setValue(value);
				return true;
			}
		}
		return null;
	}
	
	/**
	 * Remove a specified ColumnValue from line of table of database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * True if deleted<br/>
	 * False if not<br/>
	 * Null if column, line, table, schema or database not exists
	 */
	public static Boolean deleteColumnValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLine(databaseName, schemaName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return line.getValues().remove(cv);
			}
		}
		return null;
	}
	
	/**
	 * Remove a specified ColumnValue from line of table of database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * True if deleted<br/>
	 * False if not<br/>
	 * Null if column, line, table or database not exists
	 */
	public static Boolean deleteColumnValue(String databaseName, String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLine(databaseName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return line.getValues().remove(cv);
			}
		}
		return null;
	}
	
	/**
	 * Remove a specified ColumnValue from line of table of default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * True if deleted<br/>
	 * False if not<br/>
	 * Null if column, line, table, schema or default database not exists
	 */
	public static Boolean deleteColumnValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLineDefaultDB(schemaName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return line.getValues().remove(cv);
			}
		}
		return null;
	}
	
	/**
	 * Remove a specified ColumnValue from line of table of default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param lineIndex
	 * @param ColumnOrder
	 * @return
	 * True if deleted<br/>
	 * False if not<br/>
	 * Null if column, line, table or default database not exists
	 */
	public static Boolean deleteColumnValue(String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLine(tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return line.getValues().remove(cv);
			}
		}
		return null;
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
	public static Boolean existsColumnValue(String databaseName, String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLine(databaseName, schemaName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return true;
			}
		}
		return false;
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
	public static Boolean existsColumnValue(String databaseName, String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLine(databaseName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return true;
			}
		}
		return false;
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
	public static Boolean existsColumnValueDefaultDB(String schemaName, String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLineDefaultDB(schemaName, tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return true;
			}
		}
		return false;
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
	public static Boolean existsColumnValue(String tableName, Long lineIndex, Integer columnOrder) {
		Line line = getLine(tableName, lineIndex);
		if(line != null) {
			for(ColumnValue cv : line.getValues()) {
				if(cv.getOrder().equals(columnOrder))
					return true;
			}
		}
		return false;
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
			Boolean constraintsCondition = true;
			for(Constraint constraint : column.getConstraints()) {
				constraintsCondition = constraintsCondition && 
						ConstraintTypeManager.verifyConstraint(databaseName, schemaName, tableName, columnValue, constraint.getType());
			}
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
			Boolean constraintsCondition = true;
			for(Constraint constraint : column.getConstraints()) {
				constraintsCondition = constraintsCondition && 
						ConstraintTypeManager.verifyConstraint(databaseName, tableName, columnValue, constraint.getType());
			}
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
			Boolean constraintsCondition = true;
			for(Constraint constraint : column.getConstraints()) {
				constraintsCondition = constraintsCondition && 
						ConstraintTypeManager.verifyConstraintDefaultDB(schemaName, tableName, columnValue, constraint.getType());
			}
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
			Boolean constraintsCondition = true;
			for(Constraint constraint : column.getConstraints()) {
				constraintsCondition = constraintsCondition && 
						ConstraintTypeManager.verifyConstraint(tableName, columnValue, constraint.getType());
			}
			return typeCondition && constraintsCondition;
		}
		return false;
	}
}
