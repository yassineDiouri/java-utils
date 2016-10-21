package org.binx.utils.database.memdb.manager;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class TableManagerUnitTest extends TestCase {

	// databases
	private String simpledb;
	private String defaultdb;
	private String notexistdb;
	//schemas
	private String simpleSchema;
	private String nullNameSchema;
	private String notexistSchema;
	//tables
	private String simpleTab;
	private String emptyTab;
	private String notexistTab;
	
	@Override
	protected void setUp() throws Exception {
		simpledb = "simpledb";
		defaultdb = "defaultdb";
		notexistdb = "notexistdb";
		
		simpleSchema = "simpleSchema";
		nullNameSchema = null;
		notexistSchema = "notexistSchema";
		
		simpleTab = "simpleTab";
		emptyTab = " ";
		notexistTab = "notexistTab";
	}
	
	public void testTableManager() {
		DatabaseListManager.getDatabaseList();
		DatabaseManager.createNewDatabase(simpledb);
		DatabaseManager.createNewDatabase(defaultdb);
		SchemaManager.createNewSchema(simpledb, simpleSchema);
		
		createNewTableWithDefaultDbScTabReturnNull();
		createNewTableWithDefaultDbDefaultScTabReturnNull();
		getAllTablesWithDefaultDbDefaultScTabReturnNull();
		
		DatabaseManager.setToDefault(defaultdb);
		SchemaManager.createNewSchema(simpleSchema);

		createNewTableWithDbScTabReturnNull();
		createNewTableWithDbDefaultScTabReturnNull();
		getTableWithDbScTabReturnNull();
		getTableWithDbDefaultScTabReturnNull();
		getTableWithDefaultDbScTabReturnNull();
		getTableWithDefaultDbDefaultScTabReturnNull();
		getAllTablesWithDbScTabReturnNull();
		getAllTablesWithDbDefaultScTabReturnNull();
		getAllTablesWithDefaultDbScTabReturnNull();

		createNewTableWithDbScTabReturnTrue();
		createNewTableWithDbScTabReturnFalse();
		createNewTableWithDbDefaultScTabReturnTrue();
		createNewTableWithDbDefaultScTabReturnFalse();
		createNewTableWithDefaultDbScTabReturnTrue();
		createNewTableWithDefaultDbScTabReturnFalse();
		createNewTableWithDefaultDbDefaultScTabReturnTrue();
		createNewTableWithDefaultDbDefaultScTabReturnFalse();
		getTableWithDbScTabReturnNotNull();
		getTableWithDbDefaultScTabReturnNotNull();
		getTableWithDefaultDbScTabReturnNotNull();
		getTableWithDefaultDbDefaultScTabReturnNotNull();
		getAllTablesWithDbScTabReturnNotNull();
		getAllTablesWithDbDefaultScTabReturnNotNull();
		getAllTablesWithDefaultDbScTabReturnNotNull();
		getAllTablesWithDefaultDbDefaultScTabReturnNotNull();
	}
	
	public void createNewTableWithDbScTabReturnNull() {
		assertNull(TableManager.createNewTable(notexistdb, simpleSchema, simpleTab));
		assertNull(TableManager.createNewTable(simpledb, notexistSchema, simpleTab));
		assertNull(TableManager.createNewTable(notexistdb, notexistSchema, simpleTab));
	}
	
	public void createNewTableWithDbScTabReturnFalse() {
		assertFalse(TableManager.createNewTable(simpledb, simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDbScTabReturnTrue() {
		assertTrue(TableManager.createNewTable(simpledb, simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.createNewTable(notexistdb, simpleTab));
	}
	
	public void createNewTableWithDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.createNewTable(simpledb, simpleTab));
	}
	
	public void createNewTableWithDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.createNewTable(simpledb, simpleTab));
	}
	
	public void createNewTableWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.createNewTableDefaultDB(notexistSchema, simpleTab));
		assertNull(TableManager.createNewTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDefaultDbScTabReturnFalse() {
		assertFalse(TableManager.createNewTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDefaultDbScTabReturnTrue() {
		assertTrue(TableManager.createNewTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.createNewTable(simpleTab));
	}
	
	public void createNewTableWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.createNewTable(simpleTab));
	}
	
	public void createNewTableWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.createNewTable(simpleTab));
	}
	
	public void getTableWithDbScTabReturnNull() {
		assertNull(TableManager.getTable(notexistdb, simpleSchema, simpleTab));
		assertNull(TableManager.getTable(simpledb, notexistSchema, simpleTab));
		assertNull(TableManager.getTable(simpledb, simpleSchema, notexistTab));
	}
	
	public void getTableWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getTable(simpledb, simpleSchema, simpleTab));
	}
	
	public void getTableWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getTable(notexistdb, simpleTab));
		assertNull(TableManager.getTable(simpledb, notexistTab));
	}
	
	public void getTableWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getTable(simpledb, simpleTab));
	}
	
	public void getTableWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getTableDefaultDB(notexistSchema, simpleTab));
		assertNull(TableManager.getTableDefaultDB(simpleSchema, notexistTab));
	}
	
	public void getTableWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void getTableWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getTable(notexistTab));
	}
	
	public void getTableWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getTable(simpleTab));
	}
	
	public void getAllTablesWithDbScTabReturnNull() {
		assertNull(TableManager.getAllTables(notexistdb, simpleSchema));
		assertNull(TableManager.getAllTables(simpledb, notexistSchema));
	}
	
	public void getAllTablesWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getAllTables(simpledb, simpleSchema));
	}
	
	public void getAllTablesWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getAllTables(notexistdb));
	}
	
	public void getAllTablesWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getAllTables(simpledb));
	}
	
	public void getAllTablesWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getAllTablesDefaultDB(notexistSchema));
	}
	
	public void getAllTablesWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getAllTablesDefaultDB(simpleSchema));
	}
	
	public void getAllTablesWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getAllTables());
	}
	
	public void getAllTablesWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getAllTables());
	}
}
