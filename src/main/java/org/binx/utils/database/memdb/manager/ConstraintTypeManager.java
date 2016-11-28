package org.binx.utils.database.memdb.manager;

import java.util.*;

import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ConstraintTypeManager {

	/**
	 * Help to verify if the value of the specified column respects the specified constraint<br/>
	 * from table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @param constraint
	 * @return
	 * Null if specified Constraint, ColumnValue, column, line, table, schema or database not exists<br/>
	 * True if the value respects the constraint<br/>
	 * else False
	 */
	public static Boolean verifyConstraint(String databaseName, String schemaName, String tableName, ColumnValue columnValue, ConstraintType constraint) {
		if(columnValue != null) {
			switch (constraint) {
			case DEFAULT:
				return _default(columnValue.getValue());
			case NOT_NULL:
				return notNull(columnValue.getValue());
			case PRIMARY_KEY:
				return primaryKey(databaseName, schemaName, tableName, columnValue);
			case UNIQUE:
				return unique(databaseName, schemaName, tableName, columnValue);
			default:
				return null;
			}
		}
		return null;
	}
	
	/**
	 * Help to verify if the value of the specified column respects the specified constraint<br/>
	 * from table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @param constraint
	 * @return
	 * Null if specified Constraint, ColumnValue, column, line, table or database not exists<br/>
	 * True if the value respects the constraint<br/>
	 * else False
	 */
	public static Boolean verifyConstraint(String databaseName, String tableName, ColumnValue columnValue, ConstraintType constraint) {
		if(columnValue != null) {
			switch (constraint) {
			case DEFAULT:
				return _default(columnValue.getValue());
			case NOT_NULL:
				return notNull(columnValue.getValue());
			case PRIMARY_KEY:
				return primaryKey(databaseName, tableName, columnValue);
			case UNIQUE:
				return unique(databaseName, tableName, columnValue);
			default:
				return null;
			}
		}
		return null;
	}

	/**
	 * Help to verify if the value of the specified column respects the specified constraint<br/>
	 * from table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @param constraint
	 * @return
	 * Null if specified Constraint, ColumnValue, column, line, table, schema or default database not exists<br/>
	 * True if the value respects the constraint<br/>
	 * else False
	 */
	public static Boolean verifyConstraintDefaultDB(String schemaName, String tableName, ColumnValue columnValue, ConstraintType constraint) {
		if(columnValue != null) {
			switch (constraint) {
			case DEFAULT:
				return _default(columnValue.getValue());
			case NOT_NULL:
				return notNull(columnValue.getValue());
			case PRIMARY_KEY:
				return primaryKeyDefaultDB(schemaName, tableName, columnValue);
			case UNIQUE:
				return uniqueDefaultDB(schemaName, tableName, columnValue);
			default:
				return null;
			}
		}
		return null;
	}
	
	/**
	 * Help to verify if the value of the specified column respects the specified constraint<br/>
	 * from table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param lineIndex
	 * @param columnOrder
	 * @param constraint
	 * @return
	 * Null if specified Constraint, ColumnValue, column, line, table or default database not exists<br/>
	 * True if the value respects the constraint<br/>
	 * else False
	 */
	public static Boolean verifyConstraint(String tableName, ColumnValue columnValue, ConstraintType constraint) {
		if(columnValue != null) {
			switch (constraint) {
			case DEFAULT:
				return _default(columnValue.getValue());
			case NOT_NULL:
				return notNull(columnValue.getValue());
			case PRIMARY_KEY:
				return primaryKey(tableName, columnValue);
			case UNIQUE:
				return unique(tableName, columnValue);
			default:
				return null;
			}
		}
		return null;
	}
	
	private static Boolean _default(Object value) {
		return true; //TODO to implement it
	}
	
	/**
	 * Verify if the value givven is not null
	 * 
	 * @param object
	 * @return
	 * True if not null<br/>
	 * False if null. 
	 */
	private static Boolean notNull(Object value) {
		return value != null;
	}
	
	/**
	 * Verify if the specified value is notNull && unique
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if respected constraint<br/<
	 * False if not.
	 */
	private static Boolean primaryKey(String databaseName, String schemaName, String tableName, ColumnValue columnValue) {
		Boolean notNull = notNull(columnValue.getValue());
		Boolean unique  = unique(databaseName, schemaName, tableName, columnValue);
		return notNull && unique;
	}
	
	/**
	 * Verify if the specified value is notNull && unique
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if respected constraint<br/<
	 * False if not.
	 */
	private static Boolean primaryKey(String databaseName, String tableName, ColumnValue columnValue) {
		Boolean notNull = notNull(columnValue.getValue());
		Boolean unique  = unique(databaseName, tableName, columnValue);
		return notNull && unique;
	}
	
	/**
	 * Verify if the specified value is notNull && unique
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if respected constraint<br/<
	 * False if not.
	 */
	private static Boolean primaryKeyDefaultDB(String schemaName, String tableName, ColumnValue columnValue) {
		Boolean notNull = notNull(columnValue.getValue());
		Boolean unique  = uniqueDefaultDB(schemaName, tableName, columnValue);
		return notNull && unique;
	}
	
	/**
	 * Verify if the specified value is notNull && unique
	 * 
	 * @param tableName
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if respected constraint<br/<
	 * False if not.
	 */
	private static Boolean primaryKey(String tableName, ColumnValue columnValue) {
		Boolean notNull = notNull(columnValue.getValue());
		Boolean unique  = unique(tableName, columnValue);
		return notNull && unique;
	}
	
	/**
	 * Verify if the value given is unique
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if there in no duplicat value on the table<br/>
	 * else False.
	 */
	private static Boolean unique(String databaseName, String schemaName, String tableName, ColumnValue columnValue) {
		List<Line> lines = TableManager.getAllLines(databaseName, schemaName, tableName);
		for(Line line : lines) {
			Object o = ColumnValueManager.getValue(databaseName, schemaName, tableName, line.getIndex(), columnValue.getOrder());
			if(!line.getIndex().equals(columnValue.getIndex())) {
				if(o == null) {
					if(columnValue.getValue() == null)
						return false;
				} else {
					if(equals(o, columnValue.getValue()))
						return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Verify if the value given is unique
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if there in no duplicat value on the table<br/>
	 * else False.
	 */
	private static Boolean unique(String databaseName, String tableName, ColumnValue columnValue) {
		List<Line> lines = TableManager.getAllLines(databaseName, tableName);
		for(Line line : lines) {
			if(!line.getIndex().equals(columnValue.getIndex())) {
				Object o = ColumnValueManager.getValue(databaseName, tableName, line.getIndex(), columnValue.getOrder());
				if(o == null) {
					if(columnValue.getValue() == null)
						return false;
				} else {
					if(equals(o, columnValue.getValue()))
						return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Verify if the value given is unique
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if there in no duplicat value on the table<br/>
	 * else False.
	 */
	private static Boolean uniqueDefaultDB(String schemaName, String tableName, ColumnValue columnValue) {
		List<Line> lines = TableManager.getAllLinesDefaultDB(schemaName, tableName);
		for(Line line : lines) {
			if(!line.getIndex().equals(columnValue.getIndex())) {
				Object o = ColumnValueManager.getValueDefaultDB(schemaName, tableName, line.getIndex(), columnValue.getOrder());
				if(o == null) {
					if(columnValue.getValue() == null)
						return false;
				} else {
					if(equals(o, columnValue.getValue()))
						return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Verify if the value given is unique
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @param value
	 * @return
	 * True if there in no duplicat value on the table<br/>
	 * else False.
	 */
	private static Boolean unique(String tableName, ColumnValue columnValue) {
		List<Line> lines = TableManager.getAllLines(tableName);
		for(Line line : lines) {
			if(!line.getIndex().equals(columnValue.getIndex())) {
				Object o = ColumnValueManager.getValue(tableName, line.getIndex(), columnValue.getOrder());
				if(o == null) {
					if(columnValue.getValue() == null)
						return false;
				} else {
					if(equals(o, columnValue.getValue()))
						return false;
				}
			}
		}
		return true;
	}
	
	private static Boolean equals(Object o1, Object o2) {
		if(o1 instanceof String)
			return ((String) o1).equalsIgnoreCase((String) o2);
		return o1.equals(o2);
	}
}
