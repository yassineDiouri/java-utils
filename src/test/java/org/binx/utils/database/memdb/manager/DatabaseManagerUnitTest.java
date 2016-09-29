package org.binx.utils.database.memdb.manager;

import junit.framework.TestCase;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseManagerUnitTest extends TestCase {

	private String nul;
	private String name;
	private String emptyName;
	
	@Override
	protected void setUp() throws Exception {
		DatabaseListManager.getDatabaseList();
		nul = null;
		name = " newDb ";
		emptyName = " ";
	}
	
	public void testDatabaseManager() {
		createNewDatabaseReturnFalse();
		getDatabaseReturnNull();
		
		createNewDatabaseReturnTrue();
		getDatabaseReturnNotNull();
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
}
