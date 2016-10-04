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
		sizeReturnZero();
		
		addDatabaseReturnTrue();
		existsDatabaseReturnTrue();
		addDatabaseMakeSizeNotZero();
		getNamesDatabasesReturnSameSize();
		getDatabaseReturnNotNull();
		getDefaultDatabaseReturnNull();
		setToDefaultDatabaseReturnTrue();
		setToDefaultDatabaseReturnFalse();
		getDefaultDatabaseReturnNotNull();
		removeDatabaseReturnTrue();
		removeDatabaseReturnFalse();
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
		assertEquals(DatabaseListManager.getAllNamesDatabases().size(), 
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
	
	public void setToDefaultDatabaseReturnTrue() {
		assertTrue(DatabaseListManager.setToDefaultDatabase(existName));
	}
	
	public void setToDefaultDatabaseReturnFalse() {
		assertFalse(DatabaseListManager.setToDefaultDatabase(nul));
		assertFalse(DatabaseListManager.setToDefaultDatabase(emptyName));
		assertFalse(DatabaseListManager.setToDefaultDatabase(notExistName));
	}
	
	public void getDefaultDatabaseReturnNull() {
		assertNull(DatabaseListManager.getDefaultDatabase());
	}
	
	public void getDefaultDatabaseReturnNotNull() {
		assertNotNull(DatabaseListManager.getDefaultDatabase());
	}
	
	public void removeDatabaseReturnTrue() {
		assertTrue(DatabaseListManager.deleteDatabase(existName));
	}
	
	public void removeDatabaseReturnFalse() {
		assertFalse(DatabaseListManager.deleteDatabase(nul));
		assertFalse(DatabaseListManager.deleteDatabase(emptyName));
		assertFalse(DatabaseListManager.deleteDatabase(notExistName));
	}
	
	public void sizeReturnZero() {
		assertEquals(DatabaseListManager.size(), new Integer(0));
	}
}
