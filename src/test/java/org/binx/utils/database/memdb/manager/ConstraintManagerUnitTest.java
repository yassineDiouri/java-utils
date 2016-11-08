package org.binx.utils.database.memdb.manager;

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
	private String notexistCol;
	//constraints
	private String constraintName;
	private String newConstraintName;
	private String notexistConstraint;
	private ConstraintType constraintType;
	
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
		
		constraintName = "constraintName";
		newConstraintName = "newConstraintName";
		notexistConstraint = "notexistConstraint";
		constraintType = ConstraintType.PRIMARY_KEY;
		
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
	
	public void testConstraintManager() {
		createNewConstraintWithDbScReturnNull();
		createNewConstraintWithDbDefaultScReturnNull();
		createNewConstraintWithDefaultDbScReturnNull();
		createNewConstraintWithDefaultDbDefaultScReturnNull();
		getConstraintWithDbScReturnNull();
		getConstraintWithDbDefaultScReturnNull();
		getConstraintWithDefaultDbScReturnNull();
		getConstraintWithDefaultDbDefaultScReturnNull();
		updateConstraintNameWithDbScReturnNull();
		updateConstraintNameWithDbDefaultScReturnNull();
		updateConstraintNameWithDefaultDbScReturnNull();
		updateConstraintNameWithDefaultDbDefaultScReturnNull();
		deleteWithDbScReturnNull();
		deleteWithDbDefaultScReturnNull();
		deleteWithDefaultDbScReturnNull();
		deleteWithDefaultDbDefaultScReturnNull();

		createNewConstraintWithDbScReturnTrue();
		createNewConstraintWithDbScReturnFalse();
		createNewConstraintWithDbDefaultScReturnTrue();
		createNewConstraintWithDbDefaultScReturnFalse();
		createNewConstraintWithDefaultDbScReturnTrue();
		createNewConstraintWithDefaultDbScReturnFalse();
		createNewConstraintWithDefaultDbDefaultScReturnTrue();
		createNewConstraintWithDefaultDbDefaultScReturnFalse();
		getConstraintWithDbScReturnNotNull();
		getConstraintWithDbDefaultScReturnNotNull();
		getConstraintWithDefaultDbScReturnNotNull();
		getConstraintWithDefaultDbDefaultScReturnNotNull();
		existsWithDbScReturnFalse();
		existsWithDbDefaultScReturnFalse();
		existsWithDefaultDbScReturnFalse();
		existsWithDefaultDbDefaultScReturnFalse();
		existsWithDbScReturnTrue();
		existsWithDbDefaultScReturnTrue();
		existsWithDefaultDbScReturnTrue();
		existsWithDefaultDbDefaultScReturnTrue();

		updateConstraintNameWithDbScReturnFalse();
		updateConstraintNameWithDbDefaultScReturnFalse();
		updateConstraintNameWithDefaultDbScReturnFalse();
		updateConstraintNameWithDefaultDbDefaultScReturnFalse();
		updateConstraintNameWithDbScReturnTrue();
		updateConstraintNameWithDbDefaultScReturnTrue();
		updateConstraintNameWithDefaultDbScReturnTrue();
		updateConstraintNameWithDefaultDbDefaultScReturnTrue();
		
		deleteWithDbScReturnFalse();
		deleteWithDbDefaultScReturnFalse();
		deleteWithDefaultDbScReturnFalse();
		deleteWithDefaultDbDefaultScReturnFalse();
		deleteWithDbScReturnTrue();
		deleteWithDbDefaultScReturnTrue();
		deleteWithDefaultDbScReturnTrue();
		deleteWithDefaultDbDefaultScReturnTrue();
	}
	
	public void createNewConstraintWithDbScReturnNull() {
		assertNull(ConstraintManager.createNewConstraint(notexistdb, schemaName, tableName, columnName, constraintName, constraintType));
		assertNull(ConstraintManager.createNewConstraint(databaseName, notexistSchema, tableName, columnName, constraintName, constraintType));
		assertNull(ConstraintManager.createNewConstraint(databaseName, schemaName, notexistTab, columnName, constraintName, constraintType));
		assertNull(ConstraintManager.createNewConstraint(databaseName, schemaName, tableName, notexistCol, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDbScReturnFalse() {
		assertFalse(ConstraintManager.createNewConstraint(databaseName, schemaName, tableName, columnName, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDbScReturnTrue() {
		assertTrue(ConstraintManager.createNewConstraint(databaseName, schemaName, tableName, columnName, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDbDefaultScReturnNull() {
		assertNull(ConstraintManager.createNewConstraint(notexistdb, tableName, columnName, constraintName, constraintType));
		assertNull(ConstraintManager.createNewConstraint(databaseName, notexistTab, columnName, constraintName, constraintType));
		assertNull(ConstraintManager.createNewConstraint(databaseName, tableName, notexistCol, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDbDefaultScReturnFalse() {
		assertFalse(ConstraintManager.createNewConstraint(databaseName, tableName, columnName, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDbDefaultScReturnTrue() {
		assertTrue(ConstraintManager.createNewConstraint(databaseName, tableName, columnName, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDefaultDbScReturnNull() {
		assertNull(ConstraintManager.createNewConstraintDefaultDB(notexistSchema, tableName, columnName, constraintName, constraintType));
		assertNull(ConstraintManager.createNewConstraintDefaultDB(schemaName, notexistTab, columnName, constraintName, constraintType));
		assertNull(ConstraintManager.createNewConstraintDefaultDB(schemaName, tableName, notexistCol, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDefaultDbScReturnFalse() {
		assertFalse(ConstraintManager.createNewConstraintDefaultDB(schemaName, tableName, columnName, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDefaultDbScReturnTrue() {
		assertTrue(ConstraintManager.createNewConstraintDefaultDB(schemaName, tableName, columnName, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDefaultDbDefaultScReturnNull() {
		assertNull(ConstraintManager.createNewConstraint(notexistTab, columnName, constraintName, constraintType));
		assertNull(ConstraintManager.createNewConstraint(tableName, notexistCol, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDefaultDbDefaultScReturnFalse() {
		assertFalse(ConstraintManager.createNewConstraint(tableName, columnName, constraintName, constraintType));
	}
	
	public void createNewConstraintWithDefaultDbDefaultScReturnTrue() {
		assertTrue(ConstraintManager.createNewConstraint(tableName, columnName, constraintName, constraintType));
	}
	
	public void getConstraintWithDbScReturnNull() {
		assertNull(ConstraintManager.getConstraint(notexistdb, schemaName, tableName, columnName, constraintName));
		assertNull(ConstraintManager.getConstraint(databaseName, notexistSchema, tableName, columnName, constraintName));
		assertNull(ConstraintManager.getConstraint(databaseName, schemaName, notexistTab, columnName, constraintName));
		assertNull(ConstraintManager.getConstraint(databaseName, schemaName, tableName, notexistCol, constraintName));
		assertNull(ConstraintManager.getConstraint(databaseName, schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void getConstraintWithDbScReturnNotNull() {
		assertNotNull(ConstraintManager.getConstraint(databaseName, schemaName, tableName, columnName, constraintName));
	}
	
	public void getConstraintWithDbDefaultScReturnNull() {
		assertNull(ConstraintManager.getConstraint(notexistdb, tableName, columnName, constraintName));
		assertNull(ConstraintManager.getConstraint(databaseName, notexistTab, columnName, constraintName));
		assertNull(ConstraintManager.getConstraint(databaseName, tableName, notexistCol, constraintName));
		assertNull(ConstraintManager.getConstraint(databaseName, tableName, columnName, notexistConstraint));
	}
	
	public void getConstraintWithDbDefaultScReturnNotNull() {
		assertNotNull(ConstraintManager.getConstraint(databaseName, tableName, columnName, constraintName));
	}
	
	public void getConstraintWithDefaultDbScReturnNull() {
		assertNull(ConstraintManager.getConstraintDefaultDB(notexistSchema, tableName, columnName, constraintName));
		assertNull(ConstraintManager.getConstraintDefaultDB(schemaName, notexistTab, columnName, constraintName));
		assertNull(ConstraintManager.getConstraintDefaultDB(schemaName, tableName, notexistCol, constraintName));
		assertNull(ConstraintManager.getConstraintDefaultDB(schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void getConstraintWithDefaultDbScReturnNotNull() {
		assertNotNull(ConstraintManager.getConstraintDefaultDB(schemaName, tableName, columnName, constraintName));
	}
	
	public void getConstraintWithDefaultDbDefaultScReturnNull() {
		assertNull(ConstraintManager.getConstraint(notexistTab, columnName, constraintName));
		assertNull(ConstraintManager.getConstraint(tableName, notexistCol, constraintName));
		assertNull(ConstraintManager.getConstraint(tableName, columnName, notexistConstraint));
	}
	
	public void getConstraintWithDefaultDbDefaultScReturnNotNull() {
		assertNotNull(ConstraintManager.getConstraint(tableName, columnName, constraintName));
	}
	
	public void updateConstraintNameWithDbScReturnNull() {
		assertNull(ConstraintManager.updateConstraintName(notexistdb, schemaName, tableName, columnName, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(databaseName, notexistSchema, tableName, columnName, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(databaseName, schemaName, notexistTab, columnName, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(databaseName, schemaName, tableName, notexistCol, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(databaseName, schemaName, tableName, columnName, notexistConstraint, newConstraintName));
	}
	
	public void updateConstraintNameWithDbScReturnFalse() {
		assertFalse(ConstraintManager.updateConstraintName(databaseName, schemaName, tableName, columnName, constraintName, constraintName));
	}
	
	public void updateConstraintNameWithDbScReturnTrue() {
		assertTrue(ConstraintManager.updateConstraintName(databaseName, schemaName, tableName, columnName, constraintName, newConstraintName));
	}
	
	public void updateConstraintNameWithDbDefaultScReturnNull() {
		assertNull(ConstraintManager.updateConstraintName(notexistdb, tableName, columnName, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(databaseName, notexistTab, columnName, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(databaseName, tableName, notexistCol, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(databaseName, tableName, columnName, notexistConstraint, newConstraintName));
	}
	
	public void updateConstraintNameWithDbDefaultScReturnFalse() {
		assertFalse(ConstraintManager.updateConstraintName(databaseName, tableName, columnName, constraintName, constraintName));
	}
	
	public void updateConstraintNameWithDbDefaultScReturnTrue() {
		assertTrue(ConstraintManager.updateConstraintName(databaseName, tableName, columnName, constraintName, newConstraintName));
	}
	
	public void updateConstraintNameWithDefaultDbScReturnNull() {
		assertNull(ConstraintManager.updateConstraintNameDefaultDB(notexistSchema, tableName, columnName, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintNameDefaultDB(schemaName, notexistTab, columnName, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintNameDefaultDB(schemaName, tableName, notexistCol, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintNameDefaultDB(schemaName, tableName, columnName, notexistConstraint, newConstraintName));
	}
	
	public void updateConstraintNameWithDefaultDbScReturnFalse() {
		assertFalse(ConstraintManager.updateConstraintNameDefaultDB(schemaName, tableName, columnName, constraintName, constraintName));
	}
	
	public void updateConstraintNameWithDefaultDbScReturnTrue() {
		assertTrue(ConstraintManager.updateConstraintNameDefaultDB(schemaName, tableName, columnName, constraintName, newConstraintName));
	}
	
	public void updateConstraintNameWithDefaultDbDefaultScReturnNull() {
		assertNull(ConstraintManager.updateConstraintName(notexistTab, columnName, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(tableName, notexistCol, constraintName, newConstraintName));
		assertNull(ConstraintManager.updateConstraintName(tableName, columnName, notexistConstraint, newConstraintName));
	}
	
	public void updateConstraintNameWithDefaultDbDefaultScReturnFalse() {
		assertFalse(ConstraintManager.updateConstraintName(tableName, columnName, constraintName, constraintName));
	}
	
	public void updateConstraintNameWithDefaultDbDefaultScReturnTrue() {
		assertTrue(ConstraintManager.updateConstraintName(tableName, columnName, constraintName, newConstraintName));
	}
	
	public void deleteWithDbScReturnNull() {
		assertNull(ConstraintManager.delete(notexistdb, schemaName, tableName, columnName, newConstraintName));
		assertNull(ConstraintManager.delete(databaseName, notexistSchema, tableName, columnName, newConstraintName));
		assertNull(ConstraintManager.delete(databaseName, schemaName, notexistTab, columnName, newConstraintName));
		assertNull(ConstraintManager.delete(databaseName, schemaName, tableName, notexistCol, newConstraintName));
	}
	
	public void deleteWithDbScReturnFalse() {
		assertFalse(ConstraintManager.delete(databaseName, schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void deleteWithDbScReturnTrue() {
		assertTrue(ConstraintManager.delete(databaseName, schemaName, tableName, columnName, newConstraintName));
	}
	
	public void deleteWithDbDefaultScReturnNull() {
		assertNull(ConstraintManager.delete(notexistdb, tableName, columnName, newConstraintName));
		assertNull(ConstraintManager.delete(databaseName, notexistTab, columnName, newConstraintName));
		assertNull(ConstraintManager.delete(databaseName, tableName, notexistCol, newConstraintName));
	}
	
	public void deleteWithDbDefaultScReturnFalse() {
		assertFalse(ConstraintManager.delete(databaseName, tableName, columnName, notexistConstraint));
	}
	
	public void deleteWithDbDefaultScReturnTrue() {
		assertTrue(ConstraintManager.delete(databaseName, tableName, columnName, newConstraintName));
	}
	
	public void deleteWithDefaultDbScReturnNull() {
		assertNull(ConstraintManager.deleteDefaultDB(notexistSchema, tableName, columnName, newConstraintName));
		assertNull(ConstraintManager.deleteDefaultDB(schemaName, notexistTab, columnName, newConstraintName));
		assertNull(ConstraintManager.deleteDefaultDB(schemaName, tableName, notexistCol, newConstraintName));
	}
	
	public void deleteWithDefaultDbScReturnFalse() {
		assertFalse(ConstraintManager.deleteDefaultDB(schemaName, tableName, columnName, notexistConstraint));
	}
	
	public void deleteWithDefaultDbScReturnTrue() {
		assertTrue(ConstraintManager.deleteDefaultDB(schemaName, tableName, columnName, newConstraintName));
	}
	
	public void deleteWithDefaultDbDefaultScReturnNull() {
		assertNull(ConstraintManager.delete(notexistTab, columnName, newConstraintName));
		assertNull(ConstraintManager.delete(tableName, notexistCol, newConstraintName));
	}
	
	public void deleteWithDefaultDbDefaultScReturnFalse() {
		assertFalse(ConstraintManager.delete(tableName, columnName, notexistConstraint));
	}
	
	public void deleteWithDefaultDbDefaultScReturnTrue() {
		assertTrue(ConstraintManager.delete(tableName, columnName, newConstraintName));
	}
	
	public void existsWithDbScReturnFalse() {
		assertFalse(ConstraintManager.exists(notexistdb, schemaName, tableName, columnName, constraintName));
		assertFalse(ConstraintManager.exists(databaseName, notexistSchema, tableName, columnName, constraintName));
		assertFalse(ConstraintManager.exists(databaseName, schemaName, notexistTab, columnName, constraintName));
		assertFalse(ConstraintManager.exists(databaseName, schemaName, tableName, notexistCol, constraintName));
		assertFalse(ConstraintManager.exists(databaseName, schemaName, tableName, columnName, newConstraintName));
	}
	
	public void existsWithDbScReturnTrue() {
		assertTrue(ConstraintManager.exists(databaseName, schemaName, tableName, columnName, constraintName));
	}
	
	public void existsWithDbDefaultScReturnFalse() {
		assertFalse(ConstraintManager.exists(notexistdb, tableName, columnName, constraintName));
		assertFalse(ConstraintManager.exists(databaseName, notexistTab, columnName, constraintName));
		assertFalse(ConstraintManager.exists(databaseName, tableName, notexistCol, constraintName));
		assertFalse(ConstraintManager.exists(databaseName, tableName, columnName, newConstraintName));
	}
	
	public void existsWithDbDefaultScReturnTrue() {
		assertTrue(ConstraintManager.exists(databaseName, tableName, columnName, constraintName));
	}
	
	public void existsWithDefaultDbScReturnFalse() {
		assertFalse(ConstraintManager.existsDefaultDB(notexistSchema, tableName, columnName, constraintName));
		assertFalse(ConstraintManager.existsDefaultDB(schemaName, notexistTab, columnName, constraintName));
		assertFalse(ConstraintManager.existsDefaultDB(schemaName, tableName, notexistCol, constraintName));
		assertFalse(ConstraintManager.existsDefaultDB(schemaName, tableName, columnName, newConstraintName));
	}
	
	public void existsWithDefaultDbScReturnTrue() {
		assertTrue(ConstraintManager.existsDefaultDB(schemaName, tableName, columnName, constraintName));
	}
	
	public void existsWithDefaultDbDefaultScReturnFalse() {
		assertFalse(ConstraintManager.exists(notexistTab, columnName, constraintName));
		assertFalse(ConstraintManager.exists(tableName, notexistCol, constraintName));
		assertFalse(ConstraintManager.exists(tableName, columnName, newConstraintName));
	}
	
	public void existsWithDefaultDbDefaultScReturnTrue() {
		assertTrue(ConstraintManager.exists(tableName, columnName, constraintName));
	}
}
