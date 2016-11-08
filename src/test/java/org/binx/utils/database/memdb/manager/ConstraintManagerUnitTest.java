package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

import junit.framework.*;

public class ConstraintManagerUnitTest extends TestCase {

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

			ColumnManager.createNewColumn(databaseName, schemaName, tableName, columnName, String.class);
			ColumnManager.createNewColumn(databaseName, tableName, columnName, String.class);
			ColumnManager.createNewColumnDefaultDB(schemaName, tableName, columnName, String.class);
			ColumnManager.createNewColumn(tableName, columnName, String.class);
		}
}
