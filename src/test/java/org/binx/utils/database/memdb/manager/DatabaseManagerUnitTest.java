package org.binx.utils.database.memdb.manager;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseManagerUnitTest extends TestCase {

	private String nul;
	private String name;
	private String notExistName;
	private String emptyName;
	
	@Override
	protected void setUp() throws Exception {
		DatabaseListManager.getDatabaseList();
		nul = null;
		name = " newDb ";
		notExistName = "not_Exist";
		emptyName = " ";
	}
	
	public void testDatabaseManager() {
		createNewDatabaseReturnFalse();
		getDatabaseReturnNull();
		setToDefaultReturnFalse();
		deleteDatabaseReturnFalse();
		
		createNewDatabaseReturnTrue();
		existsReturnFalse();
		existsReturnTrue();
		getDatabaseReturnNotNull();
		setToDefaultReturnTrue();
		deleteDatabaseReturnTrue();
	}
	
	public void existsReturnFalse() {
		assertFalse(DatabaseManager.exists(nul));
		assertFalse(DatabaseManager.exists(emptyName));
		assertFalse(DatabaseManager.exists(notExistName));
	}
	
	public void existsReturnTrue() {
		assertTrue(DatabaseManager.exists(name));
	}
	
	public void createNewDatabaseReturnFalse() {
		assertFalse(DatabaseManager.createNewDatabase(emptyName));
	}
	
	public void createNewDatabaseReturnTrue() {
		assertTrue(DatabaseManager.createNewDatabase(name));
	}
	
	public void getDatabaseReturnNull() {
		assertNull(DatabaseManager.getDatabase(nul));
		assertNull(DatabaseManager.getDatabase(emptyName));
	}
	
	public void getDatabaseReturnNotNull() {
		assertNotNull(DatabaseManager.getDatabase(name));
	}
	
	public void setToDefaultReturnFalse() {
		assertFalse(DatabaseManager.setToDefault(nul));
		assertFalse(DatabaseManager.setToDefault(emptyName));
	}
	
	public void setToDefaultReturnTrue() {
		assertTrue(DatabaseManager.setToDefault(name));
	}
	
	public void deleteDatabaseReturnFalse() {
		assertFalse(DatabaseManager.deleteDatabase(nul));
		assertFalse(DatabaseManager.deleteDatabase(emptyName));
		assertFalse(DatabaseManager.deleteDatabase(notExistName));
	}
	
	public void deleteDatabaseReturnTrue() {
		assertTrue(DatabaseManager.deleteDatabase(name) 
					&& !DatabaseManager.exists(name));
	}
}
