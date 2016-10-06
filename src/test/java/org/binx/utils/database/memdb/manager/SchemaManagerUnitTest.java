package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

import junit.framework.*;

public class SchemaManagerUnitTest extends TestCase {

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
	private Table simpleTable;
	private Table emptyTable;
	
	@Override
	protected void setUp() throws Exception {		
		simpledb = "simpledb";
		defaultdb = "defaultdb";
		notexistdb = "notexistdb";
		DatabaseListManager.getDatabaseList();
		DatabaseManager.createNewDatabase(simpledb);
		DatabaseManager.createNewDatabase(defaultdb);
		
		simpleSchema = "simpleSchema";
		nullNameSchema = null;
		notexistSchema = "notexistSchema";

		simpleTab = "simpleTab";
		emptyTab = " ";
		notexistTab = "notexistTab";
		simpleTable = TableGenerator.getTable(simpleTab);
		emptyTable = TableGenerator.getTable(emptyTab);
	}
	
	public void testSchemaManager() {
		createNewSchemaWithDatabaseReturnNull();
		createNewSchemaWithDatabaseReturnFalse();
		createNewSchemaOnDefaultDatabaseReturnNull();
		getSchemaFromDefaultDatabaseReturnNull();
		getDefaultWithDatabaseReturnNull();
		getDefaultWithDatabaseReturnNotNull();
		getDefaultFromDefaultDatabaseReturnNull();
		deleteFromDefaultDatabaseReturnNull();
		existsOnDefaultDatabaseReturnFalse();
		addTableOnDefaultDatabaseAndDefaultSchemaReturnNull();
		getAllTablesWithDefaultDatabaseAndDefaultSchemaReturnNull();
		deleteTableWithDefaultDatabaseAndDefaultSchemaReturnNull();
		getAllNamesTablesWithDefaultDatabaseAndDefaultSchemaReturnNull();
		countTablesWithDefaultDatabaseAndDefaultSchemaReturnMinus1();
		
		DatabaseManager.setToDefault(defaultdb);
		createNewSchemaWithDatabaseReturnTrue();
		createNewSchemaOnDefaultDatabaseReturnFalse();
		createNewSchemaOnDefaultDatabaseReturnTrue();
		
		getSchemaWithDatabaseReturnNull();
		getSchemaWithDatabaseReturnNotNull();
		getSchemaFromDefaultDatabaseReturnNotNull();
		getDefaultFromDefaultDatabaseReturnNotNull();
		existsWithDatabaseReturnFalse();
		existsWithDatabaseReturnTrue();
		existsOnDefaultDatabaseReturnTrue();
		addTableWithDatabaseAndSchemaReturnNull();
		addTableWithDatabaseAndSchemaReturnTrue();
		addTableWithDatabaseAndSchemaReturnFalse();
		addTableWithDatabaseAndDefaultSchemaReturnNull();
		addTableWithDatabaseAndDefaultSchemaReturnTrue();
		addTableWithDatabaseAndDefaultSchemaReturnFalse();
		addTableDefaultDBOnDefaultDatabaseAndSchemaReturnNull();
		addTableDefaultDBOnDefaultDatabaseAndSchemaReturnTrue();
		addTableDefaultDBOnDefaultDatabaseAndSchemaReturnFalse();
		addTableOnDefaultDatabaseAndDefaultSchemaReturnTrue();
		addTableOnDefaultDatabaseAndDefaultSchemaReturnFalse();
		getAllTablesWithDatabaseAndSchemaReturnNull();
		getAllTablesWithDatabaseAndSchemaReturnNotNull();
		getAllTablesWithDatabaseAndDefaultSchemaReturnNull();
		getAllTablesWithDatabaseAndDefaultSchemaReturnNotNull();
		getAllTablesDefaultDBWithDefaultDatabaseAndSchemaReturnNull();
		getAllTablesDefaultDBWithDefaultDatabaseAndSchemaReturnNotNull();
		getAllTablesWithDefaultDatabaseAndDefaultSchemaReturnNotNull();
		existsTableWithDatabaseAndSchemaReturnFalse();
		existsTableWithDatabaseAndSchemaReturnTrue();
		existsTableWithDatabaseAndDefaultSchemaReturnFalse();
		existsTableWithDatabaseAndDefaultSchemaReturnTrue();
		existsTableDefaultDBWithDatabaseAndSchemaReturnFalse();
		existsTableDefaultDBWithDatabaseAndSchemaReturnTrue();
		existsTableWithDefaultDatabaseAndDefaultSchemaReturnFalse();
		existsTableWithDefaultDatabaseAndDefaultSchemaReturnTrue();
		getAllNamesTablesWithDatabaseAndSchemaReturnNotNull();
		getAllNamesTablesWithDatabaseAndSchemaReturnNull();
		getAllNamesTablesWithDatabaseAndDefaultSchemaReturnNull();
		getAllNamesTablesWithDatabaseAndDefaultSchemaReturnNotNull();
		getAllNamesTablesDefaultDBWithDefaultDatabaseAndSchemaReturnNull();
		getAllNamesTablesDefaultDBWithDefaultDatabaseAndSchemaReturnNotNull();
		getAllNamesTablesWithDefaultDatabaseAndDefaultSchemaReturnNotNull();
		countTablesWithDatabaseAndSchemaReturnMinus1();
		countTablesWithDatabaseAndSchemaReturnGreaterOrEqualTo0();
		countTablesWithDatabaseAndDefaultSchemaReturnMinus1();
		countTablesWithDatabaseAndDefaultSchemaReturnGreaterOrEqualTo0();
		countTablesDefaultDBWithDefaultDatabaseAndSchemaReturnMinus1();
		countTablesDefaultDBWithDefaultDatabaseAndSchemaReturnGreaterOrEqualTo0();
		countTablesWithDefaultDatabaseAndDefaultSchemaReturnGreaterOrEqualTo0();
		
		deleteTableWithDefaultDatabaseAndDefaultSchemaReturnFalse();
		deleteTableDefaultDBWithDefaultDatabaseAndSchemaReturnNull();
		deleteTableDefaultDBWithDefaultDatabaseAndSchemaReturnFalse();
		deleteTableWithDatabaseAndDefaultSchemaReturnNull();
		deleteTableWithDatabaseAndDefaultSchemaReturnFalse();
		deleteTableWithDatabaseAndSchemaReturnNull();
		deleteTableWithDatabaseAndSchemaReturnFalse();
		deleteSchemaWithDatabaseReturnNull();
		deleteSchemaWithDatabaseReturnFalse();
		deleteFromDefaultDatabaseReturnFalse();
		deleteTableWithDefaultDatabaseAndDefaultSchemaReturnTrue();
		deleteTableDefaultDBWithDefaultDatabaseAndSchemaReturnTrue();
		deleteTableWithDatabaseAndDefaultSchemaReturnTrue();
		deleteTableWithDatabaseAndSchemaReturnTrue();
		deleteWithDatabaseReturntrue();
		deleteFromDefaultDatabaseReturntrue();
		
	}
	
	public void createNewSchemaWithDatabaseReturnNull() {
		assertNull(SchemaManager.createNewSchema(notexistdb, simpleSchema));
	}
	
	public void createNewSchemaWithDatabaseReturnFalse() {
		assertFalse(SchemaManager.createNewSchema(simpledb, nullNameSchema));
		assertFalse(SchemaManager.createNewSchema(defaultdb, nullNameSchema));
	}
	
	public void createNewSchemaWithDatabaseReturnTrue() {
		assertTrue(SchemaManager.createNewSchema(simpledb, simpleSchema));
	}
	
	public void createNewSchemaOnDefaultDatabaseReturnNull() {
		assertNull(SchemaManager.createNewSchema(simpleSchema));
	}
	
	public void createNewSchemaOnDefaultDatabaseReturnFalse() {
		assertFalse(SchemaManager.createNewSchema(nullNameSchema));
	}
	
	public void createNewSchemaOnDefaultDatabaseReturnTrue() {
		assertTrue(SchemaManager.createNewSchema(simpleSchema));
	}
	
	public void getSchemaWithDatabaseReturnNull() {
		assertNull(SchemaManager.getSchema(notexistdb, simpleSchema));
	}
	
	public void getSchemaWithDatabaseReturnNotNull() {
		assertNotNull(SchemaManager.getSchema(simpledb, simpleSchema));
		assertNotNull(SchemaManager.getSchema(simpledb, nullNameSchema));
	}
	
	public void getSchemaFromDefaultDatabaseReturnNull() {
		assertNull(SchemaManager.getSchema(simpleSchema));
	}
	
	public void getSchemaFromDefaultDatabaseReturnNotNull() {
		assertNotNull(SchemaManager.getSchema(simpleSchema));
		assertNotNull(SchemaManager.getSchema(nullNameSchema));
	}
	
	public void getDefaultWithDatabaseReturnNull() {
		assertNull(SchemaManager.getDefault(notexistdb));
	}
	
	public void getDefaultWithDatabaseReturnNotNull() {
		assertNotNull(SchemaManager.getDefault(simpledb));
	}
	
	public void getDefaultFromDefaultDatabaseReturnNull() {
		assertNull(SchemaManager.getDefault());
	}
	
	public void getDefaultFromDefaultDatabaseReturnNotNull() {
		assertNotNull(SchemaManager.getDefault());
	}
	
	public void deleteSchemaWithDatabaseReturnNull() {
		assertNull(SchemaManager.delete(notexistdb, simpleSchema));
	}
	
	public void deleteSchemaWithDatabaseReturnFalse() {
		assertFalse(SchemaManager.delete(simpledb, notexistSchema));
		assertFalse(SchemaManager.delete(simpledb, Schema.DEFAULT_NAME));
	}
	
	public void deleteWithDatabaseReturntrue() {
		assertTrue(SchemaManager.delete(simpledb, simpleSchema));
	}
	
	public void deleteFromDefaultDatabaseReturnNull() {
		assertNull(SchemaManager.delete(Schema.DEFAULT_NAME));
	}
	
	public void deleteFromDefaultDatabaseReturnFalse() {
		assertFalse(SchemaManager.delete(notexistSchema));
		assertFalse(SchemaManager.delete(Schema.DEFAULT_NAME));
	}
	
	public void deleteFromDefaultDatabaseReturntrue() {
		assertTrue(SchemaManager.delete(simpleSchema));
	}
	
	public void existsWithDatabaseReturnFalse() {
		assertFalse(SchemaManager.exists(notexistdb, simpleSchema));
		assertFalse(SchemaManager.exists(simpledb, notexistSchema));
	}
	
	public void existsWithDatabaseReturnTrue() {
		assertTrue(SchemaManager.exists(simpledb, simpleSchema));
	}
	
	public void existsOnDefaultDatabaseReturnFalse() {
		assertFalse(SchemaManager.exists(simpleSchema));
		assertFalse(SchemaManager.exists(notexistSchema));
	}
	
	public void existsOnDefaultDatabaseReturnTrue() {
		assertTrue(SchemaManager.exists(simpleSchema));
	}
	
	public void addTableWithDatabaseAndSchemaReturnNull() {
		assertNull(SchemaManager.addTable(notexistdb, simpleSchema, simpleTable));
		assertNull(SchemaManager.addTable(simpledb, notexistSchema, simpleTable));
	}
	
	public void addTableWithDatabaseAndSchemaReturnFalse() {
		assertFalse(SchemaManager.addTable(simpledb, simpleSchema, simpleTable)); //exists
		assertFalse(SchemaManager.addTable(simpledb, simpleSchema, emptyTable));
		assertFalse(SchemaManager.addTable(simpledb, simpleSchema, null));
	}
	
	public void addTableWithDatabaseAndSchemaReturnTrue() {
		assertTrue(SchemaManager.addTable(simpledb, simpleSchema, simpleTable));
	}
	
	public void addTableWithDatabaseAndDefaultSchemaReturnNull() {
		assertNull(SchemaManager.addTable(notexistdb, simpleTable));
	}
	
	public void addTableWithDatabaseAndDefaultSchemaReturnFalse() {
		assertFalse(SchemaManager.addTable(simpledb, simpleTable)); //exists
		assertFalse(SchemaManager.addTable(simpledb, emptyTable));
		assertFalse(SchemaManager.addTable(simpledb, null));
	}
	
	public void addTableWithDatabaseAndDefaultSchemaReturnTrue() {
		assertTrue(SchemaManager.addTable(simpledb, simpleTable));
	}
	
	public void addTableDefaultDBOnDefaultDatabaseAndSchemaReturnNull() {
		assertNull(SchemaManager.addTableDefaultDB(notexistSchema, simpleTable));
	}
	
	public void addTableDefaultDBOnDefaultDatabaseAndSchemaReturnFalse() {
		assertFalse(SchemaManager.addTableDefaultDB(simpleSchema, simpleTable)); //exists
		assertFalse(SchemaManager.addTableDefaultDB(simpleSchema, emptyTable));
		assertFalse(SchemaManager.addTableDefaultDB(simpleSchema, null));
	}
	
	public void addTableDefaultDBOnDefaultDatabaseAndSchemaReturnTrue() {
		assertTrue(SchemaManager.addTableDefaultDB(simpleSchema, simpleTable));
	}
	
	public void addTableOnDefaultDatabaseAndDefaultSchemaReturnNull() {
		assertNull(SchemaManager.addTable(simpleTable));
	}
	
	public void addTableOnDefaultDatabaseAndDefaultSchemaReturnFalse() {
		assertFalse(SchemaManager.addTable(simpleTable)); //exists
		assertFalse(SchemaManager.addTable(emptyTable));
		assertFalse(SchemaManager.addTable(null));
	}
	
	public void addTableOnDefaultDatabaseAndDefaultSchemaReturnTrue() {
		assertTrue(SchemaManager.addTable(simpleTable));
	}
	
	public void getAllTablesWithDatabaseAndSchemaReturnNull() {
		assertNull(SchemaManager.getAllTables(notexistdb, simpleSchema));
		assertNull(SchemaManager.getAllTables(simpledb, notexistSchema));
	}
	
	public void getAllTablesWithDatabaseAndSchemaReturnNotNull() {
		assertNotNull(SchemaManager.getAllTables(simpledb, simpleSchema));
	}
	
	public void getAllTablesWithDatabaseAndDefaultSchemaReturnNull() {
		assertNull(SchemaManager.getAllTables(notexistdb));
	}
	
	public void getAllTablesWithDatabaseAndDefaultSchemaReturnNotNull() {
		assertNotNull(SchemaManager.getAllTables(simpledb));
	}
	
	public void getAllTablesDefaultDBWithDefaultDatabaseAndSchemaReturnNull() {
		assertNull(SchemaManager.getAllTablesDefaultDB(notexistSchema));
	}
	
	public void getAllTablesDefaultDBWithDefaultDatabaseAndSchemaReturnNotNull() {
		assertNotNull(SchemaManager.getAllTablesDefaultDB(simpleSchema));
	}
	
	public void getAllTablesWithDefaultDatabaseAndDefaultSchemaReturnNull() {
		assertNull(SchemaManager.getAllTables());
	}
	
	public void getAllTablesWithDefaultDatabaseAndDefaultSchemaReturnNotNull() {
		assertNotNull(SchemaManager.getAllTables());
	}
	
	public void deleteTableWithDatabaseAndSchemaReturnNull() {
		assertNull(SchemaManager.deleteTable(notexistdb, simpleSchema, simpleTab));
		assertNull(SchemaManager.deleteTable(simpledb, notexistSchema, simpleTab));
	}
	
	public void deleteTableWithDatabaseAndSchemaReturnFalse() {
		assertFalse(SchemaManager.deleteTable(simpledb, simpleSchema, notexistTab));
		assertFalse(SchemaManager.deleteTable(simpledb, simpleSchema, emptyTab));
	}
	
	public void deleteTableWithDatabaseAndSchemaReturnTrue() {
		assertTrue(SchemaManager.deleteTable(simpledb, simpleSchema, simpleTab));
	}
	
	public void deleteTableWithDatabaseAndDefaultSchemaReturnNull() {
		assertNull(SchemaManager.deleteTable(notexistdb, simpleTab));
	}
	
	public void deleteTableWithDatabaseAndDefaultSchemaReturnFalse() {
		assertFalse(SchemaManager.deleteTable(simpledb, notexistTab));
		assertFalse(SchemaManager.deleteTable(simpledb, emptyTab));
	}
	
	public void deleteTableWithDatabaseAndDefaultSchemaReturnTrue() {
		assertTrue(SchemaManager.deleteTable(simpledb, simpleTab));
	}
	
	public void deleteTableDefaultDBWithDefaultDatabaseAndSchemaReturnNull() {
		assertNull(SchemaManager.deleteTableDefaultDB(notexistSchema, simpleTab));
	}
	
	public void deleteTableDefaultDBWithDefaultDatabaseAndSchemaReturnFalse() {
		assertFalse(SchemaManager.deleteTableDefaultDB(simpleSchema, notexistTab));
		assertFalse(SchemaManager.deleteTableDefaultDB(simpleSchema, emptyTab));
	}
	
	public void deleteTableDefaultDBWithDefaultDatabaseAndSchemaReturnTrue() {
		assertTrue(SchemaManager.deleteTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void deleteTableWithDefaultDatabaseAndDefaultSchemaReturnNull() {
		assertNull(SchemaManager.deleteTable(simpleTab));
	}
	
	public void deleteTableWithDefaultDatabaseAndDefaultSchemaReturnFalse() {
		assertFalse(SchemaManager.deleteTable(notexistTab));
		assertFalse(SchemaManager.deleteTable(emptyTab));
	}
	
	public void deleteTableWithDefaultDatabaseAndDefaultSchemaReturnTrue() {
		assertTrue(SchemaManager.deleteTable(simpleTab));
	}
	
	public void existsTableWithDatabaseAndSchemaReturnFalse() {
		assertFalse(SchemaManager.existsTable(notexistdb, simpleSchema, simpleTab));
		assertFalse(SchemaManager.existsTable(simpledb, notexistSchema, simpleTab));
		assertFalse(SchemaManager.existsTable(simpledb, simpleSchema, notexistTab));
	}
	
	public void existsTableWithDatabaseAndSchemaReturnTrue() {
		assertTrue(SchemaManager.existsTable(simpledb, simpleSchema, simpleTab));
	}
	
	public void existsTableWithDatabaseAndDefaultSchemaReturnFalse() {
		assertFalse(SchemaManager.existsTable(notexistdb, simpleTab));
		assertFalse(SchemaManager.existsTable(simpledb, notexistTab));
	}
	
	public void existsTableWithDatabaseAndDefaultSchemaReturnTrue() {
		assertTrue(SchemaManager.existsTable(simpledb, simpleTab));
	}
	
	public void existsTableDefaultDBWithDatabaseAndSchemaReturnFalse() {
		assertFalse(SchemaManager.existsTableDefaultDB(notexistSchema, simpleTab));
		assertFalse(SchemaManager.existsTableDefaultDB(simpleSchema, notexistTab));
	}
	
	public void existsTableDefaultDBWithDatabaseAndSchemaReturnTrue() {
		assertTrue(SchemaManager.existsTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void existsTableWithDefaultDatabaseAndDefaultSchemaReturnFalse() {
		assertFalse(SchemaManager.existsTable(notexistTab));
	}
	
	public void existsTableWithDefaultDatabaseAndDefaultSchemaReturnTrue() {
		assertTrue(SchemaManager.existsTable(simpleTab));
	}
	
	public void getAllNamesTablesWithDatabaseAndSchemaReturnNull() {
		assertNull(SchemaManager.getAllNamesTables(simpledb, notexistSchema));
		assertNull(SchemaManager.getAllNamesTables(notexistdb, simpleSchema));
	}
	
	public void getAllNamesTablesWithDatabaseAndSchemaReturnNotNull() {
		assertNotNull(SchemaManager.getAllNamesTables(simpledb, simpleSchema));
	}
	
	public void getAllNamesTablesWithDatabaseAndDefaultSchemaReturnNull() {
		assertNull(SchemaManager.getAllNamesTables(notexistdb));
	}
	
	public void getAllNamesTablesWithDatabaseAndDefaultSchemaReturnNotNull() {
		assertNotNull(SchemaManager.getAllNamesTables(simpledb));
	}
	
	public void getAllNamesTablesDefaultDBWithDefaultDatabaseAndSchemaReturnNull() {
		assertNull(SchemaManager.getAllNamesTablesDefaultDB(notexistSchema));
	}
	
	public void getAllNamesTablesDefaultDBWithDefaultDatabaseAndSchemaReturnNotNull() {
		assertNotNull(SchemaManager.getAllNamesTablesDefaultDB(simpleSchema));
	}
	
	public void getAllNamesTablesWithDefaultDatabaseAndDefaultSchemaReturnNull() {
		assertNull(SchemaManager.getAllNamesTables());
	}
	
	public void getAllNamesTablesWithDefaultDatabaseAndDefaultSchemaReturnNotNull() {
		assertNotNull(SchemaManager.getAllNamesTables());
	}
	
	public void countTablesWithDatabaseAndSchemaReturnMinus1() {
		assertEquals(SchemaManager.countTables(notexistdb, simpleSchema), new Integer(-1));
		assertEquals(SchemaManager.countTables(simpledb, notexistSchema), new Integer(-1));
	}
	
	public void countTablesWithDatabaseAndSchemaReturnGreaterOrEqualTo0() {
		assertTrue(SchemaManager.countTables(simpledb, simpleSchema) >= 0);
	}
	
	public void countTablesWithDatabaseAndDefaultSchemaReturnMinus1() {
		assertEquals(SchemaManager.countTables(notexistdb), new Integer(-1));
	}
	
	public void countTablesWithDatabaseAndDefaultSchemaReturnGreaterOrEqualTo0() {
		assertTrue(SchemaManager.countTables(simpledb) >= 0);
	}
	
	public void countTablesDefaultDBWithDefaultDatabaseAndSchemaReturnMinus1() {
		assertEquals(SchemaManager.countTablesDefaultDB(notexistSchema), new Integer(-1));
	}
	
	public void countTablesDefaultDBWithDefaultDatabaseAndSchemaReturnGreaterOrEqualTo0() {
		assertTrue(SchemaManager.countTablesDefaultDB(simpleSchema) >= 0);
	}
	
	public void countTablesWithDefaultDatabaseAndDefaultSchemaReturnMinus1() {
		assertEquals(SchemaManager.countTables(), new Integer(-1));
	}
	
	public void countTablesWithDefaultDatabaseAndDefaultSchemaReturnGreaterOrEqualTo0() {
		assertTrue(SchemaManager.countTables() >= 0);
	}
}
