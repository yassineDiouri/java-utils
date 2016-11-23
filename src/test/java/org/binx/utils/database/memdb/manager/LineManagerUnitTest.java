package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class LineManagerUnitTest extends TestCase {

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
	//lines
	//col values
	private ColumnValue columnValue;
	private ColumnValue columnValueNull;
	private ColumnValue columnValueDiffType;
	private ColumnValue columnValueDiffOrder;
	
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

		columnValue = ColumnValueGenerator.getColumnValue("columnValue");
		columnValue.setOrder(0);
		columnValueNull = ColumnValueGenerator.getColumnValue();
		columnValueNull.setOrder(0);
		columnValueDiffType = ColumnValueGenerator.getColumnValue(new Integer(100));
		columnValueDiffType.setOrder(0);
		columnValueDiffOrder = ColumnValueGenerator.getColumnValue();
		columnValueDiffOrder.setOrder(10000);
	}
	
	public void testLineManager() {
		createNewEmptyLineWithDbScTabReturnNull();
		createNewEmptyLineWithDbDefaultScTabReturnNull();
		createNewEmptyLineWithDefaultDbScTabReturnNull();
		createNewEmptyLineWithDefaultDbDefaultScTabReturnNull();
		getLineWithDbScTabReturnNull();
		getLineWithDbDefaultScTabReturnNull();
		getLineWithDefaultDbScTabReturnNull();
		getLineWithDefaultDbDefaultScTabReturnNull();
		deleteWithDbScTabReturnNull();
		deleteWithDbDefaultScTabReturnNull();
		deleteWithDefaultDbScTabReturnNull();
		deleteWithDefaultDbDefaultScTabReturnNull();

		createNewEmptyLineWithDbScTabReturnNotNull();
		createNewEmptyLineWithDbDefaultScTabReturnNotNull();
		createNewEmptyLineWithDefaultDbScTabReturnNotNull();
		createNewEmptyLineWithDefaultDbDefaultScTabReturnNotNull();
		getLineWithDbScTabReturnNotNull();
		getLineWithDbDefaultScTabReturnNotNull();
		getLineWithDefaultDbScTabReturnNotNull();
		getLineWithDefaultDbDefaultScTabReturnNotNull();
		addColumnValueWithDbScTabReturnNull();
		addColumnValueWithDbDefaultScTabReturnNull();
		addColumnValueWithDefaultDbScTabReturnNull();
		addColumnValueWithDefaultDbDefaultScTabReturnNull();
		addColumnValueWithDbScTabReturnTrue();
		addColumnValueWithDbDefaultScTabReturnTrue();
		addColumnValueWithDefaultDbScTabReturnTrue();
		addColumnValueWithDefaultDbDefaultScTabReturnTrue();
		getColumnValueWithDbScTabReturnNull();
		getColumnValueWithDbDefaultScTabReturnNull();
		getColumnValueWithDefaultDbScTabReturnNull();
		getColumnValueWithDefaultDbDefaultScTabReturnNull();
		getColumnValueWithDbScTabReturnNotNull();
		getColumnValueWithDbDefaultScTabReturnNotNull();
		getColumnValueWithDefaultDbScTabReturnNotNull();
		getColumnValueWithDefaultDbDefaultScTabReturnNotNull();
		getAllColumnValuesWithDbScTabReturnNull();
		getAllColumnValuesWithDbDefaultScTabReturnNull();
		getAllColumnValuesDefaultDbScTabReturnNull();
		getAllColumnValuesDefaultDbDefaultScTabReturnNull();
		getAllColumnValuesWithDbScTabReturnNotNull();
		getAllColumnValuesWithDbDefaultScTabReturnNotNull();
		getAllColumnValuesDefaultDbScTabReturnNotNull();
		getAllColumnValuesDefaultDbDefaultScTabReturnNotNull();
		updateColumnValueWithDbScTabReturnNull();
		updateColumnValueWithDbDefaultScTabReturnNull();
		updateColumnValueWithDefaultDbScTabReturnNull();
		updateColumnValueWithDefaultDbDefaultScTabReturnNull();
		updateColumnValueWithDbScTabReturnTrue();
		updateColumnValueWithDbDefaultScTabReturnTrue();
		updateColumnValueWithDefaultDbScTabReturnTrue();
		updateColumnValueWithDefaultDbDefaultScTabReturnTrue();
		existsColumnValueWithDbScTabReturnFalse();
		existsColumnValueWithDbDefaultScTabReturnFalse();
		existsColumnValueWithDefaultDbScTabReturnFalse();
		existsColumnValueWithDefaultDbDefaultScTabReturnFalse();
		existsColumnValueWithDbScTabReturnTrue();
		existsColumnValueWithDbDefaultScTabReturnTrue();
		existsColumnValueWithDefaultDbScTabReturnTrue();
		existsColumnValueWithDefaultDbDefaultScTabReturnTrue();

		deleteColumnValueWithDbScTabReturnNull();
		deleteColumnValueWithDbDefaultScTabReturnNull();
		deleteColumnValueWithDefaultDbScTabReturnNull();
		deleteColumnValueWithDefaultDbDefaultScTabReturnNull();
		deleteColumnValueWithDbScTabReturnTrue();
		deleteColumnValueWithDbDefaultScTabReturnTrue();
		deleteColumnValueWithDefaultDbScTabReturnTrue();
		deleteColumnValueWithDefaultDbDefaultScTabReturnTrue();
		deleteWithDbScTabReturnTrue();
		deleteWithDbDefaultScTabReturnTrue();
		deleteWithDefaultDbScTabReturnTrue();
		deleteWithDefaultDbDefaultScTabReturnTrue();
	}
	
	private void createNewEmptyLineWithDbScTabReturnNull() {
		assertNull(LineManager.createNewEmptyLine(notexistdb, schemaName, tableName));
		assertNull(LineManager.createNewEmptyLine(databaseName, notexistSchema, tableName));
		assertNull(LineManager.createNewEmptyLine(databaseName, schemaName, notexistTab));
	}
	
	private void createNewEmptyLineWithDbScTabReturnNotNull() {
		assertNotNull(LineManager.createNewEmptyLine(databaseName, schemaName, tableName));
	}
	
	private void createNewEmptyLineWithDbDefaultScTabReturnNull() {
		assertNull(LineManager.createNewEmptyLine(notexistdb, tableName));
		assertNull(LineManager.createNewEmptyLine(databaseName, notexistTab));
	}
	
	private void createNewEmptyLineWithDbDefaultScTabReturnNotNull() {
		assertNotNull(LineManager.createNewEmptyLine(databaseName, tableName));
	}
	
	private void createNewEmptyLineWithDefaultDbScTabReturnNull() {
		assertNull(LineManager.createNewEmptyLineDefaultDB(notexistSchema, tableName));
		assertNull(LineManager.createNewEmptyLineDefaultDB(schemaName, notexistTab));
	}
	
	private void createNewEmptyLineWithDefaultDbScTabReturnNotNull() {
		assertNotNull(LineManager.createNewEmptyLineDefaultDB(schemaName, tableName));
	}
	
	private void createNewEmptyLineWithDefaultDbDefaultScTabReturnNull() {
		assertNull(LineManager.createNewEmptyLine(notexistTab));
	}
	
	private void createNewEmptyLineWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(LineManager.createNewEmptyLine(tableName));
	}
	
	private void getLineWithDbScTabReturnNull() {
		assertNull(LineManager.getLine(notexistdb, schemaName, tableName, 0L));
		assertNull(LineManager.getLine(databaseName, notexistSchema, tableName, 0L));
		assertNull(LineManager.getLine(databaseName, schemaName, notexistTab, 0L));
		assertNull(LineManager.getLine(databaseName, schemaName, tableName, -1L));
		assertNull(LineManager.getLine(databaseName, schemaName, tableName, 10000000L));
	}
	
	private void getLineWithDbScTabReturnNotNull() {
		assertNotNull(LineManager.getLine(databaseName, schemaName, tableName, 0L));
	}
	
	private void getLineWithDbDefaultScTabReturnNull() {
		assertNull(LineManager.getLine(notexistdb, tableName, 0L));
		assertNull(LineManager.getLine(databaseName, notexistTab, 0L));
		assertNull(LineManager.getLine(databaseName, tableName, -1L));
		assertNull(LineManager.getLine(databaseName, tableName, 10000000L));
	}
	
	private void getLineWithDbDefaultScTabReturnNotNull() {
		assertNotNull(LineManager.getLine(databaseName, tableName, 0L));
	}
	
	private void getLineWithDefaultDbScTabReturnNull() {
		assertNull(LineManager.getLineDefaultDB(notexistSchema, tableName, 0L));
		assertNull(LineManager.getLineDefaultDB(schemaName, notexistTab, 0L));
		assertNull(LineManager.getLineDefaultDB(schemaName, tableName, -1L));
		assertNull(LineManager.getLineDefaultDB(schemaName, tableName, 10000000L));
	}
	
	private void getLineWithDefaultDbScTabReturnNotNull() {
		assertNotNull(LineManager.getLineDefaultDB(schemaName, tableName, 0L));
	}
	
	private void getLineWithDefaultDbDefaultScTabReturnNull() {
		assertNull(LineManager.getLine(notexistTab, 0L));
		assertNull(LineManager.getLine(tableName, -1L));
		assertNull(LineManager.getLine(tableName, 10000000L));
	}
	
	private void getLineWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(LineManager.getLine(tableName, 0L));
	}
	
	private void deleteWithDbScTabReturnNull() {
		assertNull(LineManager.delete(notexistdb, schemaName, tableName, 0L));
		assertNull(LineManager.delete(databaseName, notexistSchema, tableName, 0L));
		assertNull(LineManager.delete(databaseName, schemaName, notexistTab, 0L));
		assertNull(LineManager.delete(databaseName, schemaName, tableName, -1L));
		assertNull(LineManager.delete(databaseName, schemaName, tableName, 1000000L));
	}
	
	private void deleteWithDbScTabReturnTrue() {
		assertTrue(LineManager.delete(databaseName, schemaName, tableName, 0L));
	}
	
	private void deleteWithDbDefaultScTabReturnNull() {
		assertNull(LineManager.delete(notexistdb, tableName, 0L));
		assertNull(LineManager.delete(databaseName, notexistTab, 0L));
		assertNull(LineManager.delete(databaseName, tableName, -1L));
		assertNull(LineManager.delete(databaseName, tableName, 1000000L));
	}
	
	private void deleteWithDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.delete(databaseName, tableName, 0L));
	}
	
	private void deleteWithDefaultDbScTabReturnNull() {
		assertNull(LineManager.deleteDefaultDB(notexistSchema, tableName, 0L));
		assertNull(LineManager.deleteDefaultDB(schemaName, notexistTab, 0L));
		assertNull(LineManager.deleteDefaultDB(schemaName, tableName, -1L));
		assertNull(LineManager.deleteDefaultDB(schemaName, tableName, 1000000L));
	}
	
	private void deleteWithDefaultDbScTabReturnTrue() {
		assertTrue(LineManager.deleteDefaultDB(schemaName, tableName, 0L));
	}
	
	private void deleteWithDefaultDbDefaultScTabReturnNull() {
		assertNull(LineManager.delete(notexistTab, 0L));
		assertNull(LineManager.delete(tableName, -1L));
		assertNull(LineManager.delete(tableName, 1000000L));
	}
	
	private void deleteWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.delete(tableName, 0L));
	}
	
	private void addColumnValueWithDbScTabReturnNull() {
		assertNull(LineManager.addColumnValue(notexistdb, schemaName, tableName, 0L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, notexistSchema, tableName, 0L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, schemaName, notexistTab, 0L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, schemaName, tableName, -1L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, schemaName, tableName, 100000L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, schemaName, tableName, 0L, columnValueDiffType));
		assertNull(LineManager.addColumnValue(databaseName, schemaName, tableName, 0L, columnValueDiffOrder));
	}
	
	private void addColumnValueWithDbScTabReturnTrue() {
		assertTrue(LineManager.addColumnValue(databaseName, schemaName, tableName, 0L, columnValueNull));
		assertTrue(LineManager.addColumnValue(databaseName, schemaName, tableName, 0L, columnValue));
	}
	
	private void addColumnValueWithDbDefaultScTabReturnNull() {
		assertNull(LineManager.addColumnValue(notexistdb, tableName, 0L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, notexistTab, 0L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, tableName, -1L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, tableName, 100000L, columnValue));
		assertNull(LineManager.addColumnValue(databaseName, tableName, 0L, columnValueDiffType));
		assertNull(LineManager.addColumnValue(databaseName, tableName, 0L, columnValueDiffOrder));
	}
	
	private void addColumnValueWithDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.addColumnValue(databaseName, tableName, 0L, columnValueNull));
		assertTrue(LineManager.addColumnValue(databaseName, tableName, 0L, columnValue));
	}
	
	private void addColumnValueWithDefaultDbScTabReturnNull() {
		assertNull(LineManager.addColumnValueDefaultDB(notexistSchema, tableName, 0L, columnValue));
		assertNull(LineManager.addColumnValueDefaultDB(schemaName, notexistTab, 0L, columnValue));
		assertNull(LineManager.addColumnValueDefaultDB(schemaName, tableName, -1L, columnValue));
		assertNull(LineManager.addColumnValueDefaultDB(schemaName, tableName, 100000L, columnValue));
		assertNull(LineManager.addColumnValueDefaultDB(schemaName, tableName, 0L, columnValueDiffType));
		assertNull(LineManager.addColumnValueDefaultDB(schemaName, tableName, 0L, columnValueDiffOrder));
	}
	
	private void addColumnValueWithDefaultDbScTabReturnTrue() {
		assertTrue(LineManager.addColumnValueDefaultDB(schemaName, tableName, 0L, columnValueNull));
		assertTrue(LineManager.addColumnValueDefaultDB(schemaName, tableName, 0L, columnValue));
	}
	
	private void addColumnValueWithDefaultDbDefaultScTabReturnNull() {
		assertNull(LineManager.addColumnValue(notexistTab, 0L, columnValue));
		assertNull(LineManager.addColumnValue(tableName, -1L, columnValue));
		assertNull(LineManager.addColumnValue(tableName, 100000L, columnValue));
		assertNull(LineManager.addColumnValue(tableName, 0L, columnValueDiffType));
		assertNull(LineManager.addColumnValue(tableName, 0L, columnValueDiffOrder));
	}
	
	private void addColumnValueWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.addColumnValue(tableName, 0L, columnValueNull));
		assertTrue(LineManager.addColumnValue(tableName, 0L, columnValue));
	}
	
	private void getColumnValueWithDbScTabReturnNull() {
		assertNull(LineManager.getColumnValue(notexistdb, schemaName, tableName, 0L, 0));
		assertNull(LineManager.getColumnValue(databaseName, notexistSchema, tableName, 0L, 0));
		assertNull(LineManager.getColumnValue(databaseName, schemaName, notexistTab, 0L, 0));
		assertNull(LineManager.getColumnValue(databaseName, schemaName, tableName, -1L, 0));
		assertNull(LineManager.getColumnValue(databaseName, schemaName, tableName, 1000000L, 0));
		assertNull(LineManager.getColumnValue(databaseName, schemaName, tableName, 0L, -1));
		assertNull(LineManager.getColumnValue(databaseName, schemaName, tableName, 0L, 100000));
	}
	
	private void getColumnValueWithDbScTabReturnNotNull() {
		assertNotNull(LineManager.getColumnValue(databaseName, schemaName, tableName, 0L, 0));
	}
	
	private void getColumnValueWithDbDefaultScTabReturnNull() {
		assertNull(LineManager.getColumnValue(notexistdb, tableName, 0L, 0));
		assertNull(LineManager.getColumnValue(databaseName, notexistTab, 0L, 0));
		assertNull(LineManager.getColumnValue(databaseName, tableName, -1L, 0));
		assertNull(LineManager.getColumnValue(databaseName, tableName, 1000000L, 0));
		assertNull(LineManager.getColumnValue(databaseName, tableName, 0L, -1));
		assertNull(LineManager.getColumnValue(databaseName, tableName, 0L, 100000));
	}
	
	private void getColumnValueWithDbDefaultScTabReturnNotNull() {
		assertNotNull(LineManager.getColumnValue(databaseName, tableName, 0L, 0));
	}
	
	private void getColumnValueWithDefaultDbScTabReturnNull() {
		assertNull(LineManager.getColumnValueDefaultDB(notexistSchema, tableName, 0L, 0));
		assertNull(LineManager.getColumnValueDefaultDB(schemaName, notexistTab, 0L, 0));
		assertNull(LineManager.getColumnValueDefaultDB(schemaName, tableName, -1L, 0));
		assertNull(LineManager.getColumnValueDefaultDB(schemaName, tableName, 1000000L, 0));
		assertNull(LineManager.getColumnValueDefaultDB(schemaName, tableName, 0L, -1));
		assertNull(LineManager.getColumnValueDefaultDB(schemaName, tableName, 0L, 100000));
	}
	
	private void getColumnValueWithDefaultDbScTabReturnNotNull() {
		assertNotNull(LineManager.getColumnValueDefaultDB(schemaName, tableName, 0L, 0));
	}
	
	private void getColumnValueWithDefaultDbDefaultScTabReturnNull() {
		assertNull(LineManager.getColumnValue(notexistTab, 0L, 0));
		assertNull(LineManager.getColumnValue(tableName, -1L, 0));
		assertNull(LineManager.getColumnValue(tableName, 1000000L, 0));
		assertNull(LineManager.getColumnValue(tableName, 0L, -1));
		assertNull(LineManager.getColumnValue(tableName, 0L, 100000));
	}
	
	private void getColumnValueWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(LineManager.getColumnValue(tableName, 0L, 0));
	}
	
	private void getAllColumnValuesWithDbScTabReturnNull() {
		assertNull(LineManager.getAllColumnValues(notexistdb, schemaName, tableName, 0L));
		assertNull(LineManager.getAllColumnValues(databaseName, notexistSchema, tableName, 0L));
		assertNull(LineManager.getAllColumnValues(databaseName, schemaName, notexistTab, 0L));
		assertNull(LineManager.getAllColumnValues(databaseName, schemaName, tableName, -1L));
		assertNull(LineManager.getAllColumnValues(databaseName, schemaName, tableName, 100000L));
	}
	
	private void getAllColumnValuesWithDbScTabReturnNotNull() {
		assertNotNull(LineManager.getAllColumnValues(databaseName, schemaName, tableName, 0L));
	}
	
	private void getAllColumnValuesWithDbDefaultScTabReturnNull() {
		assertNull(LineManager.getAllColumnValues(notexistdb, tableName, 0L));
		assertNull(LineManager.getAllColumnValues(databaseName, notexistTab, 0L));
		assertNull(LineManager.getAllColumnValues(databaseName, tableName, -1L));
		assertNull(LineManager.getAllColumnValues(databaseName, tableName, 100000L));
	}
	
	private void getAllColumnValuesWithDbDefaultScTabReturnNotNull() {
		assertNotNull(LineManager.getAllColumnValues(databaseName, tableName, 0L));
	}
	
	private void getAllColumnValuesDefaultDbScTabReturnNull() {
		assertNull(LineManager.getAllColumnValuesDefaultDB(notexistSchema, tableName, 0L));
		assertNull(LineManager.getAllColumnValuesDefaultDB(schemaName, notexistTab, 0L));
		assertNull(LineManager.getAllColumnValuesDefaultDB(schemaName, tableName, -1L));
		assertNull(LineManager.getAllColumnValuesDefaultDB(schemaName, tableName, 100000L));
	}
	
	private void getAllColumnValuesDefaultDbScTabReturnNotNull() {
		assertNotNull(LineManager.getAllColumnValuesDefaultDB(schemaName, tableName, 0L));
	}
	
	private void getAllColumnValuesDefaultDbDefaultScTabReturnNull() {
		assertNull(LineManager.getAllColumnValues(notexistdb, tableName, 0L));
		assertNull(LineManager.getAllColumnValues(notexistTab, 0L));
		assertNull(LineManager.getAllColumnValues(tableName, -1L));
		assertNull(LineManager.getAllColumnValues(tableName, 100000L));
	}
	
	private void getAllColumnValuesDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(LineManager.getAllColumnValues(tableName, 0L));
	}
	
	private void updateColumnValueWithDbScTabReturnNull() {
		assertNull(LineManager.updateColumnValue(notexistdb, schemaName, tableName, 0L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, notexistSchema, tableName, 0L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, schemaName, notexistTab, 0L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, schemaName, tableName, -1L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, schemaName, tableName, 100000L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, schemaName, tableName, 0L, -1, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, schemaName, tableName, 0L, 10000, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, schemaName, tableName, 0L, 0, new Integer(10)));
	}
	
	private void updateColumnValueWithDbScTabReturnTrue() {
		assertTrue(LineManager.updateColumnValue(databaseName, schemaName, tableName, 0L, 0, null));
		assertTrue(LineManager.updateColumnValue(databaseName, schemaName, tableName, 0L, 0, new String("value")));
	}
	
	private void updateColumnValueWithDbDefaultScTabReturnNull() {
		assertNull(LineManager.updateColumnValue(notexistdb, tableName, 0L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, notexistTab, 0L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, tableName, -1L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, tableName, 100000L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, tableName, 0L, -1, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, tableName, 0L, 10000, new String("value")));
		assertNull(LineManager.updateColumnValue(databaseName, tableName, 0L, 0, new Integer(10)));
	}
	
	private void updateColumnValueWithDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.updateColumnValue(databaseName, tableName, 0L, 0, null));
		assertTrue(LineManager.updateColumnValue(databaseName, tableName, 0L, 0, new String("value")));
	}
	
	private void updateColumnValueWithDefaultDbScTabReturnNull() {
		assertNull(LineManager.updateColumnValueDefaultDB(notexistSchema, tableName, 0L, 0, new String("value")));
		assertNull(LineManager.updateColumnValueDefaultDB(schemaName, notexistTab, 0L, 0, new String("value")));
		assertNull(LineManager.updateColumnValueDefaultDB(schemaName, tableName, -1L, 0, new String("value")));
		assertNull(LineManager.updateColumnValueDefaultDB(schemaName, tableName, 100000L, 0, new String("value")));
		assertNull(LineManager.updateColumnValueDefaultDB(schemaName, tableName, 0L, -1, new String("value")));
		assertNull(LineManager.updateColumnValueDefaultDB(schemaName, tableName, 0L, 10000, new String("value")));
		assertNull(LineManager.updateColumnValueDefaultDB(schemaName, tableName, 0L, 0, new Integer(10)));
	}
	
	private void updateColumnValueWithDefaultDbScTabReturnTrue() {
		assertTrue(LineManager.updateColumnValueDefaultDB(schemaName, tableName, 0L, 0, null));
		assertTrue(LineManager.updateColumnValueDefaultDB(schemaName, tableName, 0L, 0, new String("value")));
	}
	
	private void updateColumnValueWithDefaultDbDefaultScTabReturnNull() {
		assertNull(LineManager.updateColumnValue(notexistTab, 0L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(tableName, -1L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(tableName, 100000L, 0, new String("value")));
		assertNull(LineManager.updateColumnValue(tableName, 0L, -1, new String("value")));
		assertNull(LineManager.updateColumnValue(tableName, 0L, 10000, new String("value")));
		assertNull(LineManager.updateColumnValue(tableName, 0L, 0, new Integer(10)));
	}
	
	private void updateColumnValueWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.updateColumnValue(tableName, 0L, 0, null));
		assertTrue(LineManager.updateColumnValue(tableName, 0L, 0, new String("value")));
	}
	
	private void deleteColumnValueWithDbScTabReturnNull() {
		assertNull(LineManager.deleteColumnValue(notexistdb, schemaName, tableName, 0L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, notexistSchema, tableName, 0L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, schemaName, notexistTab, 0L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, schemaName, tableName, -1L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, schemaName, tableName, 100000L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, schemaName, tableName, 0L, -1));
		assertNull(LineManager.deleteColumnValue(databaseName, schemaName, tableName, 0L, 1000));
	}
	
	private void deleteColumnValueWithDbScTabReturnTrue() {
		assertTrue(LineManager.deleteColumnValue(databaseName, schemaName, tableName, 0L, 0));
	}
	
	private void deleteColumnValueWithDbDefaultScTabReturnNull() {
		assertNull(LineManager.deleteColumnValue(notexistdb, tableName, 0L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, notexistTab, 0L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, tableName, -1L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, tableName, 100000L, 0));
		assertNull(LineManager.deleteColumnValue(databaseName, tableName, 0L, -1));
		assertNull(LineManager.deleteColumnValue(databaseName, tableName, 0L, 1000));
	}
	
	private void deleteColumnValueWithDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.deleteColumnValue(databaseName, tableName, 0L, 0));
	}
	
	private void deleteColumnValueWithDefaultDbScTabReturnNull() {
		assertNull(LineManager.deleteColumnValueDefaultDB(notexistSchema, tableName, 0L, 0));
		assertNull(LineManager.deleteColumnValueDefaultDB(schemaName, notexistTab, 0L, 0));
		assertNull(LineManager.deleteColumnValueDefaultDB(schemaName, tableName, -1L, 0));
		assertNull(LineManager.deleteColumnValueDefaultDB(schemaName, tableName, 100000L, 0));
		assertNull(LineManager.deleteColumnValueDefaultDB(schemaName, tableName, 0L, -1));
		assertNull(LineManager.deleteColumnValueDefaultDB(schemaName, tableName, 0L, 1000));
	}
	
	private void deleteColumnValueWithDefaultDbScTabReturnTrue() {
		assertTrue(LineManager.deleteColumnValueDefaultDB(schemaName, tableName, 0L, 0));
	}
	
	private void deleteColumnValueWithDefaultDbDefaultScTabReturnNull() {
		assertNull(LineManager.deleteColumnValue(notexistTab, 0L, 0));
		assertNull(LineManager.deleteColumnValue(tableName, -1L, 0));
		assertNull(LineManager.deleteColumnValue(tableName, 100000L, 0));
		assertNull(LineManager.deleteColumnValue(tableName, 0L, -1));
		assertNull(LineManager.deleteColumnValue(tableName, 0L, 1000));
	}
	
	private void deleteColumnValueWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.deleteColumnValue(tableName, 0L, 0));
	}
	
	private void existsColumnValueWithDbScTabReturnFalse() {
		assertFalse(LineManager.existsColumnValue(notexistdb, schemaName, tableName, 0L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, notexistSchema, tableName, 0L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, schemaName, notexistTab, 0L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, schemaName, tableName, -1L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, schemaName, tableName, 10000L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, schemaName, tableName, 0L, -1));
		assertFalse(LineManager.existsColumnValue(databaseName, schemaName, tableName, 0L, 10000));
	}
	
	private void existsColumnValueWithDbScTabReturnTrue() {
		assertTrue(LineManager.existsColumnValue(databaseName, schemaName, tableName, 0L, 0));
	}
	
	private void existsColumnValueWithDbDefaultScTabReturnFalse() {
		assertFalse(LineManager.existsColumnValue(notexistdb, tableName, 0L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, notexistTab, 0L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, tableName, -1L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, tableName, 10000L, 0));
		assertFalse(LineManager.existsColumnValue(databaseName, tableName, 0L, -1));
		assertFalse(LineManager.existsColumnValue(databaseName, tableName, 0L, 10000));
	}
	
	private void existsColumnValueWithDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.existsColumnValue(databaseName, tableName, 0L, 0));
	}
	
	private void existsColumnValueWithDefaultDbScTabReturnFalse() {
		assertFalse(LineManager.existsColumnValueDefaultDB(notexistSchema, tableName, 0L, 0));
		assertFalse(LineManager.existsColumnValueDefaultDB(schemaName, notexistTab, 0L, 0));
		assertFalse(LineManager.existsColumnValueDefaultDB(schemaName, tableName, -1L, 0));
		assertFalse(LineManager.existsColumnValueDefaultDB(schemaName, tableName, 10000L, 0));
		assertFalse(LineManager.existsColumnValueDefaultDB(schemaName, tableName, 0L, -1));
		assertFalse(LineManager.existsColumnValueDefaultDB(schemaName, tableName, 0L, 10000));
	}
	
	private void existsColumnValueWithDefaultDbScTabReturnTrue() {
		assertTrue(LineManager.existsColumnValueDefaultDB(schemaName, tableName, 0L, 0));
	}
	
	private void existsColumnValueWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(LineManager.existsColumnValue(notexistTab, 0L, 0));
		assertFalse(LineManager.existsColumnValue(tableName, -1L, 0));
		assertFalse(LineManager.existsColumnValue(tableName, 10000L, 0));
		assertFalse(LineManager.existsColumnValue(tableName, 0L, -1));
		assertFalse(LineManager.existsColumnValue(tableName, 0L, 10000));
	}
	
	private void existsColumnValueWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(LineManager.existsColumnValue(tableName, 0L, 0));
	}
}
