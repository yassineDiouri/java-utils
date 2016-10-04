package org.binx.utils.database.memdb.manager;

import junit.framework.*;

public class SchemaManagerUnitTest extends TestCase {

	private String simpledb;
	private String defaultdb;
	private String notexistdb;
	
	private String simpleSchema;
	private String nullNameSchema;
	
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
	}
	
	public void testSchemaManager() {
		int i = 0;
		System.out.println(++i);createNewSchemaWithDatabaseReturnNull();
		System.out.println(++i);createNewSchemaWithDatabaseReturnFalse();
		System.out.println(++i);createNewSchemaOnDefaultDatabaseReturnNull();
		
		DatabaseManager.setToDefault(defaultdb);
		System.out.println(++i);createNewSchemaWithDatabaseReturnTrue();
		System.out.println(++i);createNewSchemaOnDefaultDatabaseReturnFalse();
		System.out.println(++i);createNewSchemaOnDefaultDatabaseReturnTrue();
		
		
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
}
