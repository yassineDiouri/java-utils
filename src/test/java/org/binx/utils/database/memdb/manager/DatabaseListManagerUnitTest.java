package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.model.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseListManagerUnitTest extends TestCase {

	private Database db;
	private Database dbNameEmpty;
	private String emptyName;
	private String nul;
	private String notExistName;
	private String existName;
	
	@Override
	protected void setUp() {
		nul = null;
		emptyName = "";
		notExistName = "notExistDB";
		existName = "testDB";
		db = new Database(existName);
		dbNameEmpty = new Database(emptyName);
	}
	
	public void testDatabaseListManager() {
		getDatabaseListReturnNotNull();
		getDatabaseListReturnDatabaseListClass();
		addDatabaseReturnFalse();
		existsDatabaseReturnFalse();
		getDatabaseReturnNull();
		
		addDatabaseReturnTrue();
		existsDatabaseReturnTrue();
		addDatabaseMakeSizeNotZero();
		getNamesDatabasesReturnSameSize();
		getDatabaseReturnNotNull();
	}
	
	public void getDatabaseListReturnNotNull() {
		assertNotNull(DatabaseListManager.getDatabaseList());
	}
	
	public void getDatabaseListReturnDatabaseListClass() {
		assertEquals(DatabaseListManager.getDatabaseList().getClass(), DatabaseList.class);
	}
	
	public void existsDatabaseReturnFalse() {
		assertFalse(DatabaseListManager.existsDatabase(notExistName));
	}
	
	public void existsDatabaseReturnTrue() {
		assertTrue(DatabaseListManager.existsDatabase(existName));
	}
	
	public void addDatabaseReturnFalse() {
		assertFalse(DatabaseListManager.addDatabase(null));
		assertFalse(DatabaseListManager.addDatabase(dbNameEmpty));
	}
	
	public void addDatabaseReturnTrue() {
		assertTrue(DatabaseListManager.addDatabase(db));
	}
	
	public void addDatabaseMakeSizeNotZero() {
		assertTrue(!DatabaseListManager.getDatabaseList().getDatabases().isEmpty());
	}
	
	public void getNamesDatabasesReturnSameSize() {
		assertEquals(DatabaseListManager.getNamesDatabases().size(), 
				DatabaseListManager.getDatabaseList().getDatabases().size());
	}
	
	public void getDatabaseReturnNull() {
		assertNull(DatabaseListManager.getDatabase(nul));
		assertNull(DatabaseListManager.getDatabase(emptyName));
		assertNull(DatabaseListManager.getDatabase(notExistName));
	}
	
	public void getDatabaseReturnNotNull() {
		assertNotNull(DatabaseListManager.getDatabase(existName));
	}
}
