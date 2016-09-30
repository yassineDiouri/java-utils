package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.model.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseManagerUnitTest extends TestCase {

	private String nul;
	private String dbName;
	private String notExistDbName;
	private String emptyDbName;
	private Schema nullSchema;
	private Schema nullNameSchema;
	private Schema schema;
	private Schema defaultSchema;
	private Schema emptyNameSchema;
	
	@Override
	protected void setUp() throws Exception {
		DatabaseListManager.getDatabaseList();
		nul = null;
		dbName = " newDb ";
		notExistDbName = "not_Exist";
		emptyDbName = "";
		schema = new Schema("schema");
		defaultSchema = new Schema();
		nullNameSchema = new Schema(null);
		emptyNameSchema = new Schema("");
		nullSchema = null;
	}
	
	public void testDatabaseManager() {
		createNewDatabaseReturnFalse();
		getDatabaseReturnNull();
		setToDefaultReturnFalse();
		deleteDatabaseReturnFalse();
		getDefaultReturnNull();
		existsSchemaOnDatabaseNameReturnFalse();

		getAllSchemasOnDatabaseNameReturnNull();
		getAllNamesSchemasWithDatabaseNameReturnNull();
		
		createNewDatabaseReturnTrue();
		existsReturnFalse();
		existsReturnTrue();
		getDatabaseReturnNotNull();
		getAllNamesSchemasOfDefaultDatabaseReturnNull();
		getAllSchemasOnDefaultDatabaseReturnNull();
		setToDefaultReturnTrue();
		getDefaultReturnNotNull();
		existsSchemaOnDefaultDatabaseReturnFalse();
		addSchemaWithSpecifiedDbReturnFalse();
		addSchemaWithSpecifiedDbReturnTrue();
		addSchemaWithDefaultDbReturnFalse();
		addSchemaWithDefaultDbReturnTrue();
		getAllSchemasOnDatabaseNameReturnNoNull();
		existsSchemaOnDefaultDatabaseReturnTrue();
		isDefaultSchemaReturnFalse();
		isDefaultSchemaReturnTrue();
		existsSchemaOnDatabaseNameReturnTrue();
		getAllSchemasOnDefaultDatabaseReturnNoNull();
		getAllNamesSchemasWithDatabaseNameReturnSameSize();
		getAllNamesSchemasOfDefaultDatabaseReturnSameSize();
		deleteDatabaseReturnTrue();
	}
	
	public void existsReturnFalse() {
		assertFalse(DatabaseManager.exists(nul));
		assertFalse(DatabaseManager.exists(emptyDbName));
		assertFalse(DatabaseManager.exists(notExistDbName));
	}
	
	public void existsReturnTrue() {
		assertTrue(DatabaseManager.exists(dbName));
	}
	
	public void createNewDatabaseReturnFalse() {
		assertFalse(DatabaseManager.createNewDatabase(emptyDbName));
	}
	
	public void createNewDatabaseReturnTrue() {
		assertTrue(DatabaseManager.createNewDatabase(dbName));
	}
	
	public void getDatabaseReturnNull() {
		assertNull(DatabaseManager.getDatabase(nul));
		assertNull(DatabaseManager.getDatabase(emptyDbName));
	}
	
	public void getDatabaseReturnNotNull() {
		assertNotNull(DatabaseManager.getDatabase(dbName));
	}
	
	public void setToDefaultReturnFalse() {
		assertFalse(DatabaseManager.setToDefault(nul));
		assertFalse(DatabaseManager.setToDefault(emptyDbName));
	}
	
	public void setToDefaultReturnTrue() {
		assertTrue(DatabaseManager.setToDefault(dbName));
	}
	
	public void getDefaultReturnNull() {
		assertNull(DatabaseManager.getDefault());
	}
	
	public void getDefaultReturnNotNull() {
		assertNotNull(DatabaseManager.getDefault());
	}
	
	public void deleteDatabaseReturnFalse() {
		assertFalse(DatabaseManager.deleteDatabase(nul));
		assertFalse(DatabaseManager.deleteDatabase(emptyDbName));
		assertFalse(DatabaseManager.deleteDatabase(notExistDbName));
	}
	
	public void deleteDatabaseReturnTrue() {
		assertTrue(DatabaseManager.deleteDatabase(dbName) 
					&& !DatabaseManager.exists(dbName));
	}
	
	public void addSchemaWithSpecifiedDbReturnFalse() {
		assertFalse(DatabaseManager.addSchema(notExistDbName, schema));
		assertFalse(DatabaseManager.addSchema(dbName, nullSchema));
		assertFalse(DatabaseManager.addSchema(dbName, nullNameSchema));
		assertFalse(DatabaseManager.addSchema(dbName, emptyNameSchema));
	}
	
	public void addSchemaWithSpecifiedDbReturnTrue() {
		assertTrue(DatabaseManager.addSchema(dbName, schema));
	}
	
	public void addSchemaWithDefaultDbReturnFalse() {
		assertFalse(DatabaseManager.addSchema(nullSchema));
		assertFalse(DatabaseManager.addSchema(nullNameSchema));
		assertFalse(DatabaseManager.addSchema(emptyNameSchema));
	}
	
	public void addSchemaWithDefaultDbReturnTrue() {
		assertTrue(DatabaseManager.addSchema(schema));
	}
	
	public void getAllSchemasOnDatabaseNameReturnNull() {
		assertNull(DatabaseManager.getAllNamesSchemas(notExistDbName));
	}
	
	public void getAllSchemasOnDatabaseNameReturnNoNull() {
		assertNotNull(DatabaseManager.getAllNamesSchemas(dbName));
	}
	
	public void getAllSchemasOnDefaultDatabaseReturnNull() {
		assertNull(DatabaseManager.getAllNamesSchemas());
	}
	
	public void getAllSchemasOnDefaultDatabaseReturnNoNull() {
		assertNotNull(DatabaseManager.getAllNamesSchemas());
	}
	
	public void isDefaultSchemaReturnFalse() {
		assertFalse(DatabaseManager.isDefaultSchema(nullSchema));
		assertFalse(DatabaseManager.isDefaultSchema(schema));
	}
	
	public void isDefaultSchemaReturnTrue() {
		assertTrue(DatabaseManager.isDefaultSchema(defaultSchema));
		assertTrue(DatabaseManager.isDefaultSchema(emptyNameSchema));
		assertTrue(DatabaseManager.isDefaultSchema(nullNameSchema));
	}
	
	public void existsSchemaOnDatabaseNameReturnFalse() {
		assertFalse(DatabaseManager.existsSchema(notExistDbName, schema));
		assertFalse(DatabaseManager.existsSchema(dbName, nullSchema));
	}
	
	public void existsSchemaOnDatabaseNameReturnTrue() {
		assertTrue(DatabaseManager.existsSchema(dbName, schema));
	}
	
	public void existsSchemaOnDefaultDatabaseReturnFalse() {
		assertFalse(DatabaseManager.existsSchema(schema));
		assertFalse(DatabaseManager.existsSchema(nullSchema));
	}
	
	public void existsSchemaOnDefaultDatabaseReturnTrue() {
		assertTrue(DatabaseManager.existsSchema(dbName, schema));
	}
	
	public void getAllNamesSchemasWithDatabaseNameReturnNull() {
		assertNull(DatabaseManager.getAllNamesSchemas(notExistDbName));
	}
	
	public void getAllNamesSchemasWithDatabaseNameReturnSameSize() {
		assertEquals(DatabaseManager.getAllNamesSchemas(dbName).size(),
				DatabaseManager.getDatabase(dbName).getSchemas().size());
	}
	
	public void getAllNamesSchemasOfDefaultDatabaseReturnNull() {
		assertNull(DatabaseManager.getAllNamesSchemas());/*No default database*/
	}
	
	public void getAllNamesSchemasOfDefaultDatabaseReturnSameSize() {
		assertEquals(DatabaseManager.getAllNamesSchemas().size(),
				DatabaseManager.getDefault().getSchemas().size());
	}
}
