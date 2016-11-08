package org.binx.utils.database.memdb.manager;

import java.util.*;

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
	} // TODO createNewColumn with specified order

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
		return TableManager.addColumnDefaultDB(schemaName, tableName, ColumnGenerator.getColumn(columnName, columnType));
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
	 * Null if not exists column, table, schema or no default database
	 */
	public static Class<?> getTypeDefaultDB(String schemaName, String tableName, String columnName) {
		Column column = getColumnDefaultDB(schemaName, tableName, columnName);
		if(column != null)
			return column.getType();
		return null;
	}	
	
	/**
	 * Get type of specified columnName from table in default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if value is null, or not exists column, table or no default database
	 */
	public static Class<?> getType(String tableName, String columnName) {
		Column column = getColumn(tableName, columnName);
		if(column != null)
			return column.getType();
		return null;
	}

	/**
	 * Get order of specified columnName from table in database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if not exists column, table, schema or database
	 */
	public static Integer getOrder(String databaseName, String schemaName, String tableName, String columnName) {
		Column column = getColumn(databaseName, schemaName, tableName, columnName);
		if(column != null)
			return column.getOrder();
		return null;
	}

	/**
	 * Get order of specified columnName from table in database..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if not exists column, table or database
	 */
	public static Integer getOrder(String databaseName, String tableName, String columnName) {
		Column column = getColumn(databaseName, tableName, columnName);
		if(column != null)
			return column.getOrder();
		return null;
	}

	/**
	 * Get order of specified columnName from table in default(database)..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if not exists column, table, schema or no default database
	 */
	public static Integer getOrderDefaultDB(String schemaName, String tableName, String columnName) {
		Column column = getColumnDefaultDB(schemaName, tableName, columnName);
		if(column != null)
			return column.getOrder();
		return null;
	}

	/**
	 * Get order of specified columnName from table in default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if value is null, or not exists column, table or no default database
	 */
	public static Integer getOrder(String tableName, String columnName) {
		Column column = getColumn(tableName, columnName);
		if(column != null)
			return column.getOrder();
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
	public static Boolean updateName(String databaseName, String schemaName, String tableName, String oldName, String newName) {
		Column column = getColumn(databaseName, schemaName, tableName, oldName);
		if(column != null) {
			if(!exists(databaseName, schemaName, tableName, newName)) {
				column.setName(newName);
				return true;
			}
			return false;
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
	public static Boolean updateName(String databaseName, String tableName, String oldName, String newName) {
		Column column = getColumn(databaseName, tableName, oldName);
		if(column != null) {
			if(!exists(databaseName, tableName, newName)) {
				column.setName(newName);
				return true;
			}
			return false;
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
	public static Boolean updateNameDefaultDB(String schemaName, String tableName, String oldName, String newName) {
		Column column = getColumnDefaultDB(schemaName, tableName, oldName);
		if(column != null) {
			if(!existsDefaultDB(schemaName, tableName, newName)) {
				column.setName(newName);
				return true;
			}
			return false;
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
	public static Boolean updateName(String tableName, String oldName, String newName) {
		Column column = getColumn(tableName, oldName);
		if(column != null) {
			if(!exists(tableName, newName)) {
				column.setName(newName);
				return true;
			}
			return false;
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
	public static Boolean updateType(String databaseName, String schemaName, String tableName, String columnName, Class<?> newType) {
		Column column = getColumn(databaseName, schemaName, tableName, columnName);
		if(column != null) {
			if(!column.getType().equals(newType)) {
				column.setType(newType);
				return true;
			}
			return false;
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
	public static Boolean updateType(String databaseName, String tableName, String columnName, Class<?> newType) {
		Column column = getColumn(databaseName, tableName, columnName);
		if(column != null) {
			if(!column.getType().equals(newType)) {
				column.setType(newType);
				return true;
			}
			return false;
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
	public static Boolean updateTypeDefaultDB(String schemaName, String tableName, String columnName, Class<?> newType) {
		Column column = getColumnDefaultDB(schemaName, tableName, columnName);
		if(column != null) {
			if(!column.getType().equals(newType)) {
				column.setType(newType);
				return true;
			}
			return false;
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
	public static Boolean updateType(String tableName, String columnName, Class<?> newType) {
		Column column = getColumn(tableName, columnName);
		if(column != null) {
			if(!column.getType().equals(newType)) {
				column.setType(newType);
				return true;
			}
			return false;
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
	
	/**
	 * Add Constraint into specified column of table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraint
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if column, table, schema or database not exists
	 */
	public static Boolean addConstraint(String databaseName, String schemaName, String tableName, String columnName, Constraint constraint) {
		if(existsConstraint(databaseName, schemaName, tableName, columnName, constraint.getName()))
			return false;
		Column column = getColumn(databaseName, schemaName, tableName, columnName);
		if(column != null) {
			return column.getConstraints().add(constraint);
		}
		return null;
	}
	
	/**
	 * Add Constraint into specified column of table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @param constraint
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if column, table or database not exists
	 */
	public static Boolean addConstraint(String databaseName, String tableName, String columnName, Constraint constraint) {
		if(existsConstraint(databaseName, tableName, columnName, constraint.getName()))
			return false;
		Column column = getColumn(databaseName, tableName, columnName);
		if(column != null) {
			return column.getConstraints().add(constraint);
		}
		return null;
	}
	
	/**
	 * Add Constraint into specified column of table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraint
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if column, table, schema or default database not exists
	 */
	public static Boolean addConstraintDefaultDB(String schemaName, String tableName, String columnName, Constraint constraint) {
		if(existsConstraintDefaultDB(schemaName, tableName, columnName, constraint.getName()))
			return false;
		Column column = getColumnDefaultDB(schemaName, tableName, columnName);
		if(column != null) {
			return column.getConstraints().add(constraint);
		}
		return null;
	}
	
	/**
	 * Add Constraint into specified column of table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param columnName
	 * @param constraint
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if column, table or default database not exists
	 */
	public static Boolean addConstraint(String tableName, String columnName, Constraint constraint) {
		if(existsConstraint(tableName, columnName, constraint.getName()))
			return false;
		Column column = getColumn(tableName, columnName);
		if(column != null) {
			return column.getConstraints().add(constraint);
		}
		return null;
	}
	
	/**
	 * Get Constraint of specified column from table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * Null if constraint, column, table or database..schema not exist
	 */
	public static Constraint getConstraint(String databaseName, String schemaName, String tableName, String columnName, String constraintName) {
		Column column = getColumn(databaseName, schemaName, tableName, columnName);
		if(column != null) {
			for(Constraint constraint : column.getConstraints()) {
				if(constraint.getName().equals(constraintName))
					return constraint;
			}
		}
		return null;
	}
	
	/**
	 * Get Constraint of specified column from table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * Null if constraint, column, table or database..default(schema) not exist
	 */
	public static Constraint getConstraint(String databaseName, String tableName, String columnName, String constraintName) {
		Column column = getColumn(databaseName, tableName, columnName);
		if(column != null) {
			for(Constraint constraint : column.getConstraints()) {
				if(constraint.getName().equals(constraintName))
					return constraint;
			}
		}
		return null;
	}
	
	/**
	 * Get Constraint of specified column from table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * Null if constraint, column, table or default(database)..schema not exist
	 */
	public static Constraint getConstraintDefaultDB(String schemaName, String tableName, String columnName, String constraintName) {
		Column column = getColumnDefaultDB(schemaName, tableName, columnName);
		if(column != null) {
			for(Constraint constraint : column.getConstraints()) {
				if(constraint.getName().equals(constraintName))
					return constraint;
			}
		}
		return null;
	}
	
	/**
	 * Get Constraint of specified column from table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * Null if constraint, column, table or default(database)..default(schema) not exist
	 */
	public static Constraint getConstraint(String tableName, String columnName, String constraintName) {
		Column column = getColumn(tableName, columnName);
		if(column != null) {
			for(Constraint constraint : column.getConstraints()) {
				if(constraint.getName().equals(constraintName))
					return constraint;
			}
		}
		return null;
	}
	
	/**
	 * Get all constraints from specified Column of table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static List<Constraint> getAllConstraints(String databaseName, String schemaName, String tableName, String columnName) {
		if(exists(databaseName, schemaName, tableName, columnName)) {
			return getColumn(databaseName, schemaName, tableName, columnName).getConstraints();
		}
		return null;
	}
	
	/**
	 * Get all constraints from specified Column of table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table or database not exist
	 */
	public static List<Constraint> getAllConstraints(String databaseName, String tableName, String columnName) {
		if(exists(databaseName, tableName, columnName)) {
			return getColumn(databaseName, tableName, columnName).getConstraints();
		}
		return null;
	}
	
	/**
	 * Get all constraints from specified Column of table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table or schema not exist, or no default database
	 */
	public static List<Constraint> getAllConstraintsDefaultDB(String schemaName, String tableName, String columnName) {
		if(existsDefaultDB(schemaName, tableName, columnName)) {
			return getColumnDefaultDB(schemaName, tableName, columnName).getConstraints();
		}
		return null;
	}
	
	/**
	 * Get all constraints from specified Column of table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table not exist, or no default database
	 */
	public static List<Constraint> getAllConstraints(String tableName, String columnName) {
		if(exists(tableName, columnName)) {
			return getColumn(tableName, columnName).getConstraints();
		}
		return null;
	}
	
	/**
	 * Remove constraint from specified column of table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if removed<br/>
	 * False if not or constraint not exists<br/>
	 * Null if column, table, schema or database not exist
	 */
	public static Boolean deleteConstraint(String databaseName, String schemaName, String tableName, String columnName, String constraintName) {
		List<Constraint> constraints = getAllConstraints(databaseName, schemaName, tableName, columnName);
		if(constraints != null) {
			for(Constraint constraint : constraints) {
				if(constraint.getName().equals(constraintName))
					return constraints.remove(constraint);
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Remove constraint from specified column of table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if removed<br/>
	 * False if not or constraint not exists<br/>
	 * Null if column, table or database not exist
	 */
	public static Boolean deleteConstraint(String databaseName, String tableName, String columnName, String constraintName) {
		List<Constraint> constraints = getAllConstraints(databaseName, tableName, columnName);
		if(constraints != null) {
			for(Constraint constraint : constraints) {
				if(constraint.getName().equals(constraintName))
					return constraints.remove(constraint);
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Remove constraint from specified column of table on default(database)..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if removed<br/>
	 * False if not or constraint not exists<br/>
	 * Null if column, table, schema or default database not exist
	 */
	public static Boolean deleteConstraintDefaultDB(String schemaName, String tableName, String columnName, String constraintName) {
		List<Constraint> constraints = getAllConstraintsDefaultDB(schemaName, tableName, columnName);
		if(constraints != null) {
			for(Constraint constraint : constraints) {
				if(constraint.getName().equals(constraintName))
					return constraints.remove(constraint);
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Remove constraint from specified column of table on default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if removed<br/>
	 * False if not or constraint not exists<br/>
	 * Null if column, table or default database not exist
	 */
	public static Boolean deleteConstraint(String tableName, String columnName, String constraintName) {
		List<Constraint> constraints = getAllConstraints(tableName, columnName);
		if(constraints != null) {
			for(Constraint constraint : constraints) {
				if(constraint.getName().equals(constraintName))
					return constraints.remove(constraint);
			}
			return false;
		}
		return null;
	}
	
	/**
	 * Verify if constraint exists on specified column of table in database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsConstraint(String databaseName, String schemaName, String tableName, String columnName, String constraintName) {
		List<String> names = getAllNamesConstraints(databaseName, schemaName, tableName, columnName);
		if(names != null) {
			return names.contains(constraintName);
		}
		return false;
	}
	
	/**
	 * Verify if constraint exists on specified column of table in database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsConstraint(String databaseName, String tableName, String columnName, String constraintName) {
		List<String> names = getAllNamesConstraints(databaseName, tableName, columnName);
		if(names != null) {
			return names.contains(constraintName);
		}
		return false;
	}
	
	/**
	 * Verify if constraint exists on specified column of table in default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsConstraintDefaultDB(String schemaName, String tableName, String columnName, String constraintName) {
		List<String> names = getAllNamesConstraintsDefaultDB(schemaName, tableName, columnName);
		if(names != null) {
			return names.contains(constraintName);
		}
		return false;
	}
	
	/**
	 * Verify if constraint exists on specified column of table in default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsConstraint(String tableName, String columnName, String constraintName) {
		List<String> names = getAllNamesConstraints(tableName, columnName);
		if(names != null) {
			return names.contains(constraintName);
		}
		return false;
	}
	
	/**
	 * Get all names constraints from specified Column of table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static List<String> getAllNamesConstraints(String databaseName, String schemaName, String tableName, String columnName) {
		List<String> names = new ArrayList<>();
		if(exists(databaseName, schemaName, tableName, columnName)) {
			for(Constraint constraint : getColumn(databaseName, schemaName, tableName, columnName).getConstraints()) {
				names.add(constraint.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * Get all names constraints from specified Column of table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table or database not exist
	 */
	public static List<String> getAllNamesConstraints(String databaseName, String tableName, String columnName) {
		List<String> names = new ArrayList<>();
		if(exists(databaseName, tableName, columnName)) {
			for(Constraint constraint : getColumn(databaseName, tableName, columnName).getConstraints()) {
				names.add(constraint.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * Get all names constraints from specified Column of table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table or schema not exist, or no default database
	 */
	public static List<String> getAllNamesConstraintsDefaultDB(String schemaName, String tableName, String columnName) {
		List<String> names = new ArrayList<>();
		if(existsDefaultDB(schemaName, tableName, columnName)) {
			for(Constraint constraint : getColumnDefaultDB(schemaName, tableName, columnName).getConstraints()) {
				names.add(constraint.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * Get all names constraints from specified Column of table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table not exist, or no default database
	 */
	public static List<String> getAllNamesConstraints(String tableName, String columnName) {
		List<String> names = new ArrayList<>();
		if(exists(tableName, columnName)) {
			for(Constraint constraint : getColumn(tableName, columnName).getConstraints()) {
				names.add(constraint.getName());
			}
			return names;
		}
		return null;
	}
}
