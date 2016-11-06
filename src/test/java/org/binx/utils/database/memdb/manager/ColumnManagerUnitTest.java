package org.binx.utils.database.memdb.manager;

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
	private String notexistCol;
	//constraints
	
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
		notexistCol = "notexistCol";
	}
	
	public void testColumnManager() {
		DatabaseListManager.getDatabaseList();
		
		DatabaseManager.createNewDatabase(databaseName);
		DatabaseManager.createNewDatabase(defaultdb);
		DatabaseManager.setToDefault(defaultdb);
		
		SchemaManager.createNewSchema(databaseName, schemaName);
		SchemaManager.createNewSchema(schemaName);
		
		TableManager.createNewTable(databaseName, schemaName, tableName);
		TableManager.createNewTable(databaseName, tableName);
		TableManager.createNewTableDefaultDB(schemaName, tableName);
		TableManager.createNewTable(tableName);
		
		createNewColumnWithDbScTabReturnNull();
		createNewColumnWithDbDefaultScTabReturnNull();
		createNewColumnWithDefaultDbScTabReturnNull();
		createNewColumnWithDefaultDbDefaultScTabReturnNull();
		
		createNewColumnWithDbScTabReturnTrue();
		createNewColumnWithDbScTabReturnFalse();
		createNewColumnWithDbDefaultScTabReturnTrue();
		createNewColumnWithDbDefaultScTabReturnFalse();
		createNewColumnWithDefaultDbScTabReturnTrue();
		createNewColumnWithDefaultDbScTabReturnFalse();
		createNewColumnWithDefaultDbDefaultScTabReturnTrue();
		createNewColumnWithDefaultDbDefaultScTabReturnFalse();
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
}
