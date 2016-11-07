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
	private String newColumnName;
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
		newColumnName = "newColumnName";
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
}
