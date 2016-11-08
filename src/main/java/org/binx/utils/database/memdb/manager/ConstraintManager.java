package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ConstraintManager {

	/**
	 * Add Constraint into specified column of table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @param constraintType
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if column, table, schema or database not exists
	 */
	public static Boolean createNewConstraint(String databaseName, String schemaName, String tableName, String columnName, String constraintName, ContraintType constraintType) {
		return ColumnManager.addConstraint(databaseName, schemaName, tableName, columnName, ConstraintGenerator.getConstraint(constraintName, constraintType));
	}
	
	/**
	 * Add Constraint into specified column of table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @param constraintType
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if column, table or database not exists
	 */
	public static Boolean createNewConstraint(String databaseName, String tableName, String columnName, String constraintName, ContraintType constraintType) {
		return ColumnManager.addConstraint(databaseName, tableName, columnName, ConstraintGenerator.getConstraint(constraintName, constraintType));
	}
	
	/**
	 * Add Constraint into specified column of table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @param constraintType
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if column, table, schema or default database not exists
	 */
	public static Boolean createNewConstraintDefaultDB(String schemaName, String tableName, String columnName, String constraintName, ContraintType constraintType) {
		return ColumnManager.addConstraintDefaultDB(schemaName, tableName, columnName, ConstraintGenerator.getConstraint(constraintName, constraintType));
	}
	
	/**
	 * Add Constraint into specified column of table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @param constraintType
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if column, table or default database not exists
	 */
	public static Boolean createNewConstraint(String tableName, String columnName, String constraintName, ContraintType constraintType) {
		return ColumnManager.addConstraint(tableName, columnName, ConstraintGenerator.getConstraint(constraintName, constraintType));
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
		return ColumnManager.getConstraint(databaseName, schemaName, tableName, columnName, constraintName);
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
		return ColumnManager.getConstraint(databaseName, tableName, columnName, constraintName);
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
		return ColumnManager.getConstraintDefaultDB(schemaName, tableName, columnName, constraintName);
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
		return ColumnManager.getConstraint(tableName, columnName, constraintName);
	}
	
	/**
	 * Modify Constraint Name to newer of specified specified column from table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param oldName
	 * @param newName
	 * @return
	 * True if changed<br/>
	 * False if new Name already exists<br/>
	 * Null if constraint ,column, table, schema or database not exists
	 */
	public static Boolean updateConstraintName(String databaseName, String schemaName, String tableName, String columnName, String oldName, String newName) {
		Constraint constraint = getConstraint(databaseName, schemaName, tableName, columnName, oldName);
		if(constraint != null) {
			if(!exists(databaseName, schemaName, tableName, columnName, newName))
				constraint.setName(newName);
			return false;
		}
		return null;
	}
	
	/**
	 * Modify Constraint Name to newer of specified specified column from table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @param oldName
	 * @param newName
	 * @return
	 * True if changed<br/>
	 * False if new Name already exists<br/>
	 * Null if constraint ,column, table or database not exists
	 */
	public static Boolean updateConstraintName(String databaseName, String tableName, String columnName, String oldName, String newName) {
		Constraint constraint = getConstraint(databaseName, tableName, columnName, oldName);
		if(constraint != null) {
			if(!exists(databaseName, tableName, columnName, newName))
				constraint.setName(newName);
			return false;
		}
		return null;
	}
	
	/**
	 * Modify Constraint Name to newer of specified specified column from table on default(database)..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param oldName
	 * @param newName
	 * @return
	 * True if changed<br/>
	 * False if new Name already exists<br/>
	 * Null if constraint ,column, table, schema or default database not exists
	 */
	public static Boolean updateConstraintNameDefaultDB(String schemaName, String tableName, String columnName, String oldName, String newName) {
		Constraint constraint = getConstraintDefaultDB(schemaName, tableName, columnName, oldName);
		if(constraint != null) {
			if(!existsDefaultDB(schemaName, tableName, columnName, newName))
				constraint.setName(newName);
			return false;
		}
		return null;
	}
	
	/**
	 * Modify Constraint Name to newer of specified specified column from table on default(database)..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @param oldName
	 * @param newName
	 * @return
	 * True if changed<br/>
	 * False if new Name already exists<br/>
	 * Null if constraint ,column, table or default database not exists
	 */
	public static Boolean updateConstraintName(String tableName, String columnName, String oldName, String newName) {
		Constraint constraint = getConstraint(tableName, columnName, oldName);
		if(constraint != null) {
			if(!exists(tableName, columnName, newName))
				constraint.setName(newName);
			return false;
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
	public static Boolean delete(String databaseName, String schemaName, String tableName, String columnName, String constraintName) {
		return ColumnManager.deleteConstraint(databaseName, schemaName, tableName, columnName, constraintName);
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
	public static Boolean delete(String databaseName, String tableName, String columnName, String constraintName) {
		return ColumnManager.deleteConstraint(databaseName, tableName, columnName, constraintName);
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
	public static Boolean deleteDefaultDB(String schemaName, String tableName, String columnName, String constraintName) {
		return ColumnManager.deleteConstraintDefaultDB(schemaName, tableName, columnName, constraintName);
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
	public static Boolean delete(String tableName, String columnName, String constraintName) {
		return ColumnManager.deleteConstraint(tableName, columnName, constraintName);
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
	public static Boolean exists(String databaseName, String schemaName, String tableName, String columnName, String constraintName) {
		return ColumnManager.existsConstraint(databaseName, schemaName, tableName, columnName, constraintName);
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
	public static Boolean exists(String databaseName, String tableName, String columnName, String constraintName) {
		return ColumnManager.existsConstraint(databaseName, tableName, columnName, constraintName);
	}
	
	/**
	 * Verify if constraint exists on specified column of table in database..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsDefaultDB(String schemaName, String tableName, String columnName, String constraintName) {
		return ColumnManager.existsConstraintDefaultDB(schemaName, tableName, columnName, constraintName);
	}
	
	/**
	 * Verify if constraint exists on specified column of table in default(database)..schema
	 * 
	 * @param tableName
	 * @param columnName
	 * @param constraintName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String tableName, String columnName, String constraintName) {
		return ColumnManager.existsConstraint(tableName, columnName, constraintName);
	}
}
