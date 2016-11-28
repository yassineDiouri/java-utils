package org.binx.utils.database.memdb.core.manager;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class ColumnValueManagerUnitTest extends TestCase {

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
	private Class<?> columnType;
	//Col Value
	private String value;
	private Integer diffValue;
	
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
		columnType = String.class;
		
		value = "value";
		diffValue = 3;
		
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

		ColumnManager.createNewColumn(databaseName, schemaName, tableName, columnName, columnType);
		ColumnManager.createNewColumn(databaseName, tableName, columnName, columnType);
		ColumnManager.createNewColumnDefaultDB(schemaName, tableName, columnName, columnType);
		ColumnManager.createNewColumn(tableName, columnName, columnType);

		LineManager.createNewEmptyLine(databaseName, schemaName, tableName);
		LineManager.createNewEmptyLine(databaseName, tableName);
		LineManager.createNewEmptyLineDefaultDB(schemaName, tableName);
		LineManager.createNewEmptyLine(tableName);
	}
	
	public void testColumnValueManager() {
		createNewColumnValueWithDbScTabReturnNull();
		createNewColumnValueWithDbDefaultScTabReturnNull();
		createNewColumnValueWithDefaultDbScTabReturnNull();
		createNewColumnValueWithDefaultDbDefaultScTabReturnNull();
		createNewColumnValueWithValueWithDbScTabReturnNull();
		createNewColumnValueWithValueWithDbDefaultScTabReturnNull();
		createNewColumnValueWithValueWithDefaultDbScTabReturnNull();
		createNewColumnValueWithValueWithDefaultDbDefaultScTabReturnNull();
		getValueWithDbScTabReturnNull();
		getValueWithDbDefaultScTabReturnNull();
		getValueWithDefaultDbScTabReturnNull();
		getValueWithDefaultDbDefaultScTabReturnNull();
		
		createNewColumnValueWithDbScTabReturnTrue();
		createNewColumnValueWithDbDefaultScTabReturnTrue();
		createNewColumnValueWithDefaultDbScTabReturnTrue();
		createNewColumnValueWithDefaultDbDefaultScTabReturnTrue();
		createNewColumnValueWithValueWithDbScTabReturnTrue();
		createNewColumnValueWithValueWithDbDefaultScTabReturnTrue();
		createNewColumnValueWithValueWithDefaultDbScTabReturnTrue();
		createNewColumnValueWithValueWithDefaultDbDefaultScTabReturnTrue();
		getValueWithDbScTabReturnNotNull();
		getValueWithDbDefaultScTabReturnNotNull();
		getValueWithDefaultDbScTabReturnNotNull();
		getValueWithDefaultDbDefaultScTabReturnNotNull();
	}
	
	private void createNewColumnValueWithDbScTabReturnNull() {
		assertNull(ColumnValueManager.createNewColumnValue(notexistdb, schemaName, tableName, 0L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, notexistSchema, tableName, 0L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, notexistTab, 0L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, -1L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 10000L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 0L, -1));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 0L, 10000));
	}
	
	private void createNewColumnValueWithDbScTabReturnTrue() {
		assertTrue(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 0L, 0));
	}
	
	private void createNewColumnValueWithDbDefaultScTabReturnNull() {
		assertNull(ColumnValueManager.createNewColumnValue(notexistdb, tableName, 0L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, notexistTab, 0L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, -1L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, 10000L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, 0L, -1));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, 0L, 10000));
	}
	
	private void createNewColumnValueWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnValueManager.createNewColumnValue(databaseName, tableName, 0L, 0));
	}
	
	private void createNewColumnValueWithDefaultDbScTabReturnNull() {
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(notexistSchema, tableName, 0L, 0));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, notexistTab, 0L, 0));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, -1L, 0));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 10000L, 0));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 0L, -1));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 0L, 10000));
	}
	
	private void createNewColumnValueWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 0L, 0));
	}
	
	private void createNewColumnValueWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnValueManager.createNewColumnValue(notexistTab, 0L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, -1L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, 10000L, 0));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, 0L, -1));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, 0L, 10000));
	}
	
	private void createNewColumnValueWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnValueManager.createNewColumnValue(tableName, 0L, 0));
	}
	
	private void createNewColumnValueWithValueWithDbScTabReturnNull() {
		assertNull(ColumnValueManager.createNewColumnValue(notexistdb, schemaName, tableName, 0L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, notexistSchema, tableName, 0L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, notexistTab, 0L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, -1L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 10000L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 0L, -1, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 0L, 10000, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 0L, 0, diffValue));
	}
	
	private void createNewColumnValueWithValueWithDbScTabReturnTrue() {
		assertTrue(ColumnValueManager.createNewColumnValue(databaseName, schemaName, tableName, 0L, 0, value));
	}
	
	private void createNewColumnValueWithValueWithDbDefaultScTabReturnNull() {
		assertNull(ColumnValueManager.createNewColumnValue(notexistdb, tableName, 0L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, notexistTab, 0L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, -1L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, 10000L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, 0L, -1, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, 0L, 10000, value));
		assertNull(ColumnValueManager.createNewColumnValue(databaseName, tableName, 0L, 0, diffValue));
	}
	
	private void createNewColumnValueWithValueWithDbDefaultScTabReturnTrue() {
		assertTrue(ColumnValueManager.createNewColumnValue(databaseName, tableName, 0L, 0, value));
	}
	
	private void createNewColumnValueWithValueWithDefaultDbScTabReturnNull() {
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(notexistSchema, tableName, 0L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, notexistTab, 0L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, -1L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 10000L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 0L, -1, value));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 0L, 10000, value));
		assertNull(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 0L, 0, diffValue));
	}
	
	private void createNewColumnValueWithValueWithDefaultDbScTabReturnTrue() {
		assertTrue(ColumnValueManager.createNewColumnValueDefaultDB(schemaName, tableName, 0L, 0, value));
	}
	
	private void createNewColumnValueWithValueWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnValueManager.createNewColumnValue(notexistTab, 0L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, -1L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, 10000L, 0, value));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, 0L, -1, value));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, 0L, 10000, value));
		assertNull(ColumnValueManager.createNewColumnValue(tableName, 0L, 0, diffValue));
	}
	
	private void createNewColumnValueWithValueWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(ColumnValueManager.createNewColumnValue(tableName, 0L, 0, value));
	}
	
	private void getValueWithDbScTabReturnNull() {
		assertNull(ColumnValueManager.getValue(notexistdb, schemaName, tableName, 0L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, notexistSchema, tableName, 0L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, schemaName, notexistTab, 0L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, schemaName, tableName, -1L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, schemaName, tableName, 10000L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, schemaName, tableName, 0L, -1));
		assertNull(ColumnValueManager.getValue(databaseName, schemaName, tableName, 0L, 10000));
	}
	
	private void getValueWithDbScTabReturnNotNull() {
		assertNotNull(ColumnValueManager.getValue(databaseName, schemaName, tableName, 0L, 0));
	}
	
	private void getValueWithDbDefaultScTabReturnNull() {
		assertNull(ColumnValueManager.getValue(notexistdb, tableName, 0L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, notexistTab, 0L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, tableName, -1L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, tableName, 10000L, 0));
		assertNull(ColumnValueManager.getValue(databaseName, tableName, 0L, -1));
		assertNull(ColumnValueManager.getValue(databaseName, tableName, 0L, 10000));
	}
	
	private void getValueWithDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnValueManager.getValue(databaseName, tableName, 0L, 0));
	}
	
	private void getValueWithDefaultDbScTabReturnNull() {
		assertNull(ColumnValueManager.getValueDefaultDB(notexistSchema, tableName, 0L, 0));
		assertNull(ColumnValueManager.getValueDefaultDB(schemaName, notexistTab, 0L, 0));
		assertNull(ColumnValueManager.getValueDefaultDB(schemaName, tableName, -1L, 0));
		assertNull(ColumnValueManager.getValueDefaultDB(schemaName, tableName, 10000L, 0));
		assertNull(ColumnValueManager.getValueDefaultDB(schemaName, tableName, 0L, -1));
		assertNull(ColumnValueManager.getValueDefaultDB(schemaName, tableName, 0L, 10000));
	}
	
	private void getValueWithDefaultDbScTabReturnNotNull() {
		assertNotNull(ColumnValueManager.getValueDefaultDB(schemaName, tableName, 0L, 0));
	}
	
	private void getValueWithDefaultDbDefaultScTabReturnNull() {
		assertNull(ColumnValueManager.getValue(notexistTab, 0L, 0));
		assertNull(ColumnValueManager.getValue(tableName, -1L, 0));
		assertNull(ColumnValueManager.getValue(tableName, 10000L, 0));
		assertNull(ColumnValueManager.getValue(tableName, 0L, -1));
		assertNull(ColumnValueManager.getValue(tableName, 0L, 10000));
	}
	
	private void getValueWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(ColumnValueManager.getValue(tableName, 0L, 0));
	}
}
