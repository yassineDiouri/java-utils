package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

import junit.framework.TestCase;

public class ColumnManagerUnitTest extends TestCase {

	// databases
	private String databaseName;
	private String defaultdb;
	private String notexistdb;
	//schemas
	private String schemaName;
	private String notexistSchema;
	//tables
	private String tableName;
	private String notexistTab;
	//columns
	private String columnName;
	private String newColumnName;
	private String notexistCol;
	//constraints
	private String constraintName;
	private String notexistConstraint;
	private Constraint constraint;
	
	@Override
	protected void setUp() throws Exception {
		databaseName = "databaseName";
		defaultdb = "defaultdb";
		notexistdb = "notexistdb";
		
		schemaName = "simpleSchema";
		notexistSchema = "notexistSchema";
		
		tableName = "tableName";
		notexistTab = "notexistTab";
		
		columnName = "columnName";
		newColumnName = "newColumnName";
		notexistCol = "notexistCol";
		
		constraintName = "constraintName";
		notexistConstraint = "notexistConstraint";
		constraint = ConstraintGenerator.getConstraint(constraintName, ContraintType.PRIMARY_KEY);
		
		DatabaseListManager.initDatabaseList();
		
		DatabaseManager.createNewDatabase(databaseName);
		DatabaseManager.createNewDatabase(defaultdb);
		DatabaseManager.setToDefault(defaultdb);
		
		SchemaManager.createNewSchema(databaseName, schemaName);
		SchemaManager.createNewSchema(schemaName);
		
		TableManager.createNewTable(databaseName, schemaName, tableName);
		TableManager.createNewTable(databaseName, tableName);
		TableManager.createNewTableDefaultDB(schemaName, tableName);
		TableManager.createNewTable(tableName);
	}
	
	public void testColumnManager() {
		createNewColumnWithDbScTabReturnNull();
		createNewColumnWithDbDefaultScTabReturnNull();
		createNewColumnWithDefaultDbScTabReturnNull();
		createNewColumnWithDefaultDbDefaultScTabReturnNull();
		getColumnWithDbScTabReturnNull();
		getColumnWithDbDefaultScTabReturnNull();
		getColumnWithDefaultDbScTabReturnNull();
		getColumnWithDefaultDbDefaultScTabReturnNull();
		getTypeWithDbScTabReturnNull();
		getTypeWithDbDefaultScTabReturnNull();
		getTypeWithDefaultDbScTabReturnNull();
		getTypeWithDefaultDbDefaultScTabReturnNull();
		getOrderWithDbScTabReturnNull();
		getOrderWithDbDefaultScTabReturnNull();
		getOrderWithDefaultDbScTabReturnNull();
		getOrderWithDefaultDbDefaultScTabReturnNull();
		updateNameWithDbScTabReturnNull();
		updateNameWithDbDefaultScTabReturnNull();
		updateNameWithDefaultDbScTabReturnNull();
		updateNameWithDefaultDbDefaultScTabReturnNull();
		updateTypeWithDbScTabReturnNull();
		updateTypeWithDbDefaultScTabReturnNull();
		updateTypeWithDefaultDbScTabReturnNull();
		updateTypeWithDefaultDbDefaultScTabReturnNull();
		deleteWithDbScTabReturnNull();
		deleteWithDbDefaultScTabReturnNull();
		deleteWithDefaultDbScTabReturnNull();
		deleteWithDefaultDbDefaultScTabReturnNull();
		existsWithDbScTabReturnFalse();
		existsWithDbDefaultScTabReturnFalse();
		existsWithDefaultDbScTabReturnFalse();
		existsWithDefaultDbDefaultScTabReturnFalse();
		
		addConstraintWithDbScTabReturnNull();
		addConstraintWithDbDefaultScTabReturnNull();
		addConstraintWithDefaultDbScTabReturnNull();
		addConstraintWithDefaultDbDefaultScTabReturnNull();
		getConstraintWithDbScTabReturnNull();
		getConstraintWithDbDefaultScTabReturnNull();
		getConstraintWithDefaultDbScTabReturnNull();
		getConstraintWithDefaultDbDefaultScTabReturnNull();
		getAllConstraintsWithDbScTabReturnNull();
		getAllConstraintsWithDbDefaultScTabReturnNull();
		getAllConstraintsWithDefaultDbScTabReturnNull();
		getAllConstraintsWithDefaultDbDefaultScTabReturnNull();
		deleteConstraintWithDbScTabReturnNull();
		deleteConstraintWithDbDefaultScTabReturnNull();
		deleteConstraintWithDefaultDbScTabReturnNull();
		deleteConstraintWithDefaultDbDefaultScTabReturnNull();
		getAllNamesConstraintsWithDbScTabReturnNull();
		getAllNamesConstraintsWithDbDefaultScTabReturnNull();
		getAllNamesConstraintsWithDefaultDbScTabReturnNull();
		getAllNamesConstraintsWithDefaultDbDefaultScTabReturnNull();
		
		createNewColumnWithDbScTabReturnTrue();
		createNewColumnWithDbScTabReturnFalse();
		createNewColumnWithDbDefaultScTabReturnTrue();
		createNewColumnWithDbDefaultScTabReturnFalse();
		createNewColumnWithDefaultDbScTabReturnTrue();
		createNewColumnWithDefaultDbScTabReturnFalse();
		createNewColumnWithDefaultDbDefaultScTabReturnTrue();
		createNewColumnWithDefaultDbDefaultScTabReturnFalse();
		getColumnWithDbScTabReturnNotNull();
		getColumnWithDbDefaultScTabReturnNotNull();
		getColumnWithDefaultDbScTabReturnNotNull();
		getColumnWithDefaultDbDefaultScTabReturnNotNull();
		getTypeWithDbScTabReturnNotNull();
		getTypeWithDbDefaultScTabReturnNotNull();
		getTypeWithDefaultDbScTabReturnNotNull();
		getTypeWithDefaultDbDefaultScTabReturnNotNull();
		getOrderWithDbScTabReturnNotNull();
		getOrderWithDbDefaultScTabReturnNotNull();
		getOrderWithDefaultDbScTabReturnNotNull();
		getOrderWithDefaultDbDefaultScTabReturnNotNull();
		existsWithDbScTabReturnTrue();
		existsWithDbDefaultScTabReturnTrue();
		existsWithDefaultDbScTabReturnTrue();
		existsWithDefaultDbDefaultScTabReturnTrue();

		addConstraintWithDbScTabReturnTrue();
		addConstraintWithDbScTabReturnFalse();
		addConstraintWithDbDefaultScTabReturnTrue();
		addConstraintWithDbDefaultScTabReturnFalse();
		addConstraintWithDefaultDbScTabReturnTrue();
		addConstraintWithDefaultDbScTabReturnFalse();
		addConstraintWithDefaultDbDefaultScTabReturnTrue();
		addConstraintWithDefaultDbDefaultScTabReturnFalse();
		getConstraintWithDbScTabReturnNotNull();
		getConstraintWithDbDefaultScTabReturnNotNull();
		getConstraintWithDefaultDbScTabReturnNotNull();
		getConstraintWithDefaultDbDefaultScTabReturnNotNull();
		getAllConstraintsWithDbScTabReturnNotNull();
		getAllConstraintsWithDbDefaultScTabReturnNotNull();
		getAllConstraintsWithDefaultDbScTabReturnNotNull();
		getAllConstraintsWithDefaultDbDefaultScTabReturnNotNull();
		deleteConstraintWithDbScTabReturnFalse();
		deleteConstraintWithDbDefaultScTabReturnFalse();
		deleteConstraintWithDefaultDbScTabReturnFalse();
		deleteConstraintWithDefaultDbDefaultScTabReturnFalse();
		existsConstraintWithDbScTabReturnFalse();
		existsConstraintWithDbDefaultScTabReturnFalse();
		existsConstraintWithDefaultDbScTabReturnFalse();
		existsConstraintWithDefaultDbDefaultScTabReturnFalse();
		existsConstraintWithDbScTabReturnTrue();
		existsConstraintWithDbDefaultScTabReturnTrue();
		existsConstraintWithDefaultDbScTabReturnTrue();
		existsConstraintWithDefaultDbDefaultScTabReturnTrue();
		getAllNamesConstraintsWithDbScTabReturnNotNull();
		getAllNamesConstraintsWithDbDefaultScTabReturnNotNull();
		getAllNamesConstraintsWithDefaultDbScTabReturnNotNull();
		getAllNamesConstraintsWithDefaultDbDefaultScTabReturnNotNull();
		
		deleteConstraintWithDbScTabReturnTrue();
		deleteConstraintWithDbDefaultScTabReturnTrue();
		deleteConstraintWithDefaultDbScTabReturnTrue();
		deleteConstraintWithDefaultDbDefaultScTabReturnTrue();

		updateTypeWithDbScTabReturnFalse();
		updateTypeWithDbScTabReturnTrue();
		updateTypeWithDbDefaultScTabReturnFalse();
		updateTypeWithDbDefaultScTabReturnTrue();
		updateTypeWithDefaultDbScTabReturnFalse();
		updateTypeWithDefaultDbScTabReturnTrue();
		updateTypeWithDefaultDbDefaultScTabReturnFalse();
		updateTypeWithDefaultDbDefaultScTabReturnTrue();
		updateNameWithDbScTabReturnFalse();
		updateNameWithDbScTabReturnTrue();
		updateNameWithDbDefaultScTabReturnFalse();
		updateNameWithDbDefaultScTabReturnTrue();
		updateNameWithDefaultDbScTabReturnFalse();
		updateNameWithDefaultDbScTabReturnTrue();
		updateNameWithDefaultDbDefaultScTabReturnFalse();
		updateNameWithDefaultDbDefaultScTabReturnTrue();
		
		deleteWithDbScTabReturnNotNull();
		deleteWithDbDefaultScTabReturnNotNull();
		deleteWithDefaultDbScTabReturnNotNull();
		deleteWithDefaultDbDefaultScTabReturnNotNull();
	}
	
	public void createNewColumnWithDbScTabReturnNull() {
		assertNull(ColumnManager.createNewColumn(notexistdb, schemaName, tableName, columnName, String.class));
		assertNull(ColumnManager.createNewColumn(databaseName, notexistSchema, tableName, columnName, String.class));
		assertNull(ColumnManager.createNewColumn(databaseName, schemaName, notexistTab, columnName, String.class));
	}
	
	public void createNewColumnWithDbScTabReturnFalse() {
		assertFalse(ColumnManager.createNewColumn(databaseName, schemaName, tableName, columnName, String.class));
	}
	
	public void createNewColumnWithDbScTabReturnTrue() {
		assertTrue(ColumnManager.createNewColumn(databaseName, schemaName, tableName, columnName, String.class));
	}
	
	public void createNewColumnWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.createNewColumn(notexistdb, tableName, columnName, String.class));
		assertNull(ColumnManager.createNewColumn(databaseName, notexistTab, columnName, String.class));
	}
	
	public void createNewColumnWithDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.createNewColumn(databaseName, tableName, columnName, String.class));
	}
	
	public void createNewColumnWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.createNewColumn(databaseName, tableName, columnName, String.class));
	}
	
	public void createNewColumnWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.createNewColumnDefaultDB(notexistSchema, tableName, columnName, String.class));
		assertNull(ColumnManager.createNewColumnDefaultDB(schemaName, notexistTab, columnName, String.class));
	}
	
	public void createNewColumnWithDefaultDbScTabReturnFalse() {
		assertFalse(ColumnManager.createNewColumnDefaultDB(schemaName, tableName, columnName, String.class));
	}
	
	public void createNewColumnWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnManager.createNewColumnDefaultDB(schemaName, tableName, columnName, String.class));
	}
	
	public void createNewColumnWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.createNewColumn(notexistTab, columnName, String.class));
	}
	
	public void createNewColumnWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.createNewColumn(tableName, columnName, String.class));
	}
	
	public void createNewColumnWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.createNewColumn(tableName, columnName, String.class));
	}
	
	public void getColumnWithDbScTabReturnNull() {
		assertNull(ColumnManager.getColumn(notexistdb, schemaName, tableName, columnName));
		assertNull(ColumnManager.getColumn(databaseName, notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getColumn(databaseName, schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getColumn(databaseName, schemaName, tableName, notexistCol));
	}
	
	public void getColumnWithDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getColumn(databaseName, schemaName, tableName, columnName));
	}
	
	public void getColumnWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getColumn(notexistdb, tableName, columnName));
		assertNull(ColumnManager.getColumn(databaseName, notexistTab, columnName));
		assertNull(ColumnManager.getColumn(databaseName, tableName, notexistCol));
	}
	
	public void getColumnWithDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getColumn(databaseName, tableName, columnName));
	}
	
	public void getColumnWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.getColumnDefaultDB(notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getColumnDefaultDB(schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getColumnDefaultDB(schemaName, tableName, notexistCol));
	}
	
	public void getColumnWithDefaultDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getColumnDefaultDB(schemaName, tableName, columnName));
	}
	
	public void getColumnWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getColumn(notexistTab, columnName));
		assertNull(ColumnManager.getColumn(tableName, notexistCol));
	}
	
	public void getColumnWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getColumn(tableName, columnName));
	}
	
	public void getTypeWithDbScTabReturnNull() {
		assertNull(ColumnManager.getType(notexistdb, schemaName, tableName, columnName));
		assertNull(ColumnManager.getType(databaseName, notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getType(databaseName, schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getType(databaseName, schemaName, tableName, notexistCol));
	}
	
	public void getTypeWithDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getType(databaseName, schemaName, tableName, columnName));
	}
	
	public void getTypeWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getType(notexistdb, tableName, columnName));
		assertNull(ColumnManager.getType(databaseName, notexistTab, columnName));
		assertNull(ColumnManager.getType(databaseName, tableName, notexistCol));
	}
	
	public void getTypeWithDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getType(databaseName, tableName, columnName));
	}
	
	public void getTypeWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.getTypeDefaultDB(notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getTypeDefaultDB(schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getTypeDefaultDB(schemaName, tableName, notexistCol));
	}
	
	public void getTypeWithDefaultDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getTypeDefaultDB(schemaName, tableName, columnName));
	}
	
	public void getTypeWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getType(notexistTab, columnName));
		assertNull(ColumnManager.getType(tableName, notexistCol));
	}
	
	public void getTypeWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getType(tableName, columnName));
	}
	
	public void getOrderWithDbScTabReturnNull() {
		assertNull(ColumnManager.getOrder(notexistdb, schemaName, tableName, columnName));
		assertNull(ColumnManager.getOrder(databaseName, notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getOrder(databaseName, schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getOrder(databaseName, schemaName, tableName, notexistCol));
	}
	
	public void getOrderWithDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getOrder(databaseName, schemaName, tableName, columnName));
	}
	
	public void getOrderWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getOrder(notexistdb, tableName, columnName));
		assertNull(ColumnManager.getOrder(databaseName, notexistTab, columnName));
		assertNull(ColumnManager.getOrder(databaseName, tableName, notexistCol));
	}
	
	public void getOrderWithDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getOrder(databaseName, tableName, columnName));
	}
	
	public void getOrderWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.getOrderDefaultDB(notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getOrderDefaultDB(schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getOrderDefaultDB(schemaName, tableName, notexistCol));
	}
	
	public void getOrderWithDefaultDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getOrderDefaultDB(schemaName, tableName, columnName));
	}
	
	public void getOrderWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getOrder(notexistTab, columnName));
		assertNull(ColumnManager.getOrder(tableName, notexistCol));
	}
	
	public void getOrderWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getOrder(tableName, columnName));
	}
	
	public void updateNameWithDbScTabReturnNull() {
		assertNull(ColumnManager.updateName(notexistdb, schemaName, tableName, columnName, newColumnName));
		assertNull(ColumnManager.updateName(databaseName, notexistSchema, tableName, columnName, newColumnName));
		assertNull(ColumnManager.updateName(databaseName, schemaName, notexistTab, columnName, newColumnName));
		assertNull(ColumnManager.updateName(databaseName, schemaName, tableName, notexistCol, newColumnName));
	}
	
	public void updateNameWithDbScTabReturnFalse() {
		assertFalse(ColumnManager.updateName(databaseName, schemaName, tableName, columnName, columnName));
	}
	
	public void updateNameWithDbScTabReturnTrue() {
		assertTrue(ColumnManager.updateName(databaseName, schemaName, tableName, columnName, newColumnName));
	}
	
	public void updateNameWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.updateName(notexistdb, tableName, columnName, newColumnName));
		assertNull(ColumnManager.updateName(databaseName, notexistTab, columnName, newColumnName));
		assertNull(ColumnManager.updateName(databaseName, tableName, notexistCol, newColumnName));
	}
	
	public void updateNameWithDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.updateName(databaseName, tableName, columnName, columnName));
	}
	
	public void updateNameWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.updateName(databaseName, tableName, columnName, newColumnName));
	}
	
	public void updateNameWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.updateNameDefaultDB(notexistSchema, tableName, columnName, newColumnName));
		assertNull(ColumnManager.updateNameDefaultDB(schemaName, notexistTab, columnName, newColumnName));
		assertNull(ColumnManager.updateNameDefaultDB(schemaName, tableName, notexistCol, newColumnName));
	}
	
	public void updateNameWithDefaultDbScTabReturnFalse() {
		assertFalse(ColumnManager.updateNameDefaultDB(schemaName, tableName, columnName, columnName));
	}
	
	public void updateNameWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnManager.updateNameDefaultDB(schemaName, tableName, columnName, newColumnName));
	}
	
	public void updateNameWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.updateName(notexistTab, columnName, newColumnName));
		assertNull(ColumnManager.updateName(tableName, notexistCol, newColumnName));
	}
	
	public void updateNameWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.updateName(tableName, columnName, columnName));
	}
	
	public void updateNameWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.updateName(tableName, columnName, newColumnName));
	}
	
	public void updateTypeWithDbScTabReturnNull() {
		assertNull(ColumnManager.updateType(notexistdb, schemaName, tableName, columnName, Integer.class));
		assertNull(ColumnManager.updateType(databaseName, notexistSchema, tableName, columnName, Integer.class));
		assertNull(ColumnManager.updateType(databaseName, schemaName, notexistTab, columnName, Integer.class));
		assertNull(ColumnManager.updateType(databaseName, schemaName, tableName, notexistCol, Integer.class));
	}
	
	public void updateTypeWithDbScTabReturnFalse() {
		assertFalse(ColumnManager.updateType(databaseName, schemaName, tableName, columnName, String.class));
	}
	
	public void updateTypeWithDbScTabReturnTrue() {
		assertTrue(ColumnManager.updateType(databaseName, schemaName, tableName, columnName, Integer.class));
	}
	
	public void updateTypeWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.updateType(notexistdb, tableName, columnName, Integer.class));
		assertNull(ColumnManager.updateType(databaseName, notexistTab, columnName, Integer.class));
		assertNull(ColumnManager.updateType(databaseName, tableName, notexistCol, Integer.class));
	}
	
	public void updateTypeWithDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.updateType(databaseName, tableName, columnName, String.class));
	}
	
	public void updateTypeWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.updateType(databaseName, tableName, columnName, Integer.class));
	}
	
	public void updateTypeWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.updateTypeDefaultDB(notexistSchema, tableName, columnName, Integer.class));
		assertNull(ColumnManager.updateTypeDefaultDB(schemaName, notexistTab, columnName, Integer.class));
		assertNull(ColumnManager.updateTypeDefaultDB(schemaName, tableName, notexistCol, Integer.class));
	}
	
	public void updateTypeWithDefaultDbScTabReturnFalse() {
		assertFalse(ColumnManager.updateTypeDefaultDB(schemaName, tableName, columnName, String.class));
	}
	
	public void updateTypeWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnManager.updateTypeDefaultDB(schemaName, tableName, columnName, Integer.class));
	}
	
	public void updateTypeWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.updateType(notexistTab, columnName, Integer.class));
		assertNull(ColumnManager.updateType(tableName, notexistCol, Integer.class));
	}
	
	public void updateTypeWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.updateType(tableName, columnName, String.class));
	}
	
	public void updateTypeWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.updateType(tableName, columnName, Integer.class));
	}
	
	public void deleteWithDbScTabReturnNull() {
		assertNull(ColumnManager.delete(notexistdb, schemaName, tableName, newColumnName));
		assertNull(ColumnManager.delete(databaseName, notexistSchema, tableName, newColumnName));
		assertNull(ColumnManager.delete(databaseName, schemaName, notexistTab, newColumnName));
		assertNull(ColumnManager.delete(databaseName, schemaName, tableName, notexistCol));
	}
	
	public void deleteWithDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.delete(databaseName, schemaName, tableName, newColumnName));
	}
	
	public void deleteWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.delete(notexistdb, tableName, newColumnName));
		assertNull(ColumnManager.delete(databaseName, notexistTab, newColumnName));
		assertNull(ColumnManager.delete(databaseName, tableName, notexistCol));
	}
	
	public void deleteWithDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.delete(databaseName, tableName, newColumnName));
	}
	
	public void deleteWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.deleteDefaultDB(notexistSchema, tableName, newColumnName));
		assertNull(ColumnManager.deleteDefaultDB(schemaName, notexistTab, newColumnName));
		assertNull(ColumnManager.deleteDefaultDB(schemaName, tableName, notexistCol));
	}
	
	public void deleteWithDefaultDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.deleteDefaultDB(schemaName, tableName, newColumnName));
	}
	
	public void deleteWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.delete(notexistTab, newColumnName));
		assertNull(ColumnManager.delete(tableName, notexistCol));
	}
	
	public void deleteWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.delete(tableName, newColumnName));
	}
	
	public void existsWithDbScTabReturnFalse() {
		assertFalse(ColumnManager.exists(notexistdb, schemaName, tableName, columnName));
		assertFalse(ColumnManager.exists(databaseName, notexistSchema, tableName, columnName));
		assertFalse(ColumnManager.exists(databaseName, schemaName, notexistTab, columnName));
		assertFalse(ColumnManager.exists(databaseName, schemaName, tableName, notexistCol));
	}
	
	public void existsWithDbScTabReturnTrue() {
		assertTrue(ColumnManager.exists(databaseName, schemaName, tableName, columnName));
	}
	
	public void existsWithDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.exists(notexistdb, tableName, columnName));
		assertFalse(ColumnManager.exists(databaseName, notexistTab, columnName));
		assertFalse(ColumnManager.exists(databaseName, tableName, notexistCol));
	}
	
	public void existsWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.exists(databaseName, tableName, columnName));
	}
	
	public void existsWithDefaultDbScTabReturnFalse() {
		assertFalse(ColumnManager.existsDefaultDB(notexistSchema, tableName, columnName));
		assertFalse(ColumnManager.existsDefaultDB(schemaName, notexistTab, columnName));
		assertFalse(ColumnManager.existsDefaultDB(schemaName, tableName, notexistCol));
	}
	
	public void existsWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnManager.existsDefaultDB(schemaName, tableName, columnName));
	}
	
	public void existsWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.exists(notexistTab, columnName));
		assertFalse(ColumnManager.exists(tableName, notexistCol));
	}
	
	public void existsWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.exists(tableName, columnName));
	}
	
	public void addConstraintWithDbScTabReturnNull() {
		assertNull(ColumnManager.addConstraint(notexistdb, schemaName, tableName, columnName, constraint));
		assertNull(ColumnManager.addConstraint(databaseName, notexistSchema, tableName, columnName, constraint));
		assertNull(ColumnManager.addConstraint(databaseName, schemaName, notexistTab, columnName, constraint));
		assertNull(ColumnManager.addConstraint(databaseName, schemaName, tableName, notexistCol, constraint));
	}
	
	public void addConstraintWithDbScTabReturnFalse() {
		assertFalse(ColumnManager.addConstraint(databaseName, schemaName, tableName, columnName, constraint));
	}
	
	public void addConstraintWithDbScTabReturnTrue() {
		assertTrue(ColumnManager.addConstraint(databaseName, schemaName, tableName, columnName, constraint));
	}
	
	public void addConstraintWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.addConstraint(notexistdb, tableName, columnName, constraint));
		assertNull(ColumnManager.addConstraint(databaseName, notexistTab, columnName, constraint));
		assertNull(ColumnManager.addConstraint(databaseName, tableName, notexistCol, constraint));
	}
	
	public void addConstraintWithDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.addConstraint(databaseName, tableName, columnName, constraint));
	}
	
	public void addConstraintWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.addConstraint(databaseName, tableName, columnName, constraint));
	}
	
	public void addConstraintWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.addConstraintDefaultDB(notexistSchema, tableName, columnName, constraint));
		assertNull(ColumnManager.addConstraintDefaultDB(schemaName, notexistTab, columnName, constraint));
		assertNull(ColumnManager.addConstraintDefaultDB(schemaName, tableName, notexistCol, constraint));
	}
	
	public void addConstraintWithDefaultDbScTabReturnFalse() {
		assertFalse(ColumnManager.addConstraintDefaultDB(schemaName, tableName, columnName, constraint));
	}
	
	public void addConstraintWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnManager.addConstraintDefaultDB(schemaName, tableName, columnName, constraint));
	}
	
	public void addConstraintWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.addConstraint(notexistTab, columnName, constraint));
		assertNull(ColumnManager.addConstraint(tableName, notexistCol, constraint));
	}
	
	public void addConstraintWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.addConstraint(tableName, columnName, constraint));
	}
	
	public void addConstraintWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.addConstraint(tableName, columnName, constraint));
	}
	
	public void getConstraintWithDbScTabReturnNull() {
		assertNull(ColumnManager.getConstraint(notexistdb, schemaName, tableName, columnName, constraintName));
		assertNull(ColumnManager.getConstraint(databaseName, notexistSchema, tableName, columnName, constraintName));
		assertNull(ColumnManager.getConstraint(databaseName, schemaName, notexistTab, columnName, constraintName));
		assertNull(ColumnManager.getConstraint(databaseName, schemaName, tableName, notexistCol, constraintName));
		assertNull(ColumnManager.getConstraint(databaseName, schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void getConstraintWithDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getConstraint(databaseName, schemaName, tableName, columnName, constraintName));
	}
	
	public void getConstraintWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getConstraint(notexistdb, tableName, columnName, constraintName));
		assertNull(ColumnManager.getConstraint(databaseName, notexistTab, columnName, constraintName));
		assertNull(ColumnManager.getConstraint(databaseName, tableName, notexistCol, constraintName));
		assertNull(ColumnManager.getConstraint(databaseName, tableName, columnName, notexistConstraint));
	}
	
	public void getConstraintWithDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getConstraint(databaseName, tableName, columnName, constraintName));
	}
	
	public void getConstraintWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.getConstraintDefaultDB(notexistSchema, tableName, columnName, constraintName));
		assertNull(ColumnManager.getConstraintDefaultDB(schemaName, notexistTab, columnName, constraintName));
		assertNull(ColumnManager.getConstraintDefaultDB(schemaName, tableName, notexistCol, constraintName));
		assertNull(ColumnManager.getConstraintDefaultDB(schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void getConstraintWithDefaultDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getConstraintDefaultDB(schemaName, tableName, columnName, constraintName));
	}
	
	public void getConstraintWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getConstraint(notexistTab, columnName, constraintName));
		assertNull(ColumnManager.getConstraint(tableName, notexistCol, constraintName));
		assertNull(ColumnManager.getConstraint(tableName, columnName, notexistConstraint));
	}
	
	public void getConstraintWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getConstraint(tableName, columnName, constraintName));
	}
	
	public void getAllConstraintsWithDbScTabReturnNull() {
		assertNull(ColumnManager.getAllConstraints(notexistdb, schemaName, tableName, columnName));
		assertNull(ColumnManager.getAllConstraints(databaseName, notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getAllConstraints(databaseName, schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getAllConstraints(databaseName, schemaName, tableName, notexistCol));
	}
	
	public void getAllConstraintsWithDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getAllConstraints(databaseName, schemaName, tableName, columnName));
	}
	
	public void getAllConstraintsWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getAllConstraints(notexistdb, tableName, columnName));
		assertNull(ColumnManager.getAllConstraints(databaseName, notexistTab, columnName));
		assertNull(ColumnManager.getAllConstraints(databaseName, tableName, notexistCol));
	}
	
	public void getAllConstraintsWithDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getAllConstraints(databaseName, tableName, columnName));
	}
	
	public void getAllConstraintsWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.getAllConstraintsDefaultDB(notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getAllConstraintsDefaultDB(schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getAllConstraintsDefaultDB(schemaName, tableName, notexistCol));
	}
	
	public void getAllConstraintsWithDefaultDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getAllConstraintsDefaultDB(schemaName, tableName, columnName));
	}
	
	public void getAllConstraintsWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getAllConstraints(notexistTab, columnName));
		assertNull(ColumnManager.getAllConstraints(tableName, notexistCol));
	}
	
	public void getAllConstraintsWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getAllConstraints(tableName, columnName));
	}
	
	public void deleteConstraintWithDbScTabReturnNull() {
		assertNull(ColumnManager.deleteConstraint(notexistdb, schemaName, tableName, columnName, constraintName));
		assertNull(ColumnManager.deleteConstraint(databaseName, notexistSchema, tableName, columnName, constraintName));
		assertNull(ColumnManager.deleteConstraint(databaseName, schemaName, notexistTab, columnName, constraintName));
		assertNull(ColumnManager.deleteConstraint(databaseName, schemaName, tableName, notexistCol, constraintName));
	}
	
	public void deleteConstraintWithDbScTabReturnFalse() {
		assertFalse(ColumnManager.deleteConstraint(databaseName, schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void deleteConstraintWithDbScTabReturnTrue() {
		assertTrue(ColumnManager.deleteConstraint(databaseName, schemaName, tableName, columnName, constraintName));
	}
	
	public void deleteConstraintWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.deleteConstraint(notexistdb, tableName, columnName, constraintName));
		assertNull(ColumnManager.deleteConstraint(databaseName, notexistTab, columnName, constraintName));
		assertNull(ColumnManager.deleteConstraint(databaseName, tableName, notexistCol, constraintName));
	}
	
	public void deleteConstraintWithDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.deleteConstraint(databaseName, tableName, columnName, notexistConstraint));
	}
	
	public void deleteConstraintWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.deleteConstraint(databaseName, tableName, columnName, constraintName));
	}
	
	public void deleteConstraintWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.deleteConstraintDefaultDB(notexistSchema, tableName, columnName, constraintName));
		assertNull(ColumnManager.deleteConstraintDefaultDB(schemaName, notexistTab, columnName, constraintName));
		assertNull(ColumnManager.deleteConstraintDefaultDB(schemaName, tableName, notexistCol, constraintName));
	}
	
	public void deleteConstraintWithDefaultDbScTabReturnFalse() {
		assertFalse(ColumnManager.deleteConstraintDefaultDB(schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void deleteConstraintWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnManager.deleteConstraintDefaultDB(schemaName, tableName, columnName, constraintName));
	}
	
	public void deleteConstraintWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.deleteConstraint(notexistTab, columnName, constraintName));
		assertNull(ColumnManager.deleteConstraint(tableName, notexistCol, constraintName));
	}
	
	public void deleteConstraintWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.deleteConstraint(tableName, columnName, notexistConstraint));
	}
	
	public void deleteConstraintWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.deleteConstraint(tableName, columnName, constraintName));
	}
	
	public void existsConstraintWithDbScTabReturnFalse() {
		assertFalse(ColumnManager.existsConstraint(notexistdb, schemaName, tableName, columnName, constraintName));
		assertFalse(ColumnManager.existsConstraint(databaseName, notexistSchema, tableName, columnName, constraintName));
		assertFalse(ColumnManager.existsConstraint(databaseName, schemaName, notexistTab, columnName, constraintName));
		assertFalse(ColumnManager.existsConstraint(databaseName, schemaName, tableName, notexistCol, constraintName));
		assertFalse(ColumnManager.existsConstraint(databaseName, schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void existsConstraintWithDbScTabReturnTrue() {
		assertTrue(ColumnManager.existsConstraint(databaseName, schemaName, tableName, columnName, constraintName));
	}
	
	public void existsConstraintWithDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.existsConstraint(notexistdb, tableName, columnName, constraintName));
		assertFalse(ColumnManager.existsConstraint(databaseName, notexistTab, columnName, constraintName));
		assertFalse(ColumnManager.existsConstraint(databaseName, tableName, notexistCol, constraintName));
		assertFalse(ColumnManager.existsConstraint(databaseName, tableName, columnName, notexistConstraint));
	}
	
	public void existsConstraintWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.existsConstraint(databaseName, tableName, columnName, constraintName));
	}
	
	public void existsConstraintWithDefaultDbScTabReturnFalse() {
		assertFalse(ColumnManager.existsConstraintDefaultDB(notexistSchema, tableName, columnName, constraintName));
		assertFalse(ColumnManager.existsConstraintDefaultDB(schemaName, notexistTab, columnName, constraintName));
		assertFalse(ColumnManager.existsConstraintDefaultDB(schemaName, tableName, notexistCol, constraintName));
		assertFalse(ColumnManager.existsConstraintDefaultDB(schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void existsConstraintWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnManager.existsConstraintDefaultDB(schemaName, tableName, columnName, constraintName));
	}
	
	public void existsConstraintWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(ColumnManager.existsConstraint(notexistTab, columnName, constraintName));
		assertFalse(ColumnManager.existsConstraint(tableName, notexistCol, constraintName));
		assertFalse(ColumnManager.existsConstraint(tableName, columnName, notexistConstraint));
	}
	
	public void existsConstraintWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnManager.existsConstraint(tableName, columnName, constraintName));
	}
	
	public void getAllNamesConstraintsWithDbScTabReturnNull() {
		assertNull(ColumnManager.getAllNamesConstraints(notexistdb, schemaName, tableName, columnName));
		assertNull(ColumnManager.getAllNamesConstraints(databaseName, notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getAllNamesConstraints(databaseName, schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getAllNamesConstraints(databaseName, schemaName, tableName, notexistCol));
	}
	
	public void getAllNamesConstraintsWithDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getAllNamesConstraints(databaseName, schemaName, tableName, columnName));
	}
	
	public void getAllNamesConstraintsWithDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getAllNamesConstraints(notexistdb, tableName, columnName));
		assertNull(ColumnManager.getAllNamesConstraints(databaseName, notexistTab, columnName));
		assertNull(ColumnManager.getAllNamesConstraints(databaseName, tableName, notexistCol));
	}
	
	public void getAllNamesConstraintsWithDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getAllNamesConstraints(databaseName, tableName, columnName));
	}
	
	public void getAllNamesConstraintsWithDefaultDbScTabReturnNull() {
		assertNull(ColumnManager.getAllNamesConstraintsDefaultDB(notexistSchema, tableName, columnName));
		assertNull(ColumnManager.getAllNamesConstraintsDefaultDB(schemaName, notexistTab, columnName));
		assertNull(ColumnManager.getAllNamesConstraintsDefaultDB(schemaName, tableName, notexistCol));
	}
	
	public void getAllNamesConstraintsWithDefaultDbScTabReturnNotNull() {
		assertNotNull(ColumnManager.getAllNamesConstraintsDefaultDB(schemaName, tableName, columnName));
	}
	
	public void getAllNamesConstraintsWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnManager.getAllNamesConstraints(notexistTab, columnName));
		assertNull(ColumnManager.getAllNamesConstraints(tableName, notexistCol));
	}
	
	public void getAllNamesConstraintsWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnManager.getAllNamesConstraints(tableName, columnName));
	}
}
