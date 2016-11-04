package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

import junit.framework.*;

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
	private String simpleCol;
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
		
		simpleCol = "simpleCol";
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
	}
	
	
}
