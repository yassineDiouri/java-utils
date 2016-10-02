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
	private String defaultDbName;
	private String notExistDbName;
	private String emptyDbName;
	private Schema nullSchema;
	private Schema nullNameSchema;
	private Schema schema;
	private Schema defaultSchema;
	private Schema emptyNameSchema;
	private Schema notExistSchema;
	
	@Override
	protected void setUp() throws Exception {
		DatabaseListManager.getDatabaseList();
		nul = null;
		dbName = " newDb ";
		defaultDbName = "defaultDB";
		notExistDbName = "not_Exist";
		emptyDbName = "";
		schema = new Schema("schema");
		defaultSchema = Schema.DEFAULT_SCHEMA;
		nullNameSchema = new Schema(null);
		emptyNameSchema = new Schema("");
		nullSchema = null;
		notExistSchema = new Schema("notExistSchema");
	}
	
	public void testDatabaseManager() {
		createNewDatabaseReturnFalse();
		getDatabaseReturnNull();
		setToDefaultReturnFalse();
		deleteDatabaseReturnFalse();
		getDefaultReturnNull();
		existsSchemaOnDatabaseNameReturnFalse();
		getSchemaOnDatabaseNameReturnNull();
		countSchemasFromDatabaseNameReturnNull();
		countSchemasFromDefaultDatabaseReturnNull();
		addSchemaWithSpecifiedDbReturnNull();

		getAllSchemasOnDatabaseNameReturnNull();
		getAllNamesSchemasWithDatabaseNameReturnNull();
		isEmptyFromDatabaseNameReturnNull();
		isEmptyFromDatabaseNameReturnTrue();
		
		createNewDatabaseReturnTrue();
		existsReturnFalse();
		existsReturnTrue();
		getDatabaseReturnNotNull();
		getAllNamesSchemasOfDefaultDatabaseReturnNull();
		getAllSchemasOnDefaultDatabaseReturnNull();
		getSchemaOnDefaultDatabaseReturnNull();
		getDefaultSchemaFromDefaultDatabaseReturnNull();
		deleteSchemaFromDefaultDatabaseReturnNull();
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
		getSchemaOnDatabaseNameReturnDefaultSchema();
		getSchemaOnDatabaseNameReturnNotNull();
		getSchemaOnDefaultDatabaseReturnNotNull();
		getSchemaOnDefaultDatabaseReturnDefaultSchema();
		getDefaultSchemaFromDatabaseNameReturnNull();
		getDefaultSchemaFromDatabaseNameReturnNotNull();
		getDefaultSchemaFromDefaultDatabaseReturnNotNull();
		countSchemasFromDatabaseNameReturnNotNull();
		countSchemasFromDefaultDatabaseReturnNotNull();
		isEmptyFromDatabaseNameReturnFalse();
		
		deleteSchemaFromDatabaseNameReturnNull();
		deleteSchemaFromDatabaseNameReturnFalse();
		deleteSchemaFromDatabaseNameReturnTrue();
		deleteSchemaFromDefaultDatabaseReturnFalse();
		deleteSchemaFromDefaultDatabaseReturnTrue();
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
		DatabaseManager.createNewDatabase(defaultDbName);
		assertTrue(DatabaseManager.setToDefault(defaultDbName));
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
	
	public void isEmptyFromDatabaseNameReturnNull() {
		assertNull(DatabaseManager.isEmpty(notExistDbName));
	}
	
	public void isEmptyFromDatabaseNameReturnFalse() {
		assertFalse(DatabaseManager.isEmpty(dbName));
	}
	
	public void isEmptyFromDatabaseNameReturnTrue() {
		DatabaseManager.createNewDatabase("emtpyDB");
		assertTrue(DatabaseManager.isEmpty("emtpyDB"));
	}
	
	public void addSchemaWithSpecifiedDbReturnNull() {
		assertNull(DatabaseManager.addSchema(notExistDbName, schema));
	}
	
	public void addSchemaWithSpecifiedDbReturnFalse() {
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
	
	public void getSchemaOnDatabaseNameReturnNull() {
		assertNull(DatabaseManager.getSchema(notExistDbName, schema.getName()));
		assertNull(DatabaseManager.getSchema(notExistDbName, nul));
	}
	
	public void getSchemaOnDatabaseNameReturnNotNull() {
		assertNotNull(DatabaseManager.getSchema(dbName, schema.getName()));
	}
	
	public void getSchemaOnDatabaseNameReturnDefaultSchema() {
		assertEquals(DatabaseManager.getSchema(dbName, nul).getName(), Schema.DEFAULT_SCHEMA.getName());
		assertEquals(DatabaseManager.getSchema(dbName, "").getName(), Schema.DEFAULT_SCHEMA.getName());
	}
	
	public void getSchemaOnDefaultDatabaseReturnNull() {
		assertNull(DatabaseManager.getSchema(schema.getName()));
		assertNull(DatabaseManager.getSchema(nul));
	}
	
	public void getSchemaOnDefaultDatabaseReturnNotNull() {
		assertNotNull(DatabaseManager.getSchema(schema.getName()));
	}
	
	public void getSchemaOnDefaultDatabaseReturnDefaultSchema() {
		assertEquals(DatabaseManager.getSchema(nul).getName(), Schema.DEFAULT_SCHEMA.getName());
		assertEquals(DatabaseManager.getSchema("").getName(), Schema.DEFAULT_SCHEMA.getName());
	}
	
	public void getDefaultSchemaFromDatabaseNameReturnNull() {
		assertNull(DatabaseManager.getDefaultSchema(notExistDbName));
	}
	
	public void getDefaultSchemaFromDatabaseNameReturnNotNull() {
		assertNotNull(DatabaseManager.getDefaultSchema(dbName));
	}
	
	public void getDefaultSchemaFromDefaultDatabaseReturnNull() {
		assertNull(DatabaseManager.getDefaultSchema());
	}
	
	public void getDefaultSchemaFromDefaultDatabaseReturnNotNull() {
		assertNotNull(DatabaseManager.getDefaultSchema());
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
	
	public void deleteSchemaFromDatabaseNameReturnNull() {
		assertNull(DatabaseManager.deleteSchema(dbName, defaultSchema.getName()));
		assertNull(DatabaseManager.deleteSchema(notExistDbName, schema.getName()));
	}
	
	public void deleteSchemaFromDatabaseNameReturnFalse() {
		assertFalse(DatabaseManager.deleteSchema(dbName, ""));
		assertFalse(DatabaseManager.deleteSchema(dbName, notExistSchema.getName()));
	}
	
	public void deleteSchemaFromDatabaseNameReturnTrue() {
		assertTrue(DatabaseManager.deleteSchema(dbName, schema.getName()));
	}
	
	public void deleteSchemaFromDefaultDatabaseReturnNull() {
		assertNull(DatabaseManager.deleteSchema(defaultSchema.getName()));
		assertNull(DatabaseManager.deleteSchema(schema.getName()));
	}
	
	public void deleteSchemaFromDefaultDatabaseReturnFalse() {
		assertFalse(DatabaseManager.deleteSchema(""));
		assertFalse(DatabaseManager.deleteSchema(notExistSchema.getName()));
	}
	
	public void deleteSchemaFromDefaultDatabaseReturnTrue() {
		assertTrue(DatabaseManager.deleteSchema(schema.getName()));
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
		assertFalse(DatabaseManager.existsSchema(notExistDbName, schema.getName()));
		assertFalse(DatabaseManager.existsSchema(dbName, nul));
	}
	
	public void existsSchemaOnDatabaseNameReturnTrue() {
		assertTrue(DatabaseManager.existsSchema(dbName, schema.getName()));
	}
	
	public void existsSchemaOnDefaultDatabaseReturnFalse() {
		assertFalse(DatabaseManager.existsSchema(schema.getName()));
		assertFalse(DatabaseManager.existsSchema(nul));
	}
	
	public void existsSchemaOnDefaultDatabaseReturnTrue() {
		assertTrue(DatabaseManager.existsSchema(schema.getName()));
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
	
	public void countSchemasFromDatabaseNameReturnNull() {
		assertNull(DatabaseManager.countSchemas(notExistDbName));
	}
	
	public void countSchemasFromDatabaseNameReturnNotNull() {
		assertNotNull(DatabaseManager.countSchemas(dbName));
	}
	
	public void countSchemasFromDefaultDatabaseReturnNull() {
		assertNull(DatabaseManager.countSchemas());
	}
	
	public void countSchemasFromDefaultDatabaseReturnNotNull() {
		assertNotNull(DatabaseManager.countSchemas());
	}
}
