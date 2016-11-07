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
		getColumnWithDbScTabReturnNull();
		getColumnWithDbDefaultScTabReturnNull();
		getColumnWithDefaultDbScTabReturnNull();
		getColumnWithDefaultDbDefaultScTabReturnNull();
		getTypeWithDbScTabReturnNull();
		getTypeWithDbDefaultScTabReturnNull();
		getTypeWithDefaultDbScTabReturnNull();
		getTypeWithDefaultDbDefaultScTabReturnNull();
		
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
}
